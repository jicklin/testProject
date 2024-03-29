package test;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;

public class TestBigDecimal {

	public static void main(String[] args) {

		BigDecimal num = new BigDecimal("124");

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(num);

			oos.flush();
			out.flush();

			byte[] bytes = out.toByteArray();

			ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bi);
			BigDecimal bigDecimal = (BigDecimal) ois.readObject();
			System.out.println("序列化后值为：" + bigDecimal);

			ois.close();
			bi.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


	}


	@Test
	public void testRound() {
		double a  = 1.1;
		double b  = -1.1;
		System.out.println(Math.ceil(a));
		System.out.println(Math.floor(a));
		System.out.println(Math.ceil(b));
		System.out.println(Math.floor(b));
		int c = 1234;
		System.out.println(c / 1000);
		System.out.println(c % 1000);


	}
}
