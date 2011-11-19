package api.forum.thread;

import java.util.List;

public class Poll {
	private List<Answers> answers;
	private boolean closed;
	private String featured;
	private Number maxVotes;
	private String question;
	private Number totalVotes;
	private boolean voted;

	/**
	 * 
	 * @return true if featured
	 */
	public boolean isFeatured() {
		if (featured.equalsIgnoreCase("0000-00-00 00:00:00"))
			return false;
		else
			return true;
	}

	/**
	 * @return the answers
	 */
	public List<Answers> getAnswers() {
		return answers;
	}

	/**
	 * @return the closed
	 */
	public boolean isClosed() {
		return closed;
	}

	/**
	 * @return the maxVotes
	 */
	public Number getMaxVotes() {
		return maxVotes;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @return the totalVotes
	 */
	public Number getTotalVotes() {
		return totalVotes;
	}

	/**
	 * @return the voted
	 */
	public boolean hasVoted() {
		return voted;
	}

	@Override
	public String toString() {
		return "Poll [getAnswers=" + getAnswers() + ", isClosed=" + isClosed() + ", isFeatured=" + isFeatured()
				+ ", getMaxVotes=" + getMaxVotes() + ", getQuestion=" + getQuestion() + ", getTotalVotes=" + getTotalVotes()
				+ ", hasVoted=" + hasVoted() + "]";
	}
}
