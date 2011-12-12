


package api.util;

/**
 * The Class Septuple.
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
 * @param <F>
 *            the generic type
 * @param <G>
 *            the generic type
 * @author Gwindow
 */
public class Septuple<A, B, C, D, E, F, G> {
	
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
	
	/** The f. */
	private F f;
	
	/** The g. */
	private G g;

	/**
	 * Instantiates a new septuple.
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
	 * @param f
	 *            the f
	 * @param g
	 *            the g
	 */
	public Septuple(A a, B b, C c, D d, E e, F f, G g) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		this.g = g;
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

	/**
	 * Gets the f.
	 * 
	 * @return the f
	 */
	public F getF() {
		return f;
	}

	/**
	 * Sets the f.
	 * 
	 * @param f
	 *            the new f
	 */
	public void setF(F f) {
		this.f = f;
	}

	/**
	 * Gets the g.
	 * 
	 * @return the g
	 */
	public G getG() {
		return g;
	}

	/**
	 * Sets the g.
	 * 
	 * @param g
	 *            the new g
	 */
	public void setG(G g) {
		this.g = g;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return a + "," + b + "," + c + "," + d + "," + e + "," + f + "," + g;
	}

}
