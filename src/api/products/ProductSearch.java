package api.products;

import java.util.List;

import api.son.MySon;

public class ProductSearch {
	private Number currentItemCount;
	private String etag;
	private String id;
	private List<Items> items;
	private Number itemsPerPage;
	private String kind;
	private String nextLink;
	private String requestId;
	private String selfLink;
	private Number startIndex;
	private Number totalItems;
	private static final String KEY = "AIzaSyDOPEJep1GSxaWylXm7Tvdytozve8odmuo";

	public static ProductSearch ProductSearchFromUPC(String upc) {
		String url =
				"https://www.googleapis.com/shopping/search/v1/public/products?key=" + KEY + "&country=US&restrictBy=gtin=" + upc
						+ "&alt=json";
		ProductSearch ps = (ProductSearch) MySon.toObjectOther(url, ProductSearch.class);
		return ps;
	}

	public boolean hasItems() {
		if (totalItems.intValue() > 0)
			return true;
		return false;
	}

	public Number getCurrentItemCount() {
		return this.currentItemCount;
	}

	public void setCurrentItemCount(Number currentItemCount) {
		this.currentItemCount = currentItemCount;
	}

	public String getEtag() {
		return this.etag;
	}

	public void setEtag(String etag) {
		this.etag = etag;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Items> getItems() {
		return this.items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public Number getItemsPerPage() {
		return this.itemsPerPage;
	}

	public void setItemsPerPage(Number itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getNextLink() {
		return this.nextLink;
	}

	public void setNextLink(String nextLink) {
		this.nextLink = nextLink;
	}

	public String getRequestId() {
		return this.requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getSelfLink() {
		return this.selfLink;
	}

	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	public Number getStartIndex() {
		return this.startIndex;
	}

	public void setStartIndex(Number startIndex) {
		this.startIndex = startIndex;
	}

	public Number getTotalItems() {
		return this.totalItems;
	}

	public void setTotalItems(Number totalItems) {
		this.totalItems = totalItems;
	}
}
