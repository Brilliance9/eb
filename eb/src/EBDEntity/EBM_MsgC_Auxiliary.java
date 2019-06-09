package EBDEntity;
/*
 * 辅助数据
 */
public class EBM_MsgC_Auxiliary {
	private String  AuxiliaryType;
	private String  AuxiliaryDesc;
	private String Size;
	private String Digest;

	public String getAuxiliaryType() {
		return AuxiliaryType;
	}

	public void setAuxiliaryType(String auxiliaryType) {
		AuxiliaryType = auxiliaryType;
	}

	public String getAuxiliaryDesc() {
		return AuxiliaryDesc;
	}

	public void setAuxiliaryDesc(String auxiliaryDesc) {
		AuxiliaryDesc = auxiliaryDesc;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}

	public String getDigest() {
		return Digest;
	}

	public void setDigest(String digest) {
		Digest = digest;
	}

	@Override
	public String toString() {
		return "EBM_MsgC_Auxiliary [AuxiliaryType=" + AuxiliaryType + ", AuxiliaryDesc=" + AuxiliaryDesc + ", Size="
				+ Size + ", Digest=" + Digest + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
