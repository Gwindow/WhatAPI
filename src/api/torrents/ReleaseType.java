package api.torrents;

/**
 * Enum for different release types, like album, mixtape, etc
 */
public enum ReleaseType {
	ALBUM(1), SOUNDTRACK(3), EP(5), ANTHOLOGY(6), COMPILATION(7),
	DJ_MIX(8), SINGLE(9), LIVE_ALBUM(11), REMIX(13), BOOTLEG(14),
	INTERVIEW(15), MIXTAPE(16), UNKNOWN(21), CONCERT_RECORDING(22);

	/**
	 * This is the actual release type number used on the site
	 */
	private final int id;

	private ReleaseType(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
	public String toString(){
		switch (id){
			case 1:
				return "Album";
			case 3:
				return "Soundtrack";
			case 5:
				return "EP";
			case 6:
				return "Anthology";
			case 7:
				return "Compilation";
			case 8:
				return "DJ Mix";
			case 9:
				return "Single";
			case 11:
				return "Live Album";
			case 13:
				return "Remix";
			case 14:
				return "Bootleg";
			case 15:
				return "Interview";
			case 16:
				return "Mixtape";
			case 22:
				return "Concert Recording";
			default:
				return "Unknown";
		}
	}
}
