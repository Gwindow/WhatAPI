package api.user;

/**
 * User's stats
 * 
 * @author Tim
 * 
 */
public class Stats {
	private String downloaded;
	private String joinedDate;
	private String lastAccess;
	private Number ratio;
	private String requiredRatio;
	private String uploaded;

	public String getDownloaded() {
		return this.downloaded;
	}

	public String getJoinedDate() {
		return this.joinedDate;
	}

	public String getLastAccess() {
		return this.lastAccess;
	}

	public Number getRatio() {
		return this.ratio;
	}

	public String getRequiredRatio() {
		return this.requiredRatio;
	}

	public String getUploaded() {
		return this.uploaded;
	}

	@Override
	public String toString() {
		return "Stats [downloaded=" + downloaded + ", joinedDate=" + joinedDate + ", lastAccess=" + lastAccess + ", ratio="
				+ ratio + ", requiredRatio=" + requiredRatio + ", uploaded=" + uploaded + "]";
	}
}
