package EBDEntity;
/*
 * 应急广播消息
 */
public class EBD_EBM {
	private String EBMVersion;
	private String EBMID;
	private EBM_RelatedInfo RelatedInfo;
	private EBM_MsgBasicInfo MsgBasicInfo;
	private EBM_MsgContent MsgContent;
	private EBM_Dispatch Dispatch;

	public String getEBMVersion() {
		return EBMVersion;
	}

	public void setEBMVersion(String eBMVersion) {
		EBMVersion = eBMVersion;
	}

	public String getEBMID() {
		return EBMID;
	}

	public void setEBMID(String eBMID) {
		EBMID = eBMID;
	}

	public EBM_RelatedInfo getRelatedInfo() {
		return RelatedInfo;
	}

	public void setRelatedInfo(EBM_RelatedInfo relatedInfo) {
		RelatedInfo = relatedInfo;
	}

	public EBM_MsgBasicInfo getMsgBasicInfo() {
		return MsgBasicInfo;
	}

	public void setMsgBasicInfo(EBM_MsgBasicInfo msgBasicInfo) {
		MsgBasicInfo = msgBasicInfo;
	}

	public EBM_MsgContent getMsgContent() {
		return MsgContent;
	}

	public void setMsgContent(EBM_MsgContent msgContent) {
		MsgContent = msgContent;
	}

	public EBM_Dispatch getDispatch() {
		return Dispatch;
	}

	public void setDispatch(EBM_Dispatch dispatch) {
		Dispatch = dispatch;
	}

	@Override
	public String toString() {
		return "EBD_EBM [EBMVersion=" + EBMVersion + ", EBMID=" + EBMID + ", RelatedInfo=" + RelatedInfo
				+ ", MsgBasicInfo=" + MsgBasicInfo + ", MsgContent=" + MsgContent + ", Dispatch=" + Dispatch + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
