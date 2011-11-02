package api.forum.thread;

public class Answers {
	private String answer;
	private Number percent;
	private Number ratio;

	public String getAnswer() {
		try {
			return this.answer;
		} catch (Exception e) {
			return null;

		}
	}

	public Number getPercent() {
		try {
			return this.percent;
		} catch (Exception e) {
			return null;

		}
	}

	public Number getRatio() {
		try {
			return this.ratio;
		} catch (Exception e) {
			return null;

		}
	}

	@Override
	public String toString() {
		return "Answers [getAnswer=" + getAnswer() + ", getPercent=" + getPercent() + ", getRatio=" + getRatio() + "]";
	}
}
