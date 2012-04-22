



package api.util;

/**
 * The Class Quintuple.
 * 
 * @param <A>
 *            the generic type
 * @param <B>
 *            the generic type
 * @param <C>
 *            the generic type
 * @param <D>
 *            the generic type
 * @param <E>
 *            the element type
 * @author Gwindow
 */
public class Quintuple<A, B, C, D, E> {
	
	/** The a. */
	private A a;
	
	/** The b. */
	private B b;
	
	/** The c. */
	private C c;
	
	/** The d. */
	private D d;
	
	/** The e. */
	private E e;

	/**
	 * Instantiates a new quintuple.
	 * 
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 * @param c
	 *            the c
	 * @param d
	 *            the d
	 * @param e
	 *            the e
	 */
	public Quintuple(A a, B b, C c, D d, E e) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
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

	/**
	 * Gets the e.
	 * 
	 * @return the e
	 */
	public E getE() {
		return e;
	}

	/**
	 * Sets the e.
	 * 
	 * @param e
	 *            the new e
	 */
	public void setE(E e) {
		this.e = e;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return a + "," + b + "," + c + "," + d + "," + e;
	}
}
