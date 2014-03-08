package api.torrents;

/**
 * Enum for different release types, like album, mixtape, etc
 */
public enum ReleaseType {
	//These numbers don't correspond to the API numbers used since I'll
	//be using them for array indexing
	ALBUM(1), SOUNDTRACK(2), EP(3), ANTHOLOGY(4), COMPILATION(5),
	DJ_MIX(6), SINGLE(7), LIVE_ALBUM(8), REMIX(9), BOOTLEG(10),
	INTERVIEW(11), MIXTAPE(12), CONCERT_RECORDING(13), ARTIST(14),
	GUEST_ARTIST(15), COMPOSER(16), CONDUCTOR(17), DJ(18), REMIXED_BY(19),
	PRODUCER(20), UNKNOWN(21);

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
			case 2:
				return "Soundtrack";
			case 3:
				return "EP";
			case 4:
				return "Anthology";
			case 5:
				return "Compilation";
			case 6:
				return "DJ Mix";
			case 7:
				return "Single";
			case 8:
				return "Live Album";
			case 9:
				return "Remix";
			case 10:
				return "Bootleg";
			case 11:
				return "Interview";
			case 12:
				return "Mixtape";
			case 13:
				return "Concert Recording";
			case 14:
				return "Artist";
			case 15:
				return "Guest Artist";
			case 16:
				return "Composer";
			case 17:
				return "Conductor";
			case 18:
				return "DJ";
			case 19:
				return "Remixed By";
			case 20:
				return "Producer";
			default:
				return "Unknown";
		}
	}
}
