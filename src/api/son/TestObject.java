


package api.son;

/**
 * The Class TestObject.
 * 
 * @author Gwindow
 */
public class TestObject {
	int site;

	/**
	 * Inits the.
	 * 
	 * @return the test object
	 */
	public static TestObject init() {
		String json = "{\"site\":\"a\"}";
		TestObject to = (TestObject) MySon.toObjectFromString(json, TestObject.class);
		return to;
	}

	/**
	 * Gets the site.
	 * 
	 * @return the site
	 */
	public int getSite() {
		return site;
		// return Integer.parseInt(site);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestObject [getSite=" + getSite() + "]";
	}

}
