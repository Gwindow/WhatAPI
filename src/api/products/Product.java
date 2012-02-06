package api.products;

import java.util.List;

/**
 * The Class Product.
 * 
 * @author Gwindow
 */
public class Product {

	/** The author. */
	private Author author;

	/** The brand. */
	private String brand;

	/** The condition. */
	private String condition;

	/** The country. */
	private String country;

	/** The creation time. */
	private String creationTime;

	/** The description. */
	private String description;

	/** The google id. */
	private String googleId;

	/** The gtin. */
	private String gtin;

	/** The gtins. */
	private List<String> gtins;

	/** The images. */
	private List<Images> images;

	/** The inventories. */
	private List<Inventories> inventories;

	/** The language. */
	private String language;

	/** The link. */
	private String link;

	/** The modification time. */
	private String modificationTime;

	/** The title. */
	private String title;

	/**
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public Author getAuthor() {
		return this.author;
	}

	/**
	 * Sets the author.
	 * 
	 * @param author
	 *            the new author
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * Gets the brand.
	 * 
	 * @return the brand
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * Sets the brand.
	 * 
	 * @param brand
	 *            the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the condition.
	 * 
	 * @return the condition
	 */
	public String getCondition() {
		return this.condition;
	}

	/**
	 * Sets the condition.
	 * 
	 * @param condition
	 *            the new condition
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country
	 *            the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the creation time.
	 * 
	 * @return the creation time
	 */
	public String getCreationTime() {
		return this.creationTime;
	}

	/**
	 * Sets the creation time.
	 * 
	 * @param creationTime
	 *            the new creation time
	 */
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the google id.
	 * 
	 * @return the google id
	 */
	public String getGoogleId() {
		return this.googleId;
	}

	/**
	 * Sets the google id.
	 * 
	 * @param googleId
	 *            the new google id
	 */
	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	/**
	 * Gets the gtin.
	 * 
	 * @return the gtin
	 */
	public String getGtin() {
		return this.gtin;
	}

	/**
	 * Sets the gtin.
	 * 
	 * @param gtin
	 *            the new gtin
	 */
	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	/**
	 * Gets the gtins.
	 * 
	 * @return the gtins
	 */
	public List<String> getGtins() {
		return this.gtins;
	}

	/**
	 * Sets the gtins.
	 * 
	 * @param gtins
	 *            the new gtins
	 */
	public void setGtins(List<String> gtins) {
		this.gtins = gtins;
	}

	/**
	 * Gets the images.
	 * 
	 * @return the images
	 */
	public List<Images> getImages() {
		return this.images;
	}

	/**
	 * Sets the images.
	 * 
	 * @param images
	 *            the new images
	 */
	public void setImages(List<Images> images) {
		this.images = images;
	}

	/**
	 * Gets the inventories.
	 * 
	 * @return the inventories
	 */
	public List<Inventories> getInventories() {
		return this.inventories;
	}

	/**
	 * Sets the inventories.
	 * 
	 * @param inventories
	 *            the new inventories
	 */
	public void setInventories(List<Inventories> inventories) {
		this.inventories = inventories;
	}

	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public String getLanguage() {
		return this.language;
	}

	/**
	 * Sets the language.
	 * 
	 * @param language
	 *            the new language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Gets the link.
	 * 
	 * @return the link
	 */
	public String getLink() {
		return this.link;
	}

	/**
	 * Sets the link.
	 * 
	 * @param link
	 *            the new link
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Gets the modification time.
	 * 
	 * @return the modification time
	 */
	public String getModificationTime() {
		return this.modificationTime;
	}

	/**
	 * Sets the modification time.
	 * 
	 * @param modificationTime
	 *            the new modification time
	 */
	public void setModificationTime(String modificationTime) {
		this.modificationTime = modificationTime;
	}

	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Sets the title.
	 * 
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [author=" + author + ", brand=" + brand + ", condition=" + condition + ", country=" + country
				+ ", creationTime=" + creationTime + ", description=" + description + ", googleId=" + googleId + ", gtin=" + gtin
				+ ", gtins=" + gtins + ", images=" + images + ", inventories=" + inventories + ", language=" + language
				+ ", link=" + link + ", modificationTime=" + modificationTime + ", title=" + title + "]";
	}
}
