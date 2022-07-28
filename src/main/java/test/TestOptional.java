package test;

import java.util.Optional;

public class TestOptional {

	public static void main(String[] args) {
		Optional<Object> empty = Optional.empty();
		empty.get();

		Optional<String> haha = Optional.of("haha");
		System.out.println(haha.toString());
		System.out.println(haha.isPresent());

		String name = null;
		Optional<String> name1 = Optional.ofNullable(name);
		System.out.println(name1.isPresent());

		Optional<String> world = Optional.of("world");
		world.ifPresent(System.out::println);

	}
}
