package test;

import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

public class TestSystem {

	public static void main(String[] args) {

		Properties properties = System.getProperties();

		Enumeration<?> enumeration = properties.propertyNames();
		while (enumeration.hasMoreElements()) {
			Object o = enumeration.nextElement();
			System.out.println(o + "=" + properties.getProperty(o.toString()));
		}

		System.out.println(Runtime.getRuntime().availableProcessors());
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {

		}



	}
}
