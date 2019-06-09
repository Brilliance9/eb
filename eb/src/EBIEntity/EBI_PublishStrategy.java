package EBIEntity;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
/*
 * 信息建议性发布策略
 */
public class EBI_PublishStrategy {
	private String PublishRegion;
	private String BroadcastDateTime;
	private String OverDateTime;
	private BroadcastStyle BroadcastStyle[];

	public String getPublishRegion() {
		return PublishRegion;
	}

	public void setPublishRegion(String publishRegion) {
		PublishRegion = publishRegion;
	}

	public String getBroadcastDateTime() {
		return BroadcastDateTime;
	}

	public void setBroadcastDateTime(String broadcastDateTime) {
		BroadcastDateTime = broadcastDateTime;
	}

	public String getOverDateTime() {
		return OverDateTime;
	}

	public void setOverDateTime(String overDateTime) {
		OverDateTime = overDateTime;
	}

	public BroadcastStyle[] getBroadcastStyle() {
		return BroadcastStyle;
	}

	public void setBroadcastStyle(BroadcastStyle[] broadcastStyle) {
		BroadcastStyle = broadcastStyle;
	}

	@Override
	public String toString() {
		return "EBI_PublishStrategy [PublishRegion=" + PublishRegion + ", BroadcastDateTime=" + BroadcastDateTime
				+ ", OverDateTime=" + OverDateTime + ", BroadcastStyle=" + Arrays.toString(BroadcastStyle) + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
