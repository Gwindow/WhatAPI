package api.forum.thread;

/**
 * The Class Answer.
 * Stores information about an possible answer selection
 * for a Poll
 * 
 * @author Gwindow
 */
public class Answer {
	/** The answer text */
	private String answer;
	
	/** The percent of votes it's gotten */
	private Number percent;
	
	/** The ratio of votes it's gotten */
	private Number ratio;

	/**
	 * Get the answer text
	 * 
	 * @return the answer text
	 */
	public String getAnswer() {
		try {
			return this.answer;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Get the percent of votes the answers received
	 * 
	 * @return the percent of votes received
	 */
	public Number getPercent() {
		try {
			return this.percent;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Get the ratio of votes the answers received
	 * 
	 * @return the ratio of votes received
	 */
	public Number getRatio() {
		try {
			return this.ratio;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String toString() {
		return "Answer [getAnswer=" + getAnswer() + ", getPercent=" + getPercent() + ", getRatio=" + getRatio() + "]";
	}
}
