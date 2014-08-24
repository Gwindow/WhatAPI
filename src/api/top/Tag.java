package api.top;

/**
 * Holds information about a top tag
 */
public class Tag {
	/**
	 * The tag name
	 */
	private String name;

	/**
	 * The number of times this tag has been used
	 */
	private Integer uses;

	/**
	 * The number of positive votes for this tag
	 */
	private Integer posVotes;

	/**
	 * The number of negative votes for this tag
	 */
	private Integer negVotes;

	public String getName(){
		return name;
	}

	public Integer getUses(){
		return uses;
	}

	public Integer getPosVotes(){
		return posVotes;
	}

	public Integer getNegVotes(){
		return negVotes;
	}

	@Override
	public String toString(){
		return "top.Tag [ name = " + name + ", uses = " + uses + ", posVotes = " + posVotes
			+ ", negVotes = " + negVotes + " ]";
	}
}
