package transmissionEntity;

import java.util.Arrays;

public class TrumpetEntity {

	private int head;
	private int version;
	private int protocol_type;
	private int platform_type;
	private int data_length;
	
	
	private int signature_length;
	private long signature_time;
	private String Certificate_number;
	private String signature_data;
	private int CRC_32;
	
	//应急大喇叭适配器控制指令
	//ox0c
	private int white_list_length;
	private White_list[] white_list;
	
	//0x0d
	private int reback_type0d;
	private int reback_cycle;
	private int reback_address_length0d;
	private String  reback_address0d;
	
	//ox0e
	private int reserved0e;
	private String front_code0e;
	private int output_channel_id;
	private int output_channel_state;
	
	//0x0f
	private int reserved0f;
	private String front_code0f;
	private int input_channel_id;
	private int input_channel_state;
	
	//0x10
	private int reserved101;
	private String front_code10;
	private int reserved102;
	private String ebm_id;
	private int task_type;
	private long startTime;
	private long endTime;
	
	//0x11
	private int reserved11;
	private String front_code11;
	
	//0x41
	private int certauth_number41;
	private int[] certauth_length41;
	private String[] certauth41;
	private int cert_number41;
	private int[] certh_length41;
	private String[] certh41;
	
	//应急广播大喇叭终端控制指令
	//0x04
	
	
	//0x05
	private int logic_address_number;
	private int[] physical_address_length;
	private String[] physical_address;
	private int[] logic_address_length;
	private String[] logic_address;
	
	//0x06
	private int volume;
	private int resource_code_type06;
	private int resource_code_number06;
	private int resource_code_length06;
	private String[] resource_code06;
	
	//0x07
	private int reback_type07;
	private int reback_address_length07;
	private String reback_address07;
	private int resource_code_type07;
	private int resource_code_number07;
	private int resource_code_length07;
	private String[] resource_code07;
	
	//0x08
	private int reback_type08;
	private int reback_address_length08;
	private String reback_address08;
	private int resource_code_type08;
	private int resource_code_number08;
	private int resource_code_length08;
	private String[] resource_code08;
	private int ruery_code_number;
	private int[] query_code;
	
	//0x09
	private long time;
	
	//0x0a
	private String ip;
	private String subnet_mask;
	private String gateway;
	private int resource_code_type0a;
	private int resource_code_length0a;
	private String resource_code0a;
	
	//0x0b
	private int reback_cycle0b;
	private int resource_code_type0b;
	private int resource_code_number0b;
	private int resource_code_length0b;
	private String[] resource_code0b;
	
	//0x3f
	private int switch_option;
	private int resource_code_type3f;
	private int resource_code_number3f;
	private int resource_code_length3f;
	private String[] resource_code3f;
	
	//0x40
	private int certauth_number40;
	private int[] certauth_length40;
	private String[] certauth40;
	private int cert_number40;
	private int[] certh_length40;
	private String[] certh40;
	
	//0x01
	private int tag;
	private int data_length01;
	private int configure_cmd_tag;
	private int configure_cmd_length;
	private int freq;
	private int symbol_rate;
	private int qam;
	private int resource_code_type01;
	private int resource_code_number01;
	private int resource_code_length01;
	private String[] resource_code01;
	
	//0x02
	private int cmd_type;
	private int data_type;
	private int send_times;
	private int interval;
	private int coverag_resource_number;
	private String[] resource_code;
	private int data_length02;
	
	//设置扫描频点列表信息
	private int FrequencyPoints;
	private int FrequencyOrdinalNumber[] = new int[255];
	private int FrequencyPointPriority[] = new int[255];
	private double Frequency[] = new double[255];
	
	//设置采用/禁用维持指令
	private int instructions;
	private int MaintenanceCycle;
	
	//设备复位指令
	private int InstructionType;
	private int Switching12;
	private int reserved12;
	private double FrequencyInformation12;
	
	//恢复出厂设置指令
	private int InstructionType13;
	private int reserved13;
	
	//维持指令
	private int MaintenanceInstruction;
	private int reserved21;
	
	public TrumpetEntity(){
		this.head=0x49;
		this.version=1;
		this.platform_type=1;
		this.signature_length=74;
		this.configure_cmd_tag=0x04;
	}
	public int getHead() {
		return head;
	}
	public void setHead(int head) {
		this.head = head;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public int getProtocol_type() {
		return protocol_type;
	}
	public void setProtocol_type(int protocol_type) {
		this.protocol_type = protocol_type;
	}
	public int getPlatform_type() {
		return platform_type;
	}
	public void setPlatform_type(int platform_type) {
		this.platform_type = platform_type;
	}
	public int getData_length() {
		return data_length;
	}
	public void setData_length(int data_length) {
		this.data_length = data_length;
	}
	public int getWhite_list_length() {
		return white_list_length;
	}
	public void setWhite_list_length(int white_list_length) {
		this.white_list_length = white_list_length;
	}
	public White_list[] getWhite_list() {
		return white_list;
	}
	public void setWhite_list(White_list[] white_list) {
		this.white_list = white_list;
	}
	public int getReback_type0d() {
		return reback_type0d;
	}
	public void setReback_type0d(int reback_type0d) {
		this.reback_type0d = reback_type0d;
	}
	public int getReback_cycle() {
		return reback_cycle;
	}
	public void setReback_cycle(int reback_cycle) {
		this.reback_cycle = reback_cycle;
	}
	public int getReback_address_length0d() {
		return reback_address_length0d;
	}
	public void setReback_address_length0d(int reback_address_length0d) {
		this.reback_address_length0d = reback_address_length0d;
	}
	public String getReback_address0d() {
		return reback_address0d;
	}
	public void setReback_address0d(String reback_address0d) {
		this.reback_address0d = reback_address0d;
	}
	public int getReserved0e() {
		return reserved0e;
	}
	public void setReserved0e(int reserved0e) {
		this.reserved0e = reserved0e;
	}
	public String getFront_code0e() {
		return front_code0e;
	}
	public void setFront_code0e(String front_code0e) {
		this.front_code0e = front_code0e;
	}
	public int getOutput_channel_id() {
		return output_channel_id;
	}
	public void setOutput_channel_id(int output_channel_id) {
		this.output_channel_id = output_channel_id;
	}
	public int getOutput_channel_state() {
		return output_channel_state;
	}
	public void setOutput_channel_state(int output_channel_state) {
		this.output_channel_state = output_channel_state;
	}
	public int getReserved0f() {
		return reserved0f;
	}
	public void setReserved0f(int reserved0f) {
		this.reserved0f = reserved0f;
	}
	public String getFront_code0f() {
		return front_code0f;
	}
	public void setFront_code0f(String front_code0f) {
		this.front_code0f = front_code0f;
	}
	public int getInput_channel_id() {
		return input_channel_id;
	}
	public void setInput_channel_id(int input_channel_id) {
		this.input_channel_id = input_channel_id;
	}
	public int getInput_channel_state() {
		return input_channel_state;
	}
	public void setInput_channel_state(int input_channel_state) {
		this.input_channel_state = input_channel_state;
	}
	public int getReserved101() {
		return reserved101;
	}
	public void setReserved101(int reserved101) {
		this.reserved101 = reserved101;
	}
	public String getFront_code10() {
		return front_code10;
	}
	public void setFront_code10(String front_code10) {
		this.front_code10 = front_code10;
	}
	public int getReserved102() {
		return reserved102;
	}
	public void setReserved102(int reserved102) {
		this.reserved102 = reserved102;
	}
	public String getEbm_id() {
		return ebm_id;
	}
	public void setEbm_id(String ebm_id) {
		this.ebm_id = ebm_id;
	}
	public int getTask_type() {
		return task_type;
	}
	public void setTask_type(int task_type) {
		this.task_type = task_type;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	public int getReserved11() {
		return reserved11;
	}
	public void setReserved11(int reserved11) {
		this.reserved11 = reserved11;
	}
	public String getFront_code11() {
		return front_code11;
	}
	public void setFront_code11(String front_code11) {
		this.front_code11 = front_code11;
	}
	public int getCertauth_number41() {
		return certauth_number41;
	}
	public void setCertauth_number41(int certauth_number41) {
		this.certauth_number41 = certauth_number41;
	}
	public int[] getCertauth_length41() {
		return certauth_length41;
	}
	public void setCertauth_length41(int[] certauth_length41) {
		this.certauth_length41 = certauth_length41;
	}
	public String[] getCertauth41() {
		return certauth41;
	}
	public void setCertauth41(String[] certauth41) {
		this.certauth41 = certauth41;
	}
	public int getCert_number41() {
		return cert_number41;
	}
	public void setCert_number41(int cert_number41) {
		this.cert_number41 = cert_number41;
	}
	public int[] getCerth_length41() {
		return certh_length41;
	}
	public void setCerth_length41(int[] certh_length41) {
		this.certh_length41 = certh_length41;
	}
	public String[] getCerth41() {
		return certh41;
	}
	public void setCerth41(String[] certh41) {
		this.certh41 = certh41;
	}
	public int getLogic_address_number() {
		return logic_address_number;
	}
	public void setLogic_address_number(int logic_address_number) {
		this.logic_address_number = logic_address_number;
	}
	public int[] getPhysical_address_length() {
		return physical_address_length;
	}
	public void setPhysical_address_length(int[] physical_address_length) {
		this.physical_address_length = physical_address_length;
	}
	public String[] getPhysical_address() {
		return physical_address;
	}
	public void setPhysical_address(String[] physical_address) {
		this.physical_address = physical_address;
	}
	public int[] getLogic_address_length() {
		return logic_address_length;
	}
	public void setLogic_address_length(int[] logic_address_length) {
		this.logic_address_length = logic_address_length;
	}
	public String[] getLogic_address() {
		return logic_address;
	}
	public void setLogic_address(String[] logic_address) {
		this.logic_address = logic_address;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getResource_code_type06() {
		return resource_code_type06;
	}
	public void setResource_code_type06(int resource_code_type06) {
		this.resource_code_type06 = resource_code_type06;
	}
	public int getResource_code_number06() {
		return resource_code_number06;
	}
	public void setResource_code_number06(int resource_code_number06) {
		this.resource_code_number06 = resource_code_number06;
	}
	public int getResource_code_length06() {
		return resource_code_length06;
	}
	public void setResource_code_length06(int resource_code_length06) {
		this.resource_code_length06 = resource_code_length06;
	}
	public String[] getResource_code06() {
		return resource_code06;
	}
	public void setResource_code06(String[] resource_code06) {
		this.resource_code06 = resource_code06;
	}
	public int getReback_type07() {
		return reback_type07;
	}
	public void setReback_type07(int reback_type07) {
		this.reback_type07 = reback_type07;
	}
	public int getReback_address_length07() {
		return reback_address_length07;
	}
	public void setReback_address_length07(int reback_address_length07) {
		this.reback_address_length07 = reback_address_length07;
	}
	public String getReback_address07() {
		return reback_address07;
	}
	public void setReback_address07(String reback_address07) {
		this.reback_address07 = reback_address07;
	}
	public int getResource_code_type07() {
		return resource_code_type07;
	}
	public void setResource_code_type07(int resource_code_type07) {
		this.resource_code_type07 = resource_code_type07;
	}
	public int getResource_code_number07() {
		return resource_code_number07;
	}
	public void setResource_code_number07(int resource_code_number07) {
		this.resource_code_number07 = resource_code_number07;
	}
	public int getResource_code_length07() {
		return resource_code_length07;
	}
	public void setResource_code_length07(int resource_code_length07) {
		this.resource_code_length07 = resource_code_length07;
	}
	public String[] getResource_code07() {
		return resource_code07;
	}
	public void setResource_code07(String[] resource_code07) {
		this.resource_code07 = resource_code07;
	}
	public int getReback_type08() {
		return reback_type08;
	}
	public void setReback_type08(int reback_type08) {
		this.reback_type08 = reback_type08;
	}
	public int getReback_address_length08() {
		return reback_address_length08;
	}
	public void setReback_address_length08(int reback_address_length08) {
		this.reback_address_length08 = reback_address_length08;
	}
	public String getReback_address08() {
		return reback_address08;
	}
	public void setReback_address08(String reback_address08) {
		this.reback_address08 = reback_address08;
	}
	public int getResource_code_type08() {
		return resource_code_type08;
	}
	public void setResource_code_type08(int resource_code_type08) {
		this.resource_code_type08 = resource_code_type08;
	}
	public int getResource_code_number08() {
		return resource_code_number08;
	}
	public void setResource_code_number08(int resource_code_number08) {
		this.resource_code_number08 = resource_code_number08;
	}
	public int getResource_code_length08() {
		return resource_code_length08;
	}
	public void setResource_code_length08(int resource_code_length08) {
		this.resource_code_length08 = resource_code_length08;
	}
	public String[] getResource_code08() {
		return resource_code08;
	}
	public void setResource_code08(String[] resource_code08) {
		this.resource_code08 = resource_code08;
	}
	public int getRuery_code_number() {
		return ruery_code_number;
	}
	public void setRuery_code_number(int ruery_code_number) {
		this.ruery_code_number = ruery_code_number;
	}
	public int[] getQuery_code() {
		return query_code;
	}
	public void setQuery_code(int[] query_code) {
		this.query_code = query_code;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSubnet_mask() {
		return subnet_mask;
	}
	public void setSubnet_mask(String subnet_mask) {
		this.subnet_mask = subnet_mask;
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	public int getResource_code_type0a() {
		return resource_code_type0a;
	}
	public void setResource_code_type0a(int resource_code_type0a) {
		this.resource_code_type0a = resource_code_type0a;
	}
	public int getResource_code_length0a() {
		return resource_code_length0a;
	}
	public void setResource_code_length0a(int resource_code_length0a) {
		this.resource_code_length0a = resource_code_length0a;
	}
	public String getResource_code0a() {
		return resource_code0a;
	}
	public void setResource_code0a(String resource_code0a) {
		this.resource_code0a = resource_code0a;
	}
	public int getReback_cycle0b() {
		return reback_cycle0b;
	}
	public void setReback_cycle0b(int reback_cycle0b) {
		this.reback_cycle0b = reback_cycle0b;
	}
	public int getResource_code_type0b() {
		return resource_code_type0b;
	}
	public void setResource_code_type0b(int resource_code_type0b) {
		this.resource_code_type0b = resource_code_type0b;
	}
	public int getResource_code_number0b() {
		return resource_code_number0b;
	}
	public void setResource_code_number0b(int resource_code_number0b) {
		this.resource_code_number0b = resource_code_number0b;
	}
	public int getResource_code_length0b() {
		return resource_code_length0b;
	}
	public void setResource_code_length0b(int resource_code_length0b) {
		this.resource_code_length0b = resource_code_length0b;
	}
	public String[] getResource_code0b() {
		return resource_code0b;
	}
	public void setResource_code0b(String[] resource_code0b) {
		this.resource_code0b = resource_code0b;
	}
	public int getSwitch_option() {
		return switch_option;
	}
	public void setSwitch_option(int switch_option) {
		this.switch_option = switch_option;
	}
	public int getResource_code_type3f() {
		return resource_code_type3f;
	}
	public void setResource_code_type3f(int resource_code_type3f) {
		this.resource_code_type3f = resource_code_type3f;
	}
	public int getResource_code_number3f() {
		return resource_code_number3f;
	}
	public void setResource_code_number3f(int resource_code_number3f) {
		this.resource_code_number3f = resource_code_number3f;
	}
	public int getResource_code_length3f() {
		return resource_code_length3f;
	}
	public void setResource_code_length3f(int resource_code_length3f) {
		this.resource_code_length3f = resource_code_length3f;
	}
	public String[] getResource_code3f() {
		return resource_code3f;
	}
	public void setResource_code3f(String[] resource_code3f) {
		this.resource_code3f = resource_code3f;
	}
	public int getCertauth_number40() {
		return certauth_number40;
	}
	public void setCertauth_number40(int certauth_number40) {
		this.certauth_number40 = certauth_number40;
	}
	public int[] getCertauth_length40() {
		return certauth_length40;
	}
	public void setCertauth_length40(int[] certauth_length40) {
		this.certauth_length40 = certauth_length40;
	}
	public String[] getCertauth40() {
		return certauth40;
	}
	public void setCertauth40(String[] certauth40) {
		this.certauth40 = certauth40;
	}
	public int getCert_number40() {
		return cert_number40;
	}
	public void setCert_number40(int cert_number40) {
		this.cert_number40 = cert_number40;
	}
	public int[] getCerth_length40() {
		return certh_length40;
	}
	public void setCerth_length40(int[] certh_length40) {
		this.certh_length40 = certh_length40;
	}
	public String[] getCerth40() {
		return certh40;
	}
	public void setCerth40(String[] certh40) {
		this.certh40 = certh40;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public int getData_length01() {
		return data_length01;
	}
	public void setData_length01(int data_length01) {
		this.data_length01 = data_length01;
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
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public int getSymbol_rate() {
		return symbol_rate;
	}
	public void setSymbol_rate(int symbol_rate) {
		this.symbol_rate = symbol_rate;
	}
	public int getQam() {
		return qam;
	}
	public void setQam(int qam) {
		this.qam = qam;
	}
	public int getResource_code_type01() {
		return resource_code_type01;
	}
	public void setResource_code_type01(int resource_code_type01) {
		this.resource_code_type01 = resource_code_type01;
	}
	public int getResource_code_number01() {
		return resource_code_number01;
	}
	public void setResource_code_number01(int resource_code_number01) {
		this.resource_code_number01 = resource_code_number01;
	}
	public int getResource_code_length01() {
		return resource_code_length01;
	}
	public void setResource_code_length01(int resource_code_length01) {
		this.resource_code_length01 = resource_code_length01;
	}
	public String[] getResource_code01() {
		return resource_code01;
	}
	public void setResource_code01(String[] resource_code01) {
		this.resource_code01 = resource_code01;
	}
	public int getCmd_type() {
		return cmd_type;
	}
	public void setCmd_type(int cmd_type) {
		this.cmd_type = cmd_type;
	}
	public int getData_type() {
		return data_type;
	}
	public void setData_type(int data_type) {
		this.data_type = data_type;
	}
	public int getSend_times() {
		return send_times;
	}
	public void setSend_times(int send_times) {
		this.send_times = send_times;
	}
	public int getInterval() {
		return interval;
	}
	public void setInterval(int interval) {
		this.interval = interval;
	}
	public int getCoverag_resource_number() {
		return coverag_resource_number;
	}
	public void setCoverag_resource_number(int coverag_resource_number) {
		this.coverag_resource_number = coverag_resource_number;
	}
	public String[] getResource_code() {
		return resource_code;
	}
	public void setResource_code(String[] resource_code) {
		this.resource_code = resource_code;
	}
	public int getData_length02() {
		return data_length02;
	}
	public void setData_length02(int data_length02) {
		this.data_length02 = data_length02;
	}
	public int getFrequencyPoints() {
		return FrequencyPoints;
	}
	public void setFrequencyPoints(int frequencyPoints) {
		FrequencyPoints = frequencyPoints;
	}
	public int[] getFrequencyOrdinalNumber() {
		return FrequencyOrdinalNumber;
	}
	public void setFrequencyOrdinalNumber(int[] frequencyOrdinalNumber) {
		FrequencyOrdinalNumber = frequencyOrdinalNumber;
	}
	public int[] getFrequencyPointPriority() {
		return FrequencyPointPriority;
	}
	public void setFrequencyPointPriority(int[] frequencyPointPriority) {
		FrequencyPointPriority = frequencyPointPriority;
	}
	public double[] getFrequency() {
		return Frequency;
	}
	public void setFrequency(double[] frequency) {
		Frequency = frequency;
	}
	public int getInstructions() {
		return instructions;
	}
	public void setInstructions(int instructions) {
		this.instructions = instructions;
	}
	public int getMaintenanceCycle() {
		return MaintenanceCycle;
	}
	public void setMaintenanceCycle(int maintenanceCycle) {
		MaintenanceCycle = maintenanceCycle;
	}
	public int getInstructionType() {
		return InstructionType;
	}
	public void setInstructionType(int instructionType) {
		InstructionType = instructionType;
	}
	public int getSwitching12() {
		return Switching12;
	}
	public void setSwitching12(int switching12) {
		Switching12 = switching12;
	}
	public int getReserved12() {
		return reserved12;
	}
	public void setReserved12(int reserved12) {
		this.reserved12 = reserved12;
	}
	public double getFrequencyInformation12() {
		return FrequencyInformation12;
	}
	public void setFrequencyInformation12(double frequencyInformation12) {
		FrequencyInformation12 = frequencyInformation12;
	}
	public int getInstructionType13() {
		return InstructionType13;
	}
	public void setInstructionType13(int instructionType13) {
		InstructionType13 = instructionType13;
	}
	public int getReserved13() {
		return reserved13;
	}
	public void setReserved13(int reserved13) {
		this.reserved13 = reserved13;
	}
	public int getMaintenanceInstruction() {
		return MaintenanceInstruction;
	}
	public void setMaintenanceInstruction(int maintenanceInstruction) {
		MaintenanceInstruction = maintenanceInstruction;
	}
	public int getReserved21() {
		return reserved21;
	}
	public void setReserved21(int reserved21) {
		this.reserved21 = reserved21;
	}
	public int getSignature_length() {
		return signature_length;
	}
	public void setSignature_length(int signature_length) {
		this.signature_length = signature_length;
	}
	public long getSignature_time() {
		return signature_time;
	}
	public void setSignature_time(long signature_time) {
		this.signature_time = signature_time;
	}
	public String getCertificate_number() {
		return Certificate_number;
	}
	public void setCertificate_number(String certificate_number) {
		Certificate_number = certificate_number;
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
	@Override
	public String toString() {
		return "TrumpetEntity [head=" + head + ", version=" + version + ", protocol_type=" + protocol_type
				+ ", platform_type=" + platform_type + ", data_length=" + data_length + ", signature_length="
				+ signature_length + ", signature_time=" + signature_time + ", Certificate_number=" + Certificate_number
				+ ", signature_data=" + signature_data + ", CRC_32=" + CRC_32 + ", white_list_length="
				+ white_list_length + ", white_list=" + Arrays.toString(white_list) + ", reback_type0d=" + reback_type0d
				+ ", reback_cycle=" + reback_cycle + ", reback_address_length0d=" + reback_address_length0d
				+ ", reback_address0d=" + reback_address0d + ", reserved0e=" + reserved0e + ", front_code0e="
				+ front_code0e + ", output_channel_id=" + output_channel_id + ", output_channel_state="
				+ output_channel_state + ", reserved0f=" + reserved0f + ", front_code0f=" + front_code0f
				+ ", input_channel_id=" + input_channel_id + ", input_channel_state=" + input_channel_state
				+ ", reserved101=" + reserved101 + ", front_code10=" + front_code10 + ", reserved102=" + reserved102
				+ ", ebm_id=" + ebm_id + ", task_type=" + task_type + ", startTime=" + startTime + ", endTime="
				+ endTime + ", reserved11=" + reserved11 + ", front_code11=" + front_code11 + ", certauth_number41="
				+ certauth_number41 + ", certauth_length41=" + Arrays.toString(certauth_length41) + ", certauth41="
				+ Arrays.toString(certauth41) + ", cert_number41=" + cert_number41 + ", certh_length41="
				+ Arrays.toString(certh_length41) + ", certh41=" + Arrays.toString(certh41) + ", logic_address_number="
				+ logic_address_number + ", physical_address_length=" + Arrays.toString(physical_address_length)
				+ ", physical_address=" + Arrays.toString(physical_address) + ", logic_address_length="
				+ Arrays.toString(logic_address_length) + ", logic_address=" + Arrays.toString(logic_address)
				+ ", volume=" + volume + ", resource_code_type06=" + resource_code_type06 + ", resource_code_number06="
				+ resource_code_number06 + ", resource_code_length06=" + resource_code_length06 + ", resource_code06="
				+ Arrays.toString(resource_code06) + ", reback_type07=" + reback_type07 + ", reback_address_length07="
				+ reback_address_length07 + ", reback_address07=" + reback_address07 + ", resource_code_type07="
				+ resource_code_type07 + ", resource_code_number07=" + resource_code_number07
				+ ", resource_code_length07=" + resource_code_length07 + ", resource_code07="
				+ Arrays.toString(resource_code07) + ", reback_type08=" + reback_type08 + ", reback_address_length08="
				+ reback_address_length08 + ", reback_address08=" + reback_address08 + ", resource_code_type08="
				+ resource_code_type08 + ", resource_code_number08=" + resource_code_number08
				+ ", resource_code_length08=" + resource_code_length08 + ", resource_code08="
				+ Arrays.toString(resource_code08) + ", ruery_code_number=" + ruery_code_number + ", query_code="
				+ Arrays.toString(query_code) + ", time=" + time + ", ip=" + ip + ", subnet_mask=" + subnet_mask
				+ ", gateway=" + gateway + ", resource_code_type0a=" + resource_code_type0a
				+ ", resource_code_length0a=" + resource_code_length0a + ", resource_code0a=" + resource_code0a
				+ ", reback_cycle0b=" + reback_cycle0b + ", resource_code_type0b=" + resource_code_type0b
				+ ", resource_code_number0b=" + resource_code_number0b + ", resource_code_length0b="
				+ resource_code_length0b + ", resource_code0b=" + Arrays.toString(resource_code0b) + ", switch_option="
				+ switch_option + ", resource_code_type3f=" + resource_code_type3f + ", resource_code_number3f="
				+ resource_code_number3f + ", resource_code_length3f=" + resource_code_length3f + ", resource_code3f="
				+ Arrays.toString(resource_code3f) + ", certauth_number40=" + certauth_number40 + ", certauth_length40="
				+ Arrays.toString(certauth_length40) + ", certauth40=" + Arrays.toString(certauth40)
				+ ", cert_number40=" + cert_number40 + ", certh_length40=" + Arrays.toString(certh_length40)
				+ ", certh40=" + Arrays.toString(certh40) + ", tag=" + tag + ", data_length01=" + data_length01
				+ ", configure_cmd_tag=" + configure_cmd_tag + ", configure_cmd_length=" + configure_cmd_length
				+ ", freq=" + freq + ", symbol_rate=" + symbol_rate + ", qam=" + qam + ", resource_code_type01="
				+ resource_code_type01 + ", resource_code_number01=" + resource_code_number01
				+ ", resource_code_length01=" + resource_code_length01 + ", resource_code01="
				+ Arrays.toString(resource_code01) + ", cmd_type=" + cmd_type + ", data_type=" + data_type
				+ ", send_times=" + send_times + ", interval=" + interval + ", coverag_resource_number="
				+ coverag_resource_number + ", resource_code=" + Arrays.toString(resource_code) + ", data_length02="
				+ data_length02 + ", FrequencyPoints=" + FrequencyPoints + ", FrequencyOrdinalNumber="
				+ Arrays.toString(FrequencyOrdinalNumber) + ", FrequencyPointPriority="
				+ Arrays.toString(FrequencyPointPriority) + ", Frequency=" + Arrays.toString(Frequency)
				+ ", instructions=" + instructions + ", MaintenanceCycle=" + MaintenanceCycle + ", InstructionType="
				+ InstructionType + ", Switching12=" + Switching12 + ", reserved12=" + reserved12
				+ ", FrequencyInformation12=" + FrequencyInformation12 + ", InstructionType13=" + InstructionType13
				+ ", reserved13=" + reserved13 + ", MaintenanceInstruction=" + MaintenanceInstruction + ", reserved21="
				+ reserved21 + "]";
	}
	
}
