package test;

import java.io.Serializable;

public class LazyInnerClassSingleton implements Serializable {
	private static final long serialVersionUID = -4264591697494981165L;

	// 私有的构造方法
	private LazyInnerClassSingleton() {
		// 防止反射创建多个对象
		if (LazyHolder.LAZY != null) {
			throw new RuntimeException("只能实例化1个对象");
		}
	}

	// 公有的获取实例方法
	public static final LazyInnerClassSingleton getInstance() {
		return LazyHolder.LAZY;
	}

	// 静态内部类
	private static class LazyHolder {
		private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
	} // 防止序列化创建多个对象,这个方法是关键

	private Object readResolve() {
		return LazyHolder.LAZY;
	}
}

