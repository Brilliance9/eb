package transmissionEntity;

import java.util.Arrays;

public class Multilingual_contentEntity {

	private int multilingual_content_length;
	private String language_code;
	private int reserved1;
	private int code_character_set;
	private int message_text_length;
	private String message_text;
	private int agency_name_length;
	private String agency_name;
	private int reserved2;
	private int auxiliary_data_number;
	private Auxiliary_dataEntity[] Auxiliary_data;
	public Multilingual_contentEntity(){
		this.reserved1=31;
		this.reserved2=15;
	}
	public int getMultilingual_content_length() {
		return multilingual_content_length;
	}
	public void setMultilingual_content_length(int multilingual_content_length) {
		this.multilingual_content_length = multilingual_content_length;
	}
	public String getLanguage_code() {
		return language_code;
	}
	public void setLanguage_code(String language_code) {
		this.language_code = language_code;
	}
	public int getReserved1() {
		return reserved1;
	}
	public void setReserved1(int reserved1) {
		this.reserved1 = reserved1;
	}
	public int getCode_character_set() {
		return code_character_set;
	}
	public void setCode_character_set(int code_character_set) {
		this.code_character_set = code_character_set;
	}
	public int getMessage_text_length() {
		return message_text_length;
	}
	public void setMessage_text_length(int message_text_length) {
		this.message_text_length = message_text_length;
	}
	public String getMessage_text() {
		return message_text;
	}
	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}
	public int getAgency_name_length() {
		return agency_name_length;
	}
	public void setAgency_name_length(int agency_name_length) {
		this.agency_name_length = agency_name_length;
	}
	public String getAgency_name() {
		return agency_name;
	}
	public void setAgency_name(String agency_name) {
		this.agency_name = agency_name;
	}
	public int getReserved2() {
		return reserved2;
	}
	public void setReserved2(int reserved2) {
		this.reserved2 = reserved2;
	}
	public int getAuxiliary_data_number() {
		return auxiliary_data_number;
	}
	public void setAuxiliary_data_number(int auxiliary_data_number) {
		this.auxiliary_data_number = auxiliary_data_number;
	}
	public Auxiliary_dataEntity[] getAuxiliary_data() {
		return Auxiliary_data;
	}
	public void setAuxiliary_data(Auxiliary_dataEntity[] auxiliary_data) {
		Auxiliary_data = auxiliary_data;
	}
	@Override
	public String toString() {
		return "Multilingual_contentEntity [multilingual_content_length=" + multilingual_content_length
				+ ", language_code=" + language_code + ", reserved1=" + reserved1 + ", code_character_set="
				+ code_character_set + ", message_text_length=" + message_text_length + ", message_text=" + message_text
				+ ", agency_name_length=" + agency_name_length + ", agency_name=" + agency_name + ", reserved2="
				+ reserved2 + ", auxiliary_data_number=" + auxiliary_data_number + ", Auxiliary_data="
				+ Arrays.toString(Auxiliary_data) + "]";
	}
	
}
