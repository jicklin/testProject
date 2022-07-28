package test.synchronization;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(2);

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("1号选手准备就绪!用时1秒");
				latch.countDown();

			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				System.out.println("2号选手准备就绪！用时3秒");
				latch.countDown();

			}
		}).start();

		try {
			System.out.println("各位选手各就各位！");
			latch.await();
			System.out.println("砰(发令枪响)");

		} catch (InterruptedException e) {
			e.printStackTrace();

		}

	}
}
