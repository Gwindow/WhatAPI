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
				return "Albums";
			case 2:
				return "Soundtracks";
			case 3:
				return "EPs";
			case 4:
				return "Anthologies";
			case 5:
				return "Compilations";
			case 6:
				return "DJ Mixes";
			case 7:
				return "Singles";
			case 8:
				return "Live Albums";
			case 9:
				return "Remixes";
			case 10:
				return "Bootlegs";
			case 11:
				return "Interviews";
			case 12:
				return "Mixtapes";
			case 13:
				return "Concert Recordings";
			case 14:
				return "Artist";
			case 15:
				return "Guest Appearances";
			case 16:
				return "Compositions";
			case 17:
				return "Conducted By";
			case 18:
				return "DJ";
			case 19:
				return "Remixed By";
			case 20:
				return "Produced By";
			default:
				return "Unknown";
		}
	}
}
