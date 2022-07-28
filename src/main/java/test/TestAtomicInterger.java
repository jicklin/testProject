package test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInterger {

	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(1);
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.getAndIncrement());

	}
}
