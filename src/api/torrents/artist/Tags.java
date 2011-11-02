package api.torrents.artist;


public class Tags {
	private Number count;
	private String name;

	public Number getCount() {
		return this.count;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "Tags [getCount=" + getCount() + ", getName=" + getName() + "]";
	}
}
