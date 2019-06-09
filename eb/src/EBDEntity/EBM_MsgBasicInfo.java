package EBDEntity;

import java.sql.Timestamp;
import java.util.Calendar;
/*
 * 消息基本信息
 */
public class EBM_MsgBasicInfo {
	private String MsgType;
	private String SenderName;
	private String SenderCode;
	private String SendTime;
	private String EventType;
	private String Severity;
	private String StartTime;
	private String EndTime;

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getSenderName() {
		return SenderName;
	}

	public void setSenderName(String senderName) {
		SenderName = senderName;
	}

	public String getSenderCode() {
		return SenderCode;
	}

	public void setSenderCode(String senderCode) {
		SenderCode = senderCode;
	}

	public String getSendTime() {
		return SendTime;
	}

	public void setSendTime(String sendTime) {
		SendTime = sendTime;
	}

	public String getEventType() {
		return EventType;
	}

	public void setEventType(String eventType) {
		EventType = eventType;
	}

	public String getSeverity() {
		return Severity;
	}

	public void setSeverity(String severity) {
		Severity = severity;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	@Override
	public String toString() {
		return "EBM_MsgBasicInfo [MsgType=" + MsgType + ", SenderName=" + SenderName + ", SenderCode=" + SenderCode
				+ ", SendTime=" + SendTime + ", EventType=" + EventType + ", Severity=" + Severity + ", StartTime="
				+ StartTime + ", EndTime=" + EndTime + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
