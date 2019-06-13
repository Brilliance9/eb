package transmissionEntity;

import java.util.Arrays;

public class ConfigureCommandEntity {

	private int  configure_cmd_tag;
	private int configure_cmd_length;
	
	//01时钟校准指令
	private int wYear;
	private int iMonth;
	private int iDay;
	private int iHour;
	private int iMinute;
	private int iSecond;
	
	//02资源编码设置指令
	public int terminal_address_length;
	public String terminal_address;
	public int reserved2;
	public String resource_code;
	
	//03锁定频率设置指令
	private int freq;
	private int symbolrate;
	private int constellation_mapping;
	private int terminal_number;
	private int reserved3;
	private String[] resource_address;
	
	//04设置回传方式/回传地址指令
	private int reback_type;
	private int reback_address_length;
	private String reback_address;
	private int terminal_number4;
	private int reserved4;
	private String[] resource_code4;
	
	//05设置回传周期指令
	private int reback_period;
	private int terminal_number5;
	private int reserved5;
	private String[] resource_code5;
	
	//06设置默认音量指令
	private int volume;
	private int terminal_number6;
	private int reserved6;
	private String[] resource_code6;
	
	//07状态/参数查询指令
	private int parameter_number;
	private int[] parameter_tag;
	private int terminal_number7;
	private int reserved7;
	private String[] resource_code7;
	
	public ConfigureCommandEntity(){
		this.reserved2=15;
		this.reserved3=15;
		this.reserved4=15;
		this.reserved5=15;
		this.reserved6=15;
	}
	public int getConfigure_cmd_tag() {
		return configure_cmd_tag;
	}
	public void setConfigure_cmd_tag(int configure_cmd_tag) {
		this.configure_cmd_tag = configure_cmd_tag;
	}
	public int getConfigure_cmd_length() {
		return configure_cmd_length;
	}
	public void setConfigure_cmd_length(int configure_cmd_length) {
		this.configure_cmd_length = configure_cmd_length;
	}
	public int getwYear() {
		return wYear;
	}
	public void setwYear(int wYear) {
		this.wYear = wYear;
	}
	public int getiMonth() {
		return iMonth;
	}
	public void setiMonth(int iMonth) {
		this.iMonth = iMonth;
	}
	public int getiDay() {
		return iDay;
	}
	public void setiDay(int iDay) {
		this.iDay = iDay;
	}
	public int getIHour() {
		return iHour;
	}
	public void setIHour(int ihour) {
		this.iHour = ihour;
	}
	public int getiMinute() {
		return iMinute;
	}
	public void setiMinute(int iMinute) {
		this.iMinute = iMinute;
	}
	public int getiSecond() {
		return iSecond;
	}
	public void setiSecond(int iSecond) {
		this.iSecond = iSecond;
	}
	public int getiHour() {
		return iHour;
	}
	public void setiHour(int iHour) {
		this.iHour = iHour;
	}
	public int getTerminal_address_length() {
		return terminal_address_length;
	}
	public void setTerminal_address_length(int terminal_address_length) {
		this.terminal_address_length = terminal_address_length;
	}
	public String getTerminal_address() {
		return terminal_address;
	}
	public void setTerminal_address(String terminal_address) {
		this.terminal_address = terminal_address;
	}
	public int getReserved2() {
		return reserved2;
	}
	public void setReserved2(int reserved2) {
		this.reserved2 = reserved2;
	}
	public String getResource_code() {
		return resource_code;
	}
	public void setResource_code(String resource_code) {
		this.resource_code = resource_code;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public int getSymbolrate() {
		return symbolrate;
	}
	public void setSymbolrate(int symbolrate) {
		this.symbolrate = symbolrate;
	}
	public int getConstellation_mapping() {
		return constellation_mapping;
	}
	public void setConstellation_mapping(int constellation_mapping) {
		this.constellation_mapping = constellation_mapping;
	}
	public int getTerminal_number() {
		return terminal_number;
	}
	public void setTerminal_number(int terminal_number) {
		this.terminal_number = terminal_number;
	}
	public int getReserved3() {
		return reserved3;
	}
	public void setReserved3(int reserved3) {
		this.reserved3 = reserved3;
	}
	public String[] getResource_address() {
		return resource_address;
	}
	public void setResource_address(String[] resource_address) {
		this.resource_address = resource_address;
	}
	public int getReback_type() {
		return reback_type;
	}
	public void setReback_type(int reback_type) {
		this.reback_type = reback_type;
	}
	public int getReback_address_length() {
		return reback_address_length;
	}
	public void setReback_address_length(int reback_address_length) {
		this.reback_address_length = reback_address_length;
	}
	public String getReback_address() {
		return reback_address;
	}
	public void setReback_address(String reback_address) {
		this.reback_address = reback_address;
	}
	public int getTerminal_number4() {
		return terminal_number4;
	}
	public void setTerminal_number4(int terminal_number4) {
		this.terminal_number4 = terminal_number4;
	}
	public int getReserved4() {
		return reserved4;
	}
	public void setReserved4(int reserved4) {
		this.reserved4 = reserved4;
	}
	public String[] getResource_code4() {
		return resource_code4;
	}
	public void setResource_code4(String[] resource_code4) {
		this.resource_code4 = resource_code4;
	}
	public int getReback_period() {
		return reback_period;
	}
	public void setReback_period(int reback_period) {
		this.reback_period = reback_period;
	}
	public int getTerminal_number5() {
		return terminal_number5;
	}
	public void setTerminal_number5(int terminal_number5) {
		this.terminal_number5 = terminal_number5;
	}
	public int getReserved5() {
		return reserved5;
	}
	public void setReserved5(int reserved5) {
		this.reserved5 = reserved5;
	}
	public String[] getResource_code5() {
		return resource_code5;
	}
	public void setResource_code5(String[] resource_code5) {
		this.resource_code5 = resource_code5;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getTerminal_number6() {
		return terminal_number6;
	}
	public void setTerminal_number6(int terminal_number6) {
		this.terminal_number6 = terminal_number6;
	}
	public int getReserved6() {
		return reserved6;
	}
	public void setReserved6(int reserved6) {
		this.reserved6 = reserved6;
	}
	public String[] getResource_code6() {
		return resource_code6;
	}
	public void setResource_code6(String[] resource_code6) {
		this.resource_code6 = resource_code6;
	}
	public int getParameter_number() {
		return parameter_number;
	}
	public void setParameter_number(int parameter_number) {
		this.parameter_number = parameter_number;
	}
	public int[] getParameter_tag() {
		return parameter_tag;
	}
	public void setParameter_tag(int[] parameter_tag) {
		this.parameter_tag = parameter_tag;
	}
	public int getTerminal_number7() {
		return terminal_number7;
	}
	public void setTerminal_number7(int terminal_number7) {
		this.terminal_number7 = terminal_number7;
	}
	public int getReserved7() {
		return reserved7;
	}
	public void setReserved7(int reserved7) {
		this.reserved7 = reserved7;
	}
	public String[] getResource_code7() {
		return resource_code7;
	}
	public void setResource_code7(String[] resource_code7) {
		this.resource_code7 = resource_code7;
	}
	@Override
	public String toString() {
		return "ConfigureCommandEntity [configure_cmd_tag=" + configure_cmd_tag + ", configure_cmd_length="
				+ configure_cmd_length + ", wYear=" + wYear + ", iMonth=" + iMonth + ", iDay=" + iDay + ", iHour="
				+ iHour + ", iMinute=" + iMinute + ", iSecond=" + iSecond + ", terminal_address_length="
				+ terminal_address_length + ", terminal_address=" + terminal_address + ", reserved2=" + reserved2
				+ ", resource_code=" + resource_code + ", freq=" + freq + ", symbolrate=" + symbolrate
				+ ", constellation_mapping=" + constellation_mapping + ", terminal_number=" + terminal_number
				+ ", reserved3=" + reserved3 + ", resource_address=" + Arrays.toString(resource_address)
				+ ", reback_type=" + reback_type + ", reback_address_length=" + reback_address_length
				+ ", reback_address=" + reback_address + ", terminal_number4=" + terminal_number4 + ", reserved4="
				+ reserved4 + ", resource_code4=" + Arrays.toString(resource_code4) + ", reback_period=" + reback_period
				+ ", terminal_number5=" + terminal_number5 + ", reserved5=" + reserved5 + ", resource_code5="
				+ Arrays.toString(resource_code5) + ", volume=" + volume + ", terminal_number6=" + terminal_number6
				+ ", reserved6=" + reserved6 + ", resource_code6=" + Arrays.toString(resource_code6)
				+ ", parameter_number=" + parameter_number + ", parameter_tag=" + Arrays.toString(parameter_tag)
				+ ", terminal_number7=" + terminal_number7 + ", reserved7=" + reserved7 + ", resource_code7="
				+ Arrays.toString(resource_code7) + "]";
	}
	
	
}
