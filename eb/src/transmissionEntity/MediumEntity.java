package transmissionEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

//中波
public class MediumEntity {
	//起始标志
	private int startSign;
	//指令类型
	private int type;
	//指令长度
	private int length;
	//保留位
	private int reserved;
	//发送源标识码
	private String source;
	//保留位
	private int reserved2;
	//应急广播消息编号
	private String number;
	//区域目标数
	private int areas;
	//区域目标编码
	private String code[] = new String[8];

	//数据包时间
	private  long time;
	//证书编号
	private String certificate;
	//数字签名
	private String sign;
	
	
	//开播指令数据包内容
	private int duration;
	private int level;
	private String eventType;
	private int reserved3;
	
	//设置默认锁定频点指令
	private int frequencyType;
	private String value;
	
	//证书授权指令
	private String ReceiverSN;
	private int CertsAuthSN;
	private int CertsCount;
	private String[] CertSNs;
	private String SigSN;
	private String Signature;
	
	public MediumEntity(){
		this.startSign=105;
		this.reserved=15;
		this.reserved2=15;
	}

	public int getStartSign() {
		return startSign;
	}

	public void setStartSign(int startSign) {
		this.startSign = startSign;
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

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getReserved2() {
		return reserved2;
	}

	public void setReserved2(int reserved2) {
		this.reserved2 = reserved2;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getAreas() {
		return areas;
	}

	public void setAreas(int areas) {
		this.areas = areas;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public int getReserved3() {
		return reserved3;
	}

	public void setReserved3(int reserved3) {
		this.reserved3 = reserved3;
	}

	public int getFrequencyType() {
		return frequencyType;
	}

	public void setFrequencyType(int frequencyType) {
		this.frequencyType = frequencyType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getReceiverSN() {
		return ReceiverSN;
	}

	public void setReceiverSN(String receiverSN) {
		ReceiverSN = receiverSN;
	}

	public int getCertsAuthSN() {
		return CertsAuthSN;
	}

	public void setCertsAuthSN(int certsAuthSN) {
		CertsAuthSN = certsAuthSN;
	}

	public int getCertsCount() {
		return CertsCount;
	}

	public void setCertsCount(int certsCount) {
		CertsCount = certsCount;
	}

	public String[] getCertSNs() {
		return CertSNs;
	}

	public void setCertSNs(String[] certSNs) {
		CertSNs = certSNs;
	}

	public String getSigSN() {
		return SigSN;
	}

	public void setSigSN(String sigSN) {
		SigSN = sigSN;
	}

	public String getSignature() {
		return Signature;
	}

	public void setSignature(String signature) {
		Signature = signature;
	}

	@Override
	public String toString() {
		return "MediumEntity [startSign=" + startSign + ", type=" + type + ", length=" + length + ", reserved="
				+ reserved + ", source=" + source + ", reserved2=" + reserved2 + ", number=" + number + ", areas="
				+ areas + ", code=" + Arrays.toString(code) + ", content="  + ", time=" + time
				+ ", certificate=" + certificate + ", sign=" + sign + ", duration=" + duration + ", level=" + level
				+ ", eventType=" + eventType + ", reserved3=" + reserved3 + ", frequencyType=" + frequencyType
				+ ", value=" + value + ", ReceiverSN=" + ReceiverSN + ", CertsAuthSN=" + CertsAuthSN + ", CertsCount="
				+ CertsCount + ", CertSNs=" + CertSNs + ", SigSN=" + SigSN + ", Signature=" + Signature + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 精确到毫秒
        // 获取当前时间戳
        System.out.println(System.currentTimeMillis());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(new Date().getTime());

        // 精确到秒
        // 获取当前时间戳
        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(Calendar.getInstance().getTimeInMillis() / 1000);
        System.out.println(new Date().getTime() / 1000);

        // 精确到毫秒
        // 获取指定格式的时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        // 输出字符串
        System.out.println(df.format(new Date()));
        // 获取指定时间Date对象，参数是时间戳，只能精确到秒
        System.out.println(new Date(1510369871));
        df.getCalendar();
        // 获取指定时间的时间戳
        try {
            System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").parse("2017/11/11 11:11:11:111").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

}
