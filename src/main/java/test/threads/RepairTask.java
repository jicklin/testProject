package test.threads;

public class RepairTask implements Runnable {

	private Washroom washroom;

	public RepairTask(Washroom washroom) {
		this.washroom = washroom;
	}

	@Override
	public void run() {
		synchronized (washroom.getLock()) {
			System.out.println("维修工获取了厕所的锁");
			System.out.println("厕所维修ing...........");

			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			washroom.setAvailable(true);
			washroom.getLock().notifyAll();
			System.out.println("維修工已經將厠所修好了");

		}

//		washroom.setAvailable(false);
	}
}
