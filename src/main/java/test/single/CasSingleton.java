package test.single;

import java.util.concurrent.atomic.AtomicReference;

public class CasSingleton {

	private static final AtomicReference<CasSingleton> INSTANCE = new AtomicReference<>();

	private CasSingleton(){}

	public static CasSingleton getInstance() {

		for (; ; ) {

			CasSingleton singleton = INSTANCE.get();
			if (null != singleton) {
				return singleton;
			}

			singleton = new CasSingleton();
			if (INSTANCE.compareAndSet(null, singleton)) {
				return singleton;
			}

		}
	}
}
