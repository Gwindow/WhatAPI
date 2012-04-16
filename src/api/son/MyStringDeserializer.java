package api.son;

import java.lang.reflect.Type;

import api.util.StringUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class MyStringDeserializer implements JsonDeserializer<Object> {
	@Override
	public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		String s = StringUtils.unescapeHTML(json.getAsJsonPrimitive().getAsString());
		return s;

	}
}