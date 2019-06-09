package transmissionEntity;

import java.util.Arrays;

import servlet.TransmissionServlet;

//模拟调频
public class AnalogFMEntity {

	//数据包类型
	private int type;
	//数据包长度
	private int length;
	//资源编码数量
	private int number;
	//保留位
	private int reserved;
	//资源编码
	private String[] code;
	//数据包时间
	private  long time;
	//证书编号
	private String certificate;
	//数字签名
	private String sign;
	
	
	//根据数据类型定义数据包内容
	//00设置扫描频点列表信息
	private int FrequencyPoints;
	private int FrequencyOrdinalNumber[] = new int[255];
	private int FrequencyPointPriority[] = new int[255];
	private double Frequency[] = new double[255];
	
	//01设置设备资源编码
	private int PhysicalAddressLength;
	private String PhysicalAddress;
	private int reserved1;
	private String EquipmentCode;
	
	//02设置采用/禁用维持指令
	private int instructions;
	private int MaintenanceCycle;
	
	//03系统时间校时指令
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	
	//04设置回传参数
	private int ReturnMode;
	private int ReturnLength;
	private String ReturnData;
	
	//05设置回传周期
	private int ReturnCycle;
	
	//06应急广播证书授权列表更新指令
	private long SigTime;
	private String CertificateSN6;
	private String Signature;
	
	//07数字证书更新指令
	private int NumberOfCertificates;
	private int CertificateLength;
	private String[] CertificateVersion;
	private String[] IssuerSN;
	private String[] CertificateSN7;
		//格式  2108.8
	private String[] CertificateValidate;
	private String[] PublicKey;
	private String[] SignatureData;
	
	
	//08状态/参数查询指令
	private int NumberOfParameters;
	private int[] ParameterIdentification = new int[10];
	
	//11应急开播/停播指令
	private int Start_StopType;
	private int Switching;
	private int EventLevel;
	private String Eventtype;
	private int reserved11;
	private String InfoID;
	private double FrequencyInformation;
	
	//12设备复位指令
	private int InstructionType;
	private int Switching12;
	private int reserved12;
	private double FrequencyInformation12;
	
	//13恢复出厂设置指令
	private int InstructionType13;
	private int reserved13;
	
	//14应急演练指令
	private int EmergencyType;
	private int OperationInstruction;
	private int reserved14;
	private String ExerciseInstructionID;
	
	//15文本内容传输指令
	private int TextType;
	private int CodedCharacterSet;
	private int reserved15;
	private String InfoID15;
	private int TextLength;
	private String Text;
	//21维持指令
	private int MaintenanceInstruction;
	private int reserved21;
	
	//22日常开播/停播指令
	private int DailyType;
	private int Switching22;
	private String InfoID22;
	private double FrequencyInformation22;
	private int volume22;
	
	//23日常广播默认音量设置指令
	private int volume23;
	private int reserved23;
	//24终端功放开关设置指令
	private int Switching24;
	
	public AnalogFMEntity(){
		this.reserved=15;
		this.reserved1=15;
		this.reserved11=15;
		this.reserved12=15;
		this.reserved13=63;
		this.reserved14=15;
		this.reserved15=15;
		this.reserved21=255;
		this.reserved23=255;
		for(int i = 0;i<255;i++){
			this.FrequencyOrdinalNumber[i]=i+1;
		}
		
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getReserved() {
		return reserved;
	}
	public void setReserved(int reserved) {
		this.reserved = reserved;
	}
	public String[] getCode() {
		return code;
	}
	public void setCode(String[] code) {
		this.code = code;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
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
	public int getPhysicalAddressLength() {
		return PhysicalAddressLength;
	}
	public void setPhysicalAddressLength(int physicalAddressLength) {
		PhysicalAddressLength = physicalAddressLength;
	}
	public String getPhysicalAddress() {
		return PhysicalAddress;
	}
	public void setPhysicalAddress(String physicalAddress) {
		PhysicalAddress = physicalAddress;
	}
	public int getReserved1() {
		return reserved1;
	}
	public void setReserved1(int reserved1) {
		this.reserved1 = reserved1;
	}
	public String getEquipmentCode() {
		return EquipmentCode;
	}
	public void setEquipmentCode(String equipmentCode) {
		EquipmentCode = equipmentCode;
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public int getReturnMode() {
		return ReturnMode;
	}
	public void setReturnMode(int returnMode) {
		ReturnMode = returnMode;
	}
	public int getReturnLength() {
		return ReturnLength;
	}
	public void setReturnLength(int returnLength) {
		ReturnLength = returnLength;
	}
	public String getReturnData() {
		return ReturnData;
	}
	public void setReturnData(String returnData) {
		ReturnData = returnData;
	}
	public int getReturnCycle() {
		return ReturnCycle;
	}
	public void setReturnCycle(int returnCycle) {
		ReturnCycle = returnCycle;
	}
	public long getSigTime() {
		return SigTime;
	}
	public void setSigTime(long sigTime) {
		SigTime = sigTime;
	}
	public String getCertificateSN6() {
		return CertificateSN6;
	}
	public void setCertificateSN6(String certificateSN6) {
		CertificateSN6 = certificateSN6;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature(String signature) {
		Signature = signature;
	}
	public int getNumberOfCertificates() {
		return NumberOfCertificates;
	}
	public void setNumberOfCertificates(int numberOfCertificates) {
		NumberOfCertificates = numberOfCertificates;
	}
	public int getCertificateLength() {
		return CertificateLength;
	}
	public void setCertificateLength(int certificateLength) {
		CertificateLength = certificateLength;
	}
	

	public String[] getCertificateVersion() {
		return CertificateVersion;
	}
	public void setCertificateVersion(String[] certificateVersion) {
		CertificateVersion = certificateVersion;
	}
	public String[] getIssuerSN() {
		return IssuerSN;
	}
	public void setIssuerSN(String[] issuerSN) {
		IssuerSN = issuerSN;
	}
	public String[] getCertificateSN7() {
		return CertificateSN7;
	}
	public void setCertificateSN7(String[] certificateSN7) {
		CertificateSN7 = certificateSN7;
	}
	public String[] getCertificateValidate() {
		return CertificateValidate;
	}
	public void setCertificateValidate(String[] certificateValidate) {
		CertificateValidate = certificateValidate;
	}
	public String[] getPublicKey() {
		return PublicKey;
	}
	public void setPublicKey(String[] publicKey) {
		PublicKey = publicKey;
	}
	public String[] getSignatureData() {
		return SignatureData;
	}
	public void setSignatureData(String[] signatureData) {
		SignatureData = signatureData;
	}
	public int getNumberOfParameters() {
		return NumberOfParameters;
	}
	public void setNumberOfParameters(int numberOfParameters) {
		NumberOfParameters = numberOfParameters;
	}
	public int[] getParameterIdentification() {
		return ParameterIdentification;
	}
	public void setParameterIdentification(int[] parameterIdentification) {
		ParameterIdentification = parameterIdentification;
	}
	public int getStart_StopType() {
		return Start_StopType;
	}
	public void setStart_StopType(int start_StopType) {
		Start_StopType = start_StopType;
	}
	public int getSwitching() {
		return Switching;
	}
	public void setSwitching(int switching) {
		Switching = switching;
	}
	public int getEventLevel() {
		return EventLevel;
	}
	public void setEventLevel(int eventLevel) {
		EventLevel = eventLevel;
	}
	public String getEventtype() {
		return Eventtype;
	}
	public void setEventtype(String eventtype) {
		Eventtype = eventtype;
	}
	public int getReserved11() {
		return reserved11;
	}
	public void setReserved11(int reserved11) {
		this.reserved11 = reserved11;
	}
	public String getInfoID() {
		return InfoID;
	}
	public void setInfoID(String infoID) {
		InfoID = infoID;
	}
	public double getFrequencyInformation() {
		return FrequencyInformation;
	}
	public void setFrequencyInformation(double frequencyInformation) {
		FrequencyInformation = frequencyInformation;
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
	public int getEmergencyType() {
		return EmergencyType;
	}
	public void setEmergencyType(int emergencyType) {
		EmergencyType = emergencyType;
	}
	public int getOperationInstruction() {
		return OperationInstruction;
	}
	public void setOperationInstruction(int operationInstruction) {
		OperationInstruction = operationInstruction;
	}
	public int getReserved14() {
		return reserved14;
	}
	public void setReserved14(int reserved14) {
		this.reserved14 = reserved14;
	}
	public String getExerciseInstructionID() {
		return ExerciseInstructionID;
	}
	public void setExerciseInstructionID(String exerciseInstructionID) {
		ExerciseInstructionID = exerciseInstructionID;
	}
	public int getTextType() {
		return TextType;
	}
	public void setTextType(int textType) {
		TextType = textType;
	}
	public int getCodedCharacterSet() {
		return CodedCharacterSet;
	}
	public void setCodedCharacterSet(int codedCharacterSet) {
		CodedCharacterSet = codedCharacterSet;
	}
	public int getReserved15() {
		return reserved15;
	}
	public void setReserved15(int reserved15) {
		this.reserved15 = reserved15;
	}
	public String getInfoID15() {
		return InfoID15;
	}
	public void setInfoID15(String infoID15) {
		InfoID15 = infoID15;
	}
	public int getTextLength() {
		return TextLength;
	}
	public void setTextLength(int textLength) {
		TextLength = textLength;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
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
	public int getDailyType() {
		return DailyType;
	}
	public void setDailyType(int dailyType) {
		DailyType = dailyType;
	}
	public int getSwitching22() {
		return Switching22;
	}
	public void setSwitching22(int switching22) {
		Switching22 = switching22;
	}
	public String getInfoID22() {
		return InfoID22;
	}
	public void setInfoID22(String infoID22) {
		InfoID22 = infoID22;
	}
	public double getFrequencyInformation22() {
		return FrequencyInformation22;
	}
	public void setFrequencyInformation22(double frequencyInformation22) {
		FrequencyInformation22 = frequencyInformation22;
	}
	public int getVolume22() {
		return volume22;
	}
	public void setVolume22(int volume22) {
		this.volume22 = volume22;
	}
	public int getVolume23() {
		return volume23;
	}
	public void setVolume23(int volume23) {
		this.volume23 = volume23;
	}
	public int getReserved23() {
		return reserved23;
	}
	public void setReserved23(int reserved23) {
		this.reserved23 = reserved23;
	}
	public int getSwitching24() {
		return Switching24;
	}
	public void setSwitching24(int switching24) {
		Switching24 = switching24;
	}
	@Override
	public String toString() {
		return "AnalogFMEntity [type=" + type + ", length=" + length + ", number=" + number + ", reserved=" + reserved
				+ ", code=" + Arrays.toString(code) + ", time=" + time + ", certificate=" + certificate + ", sign="
				+ sign + ", FrequencyPoints=" + FrequencyPoints + ", FrequencyOrdinalNumber="
				+  ", FrequencyPointPriority="
				+ Arrays.toString(FrequencyPointPriority) + ", Frequency=" + Arrays.toString(Frequency)
				+ ", PhysicalAddressLength=" + PhysicalAddressLength + ", PhysicalAddress=" + PhysicalAddress
				+ ", reserved1=" + reserved1 + ", EquipmentCode=" + EquipmentCode + ", instructions=" + instructions
				+ ", MaintenanceCycle=" + MaintenanceCycle + ", year=" + year + ", month=" + month + ", day=" + day
				+ ", hour=" + hour + ", minute=" + minute + ", second=" + second + ", ReturnMode=" + ReturnMode
				+ ", ReturnLength=" + ReturnLength + ", ReturnData=" + ReturnData + ", ReturnCycle=" + ReturnCycle
				+ ", SigTime=" + SigTime + ", CertificateSN6=" + CertificateSN6 + ", Signature=" + Signature
				+ ", NumberOfCertificates=" + NumberOfCertificates + ", CertificateLength=" + CertificateLength
				+ ", CertificateVersion=" + CertificateVersion + ", IssuerSN=" + IssuerSN + ", CertificateSN7="
				+ CertificateSN7 + ", CertificateValidate=" + CertificateValidate + ", PublicKey=" + PublicKey
				+ ", SignatureData=" + SignatureData + ", NumberOfParameters=" + NumberOfParameters
				+ ", ParameterIdentification=" + Arrays.toString(ParameterIdentification) + ", Start_StopType="
				+ Start_StopType + ", Switching=" + Switching + ", EventLevel=" + EventLevel + ", Eventtype="
				+ Eventtype + ", reserved11=" + reserved11 + ", InfoID=" + InfoID + ", FrequencyInformation="
				+ FrequencyInformation + ", InstructionType=" + InstructionType + ", Switching12=" + Switching12
				+ ", reserved12=" + reserved12 + ", FrequencyInformation12=" + FrequencyInformation12
				+ ", InstructionType13=" + InstructionType13 + ", reserved13=" + reserved13 + ", EmergencyType="
				+ EmergencyType + ", OperationInstruction=" + OperationInstruction + ", reserved14=" + reserved14
				+ ", ExerciseInstructionID=" + ExerciseInstructionID + ", TextType=" + TextType + ", CodedCharacterSet="
				+ CodedCharacterSet + ", reserved15=" + reserved15 + ", InfoID15=" + InfoID15 + ", TextLength="
				+ TextLength + ", Text=" + Text + ", MaintenanceInstruction=" + MaintenanceInstruction + ", reserved21="
				+ reserved21 + ", DailyType=" + DailyType + ", Switching22=" + Switching22 + ", InfoID22=" + InfoID22
				+ ", FrequencyInformation22=" + FrequencyInformation22 + ", volume22=" + volume22 + ", volume23="
				+ volume23 + ", reserved23=" + reserved23 + ", Switching24=" + Switching24 + "]";
	}
	
	
}
