package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCollectionSort {

	public static void main(String[] args) {

		String[] arr = new String[]{"123", "1234", "13", "11"};

		Arrays.sort(arr, String::compareToIgnoreCase);

		System.out.println(Arrays.toString(arr));

		System.out.println(Arrays.stream(arr).findFirst());

	}
}
