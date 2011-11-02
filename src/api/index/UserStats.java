package api.index;

import com.google.gson.annotations.SerializedName;

public class UserStats {
	private String downloaded;
	private String ratio;
	private String requiredratio;
	private String uploaded;
	@SerializedName("class")
	private String userClass;

	public String getDownloaded() {
		return this.downloaded;
	}

	public String getRatio() {
		return this.ratio;
	}

	public String getRequiredratio() {
		return this.requiredratio;
	}

	public String getUploaded() {
		return this.uploaded;
	}

	public String getUserClass() {
		return this.userClass;
	}

	public String getBuffer() {
		double up = Double.valueOf(uploaded);
		double down = Double.valueOf(downloaded);
		double buffer = up - down;
		return String.valueOf(buffer);
	}

	@Override
	public String toString() {
		return "UserStats [getDownloaded=" + getDownloaded() + ", getRatio=" + getRatio() + ", getRequiredratio="
				+ getRequiredratio() + ", getUploaded=" + getUploaded() + ", getUserClass=" + getUserClass() + ", getBuffer="
				+ getBuffer() + "]";
	}

}
