package test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();
		arr.add("1");
		arr.add("2");
		arr.add("3");
		arr.add("4");
		arr.add("5");
		arr.clear();
		System.out.println(arr.size());
		//System.out.println(arr.subList(0, arr.size()));
		//
		//System.out.println(Lists.partition(arr, 2));



	}
}
