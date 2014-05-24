package api.forum.thread;

import api.soup.MySoup;
import api.util.CouldNotLoadException;
import api.util.Tuple;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Poll.
 * Stores information returned from the API about a
 * thread's Poll
 * 
 * @author Gwindow
 */
public class Poll {
    /** The question. */
    private String question;

	/** The possible answers */
	private List<Answer> answers;

	/**
	 * If the poll's been featured on the home page
	 */
	private String featured;

	/** The max votes. */
	private Number maxVotes;

	/** The total votes. */
	private Number totalVotes;

    /** If the poll is closed */
    private boolean closed;
	
	/** If we've voted on the poll */
	private boolean voted;

    /**
     * Get the question.
     *
     * @return the question
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * Get the possible answers
     *
     * @return the answers
     */
    public List<Answer> getAnswers() {
        return this.answers;
    }

	/**
	 * Check if the poll is featured
	 * 
	 * @return True if featured
	 */
	public boolean isFeatured() {
        return this.featured.equalsIgnoreCase("0000-00-00 00:00:00");
	}

	/**
	 * Get the max votes
	 * 
	 * @return the max votes
	 */
	public Number getMaxVotes() {
		return this.maxVotes;
	}

	/**
	 * Get the total votes
	 * 
	 * @return the total votes
	 */
	public Number getTotalVotes() {
		return this.totalVotes;
	}

    /**
     * Check if the poll is closed
     *
     * @return True if the poll is closed
     */
    public boolean isClosed() {
        return this.closed;
    }

	/**
	 * Check if we've voted on the poll
	 * 
	 * @return True if we've voted
	 */
	public boolean hasVoted() {
		return this.voted;
	}

	public static boolean vote(int threadid, int vote){
		try {
			System.out.println("Voting on thread " + threadid + ", vote " + vote);
			String url = "index.php";
			List<Tuple<String, String>> list = new ArrayList<Tuple<String, String>>();
			list.add(new Tuple<String, String>("action", "poll"));
			list.add(new Tuple<String, String>("auth", MySoup.getAuthKey()));
			list.add(new Tuple<String, String>("topicid", Integer.toString(threadid)));
			list.add(new Tuple<String, String>("vote", Integer.toString(vote)));
			MySoup.postMethod(url, list);
		}
		catch (CouldNotLoadException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Poll [getAnswers=" + getAnswers() + ", isClosed=" + isClosed() + ", isFeatured=" + isFeatured()
				+ ", getMaxVotes=" + getMaxVotes() + ", getQuestion=" + getQuestion() + ", getTotalVotes=" + getTotalVotes()
				+ ", hasVoted=" + hasVoted() + "]";
	}
}
