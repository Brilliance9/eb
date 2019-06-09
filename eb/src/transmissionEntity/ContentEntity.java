package transmissionEntity;

public class ContentEntity {

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
	private int reserved3;
	private String EBM_id;
	private int reserved4;
	private int multilingual_content_number;
	private Multilingual_contentEntity[] Multilingual_content;
	private int signature_length;
	private String signature_data;
	private int CRC_32;
	public ContentEntity(){
		this.table_id=254;
		this.section_syntax_indicator=1;
		this.reserved=3;
		this.reserved2=3;
		this.reserved3=15;
		this.reserved4=15;
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
	public int getReserved3() {
		return reserved3;
	}
	public void setReserved3(int reserved3) {
		this.reserved3 = reserved3;
	}
	public String getEBM_id() {
		return EBM_id;
	}
	public void setEBM_id(String eBM_id) {
		EBM_id = eBM_id;
	}
	public int getReserved4() {
		return reserved4;
	}
	public void setReserved4(int reserved4) {
		this.reserved4 = reserved4;
	}
	public int getMultilingual_content_number() {
		return multilingual_content_number;
	}
	public void setMultilingual_content_number(int multilingual_content_number) {
		this.multilingual_content_number = multilingual_content_number;
	}
	public Multilingual_contentEntity[] getMultilingual_content() {
		return Multilingual_content;
	}
	public void setMultilingual_content(Multilingual_contentEntity[] multilingual_content) {
		Multilingual_content = multilingual_content;
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
