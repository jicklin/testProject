package test.threads;

public class ShitTask implements Runnable {

	private Washroom washroom;

	private String name;

	public ShitTask(Washroom washroom, String name) {

		this.washroom = washroom;
		this.name = name;
	}

	@Override
	public void run() {
		synchronized (washroom.getLock()) {
			System.out.println(name + " 获取了厕所的锁");
			while (!washroom.isAvailable()) {
				System.out.println(name + " 厕所还是不可以使用");
				try {
					washroom.getLock().wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			System.out.println(name + " 上好了");
		}
	}
}
