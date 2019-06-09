package EBDEntity;
/*
 * 关联信息
 */
public class EBM_RelatedInfo {
	private String EBIID;
	private String EBMID;

	public String getEBIID() {
		return EBIID;
	}

	public void setEBIID(String eBIID) {
		EBIID = eBIID;
	}

	public String getEBMID() {
		return EBMID;
	}

	public void setEBMID(String eBMID) {
		EBMID = eBMID;
	}

	@Override
	public String toString() {
		return "EBM_RelatedInfo [EBIID=" + EBIID + ", EBMID=" + EBMID + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
