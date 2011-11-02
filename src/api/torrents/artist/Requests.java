package api.torrents.artist;

public class Requests {
	private String bounty;
	private String categoryId;
	private String requestId;
	private String timeAdded;
	private String title;
	private String votes;
	private String year;

	public String getBounty() {
		return this.bounty;
	}

	public String getCategoryId() {
		return this.categoryId;
	}

	public String getRequestId() {
		return this.requestId;
	}

	public String getTimeAdded() {
		return this.timeAdded;
	}

	public String getTitle() {
		return this.title;
	}

	public String getVotes() {
		return this.votes;
	}

	public String getYear() {
		return this.year;
	}

	@Override
	public String toString() {
		return "Requests [getBounty=" + getBounty() + ", getCategoryId=" + getCategoryId() + ", getRequestId=" + getRequestId()
				+ ", getTimeAdded=" + getTimeAdded() + ", getTitle=" + getTitle() + ", getVotes=" + getVotes() + ", getYear="
				+ getYear() + "]";
	}
}
