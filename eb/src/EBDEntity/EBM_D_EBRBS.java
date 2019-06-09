package EBDEntity;
/*
 * 传输覆盖播出设备信息
 */
public class EBM_D_EBRBS {
	private String BrdSysType;
	private String BrdSysInfo;

	public String getBrdSysType() {
		return BrdSysType;
	}

	public void setBrdSysType(String brdSysType) {
		BrdSysType = brdSysType;
	}

	public String getBrdSysInfo() {
		return BrdSysInfo;
	}

	public void setBrdSysInfo(String brdSysInfo) {
		BrdSysInfo = brdSysInfo;
	}

	@Override
	public String toString() {
		return "EBM_D_EBRBS [BrdSysType=" + BrdSysType + ", BrdSysInfo=" + BrdSysInfo + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
