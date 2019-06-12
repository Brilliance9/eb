package transmissionEntity;

public class Auxiliary_dataEntity {

	private int  auxiliary_data_type;
	private int auxiliary_data_length;
	private String auxiliary_data;
	public int getAuxiliary_data_type() {
		return auxiliary_data_type;
	}
	public void setAuxiliary_data_type(int auxiliary_data_type) {
		this.auxiliary_data_type = auxiliary_data_type;
	}
	public int getAuxiliary_data_length() {
		return auxiliary_data_length;
	}
	public void setAuxiliary_data_length(int auxiliary_data_length) {
		this.auxiliary_data_length = auxiliary_data_length;
	}
	public String getAuxiliary_data() {
		return auxiliary_data;
	}
	public void setAuxiliary_data(String auxiliary_data) {
		this.auxiliary_data = auxiliary_data;
	}
	@Override
	public String toString() {
		return "Auxiliary_dataEntity [auxiliary_data_type=" + auxiliary_data_type + ", auxiliary_data_length="
				+ auxiliary_data_length + ", auxiliary_data=" + auxiliary_data + "]";
	}
	
}
