package EBDEntity;
/*
 * 调用资源信息
 */
public class EBM_Dispatch {
	private String LanguageCode;
	private EBM_D_EBRPS EBRPS;
	private EBM_D_EBRRTS EBRRTS;
	private EBM_D_EBRAS EBRAS;
	private EBM_D_EBRBS EBRBS;

	public String getLanguageCode() {
		return LanguageCode;
	}

	public void setLanguageCode(String languageCode) {
		LanguageCode = languageCode;
	}

	public EBM_D_EBRPS getEBRPS() {
		return EBRPS;
	}

	public void setEBRPS(EBM_D_EBRPS eBRPS) {
		EBRPS = eBRPS;
	}

	public EBM_D_EBRRTS getEBRRTS() {
		return EBRRTS;
	}

	public void setEBRRTS(EBM_D_EBRRTS eBRRTS) {
		EBRRTS = eBRRTS;
	}

	public EBM_D_EBRAS getEBRAS() {
		return EBRAS;
	}

	public void setEBRAS(EBM_D_EBRAS eBRAS) {
		EBRAS = eBRAS;
	}

	public EBM_D_EBRBS getEBRBS() {
		return EBRBS;
	}

	public void setEBRBS(EBM_D_EBRBS eBRBS) {
		EBRBS = eBRBS;
	}

	@Override
	public String toString() {
		return "EBM_Dispatch [LanguageCode=" + LanguageCode + ", EBRPS=" + EBRPS + ", EBRRTS=" + EBRRTS + ", EBRAS="
				+ EBRAS + ", EBRBS=" + EBRBS + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
