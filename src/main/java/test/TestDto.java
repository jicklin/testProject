package test;

public class TestDto {
	private String id;

	private TestChildDto child;

	public TestChildDto getChild() {
		return child;
	}

	public void setChild(TestChildDto child) {
		this.child = child;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TestDto{" +
				"id='" + id + '\'' +
				", childDto=" + child +
				'}';
	}
}
