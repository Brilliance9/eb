package EBIEntity;
/*
 * 发布样式
 */
public class BroadcastStyle {
	private String PublishMeans;
	private String Presentation;
	private String PublishFrequency;
	private String RollFrequency;

	public String getPublishMeans() {
		return PublishMeans;
	}

	public void setPublishMeans(String publishMeans) {
		PublishMeans = publishMeans;
	}

	public String getPresentation() {
		return Presentation;
	}

	public void setPresentation(String presentation) {
		Presentation = presentation;
	}

	public String getPublishFrequency() {
		return PublishFrequency;
	}

	public void setPublishFrequency(String publishFrequency) {
		PublishFrequency = publishFrequency;
	}

	public String getRollFrequency() {
		return RollFrequency;
	}

	public void setRollFrequency(String rollFrequency) {
		RollFrequency = rollFrequency;
	}

	@Override
	public String toString() {
		return "BroadcastStyle [PublishMeans=" + PublishMeans + ", Presentation=" + Presentation + ", PublishFrequency="
				+ PublishFrequency + ", RollFrequency=" + RollFrequency + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
