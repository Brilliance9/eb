package transmissionEntity;

import java.util.Arrays;

public class IndexEntity {
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
	private int EBM_number;
	private EBMEntity[] EBM;
	private int signature_length;
	private String signature_data;
	private int CRC_32;
	
	public IndexEntity(){
		this.table_id=253;
		this.section_syntax_indicator=1;
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

	public EBMEntity[] getEBM() {
		return EBM;
	}

	public void setEBM(EBMEntity[] ebm) {
		EBM = ebm;
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

	public int getEBM_number() {
		return EBM_number;
	}

	public void setEBM_number(int eBM_number) {
		EBM_number = eBM_number;
	}

	@Override
	public String toString() {
		return "CableIndexEntity [table_id=" + table_id + ", section_syntax_indicator=" + section_syntax_indicator
				+ ", reserved=" + reserved + ", section_length=" + section_length + ", table_id_extension="
				+ table_id_extension + ", reserved2=" + reserved2 + ", version_number=" + version_number
				+ ", current_next_indicator=" + current_next_indicator + ", section_number=" + section_number
				+ ", last_section_number=" + last_section_number + ", EBM_number=" + EBM_number + ", EBM="
				+ Arrays.toString(EBM) + ", signature_length=" + signature_length + ", signature_data=" + signature_data
				+ ", CRC_32=" + CRC_32 + "]";
	}

	
	

}
