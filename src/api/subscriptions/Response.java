package api.subscriptions;

import java.util.List;

public class Response {
	private List<Threads> threads;

	public List<Threads> getThreads() {
		return this.threads;
	}

	@Override
	public String toString() {
		return "Response [getThreads=" + getThreads() + "]";
	}

}
