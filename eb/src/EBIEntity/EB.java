package EBIEntity;
import EBDEntity.EBD;
public class EB {
	private String ID;
	private EBI EBI;
	private EBD EBD;
	private String Resource;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public EBI getEBI() {
		return EBI;
	}

	public void setEBI(EBI eBI) {
		EBI = eBI;
	}

	public EBD getEBD() {
		return EBD;
	}

	public void setEBD(EBD eBD) {
		EBD = eBD;
	}

	public String getResource() {
		return Resource;
	}

	public void setResource(String resource) {
		Resource = resource;
	}

	@Override
	public String toString() {
		return "EB [ID=" + ID + ", EBI=" + EBI + ", EBD=" + EBD + ", Resource=" + Resource + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
