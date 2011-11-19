/**
 * @author Gwindow
 */
package api.util;

/**
 * The Class CouldNotLoadException.
 */
@SuppressWarnings("serial")
public class CouldNotLoadException extends Exception {
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

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return error;
	}

}
