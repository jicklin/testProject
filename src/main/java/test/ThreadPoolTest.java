package test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 18048422@cnsuning.com
 * @desc
 * @date 2019/3/25
 */
public class ThreadPoolTest {

    private static AtomicInteger count = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (long i = 0; i < 1000000L; i++) {
                count.incrementAndGet();

                }
            }
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8, 8, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);
        threadPoolExecutor.execute(task);


        threadPoolExecutor.shutdown();

        while (!threadPoolExecutor.awaitTermination(1L, TimeUnit.MINUTES)) {
            System.out.println("Not yet. Still waiting for termination");

        }

        System.out.println("count= " + count);
    }
}
