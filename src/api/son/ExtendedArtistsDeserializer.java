package api.son;

import api.torrents.artist.TorrentGroup;
import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Extended artists deserializer to handle the special case where there are none and we
 * get back false instead of an empty object. This is kind of a hack to deal with some brokenness
 * in the API but it should be fixed soonish
 */
public class ExtendedArtistsDeserializer implements JsonDeserializer<TorrentGroup.ExtendedArtists> {
	/**
	 * Need our own to do the deserialization for us if it's safe to do (ie. it's actually an object)
	 */
	private final static Gson gson = new GsonBuilder().registerTypeAdapter(String.class,
		new MyStringDeserializer()).serializeNulls().serializeSpecialFloatingPointValues().create();

	@Override
	public TorrentGroup.ExtendedArtists deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException{
		try {
			if (jsonElement.isJsonObject()){
				return gson.fromJson(jsonElement, type);
			}
		}
		catch (ClassCastException e){
			throw new JsonParseException("Failed to parse Extended Artists");
		}
		return null;
	}
}
