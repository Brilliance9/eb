package transmissionEntity;

public class ConfigureEntity {

	private int table_id;
	private int section_syntax_indicator;
	private int reserved;
	private int section_length;
	private int table_id_extension;
	private int reserved2;
	private int version_number;
	private int current_next_indicator;
	private int section_number;
	private int last_section_number;
	private int configure_cmd_number;
	ConfigureCommandEntity[] cce ;
	private int signature_length;
	private String signature_data;
	private int CRC_32;
	
	public ConfigureEntity(){
		this.table_id=251;
		this.reserved=3;
		this.reserved2=3;
	}
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
	}
	public int getSection_syntax_indicator() {
		return section_syntax_indicator;
	}
	public void setSection_syntax_indicator(int section_syntax_indicator) {
		this.section_syntax_indicator = section_syntax_indicator;
	}
	public int getReserved() {
		return reserved;
	}
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	public int getSection_length() {
		return section_length;
	}
	public void setSection_length(int section_length) {
		this.section_length = section_length;
	}
	public int getTable_id_extension() {
		return table_id_extension;
	}
	public void setTable_id_extension(int table_id_extension) {
		this.table_id_extension = table_id_extension;
	}
	public int getReserved2() {
		return reserved2;
	}
	public void setReserved2(int reserved2) {
		this.reserved2 = reserved2;
	}
	public int getVersion_number() {
		return version_number;
	}
	public void setVersion_number(int version_number) {
		this.version_number = version_number;
	}
	public int getCurrent_next_indicator() {
		return current_next_indicator;
	}
	public void setCurrent_next_indicator(int current_next_indicator) {
		this.current_next_indicator = current_next_indicator;
	}
	public int getSection_number() {
		return section_number;
	}
	public void setSection_number(int section_number) {
		this.section_number = section_number;
	}
	public int getLast_section_number() {
		return last_section_number;
	}
	public void setLast_section_number(int last_section_number) {
		this.last_section_number = last_section_number;
	}
	public int getConfigure_cmd_number() {
		return configure_cmd_number;
	}
	public void setConfigure_cmd_number(int configure_cmd_number) {
		this.configure_cmd_number = configure_cmd_number;
	}
	public ConfigureCommandEntity[] getCce() {
		return cce;
	}
	public void setCce(ConfigureCommandEntity[] cce) {
		this.cce = cce;
	}
	public int getSignature_length() {
		return signature_length;
	}
	public void setSignature_length(int signature_length) {
		this.signature_length = signature_length;
	}
	public String getSignature_data() {
		return signature_data;
	}
	public void setSignature_data(String signature_data) {
		this.signature_data = signature_data;
	}
	public int getCRC_32() {
		return CRC_32;
	}
	public void setCRC_32(int cRC_32) {
		CRC_32 = cRC_32;
	}
	
}
