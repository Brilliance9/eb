package transmission;

import transmissionEntity.*;

public class Medium {
	Encapsulate enc = new Encapsulate();
	TransTool tool = new TransTool();
	public int mediumMake(MediumEntity me){
		
		
		//封装起始标志0x69,10进制的105
		enc.encapsulate(tool.Int2Bytes(me.getStartSign()), 8);
		
		//封装指令类型
		enc.encapsulate(tool.Int2Bytes(me.getType()), 4);
		
		//封装指令长度
		enc.encapsulate(tool.Int2Bytes(me.getLength()), 12);
		
		//封装保留位
		enc.encapsulate(tool.Int2Bytes(me.getReserved()), 4);
		
		//封装发送源标识码
		//将String 类型的数据取出每一位转换为Int然后封装
		char[] source= me.getSource().toCharArray();
		for(int i=0;i<source.length;i++){
			String b= String.valueOf(source[i]);
			int c = Integer.parseInt(b);
			enc.encapsulate(tool.Int2Bytes(c), 4);
		}
		
		//封装保留位
		enc.encapsulate(tool.Int2Bytes(me.getReserved2()), 4);
		
		//封装应急广播消息编号
		char[] num= me.getNumber().toCharArray();
		for(int i=0;i<num.length;i++){
			String b= String.valueOf(num[i]);
			int c = Integer.parseInt(b);
			enc.encapsulate(tool.Int2Bytes(c), 4);
		}
		
		
		
		//封装数据包内容
		int type = me .getType();
		if(type == 1){//开播指令
			//封装目标区域数
			enc.encapsulate(tool.Int2Bytes(me.getAreas()), 8);
			
			//封装目标区域编码
			int areas = me.getAreas();
			String code[] = me.getCode();
			for(int i=0;i<areas;i++){
				char[] item= code[i].toCharArray();
				for(int j=0;j<item.length;j++){
					String b= String.valueOf(item[j]);
					int c = Integer.parseInt(b);
					enc.encapsulate(tool.Int2Bytes(c), 4);
				}
			}
			
			//封装开播指令数据包内容
			enc.encapsulate(tool.Int2Bytes(me.getDuration()), 8);
			enc.encapsulate(tool.Int2Bytes(me.getLevel()), 4);
			
			char[] eventType = me.getEventType().toCharArray();
			for(int i = 0;i<eventType.length;i++){//用 ASCII 字符串表示
				byte item = (byte)eventType[i];
				enc.encapsulate(tool.Byte2Bytes(item), 8);
			}
			//保留字段
			enc.encapsulate(tool.Int2Bytes(0), 28);
			
			
			//封装数据包时间
			enc.encapsulate(tool.Long2Bytes(me.getTime()), 32);
			//封装证书编号
			char[] cer = me.getCertificate().toCharArray();
			for(int i=0;i<cer.length;i++){
				String item = String.valueOf(cer[i]);
				int cc = Integer.parseInt(item);
				enc.encapsulate(tool.Int2Bytes(cc), 4);
			}
			//封装数字签名
			char[] sign = me.getSign().toCharArray();
			for(int i=0;i<sign.length;i++){
				byte item = (byte)sign[i];
				enc.encapsulate(tool.Byte2Bytes(item), 8);
			}
			
			
			
			
		}else if(type == 2){//停播指令
			//封装目标区域数
			enc.encapsulate(tool.Int2Bytes(me.getAreas()), 8);
			
			//封装目标区域编码
			int areas = me.getAreas();
			String code[] = me.getCode();
			for(int i=0;i<areas;i++){
				char[] item= code[i].toCharArray();
				for(int j=0;j<item.length;j++){
					String b= String.valueOf(item[j]);
					int c = Integer.parseInt(b);
					enc.encapsulate(tool.Int2Bytes(c), 4);
				}
			}
			enc.encapsulate(tool.Int2Bytes(0), 28);
			//封装数据包时间
			enc.encapsulate(tool.Long2Bytes(me.getTime()), 32);
			//封装证书编号
			char[] cer = me.getCertificate().toCharArray();
			for(int i=0;i<cer.length;i++){
				String item = String.valueOf(cer[i]);
				int cc = Integer.parseInt(item);
				enc.encapsulate(tool.Int2Bytes(cc), 4);
			}
			//封装数字签名
			char[] sign = me.getSign().toCharArray();
			for(int i=0;i<sign.length;i++){
				byte item = (byte)sign[i];
				enc.encapsulate(tool.Byte2Bytes(item), 8);
			}
		}else if(type == 3){//设置默认锁定频点指令
			//封装目标区域数
			enc.encapsulate(tool.Int2Bytes(me.getAreas()), 8);
			
			//封装目标区域编码
			int areas = me.getAreas();
			String code[] = me.getCode();
			for(int i=0;i<areas;i++){
				char[] item= code[i].toCharArray();
				for(int j=0;j<item.length;j++){
					String b= String.valueOf(item[j]);
					int c = Integer.parseInt(b);
					enc.encapsulate(tool.Int2Bytes(c), 4);
				}
			}
			//封装数据包内容
			enc.encapsulate(tool.Int2Bytes(me.getFrequencyType()), 8);
			
			char[] value = me.getValue().toCharArray();
			for(int i=0;i<value.length;i++){
				String b = String.valueOf(value[i]);
				int c = Integer.parseInt(b);
				enc.encapsulate(tool.Int2Bytes(c),4 );
			}

			//封装数据包时间
			enc.encapsulate(tool.Long2Bytes(me.getTime()), 32);
			//封装证书编号
			char[] cer = me.getCertificate().toCharArray();
			for(int i=0;i<cer.length;i++){
				String item = String.valueOf(cer[i]);
				int cc = Integer.parseInt(item);
				enc.encapsulate(tool.Int2Bytes(cc), 4);
			}
			//封装数字签名
			char[] sign = me.getSign().toCharArray();
			for(int i=0;i<sign.length;i++){
				byte item = (byte)sign[i];
				enc.encapsulate(tool.Byte2Bytes(item), 8);
			}
			
		}else if(type == 4){//证书授权指令
			enc.StringEnc(enc, me.getReceiverSN());
			enc.encInt(me.getCertsAuthSN(), 8);
			enc.encInt(me.getCertsCount(), 8);
			String[] CertSNs = me.getCertSNs();
			for(int i=0;i<me.getCertsCount();i++){
				enc.StringEnc(enc, CertSNs[i]);
			}
			enc.StringEnc(enc, me.getSigSN());
			enc.ASCIIEnc(enc, me.getSignature());
		}else{
			//未完待续
		}
		
		
		enc.printmsg();
		enc.Message2File();
		System.out.println("生成文件成功");
		
		return enc.getCountbyte();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Medium medium = new Medium();
		TransTool tool = new TransTool();
		MediumEntity me = new MediumEntity();
		me.setType(1);
		me.setLength(0);
		me.setSource("00000000000000000000000");
		me.setNumber("00000000000000000000000000000000000");
		me.setAreas(2);
		String code[] = new String[2];
		code[0]="785126548956";
		code[1]="895485624518";
		me.setCode(code);
		me.setDuration(36);
		me.setEventType("01011");
		me.setLevel(2);
		me.setTime(1235254159);
		me.setCertificate("123595124562");
		me.setSign("0000000000000000000000000000000000000000000000000000000000000000");
		System.out.println(medium.mediumMake(me));;
		
		

	}

}
