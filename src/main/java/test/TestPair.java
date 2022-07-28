package test;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

public class TestPair {

	public static void main(String[] args) {
		Pair<Integer, Integer> pair = new ImmutablePair<>(1, 2);
		System.out.println(pair.getLeft());
		System.out.println(pair.getRight());

		Triple<String, String, String> triple = new ImmutableTriple<>("我是第一个结果", "我是第二个结果", "我是第三个结果");
		System.out.println(triple.getLeft());
		System.out.println(triple.getMiddle());
		System.out.println(triple.getRight());

	}
}
