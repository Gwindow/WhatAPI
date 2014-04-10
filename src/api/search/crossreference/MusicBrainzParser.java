package api.search.crossreference;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * MusicBrainzParser is a simple xml SAX Handler for MusicBrainz Release Queries with &limit=1
 */
public class MusicBrainzParser extends DefaultHandler {
	boolean name = false;
	boolean artist = false;
	boolean title = false;

	public String searchString = "";

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException{
		if (qName.equalsIgnoreCase("artist")){
			artist = true;
		}
		else if (qName.equalsIgnoreCase("name")){
			name = true;
		}
		else if (qName.equalsIgnoreCase("title")){
			title = true;
		}
	}

	@Override
	public void characters(char ch[], int start, int length) throws SAXException{
		//We want artist name to appear before the title
		if (artist && name){
			if (!searchString.isEmpty()){
				searchString = " " + searchString;
			}
			searchString = new String(ch, start, length) + searchString;
		}
		else if (title){
			if (!searchString.isEmpty()){
				searchString += " ";
			}
			searchString += new String(ch, start, length);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException{
		if (qName.equalsIgnoreCase("name")){
			name = false;
		}
		else if (qName.equalsIgnoreCase("title")){
			title = false;
		}
		else if (qName.equalsIgnoreCase("artist")){
			artist = false;
		}
	}
}
