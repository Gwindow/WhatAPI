package api.forum.thread;

import java.util.List;

public class Poll {
	private List<Answers> answers;
	private String closed;
	private String featured;
	private String maxVotes;
	private String question;
	private Number totalVotes;
	private boolean voted;

	public List<Answers> getAnswers() {
		return this.answers;
	}

	public boolean isClosed() {
		if (closed.equalsIgnoreCase("0"))
			return false;
		else
			return true;
	}

	public boolean isFeatured() {
		if (featured.equalsIgnoreCase("0000-00-00 00:00:00"))
			return false;
		else
			return true;
	}

	public String getMaxVotes() {
		return this.maxVotes;
	}

	public String getQuestion() {
		return this.question;
	}

	public Number getTotalVotes() {
		return this.totalVotes;
	}

	public boolean hasVoted() {
		return this.voted;
	}

	@Override
	public String toString() {
		return "Poll [getAnswers=" + getAnswers() + ", isClosed=" + isClosed() + ", isFeatured=" + isFeatured()
				+ ", getMaxVotes=" + getMaxVotes() + ", getQuestion=" + getQuestion() + ", getTotalVotes=" + getTotalVotes()
				+ ", hasVoted=" + hasVoted() + "]";
	}
}
