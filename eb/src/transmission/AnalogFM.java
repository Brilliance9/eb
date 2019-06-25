package transmission;

import transmissionEntity.AnalogFMEntity;
import udp.Send;

public class AnalogFM {

	Encapsulate enc = new Encapsulate();
	TransTool tool = new TransTool();
	public int AnalogFMMake(AnalogFMEntity afm,boolean judge){
		

		//根据数据包类型调用不同的封装函数
		switch(afm.getType()){
		case 0:make0(afm);
			break;
		case 1:make1(afm);
			break;
		case 2:make2(afm);
			break;
		case 3:make3(afm);
			break;
		case 4:make4(afm);
			break;
		case 5:make5(afm);
			break;
		case 6:make6(afm);
			break;
		case 7:make7(afm);
			break;
		case 8:make8(afm);
			break;
		case 11:make11(afm);
			break;
		case 12:make12(afm);
			break;
		case 13:make13(afm);
			break;
		case 14:make14(afm);
			break;
		case 15:make15(afm);
			break;
		case 21:make21(afm);
			break;
		case 22:make22(afm);
			break;
		case 23:make23(afm);
			break;
		case 24:make24(afm);
			break;
		default:;
		
		}
		
		if(judge == true){
			Send s = new Send();
			s.run(enc.getMessage());
		}
		
		return enc.getCountbyte();

		
	}
	
	
	
	public Encapsulate head(Encapsulate enc,AnalogFMEntity afm){
		
		
		enc.encapsulate(tool.Int2Bytes(afm.getType()), 5);
		enc.encapsulate(tool.Int2Bytes(afm.getLength()), 11);
		enc.encapsulate(tool.Int2Bytes(afm.getNumber()), 8);
		for(int i =0;i<afm.getNumber();i++){
			enc.encapsulate(tool.Int2Bytes(afm.getReserved()), 4);
			enc.StringEnc(enc, afm.getCode()[i]);
		}
		
		
		
		return enc;
	}
	
	public Encapsulate tail(Encapsulate enc,AnalogFMEntity afm){
		
		//封装数据包时间
		enc.encapsulate(tool.Long2Bytes(afm.getTime()), 32);
		//封装证书编号
		enc.StringEnc(enc, afm.getCertificate());
		

		//封装数字签名
		char[] sign = afm.getSign().toCharArray();
		for(int j=0;j<sign.length;j++){
			byte item = (byte)sign[j];
			enc.encapsulate(tool.Byte2Bytes(item), 8);
		}
		enc.printmsg();
		enc.Message2File("AnalogFM_"+afm.getType()+"_");
		return enc;
	}
	
	
	
	public void make0(AnalogFMEntity afm){
		head(enc,afm);
		//数据包内容
		enc.encapsulate(tool.Int2Bytes(afm.getFrequencyPoints()), 8);
		for(int i=0;i<afm.getFrequencyPoints();i++){
			enc.encapsulate(tool.Int2Bytes(afm.getFrequencyOrdinalNumber()[i]), 8);
			enc.encapsulate(tool.Int2Bytes(afm.getFrequencyPointPriority()[i]), 8);
			
			String ff = String.valueOf(afm.getFrequency()[i]);
			String[] s = ff.split("\\.");
			char[] s0 = s[0].toCharArray();
			int l= 4-s0.length;
			if(l>0){//整数部分不足4位用0补全
				for(int j=0;j<l;j++)
					enc.encapsulate(tool.Int2Bytes(0), 4);
			}
			for(int k=0;k<s0.length;k++){
				String item = String.valueOf(s0[k]);
				int tt = Integer.parseInt(item);
				enc.encapsulate(tool.Int2Bytes(tt), 4);
			}
			//小数部分
			char[] s1 = s[1].toCharArray();
			for(int m=0;m<s1.length;m++){
				
				String item = String.valueOf(s1[m]);
				int tt = Integer.parseInt(item);
				enc.encapsulate(tool.Int2Bytes(tt), 4);
			}
			int l2=2-s1.length;
			if(l2>0){//小数部分不足2位用0补全
				for(int j=0;j<l2;j++)
					enc.encapsulate(tool.Int2Bytes(0), 4);
			}
			
			
		}
		tail(enc,afm);

	}
	
	public void make1(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getPhysicalAddressLength()), 8);
		enc.ASCIIEnc(enc, afm.getPhysicalAddress());
		enc.encapsulate(tool.Int2Bytes(afm.getReserved1()), 4);
		enc.StringEnc(enc, afm.getEquipmentCode());
		tail(enc,afm);

	}
	
	public void make2(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getInstructions()), 8);
		enc.encapsulate(tool.Int2Bytes(afm.getMaintenanceCycle()), 16);
		
		tail(enc,afm);
	}
	
	public void make3(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getYear()), 16);
		enc.encapsulate(tool.Int2Bytes(afm.getMonth()), 8);
		enc.encapsulate(tool.Int2Bytes(afm.getDay()), 8);
		enc.encapsulate(tool.Int2Bytes(afm.getHour()), 8);
		enc.encapsulate(tool.Int2Bytes(afm.getMinute()), 8);
		enc.encapsulate(tool.Int2Bytes(afm.getSecond()), 8);
		tail(enc,afm);
	}
	
	public void make4(AnalogFMEntity afm){
		head(enc,afm);
		int mode = afm.getReturnMode();
		enc.encapsulate(tool.Int2Bytes(mode), 8);
		enc.encapsulate(tool.Int2Bytes(afm.getReturnLength()), 8);
		if(mode == 1){//短信，11位数字
			enc.ASCIIEnc(enc, afm.getReturnData());
		}else if(mode == 2){//IP 地址和端口；192.168.22.56:8080
			String returnData = afm.getReturnData();
			String[] str;
			String[] IP;

			if(returnData.contains(":")){
				str = returnData.split(":");
				IP = str[0].split("\\.");
				for(int i = 0;i<4;i++){
					int item = Integer.parseInt(IP[i]);
					enc.encapsulate(tool.Int2Bytes(item), 8);
					
				}
				enc.encapsulate(tool.Int2Bytes(Integer.parseInt(str[1])), 16);
			}else if(returnData.contains("：")){
				str = returnData.split(":");
				IP = str[0].split(".");
				for(int i = 0;i<4;i++){
					int item = Integer.parseInt(IP[i]);
					enc.encapsulate(tool.Int2Bytes(item), 8);

				}
				enc.encapsulate(tool.Int2Bytes(Integer.parseInt(str[1])), 16);

			}

		}else if(mode == 3){//域名和端口号
			enc.ASCIIEnc(enc, afm.getReturnData());
		}
		tail(enc,afm);
	
	}
	
	public void make5(AnalogFMEntity afm){	
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getReturnCycle()), 32);
		tail(enc,afm);
	}
	
	public void make6(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Long2Bytes(afm.getSigTime()), 32);
		enc.StringEnc(enc, afm.getCertificateSN6());
		enc.ASCIIEnc(enc, afm.getSignature());
		tail(enc,afm);
	}
	
	public void make7(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getNumberOfCertificates()), 8);
		enc.encapsulate(tool.Int2Bytes(afm.getCertificateLength()), 8);
		for(int i=0;i<afm.getNumberOfCertificates();i++){
			enc.StringEnc(enc, afm.getCertificateVersion()[i]);
			enc.StringEnc(enc, afm.getIssuerSN()[i]);
			enc.StringEnc(enc, afm.getCertificateSN7()[i]);
			//格式  2108.8
			String str = afm.getCertificateValidate()[i];
			String[] items = str.split("\\.");
			int year = Integer.parseInt(items[0]);
			int month = Integer.parseInt(items[1]);
			enc.encapsulate(tool.Int2Bytes(year), 8);
			enc.encapsulate(tool.Int2Bytes(month), 8);
			enc.ASCIIEnc(enc, afm.getPublicKey()[i]);
			enc.ASCIIEnc(enc, afm.getSignatureData()[i]);
		}
		
		tail(enc,afm);
	}
	
	public void make8(AnalogFMEntity afm){
		head(enc,afm);
		int length = afm.getNumberOfParameters();
		enc.encapsulate(tool.Int2Bytes(length), 8);
		for(int i=0;i<length;i++){
			enc.encapsulate(tool.Int2Bytes(afm.getParameterIdentification()[i]), 8);
		}
		tail(enc,afm);
	}
	
	public void make11(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getStart_StopType()), 2);
		enc.encapsulate(tool.Int2Bytes(afm.getSwitching()), 2);
		enc.encapsulate(tool.Int2Bytes(afm.getEventLevel()), 4);
		enc.ASCIIEnc(enc, afm.getEventtype());
		enc.encapsulate(tool.Int2Bytes(afm.getReserved11()), 4);
		enc.StringEnc(enc, afm.getInfoID());
		
		if(afm.getSwitching() == 1){
			enc.DoubleEnc(enc, afm.getFrequencyInformation(),4,2);
		}else{
			enc.encapsulate(tool.Int2Bytes(0), 24);
		}
		tail(enc,afm);
	}
	public void make12(AnalogFMEntity afm){
		head(enc,afm);
		
		enc.encapsulate(tool.Int2Bytes(afm.getInstructionType()), 2);
		enc.encapsulate(tool.Int2Bytes(afm.getSwitching12()), 2);
		enc.encapsulate(tool.Int2Bytes(afm.getReserved12()), 4);
		
		if(afm.getSwitching12() == 1){
			enc.DoubleEnc(enc, afm.getFrequencyInformation12(),4,2);
		}else{
			enc.encapsulate(tool.Int2Bytes(0), 24);
		}
		tail(enc,afm);
	}
	public void make13(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getInstructionType13()), 2);
		enc.encapsulate(tool.Int2Bytes(afm.getReserved13()), 6);
		tail(enc,afm);
	}
	public void make14(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getEmergencyType()), 4);
		enc.encapsulate(tool.Int2Bytes(afm.getOperationInstruction()), 4);
		enc.encapsulate(tool.Int2Bytes(afm.getReserved14()), 4);
		enc.StringEnc(enc, afm.getExerciseInstructionID());
		tail(enc,afm);
	}
	public void make15(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getTextType()), 4);
		enc.encapsulate(tool.Int2Bytes(afm.getCodedCharacterSet()), 4);
		enc.encapsulate(tool.Int2Bytes(afm.getReserved15()), 4);
		enc.StringEnc(enc, afm.getInfoID15());
		enc.encapsulate(tool.Int2Bytes(afm.getTextLength()), 8);
		enc.ASCIIEnc(enc, afm.getText());
		tail(enc,afm);
	}
	public void make21(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getMaintenanceInstruction()), 8);
		enc.encapsulate(tool.Int2Bytes(afm.getReserved21()), 8);
		tail(enc,afm);
	}
	public void make22(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getDailyType()), 2);
		enc.encapsulate(tool.Int2Bytes(afm.getSwitching22()), 2);
		enc.StringEnc(enc, afm.getInfoID22());
		enc.DoubleEnc(enc, afm.getFrequencyInformation22(),4,2);
		enc.encapsulate(tool.Int2Bytes(afm.getVolume22()), 8);
		tail(enc,afm);
	}
	public void make23(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getVolume23()), 8);
		enc.encapsulate(tool.Int2Bytes(afm.getReserved23()), 8);
		tail(enc,afm);
	}
	public void make24(AnalogFMEntity afm){
		head(enc,afm);
		enc.encapsulate(tool.Int2Bytes(afm.getSwitching24()), 8);
		tail(enc,afm);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnalogFMEntity afme = new AnalogFMEntity();
		afme.setType(0);
		afme.setLength(542);
		afme.setNumber(1);
		String[] code = new String[1];
		code[0]="85426459154875621574851";
		afme.setCode(code);
		
		
		//0
		afme.setFrequencyPoints(2);
		int[] tt = new int[2];
		tt[0]=2;
		tt[1]=1;
		afme.setFrequencyPointPriority(tt);
		double[] ff = new double[2];
		ff[0]=1000.23f;
		ff[1]=123.4f;
		afme.setFrequency(ff);
		
		
		//1
		afme.setPhysicalAddressLength(5);
		afme.setPhysicalAddress("fir7ast1n");
		afme.setEquipmentCode("85426459154875621574851");
		
		//4
		afme.setReturnMode(2);
		afme.setReturnLength(6);
		afme.setReturnData("192.168.10.200:8080");
		
		afme.setTime(1235254159);
		afme.setCertificate("123595124562");
		afme.setSign("ingmshaghyfhnmshjaloshnrhsiaw63tmcnmashry7sgt0rhys1hysqmc64jhsmkF");
		AnalogFM af = new AnalogFM();
		System.out.println(af.AnalogFMMake(afme,true));
		System.out.println(afme.toString());
		
		String s1="foGrysMo74xiKrnzpdmNg4OXGLPIHOYCgIowBStaYPpGpWgIMoZfpN";
		String s2="AAAJ3QAAAAAAQn1utM+foGrysMo74xiKrnzpdmNg4OXGLPIHOYCgIowBStaYPpGpWgIMoZfpN/E6RJkGHFLwkenYM/K3gMFipJQ=";

//		System.out.println(s2.length());
	}

}
