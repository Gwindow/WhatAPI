package api.son;

import java.lang.reflect.Type;

import api.util.StringUtils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * The Class MyStringDeserializer.
 * A custom string deserializer where we add in unescaping of
 * HTML to the deserialization process
 *
 * @author Gwindow
 */
public class MyStringDeserializer implements JsonDeserializer<Object> {
	
	/**
     * We get the json as a string, unescape any html characters and return it back
     *
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return StringEscapeUtils.unescapeHtml4(json.getAsJsonPrimitive().getAsString());
	}
}