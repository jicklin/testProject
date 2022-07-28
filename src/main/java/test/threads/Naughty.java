package test.threads;

public class Naughty implements Runnable{

	private Washroom washroom;

	public Naughty(Washroom washroom) {

		this.washroom = washroom;
	}


	@Override
	public void run() {
		System.out.println("调皮的孩子重新将厕所堵住");
		washroom.setAvailable(false);

	}
}
