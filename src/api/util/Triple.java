



package api.util;

/**
 * The Class Triple.
 * 
 * @param <A>
 *            the generic type
 * @param <B>
 *            the generic type
 * @param <C>
 *            the generic type
 * @author Gwindow
 */
public class Triple<A,B,C> {
	
	/** The a. */
	private A a;
	
	/** The b. */
	private B b;
	
	/** The c. */
	private C c;
	
	/**
	 * Instantiates a new triple.
	 * 
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 * @param c
	 *            the c
	 */
	public Triple(A a, B b,C c) {
		this.a = a;
		this.b = b;
		this.c = c;
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
	 * Gets the c.
	 * 
	 * @return the c
	 */
	public C getC() {
		return c;
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
	
	/**
	 * Sets the c.
	 * 
	 * @param c
	 *            the new c
	 */
	public void setC(C c) {
		this.c = c;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return a + "," + b + "," + c;
	}
}
