package transmission;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Encapsulate {

	private byte[] message = new byte[5000]; //用于保存封装的数据
	private int countbit = 0;
	private int countbyte = 0;
	private static TransTool tool = new TransTool();
	
	/* 函数:addbit
	 * 形参:1.(bit取值:0,1)
	 * 功能:将bit的最低为加入message的最后一位
	 * */
	public void addBit(byte bit) {   
		message[countbyte] |= bit<<(7-countbit++);
		if(countbit==8) {
			countbyte++;
			countbit = 0;
			message[countbyte]=0;
		}
	}
	
	/*
	 * 函数:addbit
	 * 形参:1.(bit取值:0,1) 2.(cntbyte:第几个字节) 3.(cntbit:第几位)
	 * 功能:将bit的最低为加入message的第cntbyte个字节的第cntbit位，仅用于修改已加入message的位
	 * */
	public void addBit(byte bit, int cntbyte, int cntbit) { 
		message[cntbyte] = 0;
		message[cntbyte] |= bit<<(7-cntbit);
	}
	
	static public Encapsulate merge(Encapsulate enc1, Encapsulate enc2) {
		int len = 8 * enc2.getCountbyte() + enc2.getCountbit();
		byte[] mes2 = enc2.getMessage();
		byte[] bits = tool.bytes2bits(mes2);
		for(int i=0;i<len;i++) {
			enc1.addBit(bits[i]);
		}
		return enc1;
	}
	
	
	public void encInt(int num,int length){
		encapsulate(tool.Int2Bytes(num),length);
	}
	
	public void encapsulate(byte[] bytes, int len) { 
		//长度变为8倍
		byte[] bits = tool.bytes2bits(bytes);
		int cnt=bytes.length*8-len;
		while(cnt<0) {
			cnt++;
			addBit((byte)0);
		}
		for(int i=0;i<bytes.length*8;i++) {
			if(cnt>0){
				cnt--;
				continue;
			}
//			System.out.println(i);
			addBit(bits[i]);
		}
	}
	
	/* 函数:update
	 * 形参:1.(bytes:数据) 2.(startbyte:起始位置) 3.(length:指定修改的长度)
	 * 功能:将startbyte开始的length/8个字节置零，然后修改message中从第startbyte个字节开始的length位数据
	 * 说明:仅用于修改已加入message的位，不能用做直接向message添加数据。仅用于设置EBM_length。
	 * */
	public void update(byte[] bytes, int startbyte, int length) {
		
		byte[] bits = tool.bytes2bits(bytes);
		int cntbyte = startbyte;
		int cntbit = 0;
		int dis = length-bits.length;
		for(int i=0;i<dis;i++) {
			addBit((byte)0, cntbyte, cntbit);
			
			cntbit++;
			if(cntbit == 8) {
				cntbyte++;
				cntbit=0;
			}
		}
		
		for(int i=0;i<bits.length;i++) {
			if(dis<0) {
				dis++;
				continue;
			}
			addBit(bits[i], cntbyte, cntbit);
			cntbit++;
			if(cntbit == 8) {
				cntbyte++;
				cntbit=0;
			}
		}
	}
	
	
	
	
	/* 函数:Message2File
	 * 功能:将私有成员message输出到文件，文件名为:日期+alert_id
	 * 形参:(alert_id:警报ID，此次仅用于生成文件名)
	 * */
	public void Message2File() {
		System.out.println("出来吧文件！");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			//String filename ="./files/"+sdf.format(new Date())+"_"+alert_id+".dat";
			FileOutputStream fos = new FileOutputStream(new File("xghtest.dat"));
			byte[] output = new byte[countbyte+1];
			for(int i=0;i<=countbyte;i++)
				output[i] = message[i];
			fos.write(output);
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("生成文件成功2");
	}
	
	public byte[] getMessage() {
		byte[] output = new byte[countbyte+1];
		for(int i=0;i<=countbyte;i++)
			output[i] = message[i];
		return output;
	}

	public int getCountbit() {
		return countbit;
	}

	public int getCountbyte() {
		return countbyte;
	}
	public void printmsg(){
		System.out.println("countbyte:"+countbyte);
		System.out.println("countbit:"+countbit);
		for(int i=0;i<countbyte;i++){
			System.out.println(i+":"+Integer.toBinaryString(message[i]));
		}
	}
	/**
	 * @param s 
	 * 		存放的是整数，取出每一位封装成4个比特
	 * @return 
	 */
	public Encapsulate StringEnc(Encapsulate enc,String s){
		char[] c = s.toCharArray();
		for(int i=0;i<c.length;i++){
			String item = String.valueOf(c[i]);
			int a = Integer.parseInt(item);
			enc.encapsulate(tool.Int2Bytes(a), 4);
		}
		return enc;
	}
	//按ASCII编码封装
	public Encapsulate ASCIIEnc(Encapsulate enc,String s){
		char[] sign = s.toCharArray();
		for(int i=0;i<sign.length;i++){
			byte item = (byte)sign[i];
			enc.encapsulate(tool.Byte2Bytes(item), 8);
		}
		return enc;
	}
	
	/**
	 * 封装小数
	 * 
	 * @param f
	 * 		被封装的小数
	 * @param inte
	 * 		整数占的位数
	 * @param decimal
	 * 		小数占的位数
	 */
	public Encapsulate DoubleEnc(Encapsulate enc,double f,int inte,int decimal){
		String ff = String.valueOf(f);
		System.out.println(f);
		String[] s = ff.split("\\.");
		char[] s0 = s[0].toCharArray();
		int l= inte-s0.length;
		if(l>0){//整数部分不足用0补全
			for(int j=0;j<l;j++)
				enc.encapsulate(tool.Int2Bytes(0), 4);
		}
		//intel防止整数的长度大于inte
		int intel = s0.length;
		if(intel>inte){
			intel = inte;
		}
		for(int k=0;k<intel;k++){
			String item = String.valueOf(s0[k]);
			int tt = Integer.parseInt(item);
			enc.encapsulate(tool.Int2Bytes(tt), 4);
		}
		//小数部分
		
		char[] s1 = s[1].toCharArray();
		int decimall = s1.length;
		System.out.println(decimal+" "+s1.length);
		if(decimall>decimal){
			decimall = decimal;
		}
		
		for(int m=0;m<decimall;m++){
			
			String item = String.valueOf(s1[m]);
			int tt = Integer.parseInt(item);
			enc.encapsulate(tool.Int2Bytes(tt), 4);
		}
		int l2=decimal-s1.length;
		if(l2>0){//小数部分不足用0补全
			for(int j=0;j<l2;j++)
				enc.encapsulate(tool.Int2Bytes(0), 4);
		}
		return enc;
	}
	
	public static void main(String[] args) {
		
		TransTool tool = new TransTool();
		Encapsulate enc = new Encapsulate();
		enc.encapsulate(tool.Byte2Bytes((byte)0), 16);
		enc.update(tool.Byte2Bytes((byte)190), 0, 16);
		
		byte[] mes = enc.getMessage();
		System.out.println(mes[1]);
		System.out.println(enc.getCountbyte()+" "+enc.getCountbit());
		enc.printmsg();
	}
}
