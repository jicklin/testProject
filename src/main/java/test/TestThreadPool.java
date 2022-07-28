package test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadPool {

	public static void main(String[] args) {
		 final ThreadPoolExecutor executorService =
				new ThreadPoolExecutor(1, 16, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
					private final AtomicInteger threadNumber = new AtomicInteger(1);
					@Override
					public Thread newThread(Runnable r) {
						String threadName = "crowd-effect-pip-stream-process-thread-" + threadNumber.getAndIncrement();
						return new Thread(r, threadName);
					}
				});

		for (int i = 0; i < 40; i++) {

			try {
				executorService.execute(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(5000L);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + ", hello");


					}
				});
			} catch (Exception e) {
				System.out.println(e.getClass());
			}
			System.out.println("核心线程："+ executorService.getCorePoolSize());
			System.out.println("最大线程数："+ executorService.getMaximumPoolSize());
			System.out.println("总数线程："+ executorService.getPoolSize());
			System.out.println("队列任务数" + executorService.getQueue().size());
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>" );

		}
	}
}
