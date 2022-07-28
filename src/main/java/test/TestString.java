package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestString {

	public static void main(String[] args) {
		String name = "hello";

		addStr(name);

		System.out.println(name);

		System.out.println(name.toUpperCase());

		Integer a = 1;
		addA(a);
		System.out.println(a);

		Map<String, Object> map = new HashMap<>();
		map.put("1", 123);
		map.put("asdasd", "asdasd");
		System.out.println(map);

		System.out.println("aa".indexOf("-"));

		String a1 = "1";
		ArrayList<String> strings = new ArrayList<>();
		strings.add(a1);
		a1 = "12";
		System.out.println(strings);

		System.out.println("第【"+(a+1)+"】次");
		System.out.println(a);

	}

	private static void addA(Integer a) {
		a = 2;
	}

	private static void addStr(String name) {
		name = "world";
	}
}
