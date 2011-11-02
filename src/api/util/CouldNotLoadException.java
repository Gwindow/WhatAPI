package api.util;

@SuppressWarnings("serial")
public class CouldNotLoadException extends Exception {
	String error;

	public CouldNotLoadException(String error) {
		this.error = error;
	}

	@Override
	public String getMessage() {
		return error;
	}

}
