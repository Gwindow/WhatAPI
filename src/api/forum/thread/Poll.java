



package api.forum.thread;

import java.util.List;

/**
 * The Class Poll.
 * 
 * @author Gwindow
 */
public class Poll {
	
	/** The answers. */
	private List<Answers> answers;
	
	/** The closed. */
	private boolean closed;
	
	/** The featured. */
	private String featured;
	
	/** The max votes. */
	private Number maxVotes;
	
	/** The question. */
	private String question;
	
	/** The total votes. */
	private Number totalVotes;
	
	/** The voted. */
	private boolean voted;

	/**
	 * Checks if is featured.
	 * 
	 * @return true if featured
	 */
	public boolean isFeatured() {
        return featured.equalsIgnoreCase("0000-00-00 00:00:00");
	}

	/**
	 * Gets the answers.
	 * 
	 * @return the answers
	 */
	public List<Answers> getAnswers() {
		return answers;
	}

	/**
	 * Checks if is closed.
	 * 
	 * @return the closed
	 */
	public boolean isClosed() {
		return closed;
	}

	/**
	 * Gets the max votes.
	 * 
	 * @return the maxVotes
	 */
	public Number getMaxVotes() {
		return maxVotes;
	}

	/**
	 * Gets the question.
	 * 
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Gets the total votes.
	 * 
	 * @return the totalVotes
	 */
	public Number getTotalVotes() {
		return totalVotes;
	}

	/**
	 * Checks for voted.
	 * 
	 * @return the voted
	 */
	public boolean hasVoted() {
		return voted;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Poll [getAnswers=" + getAnswers() + ", isClosed=" + isClosed() + ", isFeatured=" + isFeatured()
				+ ", getMaxVotes=" + getMaxVotes() + ", getQuestion=" + getQuestion() + ", getTotalVotes=" + getTotalVotes()
				+ ", hasVoted=" + hasVoted() + "]";
	}
}
