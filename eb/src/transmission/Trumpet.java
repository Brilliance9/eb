package transmission;

import transmissionEntity.TrumpetEntity;
import transmissionEntity.White_list;

public class Trumpet {

	Encapsulate enc = new Encapsulate();
	TransTool tool = new TransTool();
	public void headMake(TrumpetEntity te){
		enc.encInt(te.getHead(), 8);
		enc.encInt(te.getVersion(), 16);
		enc.encInt(te.getProtocol_type(), 8);
		enc.encInt(te.getPlatform_type(), 8);
		enc.encInt(te.getData_length(), 32);
	}
	
	public void tailMake(TrumpetEntity te){
		enc.encInt(te.getSignature_length(), 16);
		enc.encapsulate(tool.Long2Bytes(te.getSignature_time()), 32);
		enc.StringEnc(enc, te.getCertificate_number());
		enc.ASCIIEnc(enc, te.getSignature_data());
		enc.encInt(te.getCRC_32(), 32);
	}
	public void TrumpetMake(TrumpetEntity te){
		
	}
	
	//白名单更新
	public void make0c(TrumpetEntity te){
		headMake(te);
		
		enc.encInt(te.getWhite_list_length(), 8);
		White_list[] wl = te.getWhite_list();
		for(int i=0;i<wl.length;i++){
			enc.encInt(wl[i].getOper_type(), 8);
			enc.encInt(wl[i].getPhone_number_length(), 8);
			enc.ASCIIEnc(enc, wl[i].getPhone_number());
			enc.encInt(wl[i].getUser_name_length(), 8);
			enc.ASCIIEnc(enc, wl[i].getUser_name());
			enc.encInt(wl[i].getPermission_area_number(), 8);
			enc.encInt(wl[i].getPermission_area_length(), 8);
			String[] permission_area_code = wl[i].getPermission_area_code();
			for(int j=0;j<permission_area_code.length;j++){
				enc.StringEnc(enc, permission_area_code[j]);
			}
		}
		tailMake(te);
	}
	//回传参数设置(0x0D)
	public void make0d(TrumpetEntity te){
		headMake(te);
		int reback_type = te.getReback_type0d();
		enc.encInt(reback_type, 8);
		enc.encInt(te.getReback_cycle(), 32);
		enc.encInt(te.getReback_address_length0d(), 8);
		if(reback_type == 1){//短信，11位数字
			enc.ASCIIEnc(enc, te.getReback_address0d());
		}else if(reback_type == 2){//IP 地址和端口；192.168.22.56:8080
			String returnData = te.getReback_address0d();
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

		}else if(reback_type == 3){//域名和端口号
			enc.ASCIIEnc(enc, te.getReback_address0d());
		}
		tailMake(te);
	}
	//输出通道查询(0x0E)
	public void make0e(TrumpetEntity te){
		headMake(te);
		enc.encInt(15, 4);
		enc.StringEnc(enc, te.getFront_code0e());
		enc.encInt(te.getOutput_channel_id(), 8);
		enc.encInt(te.getOutput_channel_state(), 8);
		tailMake(te);
	}
	//输入通道查询（0x0F）
	public void make0f(TrumpetEntity te){
		headMake(te);
		enc.encInt(15, 4);
		enc.StringEnc(enc, te.getFront_code0f());
		enc.encInt(te.getInput_channel_id(), 8);
		enc.encInt(te.getInput_channel_state(), 8);
		
		tailMake(te);
	}
	//播发记录查询(0x10)
	public void make10(TrumpetEntity te){
		headMake(te);
		enc.encInt(15, 4);
		enc.StringEnc(enc, te.getFront_code10());
		enc.encInt(15, 4);
		enc.StringEnc(enc, te.getEbm_id());
		enc.encInt(te.getTask_type(), 8);
		enc.encapsulate(tool.Long2Bytes(te.getStartTime()), 32);
		enc.encapsulate(tool.Long2Bytes(te.getEndTime()), 32);
		
		tailMake(te);
	}
	//故障详情查询（0x11）
	public void make11(TrumpetEntity te){
		headMake(te);
		enc.encInt(15, 4);
		enc.StringEnc(enc, te.getFront_code11());
		
		tailMake(te);
	}
	//适配器证书更新指令（0x41）
	public void make41(TrumpetEntity te){
		headMake(te);
		enc.encInt(te.getCertauth_number41(), 8);
		for(int i=0;i<te.getCertauth_number41();i++){
			enc.encInt(te.getCertauth_length41()[i], 16);
			enc.ASCIIEnc(enc, te.getCertauth41()[i]);
		}
		enc.encInt(te.getCert_number41(), 8);
		
		for(int i=0;i<te.getCert_number41();i++){
			enc.encInt(te.getCerth_length41()[i], 8);
			enc.ASCIIEnc(enc, te.getCerth41()[i]);
		}
		tailMake(te);
	}
	public void make04(TrumpetEntity te){
		headMake(te);
		tailMake(te);
	}
	//通用资源编码设置（0x05）
	public void make05(TrumpetEntity te){
		headMake(te);
		enc.encInt(te.getLogic_address_number(), 8);
		for(int i=0;i<te.getLogic_address_number();i++){
			enc.encInt(te.getPhysical_address_length()[i],8);
			enc.ASCIIEnc(enc, te.getPhysical_address()[i]);
			enc.encInt(te.getLogic_address_length()[i], 8);
			enc.ASCIIEnc(enc, te.getLogic_address()[i]);
		}
		tailMake(te);
	}
	//通用音量设置（0x06）
	public void make06(TrumpetEntity te){
		headMake(te);
		enc.encInt(te.getVolume(), 8);
		enc.encInt(te.getResource_code_type06(), 8);
		enc.encInt(te.getResource_code_number06(), 8);
		enc.encInt(te.getResource_code_length06(), 8);
		for(int i=0;i<te.getResource_code_number06();i++){
			enc.encInt(15, 4);
			enc.ASCIIEnc(enc, te.getResource_code06()[i]);
		}
		tailMake(te);
	}
	//通用回传参数设置（0x07）
	public void make07(TrumpetEntity te){
		headMake(te);
		enc.encInt(te.getReback_type07(), 8);
		enc.encInt(te.getReback_address_length07(), 8);
		if(te.getReback_type07() == 1){//短信，11位数字
			enc.ASCIIEnc(enc, te.getReback_address07());
		}else if(te.getReback_type07() == 2){//IP 地址和端口；192.168.22.56:8080
			String returnData = te.getReback_address07();
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

		}else if(te.getReback_type07() == 3){//域名和端口号
			enc.ASCIIEnc(enc, te.getReback_address07());
		}
		enc.encInt(te.getResource_code_type07(), 8);
		enc.encInt(te.getResource_code_number07(), 8);
		enc.encInt(te.getResource_code_length07(), 8);
		for(int i=0;i<te.getResource_code_number07();i++){
			enc.encInt(15, 4);
			enc.StringEnc(enc, te.getResource_code07()[i]);
		}
		tailMake(te);
	}
	//终端参数/状态查询指令（0x08）
	public void make08(TrumpetEntity te){
		headMake(te);
		enc.encInt(te.getReback_type08(), 8);
		enc.encInt(te.getReback_address_length08(), 8);
		if(te.getReback_type08() == 1){//短信，11位数字
			enc.ASCIIEnc(enc, te.getReback_address08());
		}else if(te.getReback_type08() == 2){//IP 地址和端口；192.168.22.56:8080
			String returnData = te.getReback_address08();
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

		}else if(te.getReback_type08() == 3){//域名和端口号
			enc.ASCIIEnc(enc, te.getReback_address08());
		}
		enc.encInt(te.getResource_code_type08(), 8);
		enc.encInt(te.getResource_code_number08(), 8);
		enc.encInt(te.getResource_code_length08(), 8);
		for(int i=0;i<te.getResource_code_number08();i++){
			enc.encInt(15, 4);
			enc.StringEnc(enc, te.getResource_code08()[i]);
		}
		enc.encInt(te.getRuery_code_number(), 8);
		for(int i=0;i<te.getRuery_code_number();i++){
			enc.encInt(te.getQuery_code()[i], 8);
		}
		tailMake(te);
	}
	//通用时钟校准（0x09）
	public void make09(TrumpetEntity te){
		headMake(te);
		enc.encapsulate(tool.Long2Bytes(te.getTime()), 32);
		tailMake(te);
	}
	// 通用网络参数设置（0x0A）
	public void make0a(TrumpetEntity te){
		headMake(te);
		String Ip = te.getIp();
		String subnet_mask = te.getSubnet_mask();
		String gateway = te.getGateway();
		String[] ips = Ip.split(".");
		for(int i=0;i<ips.length;i++){
			enc.encInt(Integer.parseInt(ips[i]), 8);
		}
		String[] subnet_masks = subnet_mask.split(".");
		for(int i=0;i<subnet_masks.length;i++){
			enc.encInt(Integer.parseInt(subnet_masks[i]), 8);
		}
		String[] gateways = gateway.split(".");
		for(int i=0;i<gateways.length;i++){
			enc.encInt(Integer.parseInt(gateways[i]), 8);
		}
		enc.encInt(te.getResource_code_type0a(), 8);
		enc.encInt(te.getResource_code_length0a(), 8);
		enc.encInt(15, 4);
		enc.StringEnc(enc, te.getResource_code0a());
		tailMake(te);
	}
	//通用回传周期设置（0x0B）
	public void make0b(TrumpetEntity te){
		headMake(te);
		enc.encInt(te.getReback_cycle0b(), 32);
		enc.encInt(te.getResource_code_type0b(), 8);
		enc.encInt(te.getResource_code_number0b(), 8);
		enc.encInt(te.getResource_code_length0b(), 8);
		for(int i=0;i<te.getResource_code_number0b();i++){
			enc.encInt(15, 4);
			enc.StringEnc(enc, te.getResource_code0b()[i]);
		}
		tailMake(te);
	}
	//通用终端功放开关指令(0x3F)
	public void make3f(TrumpetEntity te){
		headMake(te);
		enc.encInt(te.getSwitch_option(), 8);
		enc.encInt(te.getResource_code_type3f(), 8);
		enc.encInt(te.getResource_code_number3f(), 8);
		enc.encInt(te.getResource_code_length3f(), 8);
		for(int i=0;i<te.getResource_code_number3f();i++){
			enc.encInt(15, 4);
			enc.StringEnc(enc, te.getResource_code3f()[i]);
		}
		tailMake(te);
	}
	//通用证书更新(0x40)
	public void make40(TrumpetEntity te){
		headMake(te);
		enc.encInt(te.getCertauth_number40(), 8);
		for(int i=0;i<te.getCertauth_number40();i++){
			enc.encInt(te.getCertauth_length40()[i], 16);
			enc.ASCIIEnc(enc, te.getCertauth40()[i]);
		}
		enc.encInt(te.getCert_number40(), 8);
		
		for(int i=0;i<te.getCert_number40();i++){
			enc.encInt(te.getCerth_length40()[i], 8);
			enc.ASCIIEnc(enc, te.getCerth40()[i]);
		}
		tailMake(te);
	}
	//TS方案中的特殊指令（0x01）
	public void make01(TrumpetEntity te){
		enc.encInt(te.getTag(), 8);
		enc.encInt(te.getData_length01(), 32);
		enc.encInt(te.getConfigure_cmd_tag(), 8);
		enc.encInt(te.getConfigure_cmd_length(), 16);
		enc.encInt(te.getFreq(), 32);
		enc.encInt(te.getSymbol_rate(), 32);
		enc.encInt(te.getQam(), 8);
		enc.encInt(te.getResource_code_type01(), 8);
		enc.encInt(te.getResource_code_number01(), 8);
		enc.encInt(te.getResource_code_length01(), 8);
		for(int i=0;i<te.getResource_code_number01();i++){
			enc.encInt(15, 4);
			enc.StringEnc(enc, te.getResource_code01()[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
