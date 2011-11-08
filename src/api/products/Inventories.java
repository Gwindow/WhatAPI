package api.products;

public class Inventories {
	private String availability;
	private String channel;
	private String currency;
	private Number price;
	private Number shipping;
	private Number tax;

	public String getAvailability() {
		return this.availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Number getPrice() {
		return this.price;
	}

	public void setPrice(Number price) {
		this.price = price;
	}

	public Number getShipping() {
		return this.shipping;
	}

	public void setShipping(Number shipping) {
		this.shipping = shipping;
	}

	public Number getTax() {
		return this.tax;
	}

	public void setTax(Number tax) {
		this.tax = tax;
	}
}
