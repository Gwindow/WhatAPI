package api.products;

/**
 * Information about some product returned back from the Semantics3 API.
 * This class only includes the information that we actually need to build
 * the search terms
 */
public class Product {
	private String category, name, label, upc;

	public String getCategory(){
		return category;
	}

	/**
	 * The category is actually the genre of music but isn't formatted properly
	 * to be used as a search tag for the site. Use this function to get a site
	 * formatted tag for the genre. May need some fine tuning to handle different
	 * tags nicely.
	 */
	public String getSiteTags(){
		String tags = category;
		//If there's an ' &' (like Dance & DJ) then just take the string before sequence
		int ampersand = tags.indexOf(" &");
		if (ampersand != -1){
			tags = tags.substring(0, ampersand);
		}
		return tags.toLowerCase().replace(' ', '.');
	}

	public String getName(){
		return name;
	}

	public String getLabel(){
		return label;
	}

	public String getUpc(){
		return upc;
	}

	@Override
	public String toString(){
		return "Product [name=" + name + ", category=" + category
			+ ", label=" + label + ", upc=" + upc + ", tags=" + getSiteTags() + "]";
	}
}
