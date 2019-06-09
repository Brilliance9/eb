package EBDEntity;

import java.sql.Timestamp;
import java.util.Calendar;
/*
 * 应急广播业务数据（EBD）
 */
public class EBD {
	private String EBDVersion;
	private String EBDID;
	private String EBDType;
	private EBD_SRC SRC;
	private EBD_DEST DEST;
	private String EBDTime;
	private EBD_RelatedEBD RelatedEBD;
	private EBD_EBM EBM;

	public String getEBDVersion() {
		return EBDVersion;
	}

	public void setEBDVersion(String eBDVersion) {
		EBDVersion = eBDVersion;
	}

	public String getEBDID() {
		return EBDID;
	}

	public void setEBDID(String eBDID) {
		EBDID = eBDID;
	}

	public String getEBDType() {
		return EBDType;
	}

	public void setEBDType(String eBDType) {
		EBDType = eBDType;
	}

	public EBD_SRC getSRC() {
		return SRC;
	}

	public void setSRC(EBD_SRC sRC) {
		SRC = sRC;
	}

	public EBD_DEST getDEST() {
		return DEST;
	}

	public void setDEST(EBD_DEST dEST) {
		DEST = dEST;
	}

	public String getEBDTime() {
		return EBDTime;
	}

	public void setEBDTime(String eBDTime) {
		EBDTime = eBDTime;
	}

	public EBD_RelatedEBD getRelatedEBD() {
		return RelatedEBD;
	}

	public void setRelatedEBD(EBD_RelatedEBD relatedEBD) {
		RelatedEBD = relatedEBD;
	}

	public EBD_EBM getEBM() {
		return EBM;
	}

	public void setEBM(EBD_EBM eBM) {
		EBM = eBM;
	}

	@Override
	public String toString() {
		return "EBD [EBDVersion=" + EBDVersion + ", EBDID=" + EBDID + ", EBDType=" + EBDType + ", SRC=" + SRC
				+ ", DEST=" + DEST + ", EBDTime=" + EBDTime + ", RelatedEBD=" + RelatedEBD + ", EBM=" + EBM + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
