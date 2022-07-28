package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeMap {

	public static void main(String[] args) {

		Set<String> set = new TreeSet<>();
		set.add("1");
		set.add("3");
		set.add("2");

		set.add("b");
		set.add("a");
		set.add("c");
		System.out.println(set);

		System.out.println((1 / .15f));

		Map<String, String> map = new HashMap<>();
		map.put("1", "nu");

		System.out.println(map.put("2","null"));
		boolean modified = false;
		modified |= true;

		System.out.println(modified);
	}
}
