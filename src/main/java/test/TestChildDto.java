package test;

public class TestChildDto {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestChildDto{" +
				"name='" + name + '\'' +
				'}';
	}
}
