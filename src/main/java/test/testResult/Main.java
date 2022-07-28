package test.testResult;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		ResultA<List<String>> dataResult = new ResultA<>();
		dataResult.setData(new ArrayList<String>(){{add("123");}});

		ResultA<Long> countResult = new ResultA<>();
		countResult.setData(1L);
		parse2(dataResult, countResult);


	}

	private static <T,K> void parse(ResultA<List<T>> a, ResultA<K> b) {
		List<T> data = a.getData();
		System.out.println(a.getData());
		System.out.println(b.getData());

	}
	private static void parse2(ResultA<?> a, ResultA<?> b) {
		System.out.println(a.getData());
		System.out.println(b.getData());

	}
}
