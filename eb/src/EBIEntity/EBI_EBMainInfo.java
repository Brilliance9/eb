package EBIEntity;

/*
 * 应急广播基础信息
 */
public class EBI_EBMainInfo {
	private String EBIVersion;
	private String InfoID;
	private String EBIID;
	private String Sender;
	private String SenderCode;
	private String Identifier;
	private String EventType;
	private String EventLevel;
	private String InfoType;
	private String InfoStatus;
	private String ReferenceId;
	private String IsMediaRes;
	private String IsTTS;
	private String Instructions;

	public String getEBIVersion() {
		return EBIVersion;
	}

	public void setEBIVersion(String eBIVersion) {
		EBIVersion = eBIVersion;
	}

	public String getInfoID() {
		return InfoID;
	}

	public void setInfoID(String infoID) {
		InfoID = infoID;
	}

	public String getEBIID() {
		return EBIID;
	}

	public void setEBIID(String eBIID) {
		EBIID = eBIID;
	}

	public String getSender() {
		return Sender;
	}

	public void setSender(String sender) {
		Sender = sender;
	}

	public String getSenderCode() {
		return SenderCode;
	}

	public void setSenderCode(String senderCode) {
		SenderCode = senderCode;
	}

	public String getIdentifier() {
		return Identifier;
	}

	public void setIdentifier(String identifier) {
		Identifier = identifier;
	}

	public String getEventType() {
		return EventType;
	}

	public void setEventType(String eventType) {
		EventType = eventType;
	}

	public String getEventLevel() {
		return EventLevel;
	}

	public void setEventLevel(String eventLevel) {
		EventLevel = eventLevel;
	}

	public String getInfoType() {
		return InfoType;
	}

	public void setInfoType(String infoType) {
		InfoType = infoType;
	}

	public String getInfoStatus() {
		return InfoStatus;
	}

	public void setInfoStatus(String infoStatus) {
		InfoStatus = infoStatus;
	}

	public String getReferenceId() {
		return ReferenceId;
	}

	public void setReferenceId(String referenceId) {
		ReferenceId = referenceId;
	}

	public String getIsMediaRes() {
		return IsMediaRes;
	}

	public void setIsMediaRes(String isMediaRes) {
		IsMediaRes = isMediaRes;
	}

	public String getIsTTS() {
		return IsTTS;
	}

	public void setIsTTS(String isTTS) {
		IsTTS = isTTS;
	}

	public String getInstructions() {
		return Instructions;
	}

	public void setInstructions(String instructions) {
		Instructions = instructions;
	}

	@Override
	public String toString() {
		return "EBI_EBMainInfo [EBIVersion=" + EBIVersion + ", InfoID=" + InfoID + ", EBIID=" + EBIID + ", Sender="
				+ Sender + ", SenderCode=" + SenderCode + ", Identifier=" + Identifier + ", EventType=" + EventType
				+ ", EventLevel=" + EventLevel + ", InfoType=" + InfoType + ", InfoStatus=" + InfoStatus
				+ ", ReferenceId=" + ReferenceId + ", IsMediaRes=" + IsMediaRes + ", IsTTS=" + IsTTS + ", Instructions="
				+ Instructions + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
