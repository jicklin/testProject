package test;

import com.suning.framework.commons.utils.MD5Utils;

public class TestMd5 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("["+ MD5Utils.getMD5("13151726725")+"]");


		String msg = "hello world ";
		for (int i = 0; i < 10; i++) {
			System.out.print(msg + i);
			Thread.sleep(1000);
//			for (int j = 0; j < (msg + i).length(); j++) {
//				System.out.print("\b");
//			}
			System.out.print("\r");

		}
	}
}
