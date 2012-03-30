package api.better;

public class Results {
	private String name;
	private Number uses;
	private Number posVotes;
	private Number negVotes;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the uses
	 */
	public Number getUses() {
		return uses;
	}

	/**
	 * @return the posVotes
	 */
	public Number getPosVotes() {
		return posVotes;
	}

	/**
	 * @return the negVotes
	 */
	public Number getNegVotes() {
		return negVotes;
	}

	/* (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString() */
	@Override
	public String toString() {
		return "Results [name=" + name + ", uses=" + uses + ", posVotes=" + posVotes + ", negVotes=" + negVotes + "]";
	}
}
