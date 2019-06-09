package EBIEntity;
/*
 * 区域信息
 */
public class EBI_Area {
	private String AreaDescription;
	private String AreaPolygon;
	private String AreaCircle;

	public String getAreaDescription() {
		return AreaDescription;
	}

	public void setAreaDescription(String areaDescription) {
		AreaDescription = areaDescription;
	}

	public String getAreaPolygon() {
		return AreaPolygon;
	}

	public void setAreaPolygon(String areaPolygon) {
		AreaPolygon = areaPolygon;
	}

	public String getAreaCircle() {
		return AreaCircle;
	}

	public void setAreaCircle(String areaCircle) {
		AreaCircle = areaCircle;
	}

	@Override
	public String toString() {
		return "EBI_Area [AreaDescription=" + AreaDescription + ", AreaPolygon=" + AreaPolygon + ", AreaCircle="
				+ AreaCircle + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
