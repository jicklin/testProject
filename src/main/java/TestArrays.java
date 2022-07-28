import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestArrays {

	@Test
	public void testToList() {
		int[] intArray = {1, 2, 3};
		List list = Arrays.asList(intArray);
		System.out.println(list);
		System.out.println(list.get(0));

		List list2 = Arrays.asList(1, 2, 3);
		System.out.println(list);
		System.out.println(list2.getClass());


		String s = "123:";
		System.out.println(Arrays.toString(s.split(":")));
		System.out.println(s.split(":").length);

	}
}
