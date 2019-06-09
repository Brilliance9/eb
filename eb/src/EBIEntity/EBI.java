package EBIEntity;

import java.util.Arrays;

public class EBI {
	private EBI_EBMainInfo EBMainInfo ;
	private EBI_EBContent []EBContent;
	private EBI_PublishStrategy PublishStrategy;
	private boolean e1=false;
	private boolean e2=false;
	private EBI_ExtendInfo1 ExtendInfo1;
	private EBI_ExtendInfo2 ExtendInfo2;
	private EBI_Area Area;
	
	
	public boolean isE1() {
		return e1;
	}

	public void setE1(boolean e1) {
		this.e1 = e1;
	}

	public boolean isE2() {
		return e2;
	}

	public void setE2(boolean e2) {
		this.e2 = e2;
	}

	public EBI_EBMainInfo getEBMainInfo() {
		return EBMainInfo;
	}

	public void setEBMainInfo(EBI_EBMainInfo eBMainInfo) {
		EBMainInfo = eBMainInfo;
	}

	public EBI_EBContent[] getEBContent() {
		return EBContent;
	}

	public void setEBContent(EBI_EBContent[] eBContent) {
		EBContent = eBContent;
	}

	public EBI_PublishStrategy getPublishStrategy() {
		return PublishStrategy;
	}

	public void setPublishStrategy(EBI_PublishStrategy publishStrategy) {
		PublishStrategy = publishStrategy;
	}

	public EBI_Area getArea() {
		return Area;
	}

	public void setArea(EBI_Area area) {
		Area = area;
	}

	public EBI_ExtendInfo1 getExtendInfo1() {
		return ExtendInfo1;
	}

	public void setExtendInfo1(EBI_ExtendInfo1 extendInfo1) {
		ExtendInfo1 = extendInfo1;
	}

	public EBI_ExtendInfo2 getExtendInfo2() {
		return ExtendInfo2;
	}

	public void setExtendInfo2(EBI_ExtendInfo2 extendInfo2) {
		ExtendInfo2 = extendInfo2;
	}

	
	

	@Override
	public String toString() {
		return "EBI [EBMainInfo=" + EBMainInfo + ", EBContent=" + Arrays.toString(EBContent) + ", PublishStrategy="
				+ PublishStrategy + ", ExtendInfo1=" + ExtendInfo1 + ", ExtendInfo2=" + ExtendInfo2 + ", Area=" + Area
				+ "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
