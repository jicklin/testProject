package test.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<Long> {
	@Override
	public Long call() throws Exception {
		///Thread.sleep(2000);

		System.out.println(Thread.currentThread().getId() + " is running");
		return Thread.currentThread().getId();
	}

	public static void main(String[] args) {
		FutureTask<Long> task = new FutureTask<Long>(new TestCallable());
		new Thread(task).start();
		System.out.println("等待完成任务");
		try {
			Long result = task.get();
			System.out.println("任务结果为：" + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
