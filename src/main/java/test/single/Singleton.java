package test.single;

import java.util.EnumSet;

public class Singleton {

	private Singleton() {

	}

	public enum SingletonEnum{

		SEED,SEED2;

		private Singleton singleton;

		SingletonEnum() {
			singleton = new Singleton();
		}

		public Singleton getSingleton() {
			return singleton;
		}
	}


	public static void main(String[] args) {
		System.out.println(SingletonEnum.SEED.getSingleton());
		System.out.println(SingletonEnum.SEED.getSingleton());
		System.out.println(SingletonEnum.SEED.getSingleton());
		System.out.println(SingletonEnum.SEED2.getSingleton());
		System.out.println(SingletonEnum.SEED2.getSingleton());

		EnumSet<SingletonEnum> seed = EnumSet.of( SingletonEnum.SEED2);
		System.out.println(seed.contains(SingletonEnum.SEED));

	}
}
