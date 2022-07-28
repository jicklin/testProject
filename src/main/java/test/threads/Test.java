package test.threads;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		Washroom washroom = new Washroom();


		new Thread(new ShitTask(washroom, "孙龙"),"sunlong-thread").start();
		new Thread(new ShitTask(washroom, "陈龙"),"chenlong-thread").start();
		new Thread(new ShitTask(washroom, "马林"),"malin-thread").start();

		new Thread(new RepairTask(washroom), "repair-thread").start();


	}
}
