package test.synchronization;

public class MultiSyncronizedClass {

	private Object lock1= new Object();
	private final Object lock2 = new Object();

	public synchronized void  test1() {
		System.out.println("拿到测试方法1的锁");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void test2() {
		System.out.println("拿到测试方法2的锁");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void test3() {
		synchronized (lock1) {
			System.out.println("進入方法3");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("方法3處理結束");

		}
	}
	public void test4() {
		synchronized (lock2) {
			System.out.println("進入方法4");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("方法4處理結束");

		}
	}

	public static void main(String[] args) {
		MultiSyncronizedClass multiSyncronizedClass = new MultiSyncronizedClass();
		new Thread(new Runnable() {
			@Override
			public void run() {
				multiSyncronizedClass.test1();
				multiSyncronizedClass.test2();
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				multiSyncronizedClass.test2();

			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				multiSyncronizedClass.test3();

			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				multiSyncronizedClass.test4();

			}
		}).start();


	}
}
