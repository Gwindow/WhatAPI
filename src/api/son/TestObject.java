package api.son;

public class TestObject {
	int site;

	public static TestObject init() {
		String json = "{\"site\":\"a\"}";
		TestObject to = (TestObject) MySon.toObjectFromString(json, TestObject.class);
		return to;
	}

	public int getSite() {
		return site;
		// return Integer.parseInt(site);
	}

	@Override
	public String toString() {
		return "TestObject [getSite=" + getSite() + "]";
	}

}
