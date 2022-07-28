package test;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/3/12
 */
public class MultiThreadtest {

    private boolean resumable;

    private URL url;

    private File localFile;

    private int[] endPoint;

    private Object waiting = new Object();
    private AtomicInteger downloadedBytes = new AtomicInteger(0);
    private AtomicInteger aliveThreads = new AtomicInteger(0);

    private boolean multiThread = true;

    private int fileSize = 0;

    private int THREAD_NUM = 5;

    private int TIME_OUT = 5000;

    private final int MIN_SIZE = 2 << 20;

    public MultiThreadtest(String url, String localPath) throws MalformedURLException {
        this.url = new URL(url);
        this.localFile = new File(localPath);
    }

    public MultiThreadtest(String url, String localPath, int threadNum, int timeOut) throws MalformedURLException {
        this(url, localPath);
        this.THREAD_NUM = threadNum;
        this.TIME_OUT = timeOut;
        
    }


    public static void main(String[] args) throws IOException {
        String url = "http://mirrors.163.com/debian/ls-lR.gz";
        new MultiThreadtest(url, "D:/ls-lR.gz", 5, 5000).get();
    }

    private void get() throws IOException {

        long startTime = System.currentTimeMillis();

        resumable = supportResumeDownload();
        if (!resumable || THREAD_NUM == 1 || fileSize < MIN_SIZE) {
            multiThread = false;
        }

        if (!multiThread) {
            new DownloadThread(0, 0, fileSize - 1).start();
        }else {
            endPoint = new int[THREAD_NUM + 1];
            int block = fileSize / THREAD_NUM;
            for (int i = 0; i < THREAD_NUM; i++) {
                endPoint[i] = block * i;
            }
            endPoint[THREAD_NUM] = fileSize;
            for (int i = 0; i < THREAD_NUM; i++) {
                new DownloadThread(i, endPoint[i], endPoint[i + 1] - 1).start();
            }
        }
        startDownloadMonitor();

        try {
            synchronized (waiting) {
                waiting.wait();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clearTempFile();
        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.println("File successfully downloaded");
        System.out.println(String.format(" Time used: %.3f s,Average speed: %d KB/s", timeElapsed / 1000.0, downloadedBytes.get() / timeElapsed));
    }

    private void clearTempFile() throws IOException {
        if (multiThread) {
            merge();
            System.out.println(" temp files merged");

        }else {
            Files.move(Paths.get(localFile.getAbsolutePath() + ".0.temp"), Paths.get(localFile.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    private void merge() {
        try(OutputStream out = new FileOutputStream(localFile)) {
            byte[] buffer = new byte[1024];
            int size;
            for (int i = 0; i < THREAD_NUM; i++) {
                String tempFile = localFile.getAbsolutePath() + "." + i + ".temp";
                InputStream in = new FileInputStream(tempFile);
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }
                in.close();
                Files.delete(Paths.get(tempFile));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startDownloadMonitor() {
        Thread downloadMonitor = new Thread(new Runnable() {
            @Override
            public void run() {
                int pre = 0;
                int curr = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);

                    } catch (Exception e) {
                        e.printStackTrace();

                    }
                    curr = downloadedBytes.get();
                    System.out.println(String.format(" Speed : %d KB/s, Download:%d KB (%.2f%%) ,Thread : %d", (curr - pre) >> 10, curr >> 10, (curr / (float)fileSize) * 100.0, aliveThreads.get()));
                    pre = curr;
                    if (aliveThreads.get() == 0) {
                        synchronized (waiting) {
                            waiting.notifyAll();

                        }
                    }
                }

            }
        });

        downloadMonitor.setDaemon(true);
        downloadMonitor.start();

    }

    private boolean supportResumeDownload() throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP,new InetSocketAddress("xzproxy.cnsuning.com",8080)));
        con.setRequestProperty("Range", "bytes=0-");
        int resCode=0;

        try {
            con.connect();
            fileSize = con.getContentLength();
            resCode = con.getResponseCode();
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (resCode == 206) {
            System.out.println("support resume download");
            return true;
        }else {
            System.out.println("doesn't support resume download");
            return false;
        }


    }


    private class DownloadThread extends Thread {
        private int id;

        private int start;

        private int end;

        private OutputStream outputStream;
        public DownloadThread(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
            aliveThreads.incrementAndGet();
        }

        @Override
        public void run() {
            boolean success = false;

            while (true) {
                success = download();
                if (success) {
                    System.out.println(" Downloaded part " + (id + 1));
                    break;
                }else {
                    System.out.println(" Retry to download part " + (id + 1));
                }
            }
            aliveThreads.decrementAndGet();
        }

        private boolean download() {

            try {
                HttpURLConnection con = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP,new InetSocketAddress("xzproxy.cnsuning.com",8080)));
                con.setRequestProperty("Range", String.format("bytes=%d-%d", start, end));
                con.setConnectTimeout(TIME_OUT);
                con.setReadTimeout(TIME_OUT);
                con.connect();
                int partSize = con.getHeaderFieldInt("Content-Length", -1);
                if (partSize != end - start + 1) {
                    return false;
                }
                if (outputStream == null) {
                    outputStream = new FileOutputStream(localFile.getAbsolutePath() + "." + id + ".temp");
                }
                try (InputStream in = con.getInputStream()){
                    byte[] buffer = new byte[1024];
                    int size;
                    while (start <= end && (size = in.read(buffer)) > 0) {
                        start += size;
                        downloadedBytes.addAndGet(size);
                        outputStream.write(buffer, 0, size);
                        outputStream.flush();

                    }
                    con.disconnect();
                    if (start <= end) {
                        return false;
                    } else {
                        outputStream.close();

                    }



                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;

        }
    }
}
