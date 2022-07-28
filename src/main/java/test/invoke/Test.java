package test.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		UserDao proxyInstance = (UserDao) Proxy.newProxyInstance(UserDao.class.getClassLoader(),
				new Class[]{UserDao.class}, new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println(method.getDeclaringClass());
						if (Object.class.equals(method.getDeclaringClass())) {
							return method.invoke(this, args);
						}

						if (method.getName().equals("save")) {
							System.out.println("咋了我代理下");

						}
						return null;
					}
				});



		System.out.println(proxyInstance);
		proxyInstance.save();

	}
}
