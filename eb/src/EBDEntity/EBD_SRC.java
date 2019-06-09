package EBDEntity;
/*
 * 数 据 包 来源对象
 */
public class EBD_SRC {
	private String EBRID;
	private String URL;

	public String getEBRID() {
		return EBRID;
	}

	public void setEBRID(String eBRID) {
		EBRID = eBRID;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	@Override
	public String toString() {
		return "EBD_SRC [EBRID=" + EBRID + ", URL=" + URL + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
