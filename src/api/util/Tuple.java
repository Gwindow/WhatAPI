package api.util;

/**
 * The Class Tuple.
 * 
 * @param <A>
 *            the generic type
 * @param <B>
 *            the generic type
 * @author Gwindow
 */
public class Tuple<A, B> {

	/** The a. */
	private A a;

	/** The b. */
	private B b;

	/**
	 * Instantiates a new tuple.
	 * 
	 * @param a
	 *            the a
	 * @param b
	 *            the b
	 */
	public Tuple(A a, B b) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return a + "," + b;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple<A, B> other = (Tuple<A, B>) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		return true;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setB(B b) {
		this.b = b;
	}

	/**
	 * @param a
	 *            the a to set
	 */
	public void setA(A a) {
		this.a = a;
	}

}
