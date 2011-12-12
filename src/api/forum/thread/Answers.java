


package api.forum.thread;

/**
 * The Class Answers.
 * 
 * @author Gwindow
 */
public class Answers {
	
	/** The answer. */
	private String answer;
	
	/** The percent. */
	private Number percent;
	
	/** The ratio. */
	private Number ratio;

	/**
	 * Gets the answer.
	 * 
	 * @return the answer
	 */
	public String getAnswer() {
		try {
			return this.answer;
		} catch (Exception e) {
			return null;

		}
	}

	/**
	 * Gets the percent.
	 * 
	 * @return the percent
	 */
	public Number getPercent() {
		try {
			return this.percent;
		} catch (Exception e) {
			return null;

		}
	}

	/**
	 * Gets the ratio.
	 * 
	 * @return the ratio
	 */
	public Number getRatio() {
		try {
			return this.ratio;
		} catch (Exception e) {
			return null;

		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Answers [getAnswer=" + getAnswer() + ", getPercent=" + getPercent() + ", getRatio=" + getRatio() + "]";
	}
}
