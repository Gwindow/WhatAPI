package api.util;

public class Tuple<A,B> {
	private A a;
	private B b;
	public Tuple(A a,B b) {
		this.a = a;
		this.b = b;
	}
	public A getA() {
		return a;
	}
	public B getB() {
		return b;
	}
	public void setA(A a) {
		this.a = a;
	}
	public void setB(B b) {
		this.b = b;
	}
	public String toString() {
		return a + "," + b;
	}

}
