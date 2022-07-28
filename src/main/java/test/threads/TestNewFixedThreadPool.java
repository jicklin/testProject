package test.threads;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class TestNewFixedThreadPool {

	public static void main(String[] args) throws InterruptedException {

		final AtomicInteger integer = new AtomicInteger();

		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
				1, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(3), new ThreadFactory() {


			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r, "myhandler" + integer.getAndIncrement());
				return thread;

			}
		}
		);



		for (int i = 0; i < 6; i++) {
			final int finalI = i;
			threadPoolExecutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("当前线程是" + Thread.currentThread().getName()+Thread.currentThread()+finalI);
				}
			});
		}

		Thread.sleep(6000);

		for ( int i = 10; i < 20; i++) {
			final int finalI = i;
			threadPoolExecutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("当前线程是" + Thread.currentThread().getName()+Thread.currentThread()+ finalI);
				}
			});
		}

	}
}
