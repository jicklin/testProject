package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

/**
 * @author mal
 * @date 2022-04-14 17:56
 */
public class TestUrl {
    public static void main(String[] args) throws Exception {
        String url = "http://www.baidu.com?query=马林";
        String encode = URLEncoder.encode("query=a b");
        System.out.println("http://www.baidu.com?"+encode);
        URI uri = new URI(url);
        System.out.println(uri.toASCIIString());

        System.out.println(String.format("hahah%snnn", null));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(60*60*24*1000);

        URL url1 = new URL("https://www.google.com");
        HttpURLConnection urlConnection = (HttpURLConnection)url1.openConnection(new Proxy(Proxy.Type.HTTP,new InetSocketAddress("127.0.0.1",10809)));
        urlConnection.setRequestMethod("GET");
        urlConnection.setConnectTimeout(5000);
        urlConnection.connect();
        if (urlConnection.getResponseCode() == 200) {
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String read = null;
            while ((read= bufferedReader.readLine()) != null) {
                System.out.println(read);
            }
            System.out.println("成功了");

        }



    }
}
