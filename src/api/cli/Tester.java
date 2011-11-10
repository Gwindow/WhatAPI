package api.cli;

import api.son.TestObject;
import api.util.CouldNotLoadException;

public class Tester {
	public Tester() throws CouldNotLoadException {
		TestObject to = TestObject.init();
		System.out.println(to.toString());

	}

	public static void main(String[] args) throws CouldNotLoadException {
		new Tester();
	}
}
