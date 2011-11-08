package api.products;

public class Items {
	private String id;
	private String kind;
	private Product product;
	private String selfLink;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSelfLink() {
		return this.selfLink;
	}

	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}
}
