package test;


import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class TestBase64 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		encryption("abc");

		Decrypt("JXU1NzI4JXU1NEVBJXU1NDJDJXU1MjMwJXU3Njg0JTBB");

	}

	public static String encryption(String origin) {
		String s = Base64.getEncoder().encodeToString(origin.getBytes());
		System.out.println("加密后：" + s);
		return s;
	}

	public static void Decrypt(String encodeStr) throws UnsupportedEncodingException {
		byte[] decode = Base64.getDecoder().decode(encodeStr.getBytes("utf-16"));

		System.out.println(new String(decode));

		byte[] bytes = org.apache.commons.net.util.Base64.decodeBase64(encodeStr);
		System.out.println(new String(bytes));

	}
}
