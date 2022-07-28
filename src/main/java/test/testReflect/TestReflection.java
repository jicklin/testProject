package test.testReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {

	public static void main(String[] args) {
		try {
			Class<?> aClass = Class.forName("test.testReflect.Student");
			Method doHomeWork = aClass.getMethod("doHomeWork", String.class);

			Constructor<?> constructor = aClass.getConstructor();

			Object object = constructor.newInstance();
			doHomeWork.invoke(object, "语文");

			Object newInstance = aClass.newInstance();
			doHomeWork.invoke(newInstance, "数学");

			Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
			for (Constructor constructor1 : declaredConstructors) {
				System.out.println(constructor1);
			}

			Method[] declaredMethods = aClass.getDeclaredMethods();
			for (Method method : declaredMethods) {
				System.out.println(method);
			}


		} catch (ClassNotFoundException | NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
