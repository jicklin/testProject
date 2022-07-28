package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MemoryOut {

	public static final Integer K = 4*1024;

	public static void main(String[] args) throws InterruptedException {

		System.out.println("最大内存(byte)：" + Runtime.getRuntime().maxMemory());
		List<byte[]> data = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			System.out.println("JVM写入数据" + (i + 1)*10 + "M");
			data.add(new byte[1024 * 1024 * 10]);
			System.out.println("当前剩余内存(byte)：" + Runtime.getRuntime().freeMemory());
			TimeUnit.SECONDS.sleep(1);

		}
	}


}
