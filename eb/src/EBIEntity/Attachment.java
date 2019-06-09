package EBIEntity;
/*
 * 附件
 */
public class Attachment {
	private String AttName;
	private String AttDescription;
	private String AttSize;
	private String AttType;
	private String AttSuffix;
	private String AttURL;
	private String Digest;

	public String getAttName() {
		return AttName;
	}

	public void setAttName(String attName) {
		AttName = attName;
	}

	public String getAttDescription() {
		return AttDescription;
	}

	public void setAttDescription(String attDescription) {
		AttDescription = attDescription;
	}

	public String getAttSize() {
		return AttSize;
	}

	public void setAttSize(String attSize) {
		AttSize = attSize;
	}

	public String getAttType() {
		return AttType;
	}

	public void setAttType(String attType) {
		AttType = attType;
	}

	public String getAttSuffix() {
		return AttSuffix;
	}

	public void setAttSuffix(String attSuffix) {
		AttSuffix = attSuffix;
	}

	public String getAttURL() {
		return AttURL;
	}

	public void setAttURL(String attURL) {
		AttURL = attURL;
	}

	public String getDigest() {
		return Digest;
	}

	public void setDigest(String digest) {
		Digest = digest;
	}

	@Override
	public String toString() {
		return "Attachment [AttName=" + AttName + ", AttDescription=" + AttDescription + ", AttSize=" + AttSize
				+ ", AttType=" + AttType + ", AttSuffix=" + AttSuffix + ", AttURL=" + AttURL + ", Digest=" + Digest
				+ "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
