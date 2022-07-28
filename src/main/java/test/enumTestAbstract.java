package test;

public enum enumTestAbstract {

	NORMAL(1) {
		@Override
		void run() {
			System.out.println("normal");

		}
	},
	FAST (2){
		@Override
		void run() {
			System.out.println("fast");

		}
	};


	enumTestAbstract(int i) {

	}

	abstract void run();

	public static void main(String[] args) {
		enumTestAbstract testAbstract = enumTestAbstract.valueOf("FAST");
		testAbstract.run();
		System.out.println("ordinal:" + testAbstract.ordinal());
		System.out.println("name:" + testAbstract.name());
		System.out.println(testAbstract.toString());

	}
}
