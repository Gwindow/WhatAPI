package api.index;

import api.son.MySon;

public class Index {
	private Response response;
	private String status;

	public static Index init() {
		String url = "ajax.php?action=index";
		Index index = (Index) MySon.toObject(url, Index.class);
		return index;
	}

	public Response getResponse() {
		return response;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Index [response=" + response + ", status=" + status + ", getResponse=" + getResponse() + ", getStatus="
				+ getStatus() + ", getStatus" + getStatus() + "]";
	}
}
