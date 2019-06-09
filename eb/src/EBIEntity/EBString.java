package EBIEntity;

public class EBString {

	private int ID;
	private String EBI;
	private String EBD;
	private String Resource;
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getEBI() {
		return EBI;
	}

	public void setEBI(String eBI) {
		EBI = eBI;
	}

	public String getEBD() {
		return EBD;
	}

	public void setEBD(String eBD) {
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
		return "EBString [ID=" + ID + ", EBI=" + EBI + ", EBD=" + EBD + ", Resource=" + Resource + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
