package test;

public interface CarTree {

	String getBrandModel();

	enum BmwEnum implements CarTree{
		X1("x1", "宝马"),
		X2("x2", "宝马"),
		X6("x6", "宝马");

		String model;
		String brand;

		BmwEnum(String model, String brand) {
			this.model = model;
			this.brand = brand;
		}

		@Override
		public String getBrandModel() {
			return this.brand + "-" + this.model;
		}
	}

	enum BuickEnum implements CarTree {
		Regal("君威", "别克");

		String model;
		String brand;

		BuickEnum(String model, String brand) {
			this.model = model;
			this.brand = brand;
		}

		@Override
		public String getBrandModel() {
			return this.brand + "-" + this.model;
		}
	}

}


