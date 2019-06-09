package EBDEntity;
/*
 * 应急广播消息内容
 */
public class EBM_MsgContent {
	private String LanguageCode;
	private String MsgTitle;
	private String MsgDesc;
	private String AreaCode;
	private String ProgramNum;
	private EBM_MsgC_Auxiliary Auxiliary;

	public String getLanguageCode() {
		return LanguageCode;
	}

	public void setLanguageCode(String languageCode) {
		LanguageCode = languageCode;
	}

	public String getMsgTitle() {
		return MsgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		MsgTitle = msgTitle;
	}

	public String getMsgDesc() {
		return MsgDesc;
	}

	public void setMsgDesc(String msgDesc) {
		MsgDesc = msgDesc;
	}

	public String getAreaCode() {
		return AreaCode;
	}

	public void setAreaCode(String areaCode) {
		AreaCode = areaCode;
	}

	public String getProgramNum() {
		return ProgramNum;
	}

	public void setProgramNum(String programNum) {
		ProgramNum = programNum;
	}

	public EBM_MsgC_Auxiliary getAuxiliary() {
		return Auxiliary;
	}

	public void setAuxiliary(EBM_MsgC_Auxiliary auxiliary) {
		Auxiliary = auxiliary;
	}

	@Override
	public String toString() {
		return "EBM_MsgContent [LanguageCode=" + LanguageCode + ", MsgTitle=" + MsgTitle + ", MsgDesc=" + MsgDesc
				+ ", AreaCode=" + AreaCode + ", ProgramNum=" + ProgramNum + ", Auxiliary=" + Auxiliary + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
