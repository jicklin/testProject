package test.threadError;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author mal
 * @date 2021-10-14 10:26
 */
public class ThreadExecutor {

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(200),
            new ThreadFactoryBuilder()
                    .setNameFormat("customThread %d")
                    .setUncaughtExceptionHandler((t, e) -> System.out.println("UncaughtExceptionHandler捕获异常：" + t.getName() + "发生异常：" + e.getMessage()))
                    .build());

    @Test
    public void test() {
        IntStream.rangeClosed(1, 5).forEach(i->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //threadPoolExecutor.execute(()->{
            //    int j = 1 / 0;
            //
            //});
            Future<?> future = threadPoolExecutor.submit(() -> {
                System.out.println("线程：" + Thread.currentThread().getName() + "执行");
                int j = 1 / 0;
            });

            try {
                future.get();
            } catch (InterruptedException e) {
                
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        });

    }
}

