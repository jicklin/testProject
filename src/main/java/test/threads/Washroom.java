package test.threads;

public class Washroom {

	private volatile boolean isAvailable = false;

	private Object lock = new Object();

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean available) {
		isAvailable = available;
	}

	public Object getLock() {
		return lock;
	}

}
