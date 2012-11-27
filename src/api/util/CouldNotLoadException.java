package api.util;

/**
 * The Class CouldNotLoadException.
 * 
 * @author Gwindow
 */
@SuppressWarnings("serial")
public class CouldNotLoadException extends Exception {
	
	/** The error. */
	String error;

	/**
	 * Instantiates a new could not load exception.
	 * 
	 * @param error
	 *            the error
	 */
	public CouldNotLoadException(String error) {
		this.error = error;
	}

	@Override
	public String getMessage() {
		return error;
	}

}
