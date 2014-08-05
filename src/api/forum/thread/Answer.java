package api.forum.thread;

/**
 * The Class Answer.
 * Stores information about an possible answer selection
 * for a Poll
 *
 * @author Gwindow
 */
public class Answer {
	/**
	 * The answer text
	 */
	private String answer;

	/**
	 * The percent of votes it's gotten
	 */
	private Number percent;

	/**
	 * The ratio of votes it's gotten
	 */
	private Number ratio;

	/**
	 * Get the answer text
	 *
	 * @return the answer text
	 */
	public String getAnswer(){
		return this.answer;
	}

	/**
	 * Get the percent of votes the answers received
	 *
	 * @return the percent of votes received
	 */
	public Number getPercent(){
		return this.percent;
	}

	/**
	 * Get the ratio of votes the answers received
	 *
	 * @return the ratio of votes received
	 */
	public Number getRatio(){
		return this.ratio;
	}

	public void setPercent(float percent){
		this.percent = percent;
	}

	public void setRatio(float ratio){
		this.ratio = ratio;
	}

	@Override
	public String toString(){
		return "Answer [getAnswer=" + getAnswer() + ", getPercent=" + getPercent() + ", getRatio=" + getRatio() + "]";
	}
}
