/**
 * @author Gwindow
 */
package api.util;

/**
 * The Class Tuple.
 * 
 * @param <A>
 *            the generic type
 * @param <B>
 *            the generic type
 */
public class Tuple<A,B> {
	private A a;
	private B b;
	
	/**
	 * Instantiates a new tuple.
	 * 
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 */
	public Tuple(A a,B b) {
		this.a = a;
		this.b = b;
	}
	
	/**
	 * Gets the a.
	 * 
	 * @return the a
	 */
	public A getA() {
		return a;
	}
	
	/**
	 * Gets the b.
	 * 
	 * @return the b
	 */
	public B getB() {
		return b;
	}
	
	/**
	 * Sets the a.
	 * 
	 * @param a
	 *            the new a
	 */
	public void setA(A a) {
		this.a = a;
	}
	
	/**
	 * Sets the b.
	 * 
	 * @param b
	 *            the new b
	 */
	public void setB(B b) {
		this.b = b;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return a + "," + b;
	}

}
