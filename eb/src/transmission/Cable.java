package transmission;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import transmission.Encapsulate;
import transmission.TransTool;
import transmissionEntity.*;

public class Cable {
	Encapsulate enc = new Encapsulate();
	TransTool tool = new TransTool();
	
	public void IndexMake(IndexEntity ie){
		enc.encInt(ie.getTable_id(), 8);
		enc.encInt(ie.getSection_syntax_indicator(), 1);
		enc.encInt(1, 1);
		enc.encInt(ie.getReserved(), 2);
		enc.encInt(ie.getSection_length(), 12);
		enc.encInt(ie.getTable_id_extension(), 16);
		enc.encInt(ie.getReserved2(), 2);
		enc.encInt(ie.getVersion_number(), 5);
		enc.encInt(ie.getCurrent_next_indicator(), 1);
		enc.encInt(ie.getSection_number(), 8);
		enc.encInt(ie.getLast_section_number(), 8);
		enc.encInt(ie.getEBM_number(), 8);
		EBMEntity[] ebm = ie.getEBM();
		for(int i=0;i<ie.getEBM_number();i++){
			EBMEntity item = ebm[i];
			enc.encInt(item.getEBM_length(), 16);
			enc.encInt(item.getReserved1(), 4);
			enc.StringEnc(enc, item.getEBM_id());
			//待定
			enc.StringEnc(enc, item.getEBM_original_network_id());
			MJDEnc(item.getEBM_start_time());
			MJDEnc(item.getEBM_end_time());
			enc.ASCIIEnc(enc, item.getEBM_type());
			enc.encInt(item.getEBM_class(), 4);
			enc.encInt(item.getEBM_level(), 4);
			enc.encInt(item.getEBM_resource_number(), 8);
			for(int j=0;j<item.getEBM_resource_number();j++){
				enc.encInt(item.getReserved2(), 4);
				enc.StringEnc(enc, item.getEBM_resource_code()[j]);
			}
			enc.encInt(item.getReserved3(), 7);
			enc.encInt(item.getDetails_channel_indicate(), 1);
			
			if(item.getDetails_channel_indicate() == 1){
				//
				enc.encInt(item.getDetails_channel_network_id(), 16);
				//
				enc.encInt(item.getDetails_channel_transport_stream_id(), 16);;
				//
				enc.encInt(item.getDetails_channel_program_number(),16);
				enc.encInt(item.getReserved4(), 3);
				enc.encInt(item.getDetails_channel_PCR_PID(), 13);
				enc.encInt(item.getReserved5(), 4);
				enc.encInt(0, 2);
				enc.encInt(item.getDetails_channel_program_info_length(), 10);
				
				
				//描述符1
				Descriptor1 des = item.getDescriptor1();
				DescriptorMake dm = new DescriptorMake();
				dm.CableDescriptorMake(enc, des);
				
				//
				
				enc.encInt(item.getStream_info_length(),16);
				
				StreamEntity se[] = item.getStream();
				for(int k=0;k<se.length;k++){
					enc.encInt(se[k].getStream_type(), 8);
					enc.encInt(se[k].getReserved1(), 3);
					enc.encInt(se[k].getElementary_PID(), 13);
					enc.encInt(se[k].getReserved2(), 4);
					enc.encInt(0, 2);
					enc.encInt(se[k].getES_info_length(), 10);
					//描述符2
					dm.ProgramMake(enc, se[k].getDescrpitor2());
				}
			}
		}
		enc.encInt(ie.getSignature_length(), 16);
		enc.StringEnc(enc, ie.getSignature_data());
		//CRC
		enc.encInt(ie.getCRC_32(),32);
		
		
		enc.Message2File();
		enc.printmsg();
	}
	
	
	//应急广播内容段封装
	public void ContentMake(ContentEntity ce){
		enc.encInt(ce.getTable_id(), 8);
		enc.encInt(ce.getSection_syntax_indicator(), 1);
		enc.encInt(1, 1);
		enc.encInt(ce.getReserved(), 2);
		enc.encInt(ce.getSection_length(), 12);
		enc.encInt(ce.getTable_id_extension(), 16);
		enc.encInt(ce.getReserved2(), 2);
		enc.encInt(ce.getVersion_number(), 5);
		enc.encInt(ce.getCurrent_next_indicator(), 1);
		enc.encInt(ce.getSection_number(), 8);
		enc.encInt(ce.getLast_section_number(), 8);
		enc.encInt(ce.getReserved3(),4);
		enc.StringEnc(enc, ce.getEBM_id());
		enc.encInt(ce.getReserved4(), 4);
		enc.encInt(ce.getMultilingual_content_number(), 4);
		Multilingual_contentEntity[] me = ce.getMultilingual_content();
		for(int i=0;i<me.length;i++){
			Multilingual_contentEntity item= me[i];
			enc.encInt(item.getMultilingual_content_length(), 32);
			enc.ASCIIEnc(enc, item.getLanguage_code());
			enc.encInt(item.getReserved1(), 5);
			enc.encInt(item.getCode_character_set(), 3);
			enc.encInt(item.getMessage_text_length(), 16);
			enc.ASCIIEnc(enc, item.getMessage_text());
			enc.encInt(item.getAgency_name_length(), 8);
			enc.ASCIIEnc(enc, item.getAgency_name());
			enc.encInt(item.getReserved2(),4);
			enc.encInt(item.getAuxiliary_data_number(),4);
			Auxiliary_dataEntity[] ad= item.getAuxiliary_data();
			for(int j=0;j<item.getAuxiliary_data_number();j++){
				enc.encInt(ad[j].getAuxiliary_data_type(), 8);
				enc.encInt(ad[j].getAuxiliary_data_length(), 32);
				enc.ASCIIEnc(enc, ad[j].getAuxiliary_data());
			}
		}
		enc.encInt(ce.getSignature_length(), 16);
		enc.StringEnc(enc, ce.getSignature_data());
		//CRC
		enc.encInt(ce.getCRC_32(),32);
		
	}
	
	//应急广播证书授权协议
	public void CertificateMake(CertificateEntity ce){
		enc.encInt(ce.getTable_id(), 8);
		enc.encInt(ce.getSection_syntax_indicator(), 1);
		enc.encInt(1, 1);
		enc.encInt(ce.getReserved(), 2);
		enc.encInt(ce.getSection_length(), 12);
		enc.encInt(ce.getTable_id_extension(), 16);
		enc.encInt(ce.getReserved2(), 2);
		enc.encInt(ce.getVersion_number(), 5);
		enc.encInt(ce.getCurrent_next_indicator(), 1);
		enc.encInt(ce.getSection_number(), 8);
		enc.encInt(ce.getLast_section_number(), 8);
		enc.encInt(ce.getCertAuth_number(), 8);
		for(int i=0;i<ce.getCertAuth_number();i++){
			enc.encInt(ce.getCertAuth_length()[i], 16);
			enc.ASCIIEnc(enc, ce.getCertAuth_data()[i]);
		}
		enc.encInt(ce.getCert_number(), 8);
		for(int i=0;i<ce.getCert_number();i++){
			enc.encInt(ce.getCert_length()[i], 8);
			enc.ASCIIEnc(enc, ce.getCert_data()[i]);
		}
		enc.encInt(ce.getSignature_length(), 16);
		enc.StringEnc(enc, ce.getSignature_data());
		//CRC
		enc.encInt(ce.getCRC_32(),32);
	}
	
	
	//管理配置指令
	public void ConfigureMake(ConfigureEntity ce){
		enc.encInt(ce.getTable_id(), 8);
		enc.encInt(ce.getSection_syntax_indicator(), 1);
		enc.encInt(1, 1);
		enc.encInt(ce.getReserved(), 2);
		enc.encInt(ce.getSection_length(), 12);
		enc.encInt(ce.getTable_id_extension(), 16);
		enc.encInt(ce.getReserved2(), 2);
		enc.encInt(ce.getVersion_number(), 5);
		enc.encInt(ce.getCurrent_next_indicator(), 1);
		enc.encInt(ce.getSection_number(), 8);
		enc.encInt(ce.getLast_section_number(), 8);
		enc.encInt(ce.getConfigure_cmd_number(), 8);
		ConfigureCommandEntity[] cce = ce.getCce();
		for(int i=0;i<ce.getConfigure_cmd_number();i++){
			enc.encInt(cce[i].getConfigure_cmd_tag(), 8);
			enc.encInt(cce[i].getConfigure_cmd_length(), 16);
			
			if(cce[i].getConfigure_cmd_tag() == 1){
				enc.encInt(cce[i].getwYear(), 16);
				enc.encInt(cce[i].getiMonth(), 8);
				enc.encInt(cce[i].getiDay(), 8);
				enc.encInt(cce[i].getIHour(), 8);
				enc.encInt(cce[i].getiMinute(), 8);
				enc.encInt(cce[i].getiSecond(), 8);
			}else if(cce[i].getConfigure_cmd_tag() == 2){
				enc.encInt(cce[i].getTerminal_address_length(), 8);
				enc.ASCIIEnc(enc, cce[i].getTerminal_address());
				enc.encInt(cce[i].getReserved2(), 4);
				enc.StringEnc(enc, cce[i].getResource_code());
			}else if(cce[i].getConfigure_cmd_tag() == 3){
				enc.encInt(cce[i].getFreq(), 32);
				enc.encInt(cce[i].getSymbolrate(), 32);
				enc.encInt(cce[i].getConstellation_mapping(), 8);
				enc.encInt(cce[i].getTerminal_number(), 8);
				for(int j =0;j<cce[i].getTerminal_number();j++){
					enc.encInt(cce[i].getReserved3(), 4);
					enc.StringEnc(enc, cce[i].getResource_address()[j]);
				}
			}else if(cce[i].getConfigure_cmd_tag() == 4){
				enc.encInt(cce[i].getReback_type(), 8);
				enc.encInt(cce[i].getReback_address_length(), 8);
				if(cce[i].getReback_type() == 1){//短信，11位数字
					enc.ASCIIEnc(enc, cce[i].getReback_address());
				}else if(cce[i].getReback_type() == 2){//IP 地址和端口；192.168.22.56:8080
					String returnData = cce[i].getReback_address();
					String[] str;
					String[] IP;

					if(returnData.contains(":")){
						str = returnData.split(":");
						IP = str[0].split("\\.");
						for(int j = 0;j<4;j++){
							int item = Integer.parseInt(IP[j]);
							enc.encapsulate(tool.Int2Bytes(item), 8);
							
						}
						enc.encapsulate(tool.Int2Bytes(Integer.parseInt(str[1])), 16);
					}else if(returnData.contains("：")){
						str = returnData.split(":");
						IP = str[0].split(".");
						for(int j = 0;j<4;j++){
							int item = Integer.parseInt(IP[j]);
							enc.encapsulate(tool.Int2Bytes(item), 8);

						}
						enc.encapsulate(tool.Int2Bytes(Integer.parseInt(str[1])), 16);

					}

				}else if(cce[i].getReback_type() == 3){//域名和端口号
					enc.ASCIIEnc(enc, cce[i].getReback_address());
				}
				
				enc.encInt(cce[i].getTerminal_number4(), 8);
				for(int j=0;j<cce[i].getTerminal_number4();j++){
					enc.encInt(cce[i].getReserved4(), 4);
					enc.StringEnc(enc, cce[i].getResource_code4()[j]);
				}
				
			}else if(cce[i].getConfigure_cmd_tag() == 5){
				enc.encInt(cce[i].getReback_period(), 32);
				enc.encInt(cce[i].getTerminal_number5(), 8);
				for(int j=0;j<cce[i].getTerminal_number5();j++){
					enc.encInt(cce[i].getReserved5(), 4);
					enc.StringEnc(enc, cce[i].getResource_code5()[j]);
				}
			}else if(cce[i].getConfigure_cmd_tag() == 6){
				enc.encInt(cce[i].getVolume(), 8);
				enc.encInt(cce[i].getTerminal_number6(), 8);
				for(int j=0;j<cce[i].getTerminal_number6();j++){
					enc.encInt(cce[i].getReserved6(), 4);
					enc.StringEnc(enc, cce[i].getResource_code6()[j]);
				}
			}else if(cce[i].getConfigure_cmd_tag() == 7){
				enc.encInt(cce[i].getParameter_number(), 8);
				for(int j =0;j<cce[i].getParameter_number();j++){
					enc.encInt(cce[i].getParameter_tag()[j], 8);
				}
				enc.encInt(cce[i].getTerminal_number7(), 8);
				for(int j=0;j<cce[i].getTerminal_number7();j++){
					enc.encInt(cce[i].getReserved7(), 4);
					enc.StringEnc(enc, cce[i].getResource_code7 ()[j]);
				}
			}
		}
		enc.encInt(ce.getSignature_length(), 16);
		enc.StringEnc(enc, ce.getSignature_data());
		//CRC
		enc.encInt(ce.getCRC_32(),32);
	}
	
	//转换为MJD时间封装，算法见有线数字电视附录
	public int MJDEnc(Calendar cc){
		int Y = cc.get(Calendar.YEAR)-1900;
		
		if(Y == 100){//结束时间为不确定结束时间的实时传送流时，该字段取值为0xFFFFFFFFFF
			for(int i=0;i<10;i++){
				enc.encInt(15, 4);
			}
			return 0;
		}
		int M = cc.get(Calendar.MONTH)+1;
		int D = cc.get(Calendar.DAY_OF_MONTH);
		int hour = cc.get(Calendar.HOUR_OF_DAY);
		int minute = cc.get(Calendar.MINUTE);
		int second = cc.get(Calendar.SECOND);
		int L=0;
		if(M == 1||M == 2){
			L=1;
		}
		int mjd=14956+D+(int) ((Y-L)*365.25f)+(int) ((M+1+L*12)*30.6001f);
		
		enc.encInt(mjd, 16);
		if(hour<10){
			enc.encInt(0, 4);
			enc.encInt(hour, 4);
		}else{
			int t1 = hour/10;
			int t2 = hour%10;
			enc.encInt(t1, 4);
			enc.encInt(t2, 4);
		}
		
		if(minute<10){
			enc.encInt(0, 4);
			enc.encInt(minute, 4);
		}else{
			int t1 = minute/10;
			int t2 = minute%10;
			enc.encInt(t1, 4);
			enc.encInt(t2, 4);
		}
		if(second<10){
			enc.encInt(0, 4);
			enc.encInt(second, 4);
		}else{
			int t1 = second/10;
			int t2 = second%10;
			enc.encInt(t1, 4);
			enc.encInt(t2, 4);
		}
		return mjd;
	}
	
	//节目信息封装
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		IndexEntity ie = new IndexEntity();
		Cable cc = new Cable();
//		cc.IndexMake(ie);
		

		String str="2010-5-27 5:26:30";

		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date;
		try {
			date = sdf.parse(str);
			Calendar c = Calendar.getInstance();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
