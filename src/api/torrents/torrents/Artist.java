package api.torrents.torrents;

/**
 * A more generic Artist type for an artist on a torrent group
 * Specifically created to make handling Torrent Group artists in the app easier
 */
public class Artist {
	private Number id;
	private String name;
	private Type type;

	/**
	 * Construct the generic artist type for some artist's appearance on the torrent group
	 *
	 * @param id   artist id
	 * @param name artist name
	 * @param type type of appearance made
	 */
	public Artist(Number id, String name, Type type){
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public Number getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public Type getType(){
		return type;
	}

	@Override
	public String toString(){
		return "Artist [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

	public enum Type {
		ARTIST, GUEST, COMPOSER, CONDUCTOR, DJ, REMIXER, PRODUCER;

		@Override
		public String toString(){
			switch (this){
				case ARTIST:
					return "Artist";
				case GUEST:
					return "Guest";
				case COMPOSER:
					return "Composer";
				case CONDUCTOR:
					return "Conductor";
				case DJ:
					return "DJ";
				case REMIXER:
					return "Remixer";
				default:
					return "Producer";
			}
		}
	}
}
