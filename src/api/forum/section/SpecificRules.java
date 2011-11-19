package api.forum.section;

public class SpecificRules {
	private Number threadId;
	private String thread;

	public Number getThreadId() {
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
