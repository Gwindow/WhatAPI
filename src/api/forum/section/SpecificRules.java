package api.forum.section;

public class SpecificRules {
	private String threadId;
	private String thread;

	public String getThreadId() {
		return threadId;
	}

	public String getThread() {
		return thread;
	}

	@Override
	public String toString() {
		return "SpecificRules [getThreadId=" + getThreadId() + ", getThread=" + getThread() + "]";
	}

}
