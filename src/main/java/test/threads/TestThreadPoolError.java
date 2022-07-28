package test.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class TestThreadPoolError {

	private static final Logger logger = LoggerFactory.getLogger(TestThreadPoolError.class);

	public static void main(String[] args) {
		 ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadFactory() {

			private AtomicLong threadNum = new AtomicLong(1);

			private String machineUuid = UUID.randomUUID().toString();
			@Override
			public Thread newThread(Runnable r) {

				String threadName = "uc-redis-message-process-" + machineUuid + "-thread" + threadNum.getAndIncrement();

				return new Thread(r, threadName);
			}
		}) {
			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				if (t != null) {
					logger.error("consume uc redis message occur error", t);
					System.out.println("\"consume uc redis message occur error\"" + t + Thread.currentThread().getName());
				}
			}
		};

		for (int i = 0; i < 10; i++) {

			int finalI = i;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					System.out.println(1 / finalI);
				}
			});
		}

	}
}
