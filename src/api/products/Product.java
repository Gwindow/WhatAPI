package api.products;

import java.util.List;

public class Product {
	private Author author;
	private String brand;
	private String condition;
	private String country;
	private String creationTime;
	private String description;
	private String googleId;
	private String gtin;
	private List<String> gtins;
	private List<Images> images;
	private List<Inventories> inventories;
	private String language;
	private String link;
	private String modificationTime;
	private String title;

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGoogleId() {
		return this.googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getGtin() {
		return this.gtin;
	}

	public void setGtin(String gtin) {
		this.gtin = gtin;
	}

	public List<String> getGtins() {
		return this.gtins;
	}

	public void setGtins(List<String> gtins) {
		this.gtins = gtins;
	}

	public List<Images> getImages() {
		return this.images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public List<Inventories> getInventories() {
		return this.inventories;
	}

	public void setInventories(List<Inventories> inventories) {
		this.inventories = inventories;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getModificationTime() {
		return this.modificationTime;
	}

	public void setModificationTime(String modificationTime) {
		this.modificationTime = modificationTime;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
