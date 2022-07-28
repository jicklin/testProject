package test.synchronization;

import java.util.concurrent.Semaphore;

public class TestSemaphore {
	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(0);
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (; ; ) {
					try {
						Thread.sleep(500);
						semaphore.acquire();
						System.out.println("顾客拿到入场门票");

					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}
		});

	}
}
