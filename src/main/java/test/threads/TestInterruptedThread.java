package test.threads;

public class TestInterruptedThread {
	private static final Object keyObj = new Object();

	public static void main(String[] args) {



		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
					synchronized (keyObj) {
						try {
							keyObj.wait();
						} catch (InterruptedException e) {
							System.out.println("线程1执行出错");

							e.printStackTrace();
						}
					}
					System.out.println("线程1执行结束");

			}
		});

		Thread t2 = new Thread(() -> {
			try {
				Thread.sleep(1000);
				t1.interrupt();
				System.out.println("线程2执行结束");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		});

		t1.start();
		t2.start();

		System.out.println("主线程运行结束");

	}
}
