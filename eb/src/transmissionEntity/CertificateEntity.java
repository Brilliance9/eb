package transmissionEntity;

public class CertificateEntity {

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
	private int CertAuth_number;
	private int[] CertAuth_length;
	private String[] CertAuth_data;
	private int cert_number;
	private int[] cert_length;
	private String[] cert_data;
	private int signature_length;
	private String signature_data;
	private int CRC_32;
	public CertificateEntity(){
		this.table_id=252;
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
	public int getCertAuth_number() {
		return CertAuth_number;
	}
	public void setCertAuth_number(int certAuth_number) {
		CertAuth_number = certAuth_number;
	}
	public int[] getCertAuth_length() {
		return CertAuth_length;
	}
	public void setCertAuth_length(int[] certAuth_length) {
		CertAuth_length = certAuth_length;
	}
	public String[] getCertAuth_data() {
		return CertAuth_data;
	}
	public void setCertAuth_data(String[] certAuth_data) {
		CertAuth_data = certAuth_data;
	}
	public int getCert_number() {
		return cert_number;
	}
	public void setCert_number(int cert_number) {
		this.cert_number = cert_number;
	}
	public int[] getCert_length() {
		return cert_length;
	}
	public void setCert_length(int[] cert_length) {
		this.cert_length = cert_length;
	}
	public String[] getCert_data() {
		return cert_data;
	}
	public void setCert_data(String[] cert_data) {
		this.cert_data = cert_data;
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
