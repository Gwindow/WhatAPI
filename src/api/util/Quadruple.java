package api.util;

/**
 * The Class Quadruple.
 * 
 * @param <A>
 *            the generic type
 * @param <B>
 *            the generic type
 * @param <C>
 *            the generic type
 * @param <D>
 *            the generic type
 * @author Tim
 */

public class Quadruple<A, B, C, D> {
	
	/** The a. */
	private A a;
	
	/** The b. */
	private B b;
	
	/** The c. */
	private C c;
	
	/** The d. */
	private D d;

	/**
	 * Instantiates a new quadruple.
	 * 
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 * @param c
	 *            the c
	 * @param d
	 *            the d
	 */
	public Quadruple(A a, B b, C c, D d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
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
	 * Gets the d.
	 * 
	 * @return the d
	 */
	public D getD() {
		return d;
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

	/**
	 * Sets the d.
	 * 
	 * @param d
	 *            the new d
	 */
	public void setD(D d) {
		this.d = d;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return a + "," + b + "," + c + "," + d;
	}
}
