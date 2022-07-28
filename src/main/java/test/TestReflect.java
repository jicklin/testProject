package test;

import org.junit.Test;
import test.dto.Son;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class TestReflect {
	public static void main(String args[]) {
		try {
			Method test1 =
					TestReflect.class.getMethod("test1");
			System.out.println(test1);
			Type genericReturnType = test1.getGenericReturnType();
			System.out.println(Void.TYPE.equals(genericReturnType));

			System.out.println(genericReturnType.getClass());
		} catch (NoSuchMethodException e) {


		}

	}

	@Deprecated
	public void test1() {
		System.out.println(1);
	}

	@Test
	public void del() {
		Field[] declaredFields = Son.class.getDeclaredFields();

		Field[] fields = Son.class.getFields();

		Method[] declaredMethods = Son.class.getDeclaredMethods();

		Method[] methods = Son.class.getMethods();

	}
}
