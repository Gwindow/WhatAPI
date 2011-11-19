/**
 * @author Gwindow
 */
package api.products;

/**
 * The Class Items.
 */
public class Items {
	private String id;
	private String kind;
	private Product product;
	private String selfLink;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the kind.
	 * 
	 * @return the kind
	 */
	public String getKind() {
		return this.kind;
	}

	/**
	 * Sets the kind.
	 * 
	 * @param kind
	 *            the new kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * Gets the product.
	 * 
	 * @return the product
	 */
	public Product getProduct() {
		return this.product;
	}

	/**
	 * Sets the product.
	 * 
	 * @param product
	 *            the new product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Gets the self link.
	 * 
	 * @return the self link
	 */
	public String getSelfLink() {
		return this.selfLink;
	}

	/**
	 * Sets the self link.
	 * 
	 * @param selfLink
	 *            the new self link
	 */
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}
}
