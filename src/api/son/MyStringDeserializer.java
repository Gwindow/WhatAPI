
package api.son;

import java.lang.reflect.Type;

import api.util.StringUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * The Class MyStringDeserializer.
 * 
 * //TODO description
 * 
 * @author Gwindow
 */
public class MyStringDeserializer implements JsonDeserializer<Object> {
	
	/* (non-Javadoc)
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		String s = StringUtils.unescapeHTML(json.getAsJsonPrimitive().getAsString());
		return s;

	}
}