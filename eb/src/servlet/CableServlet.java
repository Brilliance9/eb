package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import transmission.Cable;
import transmissionEntity.Auxiliary_dataEntity;
import transmissionEntity.CertificateEntity;
import transmissionEntity.ConfigureCommandEntity;
import transmissionEntity.ConfigureEntity;
import transmissionEntity.ContentEntity;
import transmissionEntity.Descriptor1;
import transmissionEntity.EBMEntity;
import transmissionEntity.IndexEntity;
import transmissionEntity.Multilingual_contentEntity;
import transmissionEntity.Program;
import transmissionEntity.StreamEntity;

public class CableServlet extends HttpServlet {

	//
	public int String2Int(String str){
		if(str != null && !str.equals("") && !str.equals("null")){
			return Integer.parseInt(str);
		}else{
			return 0;
		}
		
	}
	public long String2Long(String str){
		if(str != null && !str.equals("") && !str.equals("null")){
			return Long.parseLong(str);
		}else{
			return 0;
		}
		
	}
	public double String2Double(String str){
		if(str != null && !str.equals("") && !str.equals("null")){
			return Double.parseDouble(str);
		}else{
			return 0;
		}
		
	}
	//数组转换
	public int[] String2Ints(String[] str){
		int[] ints = new int[str.length];
		for(int i=0;i<str.length;i++){
			if(str[i] != null && !str[i].equals("") && !str[i].equals("null")){
				ints[i]=Integer.parseInt(str[i]);
			}else{
				ints[i]=0;
			}
		}
		return ints;	
	}
	//
	public double[] String2doubles(String[] str){
		double[] ints = new double[str.length];
		for(int i=0;i<str.length;i++){
			if(str[i] != null && !str[i].equals("") && !str[i].equals("null")){
				ints[i]=Double.parseDouble(str[i]);
			}else{
				ints[i]=0;
			}
		}
		return ints;	
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int type =Integer.parseInt(request.getParameter("type"));
		if(type == 251){
			request.getRequestDispatcher("/cable251.jsp").forward(request, response);
		}else if(type == 252){
			request.getRequestDispatcher("/cable252.jsp").forward(request, response);
		}else if(type == 253){
			request.getRequestDispatcher("/cable253.jsp").forward(request, response);
		}else if(type == 254){
			request.getRequestDispatcher("/cable254.jsp").forward(request, response);
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		Enumeration enu=request.getParameterNames();  
		while(enu.hasMoreElements()){  
		String paraName=(String)enu.nextElement(); 
		
		System.out.println(paraName+": "+request.getParameter(paraName));  
		
		}
		int type = String2Int(request.getParameter("cableType"));
		
//		try{
			switch(type){
			case 253:try {
					cable253(request,response);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 254:cable254(request,response);
				break;
			case 252:cable252(request,response);
				break;
			case 251:cable251(request,response);
				break;
			default:;
			
			}
//		}catch(Exception e){
//			request.setAttribute("msg","传输失败，请检查数据填写格式是否正确");
//			request.getRequestDispatcher("/msg.jsp").forward(request, response);
//			return;
//		}
		request.setAttribute("msg","传输成功");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
	}
	public void cable253(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		System.out.println(253);
		IndexEntity ie = new IndexEntity();
		EBMEntity[] ebm = new EBMEntity[1];
		for(int i=0;i<ebm.length;i++){
			ebm[i]=new EBMEntity();
		}
		StreamEntity[] se = new StreamEntity[1];
		for(int i=0;i<se.length;i++){
			se[i] = new StreamEntity();
		}
		Descriptor1 des1= new Descriptor1();
		Program pro = new Program();
		
		
		//section_length
		ie.setTable_id(253);
		ie.setTable_id_extension(String2Int(request.getParameter("table_id_extension")));
		ie.setVersion_number(String2Int(request.getParameter("version_number")));
		ie.setCurrent_next_indicator(String2Int(request.getParameter("current_next_indicator")));
		ie.setSection_number(String2Int(request.getParameter("section_number")));
		ie.setLast_section_number(String2Int(request.getParameter("last_section_number")));

		ie.setEBM_number(String2Int(request.getParameter("EBM_number")));
		
		
		//EBM_length
		ebm[0].setEBM_id(request.getParameter("EBM_id"));
		ebm[0].setEBM_original_network_id(request.getParameter("EBM_original_network_id"));
		String time1= request.getParameter("EBM_start_time");
		String[] ss1 = time1.split("T");
		String tt1=  ss1[0]+" "+ss1[1]+":00";
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 =sdf1.parse(tt1);
		Calendar cc1 = Calendar.getInstance();
		cc1.setTime(date1);
		ebm[0].setEBM_start_time(cc1);
		
		String time2= request.getParameter("EBM_end_time");
		String[] ss2 = time2.split("T");
		String tt2=  ss2[0]+" "+ss2[1]+":00";
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date2 =sdf2.parse(tt2);
		Calendar cc2 = Calendar.getInstance();
		cc1.setTime(date2);
		ebm[0].setEBM_end_time(cc2);

		
		ebm[0].setEBM_type(request.getParameter("EBM_type"));
		ebm[0].setEBM_class(String2Int(request.getParameter("EBM_class")));
		ebm[0].setEBM_level(String2Int(request.getParameter("EBM_level")));
		ebm[0].setEBM_resource_number(String2Int(request.getParameter("EBM_resource_number")));
		ebm[0].setEBM_resource_code(request.getParameterValues("EBM_resource_code"));
		ebm[0].setDetails_channel_indicate(String2Int(request.getParameter("details_channel_indicate")));
		ebm[0].setDetails_channel_network_id(String2Int(request.getParameter("details_channel_network_id")));
		ebm[0].setDetails_channel_transport_stream_id(String2Int(request.getParameter("details_channel_transport_stream_id")));
		ebm[0].setDetails_channel_program_number(String2Int(request.getParameter("details_channel_program_number")));
		ebm[0].setDetails_channel_PCR_PID(String2Int(request.getParameter("details_channel_PCR_PID")));
		//details_channel_program_info_length
		
		//descriptor_length
		des1.setFrequency(String2Double(request.getParameter("frequency")));
		des1.setFEC_outer(String2Int(request.getParameter("FEC_outer")));
		des1.setModulation(String2Int(request.getParameter("modulation")));
		des1.setSymbol_rate(String2Double(request.getParameter("symbol_rate")));
		des1.setFEC_inner(String2Int(request.getParameter("FEC_inner")));
		des1.setDescriptor_length(11);

		
		//2
		pro.setMultiple_frame_rate_flag1(String2Int(request.getParameter("multiple_frame_rate_flag1")));
		pro.setFrame_rate_code1(String2Int(request.getParameter("frame_rate_code1")));
		pro.setMPEG_1_only_flag(String2Int(request.getParameter("MPEG_1_only_flag")));
		pro.setConstrained_parameter_flag(String2Int(request.getParameter("constrained_parameter_flag")));
		pro.setStill_picture_flag(String2Int(request.getParameter("still_picture_flag")));
		pro.setChroma_format1(String2Int(request.getParameter("chroma_format1")));
		pro.setFrame_rate_extension_flag(String2Int(request.getParameter("frame_rate_extension_flag")));
		int pl = String2Int(request.getParameter("Transferred"));
		if(pl==1){
			pro.setProfile_and_level_indication(String2Int(request.getParameter("ProfileLevel")));
		}else{
			pro.setProfile_and_level_indication(String2Int(request.getParameter("ProfileIdentifier"))+String2Int(request.getParameter("LevelIdentifier")));
		}
		if(pro.getMPEG_1_only_flag()==0){
			pro.setDescriptor_length2(3);
		}else{
			pro.setDescriptor_length2(1);
		}
		
		//3
		pro.setDescriptor_length3(1);
		pro.setFree_format_flag(String2Int(request.getParameter("free_format_flag")));
		pro.setID(String2Int(request.getParameter("ID")));
		pro.setLayer(String2Int(request.getParameter("layer")));
		pro.setVariable_rate_audio_indicator(String2Int(request.getParameter("variable_rate_audio_indicator")));
		

		//4
		pro.setDescriptor_length4(4);
		pro.setHierarchy_type(String2Int(request.getParameter("hierarchy_type")));
		pro.setHierarchy_layer_index(String2Int(request.getParameter("hierarchy_layer_index")));
		pro.setHierarchy_embedded_layer_index(String2Int(request.getParameter("hierarchy_embedded_layer_index")));
		pro.setHierarchy_channel(String2Int(request.getParameter("hierarchy_channel")));
		
		//5
		pro.setFormat_identifier(String2Int(request.getParameter("format_identifier")));
		pro.setAdditional_identification_info(request.getParameter("additional_identification_info"));
		pro.setDescriptor_length5(4+pro.getAdditional_identification_info().length());
		
		//6
		pro.setDescriptor_length6(1);
		pro.setAlignment_type(String2Int(request.getParameter("alignment_type")));
		
		//7
		pro.setDescriptor_length7(4);
		pro.setHorizontal_size(String2Int(request.getParameter("horizontal_size")));
		pro.setVertical_size(String2Int(request.getParameter("vertical_size")));
		pro.setAspect_ratio_information(String2Int(request.getParameter("aspect_ratio_information")));
		

		//8
		pro.setDescriptor_length8(4);
		pro.setHorizontal_offset(String2Int(request.getParameter("horizontal_offset")));
		pro.setVertical_offset(String2Int(request.getParameter("vertical_offset")));
		pro.setWindow_priority(String2Int(request.getParameter("window_priority")));
		
		//9
		pro.setCA_system_ID(String2Int(request.getParameter("CA_system_ID")));
		pro.setCA_PID(String2Int(request.getParameter("CA_PID")));
		pro.setPrivate_data_byte(request.getParameter("private_data_byte"));
		pro.setDescriptor_length9(4+pro.getPrivate_data_byte().length());
		
		//10
		pro.setDescriptor_length10(4);
		pro.setIS0_639_language_code(request.getParameter("IS0_639_language_code"));
		pro.setAudio_type(String2Int(request.getParameter("audio_type")));
		
		//11
		pro.setDescriptor_length11(2);
		pro.setExternal_clock_reference_indicator(String2Int(request.getParameter("external_clock_reference_indicator")));
		pro.setClock_accuracy_integer(String2Int(request.getParameter("clock_accuracy_integer")));
		pro.setClock_accuracy_exponent(String2Int(request.getParameter("clock_accuracy_exponent")));
		
		//12
		pro.setDescriptor_length12(4);
		pro.setBound_valid_flag(String2Int(request.getParameter("bound_valid_flag")));
		if(pro.getBound_valid_flag()==0){
			pro.setLTW_offset_lower_bound(0);
			pro.setLTW_offset_upper_bound(0);
		}else{
			pro.setLTW_offset_lower_bound(String2Int(request.getParameter("LTW_offset_lower_bound")));
			pro.setLTW_offset_upper_bound(String2Int(request.getParameter("LTW_offset_upper_bound")));
		}
		

		//13
		pro.setCopyright_identifier(String2Int(request.getParameter("copyright_identifier")));
		pro.setAdditional_copyright_info(request.getParameter("additional_copyright_info"));
		pro.setDescriptor_length13(4+pro.getAdditional_copyright_info().length());
		
		//14
		pro.setDescriptor_length14(3);
		pro.setMaximum_bitrate(String2Int(request.getParameter("maximum_bitrate")));
		
		//15
		pro.setDescriptor_length15(4);
		pro.setPrivate_data_indicator(String2Int(request.getParameter("private_data_indicator")));
		
		//16
		pro.setDescriptor_length16(6);
		pro.setSb_leak_rate(String2Int(request.getParameter("sb_leak_rate")));
		pro.setSb_size(String2Int(request.getParameter("sb_size")));
		
		//17
		pro.setDescriptor_length17(1);
		pro.setLeak_valid_flag(String2Int(request.getParameter("leak_valid_flag")));
		
		//18
		pro.setDescriptor_length18(2);
		pro.setClosed_gop_flag(String2Int(request.getParameter("closed_gop_flag")));
		pro.setIdentical_gop_flag(String2Int(request.getParameter("identical_gop_flag")));
		pro.setMax_gop_length(String2Int(request.getParameter("max_gop_length")));
		
		//63
		pro.setDescriptor_length63(4);
		pro.setProfile_id(String2Int(request.getParameter("profile_id")));
		pro.setLevel_id(String2Int(request.getParameter("level_id")));
		pro.setMultiple_frame_rate_flag2(String2Int(request.getParameter("multiple_frame_rate_flag2")));
		pro.setFrame_rate_code2(String2Int(request.getParameter("frame_rate_code2")));
		pro.setAVS_still_present(String2Int(request.getParameter("AVS_still_present")));
		pro.setChroma_format2(String2Int(request.getParameter("chroma_format2")));
		pro.setSample_precision(String2Int(request.getParameter("sample_precision")));
		
		ebm[0].setDetails_channel_program_info_length(55+pro.getDescriptor_length2()+pro.getDescriptor_length5()+pro.getDescriptor_length9()+pro.getDescriptor_length13());
		//stream_info_length
		//
		se[0].setStream_type(String2Int(request.getParameter("stream_type")));
		se[0].setElementary_PID(String2Int(request.getParameter("elementary_PID")));
		
		
		Program pro2 = new Program();
		//2
		pro2.setMultiple_frame_rate_flag1(String2Int(request.getParameter("multiple_frame_rate_flag12")));
		pro2.setFrame_rate_code1(String2Int(request.getParameter("frame_rate_code12")));
		pro2.setMPEG_1_only_flag(String2Int(request.getParameter("MPEG_1_only_flag2")));
		pro2.setConstrained_parameter_flag(String2Int(request.getParameter("constrained_parameter_flag2")));
		pro2.setStill_picture_flag(String2Int(request.getParameter("still_picture_flag2")));
		pro2.setChroma_format1(String2Int(request.getParameter("chroma_format12")));
		pro2.setFrame_rate_extension_flag(String2Int(request.getParameter("frame_rate_extension_flag2")));
		int pl2 = String2Int(request.getParameter("Transferred2"));
		if(pl2==1){
			pro2.setProfile_and_level_indication(String2Int(request.getParameter("ProfileLevel2")));
		}else{
			pro2.setProfile_and_level_indication(String2Int(request.getParameter("ProfileIdentifier2"))+String2Int(request.getParameter("LevelIdentifier2")));
		}
		if(pro2.getMPEG_1_only_flag()==0){
			pro2.setDescriptor_length2(3);
		}else{
			pro2.setDescriptor_length2(1);
		}
		
		//3
		pro2.setDescriptor_length3(1);
		pro2.setFree_format_flag(String2Int(request.getParameter("free_format_flag2")));
		pro2.setID(String2Int(request.getParameter("ID2")));
		pro2.setLayer(String2Int(request.getParameter("layer2")));
		pro2.setVariable_rate_audio_indicator(String2Int(request.getParameter("variable_rate_audio_indicator2")));
		

		//4
		pro2.setDescriptor_length4(4);
		pro2.setHierarchy_type(String2Int(request.getParameter("hierarchy_type2")));
		pro2.setHierarchy_layer_index(String2Int(request.getParameter("hierarchy_layer_index2")));
		pro2.setHierarchy_embedded_layer_index(String2Int(request.getParameter("hierarchy_embedded_layer_index2")));
		pro2.setHierarchy_channel(String2Int(request.getParameter("hierarchy_channel2")));
		
		//5
		pro2.setFormat_identifier(String2Int(request.getParameter("format_identifier2")));
		pro2.setAdditional_identification_info(request.getParameter("additional_identification_info2"));
		pro2.setDescriptor_length5(4+pro2.getAdditional_identification_info().length());
		
		//6
		pro2.setDescriptor_length6(1);
		pro2.setAlignment_type(String2Int(request.getParameter("alignment_type2")));
		
		//7
		pro2.setDescriptor_length7(4);
		pro2.setHorizontal_size(String2Int(request.getParameter("horizontal_size2")));
		pro2.setVertical_size(String2Int(request.getParameter("vertical_size2")));
		pro2.setAspect_ratio_information(String2Int(request.getParameter("aspect_ratio_information2")));
		

		//8
		pro2.setDescriptor_length8(4);
		pro2.setHorizontal_offset(String2Int(request.getParameter("horizontal_offset2")));
		pro2.setVertical_offset(String2Int(request.getParameter("vertical_offset2")));
		pro2.setWindow_priority(String2Int(request.getParameter("window_priority2")));
		
		//9
		pro2.setCA_system_ID(String2Int(request.getParameter("CA_system_ID2")));
		pro2.setCA_PID(String2Int(request.getParameter("CA_PID2")));
		pro2.setPrivate_data_byte(request.getParameter("private_data_byte2"));
		pro2.setDescriptor_length9(4+pro2.getPrivate_data_byte().length());
		
		//10
		pro2.setDescriptor_length10(4);
		pro2.setIS0_639_language_code(request.getParameter("IS0_639_language_code2"));
		pro2.setAudio_type(String2Int(request.getParameter("audio_type2")));
		
		//11
		pro2.setDescriptor_length11(2);
		pro2.setExternal_clock_reference_indicator(String2Int(request.getParameter("external_clock_reference_indicator2")));
		pro2.setClock_accuracy_integer(String2Int(request.getParameter("clock_accuracy_integer2")));
		pro2.setClock_accuracy_exponent(String2Int(request.getParameter("clock_accuracy_exponent2")));
		
		//12
		pro2.setDescriptor_length12(4);
		pro2.setBound_valid_flag(String2Int(request.getParameter("bound_valid_flag2")));
		if(pro2.getBound_valid_flag()==0){
			pro2.setLTW_offset_lower_bound(0);
			pro2.setLTW_offset_upper_bound(0);
		}else{
			pro2.setLTW_offset_lower_bound(String2Int(request.getParameter("LTW_offset_lower_bound2")));
			pro2.setLTW_offset_upper_bound(String2Int(request.getParameter("LTW_offset_upper_bound2")));
		}
		

		//13
		pro2.setCopyright_identifier(String2Int(request.getParameter("copyright_identifier2")));
		pro2.setAdditional_copyright_info(request.getParameter("additional_copyright_info2"));
		pro2.setDescriptor_length13(4+pro2.getAdditional_copyright_info().length());
		
		//14
		pro2.setDescriptor_length14(3);
		pro2.setMaximum_bitrate(String2Int(request.getParameter("maximum_bitrate2")));
		
		//15
		pro2.setDescriptor_length15(4);
		pro2.setPrivate_data_indicator(String2Int(request.getParameter("private_data_indicator2")));
		
		//16
		pro2.setDescriptor_length16(6);
		pro2.setSb_leak_rate(String2Int(request.getParameter("sb_leak_rate2")));
		pro2.setSb_size(String2Int(request.getParameter("sb_size2")));
		
		//17
		pro2.setDescriptor_length17(1);
		pro2.setLeak_valid_flag(String2Int(request.getParameter("leak_valid_flag2")));
		
		//18
		pro2.setDescriptor_length18(2);
		pro2.setClosed_gop_flag(String2Int(request.getParameter("closed_gop_flag2")));
		pro2.setIdentical_gop_flag(String2Int(request.getParameter("identical_gop_flag2")));
		pro2.setMax_gop_length(String2Int(request.getParameter("max_gop_length2")));
		
		//63
		pro2.setDescriptor_length63(4);
		pro2.setProfile_id(String2Int(request.getParameter("profile_id2")));
		pro2.setLevel_id(String2Int(request.getParameter("level_id2")));
		pro2.setMultiple_frame_rate_flag2(String2Int(request.getParameter("multiple_frame_rate_flag22")));
		pro2.setFrame_rate_code2(String2Int(request.getParameter("frame_rate_code22")));
		pro2.setAVS_still_present(String2Int(request.getParameter("AVS_still_present2")));
		pro2.setChroma_format2(String2Int(request.getParameter("chroma_format22")));
		pro2.setSample_precision(String2Int(request.getParameter("sample_precision2")));
		
		
		se[0].setES_info_length(44+pro2.getDescriptor_length2()+pro2.getDescriptor_length5()+pro2.getDescriptor_length9()+pro2.getDescriptor_length13());
		
		int stream_info_length =0;
		for(int i=0;i<se.length;i++){
			stream_info_length +=se[i].getES_info_length()+5;
		}
		ebm[0].setStream_info_length(stream_info_length);
		
		
		int EBM_length=38;
//		if()
		EBM_length=48+ebm[0].getDetails_channel_program_info_length()+ebm[0].getStream_info_length()+12*ebm[0].getEBM_resource_number();
		ebm[0].setEBM_length(EBM_length);
		
		int section_length=0;
		section_length = 76;
		for(int i=0;i<ebm.length;i++){
			section_length += 2+ebm[i].getEBM_length();
		}
		ie.setSection_length(section_length);
		System.out.println("section_length:"+section_length);
		System.out.println("EBM_length:"+EBM_length);
		System.out.println("stream_info_length:"+stream_info_length);
		System.out.println("EBM_length:"+EBM_length);
		ie.setSignature_length(64);
		
		ie.setSignature_data("0000000000000000000000000000000000000000000000000000000000000000");
		ie.setCRC_32(1234);
		des1.setProgram(pro);
		se[0].setDescrpitor2(pro2);
		ebm[0].setDescriptor1(des1);
		ebm[0].setStream(se);
		ie.setEBM(ebm);
		Cable cable = new Cable();
		cable.IndexMake(ie);
	}
	
	public void cable254(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContentEntity ce = new ContentEntity();
		
//		ce.set(String2Int(request.getParameter("")));
		//section_length
		
		ce.setTable_id_extension(String2Int(request.getParameter("table_id_extension")));
		ce.setVersion_number(String2Int(request.getParameter("version_number")));
		ce.setCurrent_next_indicator(String2Int(request.getParameter("current_next_indicator")));
		ce.setSection_number(String2Int(request.getParameter("section_number")));
		ce.setLast_section_number(String2Int(request.getParameter("last_section_number")));
		ce.setEBM_id(request.getParameter("EBM_id"));
		ce.setMultilingual_content_number(String2Int(request.getParameter("multilingual_content_number")));
		
		Multilingual_contentEntity[] me= new Multilingual_contentEntity[ce.getMultilingual_content_number()];
		for(int i=0;i<me.length;i++){
			me[i]= new Multilingual_contentEntity();
		}
		//multilingual_content_length

		String[]  language_code= request.getParameterValues("language_code");
		int[] code_character_set= String2Ints(request.getParameterValues("code_character_set"));
		//message_text_length
		String[] message_text = request.getParameterValues("message_text");
		int[] message_text_length = new int[message_text.length];
		for(int i=0;i<message_text.length;i++){
			message_text_length[i] = message_text[i].length();
		}
		//agency_name_length
		String[] agency_name = request.getParameterValues("agency_name");
		int[] agency_name_length = new int[agency_name.length];
		for(int i=0;i<agency_name_length.length;i++){
			agency_name_length[i] = agency_name[i].length();
		}
		int[] auxiliary_data_number= String2Ints(request.getParameterValues("auxiliary_data_number"));
		int[] auxiliary_data_type= String2Ints(request.getParameterValues("auxiliary_data_type"));
		String[]  auxiliary_data= request.getParameterValues("auxiliary_data");
		int[] auxiliary_data_length = new int[auxiliary_data_type.length];
		for(int i=0;i<auxiliary_data_length.length;i++){
			auxiliary_data_length[i] =auxiliary_data[i].length();
		}
		//auxiliary_data_length
		
		
		for(int i=0;i<me.length;i++){
			me[i].setLanguage_code(language_code[i]);
			me[i].setCode_character_set(code_character_set[i]);
			me[i].setMessage_text(message_text[i]);
			me[i].setMessage_text_length(message_text_length[i]);
			me[i].setAgency_name(agency_name[i]);
			me[i].setAgency_name_length(agency_name_length[i]);
			me[i].setAuxiliary_data_number(auxiliary_data_number[i]);
			Auxiliary_dataEntity[] item =new Auxiliary_dataEntity[auxiliary_data_number[i]];
			for(int j=0;j<item.length;j++){
				item[j] = new Auxiliary_dataEntity();
				
			}
			int adn=0;
			
			for(int j=0;j<i;j++){
				adn += me[j].getAuxiliary_data_number();
			}
			for(int j=adn;j<adn+auxiliary_data_number[i];j++){
				item[j-adn].setAuxiliary_data_type(auxiliary_data_type[j]);
				item[j-adn].setAuxiliary_data(auxiliary_data[j]);
				item[j-adn].setAuxiliary_data_length(auxiliary_data_length[j]);
			}
			me[i].setAuxiliary_data(item);
			int multilingual_content_length=0;
			multilingual_content_length = 8+message_text_length[i]+agency_name_length[i];
			for(int k=0;k<me[i].getAuxiliary_data().length;k++){
				multilingual_content_length += 3+me[i].getAuxiliary_data()[k].getAuxiliary_data_length();
			}
			me[i].setMultilingual_content_length(multilingual_content_length);
		}
		ce.setMultilingual_content(me);
		int section_length=24;
		for(int i=0;i<ce.getMultilingual_content_number();i++){
			section_length += 4+ce.getMultilingual_content()[i].getMultilingual_content_length();
		}
		ce.setSection_length(section_length);
		
		ce.setSignature_length(64);
		ce.setSignature_data("0000000000000000000000000000000000000000000000000000000000000000");
		ce.setCRC_32(1234);
		System.out.println(ce.toString());
		
		Cable cable = new Cable();
		cable.ContentMake(ce);
	}
	
	public void cable252(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CertificateEntity ce = new CertificateEntity();
		ce.setTable_id_extension(String2Int(request.getParameter("table_id_extension")));
		ce.setVersion_number(String2Int(request.getParameter("version_number")));
		ce.setCurrent_next_indicator(String2Int(request.getParameter("current_next_indicator")));
		ce.setSection_number(String2Int(request.getParameter("section_number")));
		ce.setLast_section_number(String2Int(request.getParameter("last_section_number")));
		ce.setCertAuth_number(String2Int(request.getParameter("CertAuth_number")));
		ce.setCertAuth_data(request.getParameterValues("CertAuth_data"));
		ce.setCert_number(String2Int(request.getParameter("cert_number")));
		ce.setCert_data(request.getParameterValues("cert_data"));
		
		int[] certAuth_length = new int[ce.getCertAuth_number()];
		for(int i=0;i<ce.getCertAuth_number();i++){
			certAuth_length[i] = ce.getCertAuth_data()[i].length();
		}
		ce.setCertAuth_length(certAuth_length);
		
		int[] cert_length = new int[ce.getCert_number()];
		for(int i=0;i<ce.getCert_number();i++){
			cert_length[i] = ce.getCert_data()[i].length();
		}
		ce.setCert_length(cert_length);
		
		int section_length = 77;
		for(int i=0;i<ce.getCertAuth_number();i++){
			section_length += 2+ce.getCertAuth_length()[i];
		}
		for(int i=0;i<ce.getCert_number();i++){
			section_length += 1+ce.getCert_length()[i];
		}
		ce.setSection_length(section_length);
		ce.setSignature_length(64);
		ce.setSignature_data("0000000000000000000000000000000000000000000000000000000000000000");
		ce.setCRC_32(1234);
		System.out.println(ce.toString());
		Cable cable = new Cable();
		cable.CertificateMake(ce);
	}
	
	public void cable251(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("cableservlet");
		System.out.println(251);
		ConfigureEntity ce = new ConfigureEntity();
		ce.setTable_id_extension(String2Int(request.getParameter("table_id_extension")));
		ce.setVersion_number(String2Int(request.getParameter("version_number")));
		ce.setCurrent_next_indicator(String2Int(request.getParameter("current_next_indicator")));
		ce.setSection_number(String2Int(request.getParameter("section_number")));
		ce.setLast_section_number(String2Int(request.getParameter("last_section_number")));
		int configure_cmd_number = String2Int(request.getParameter("configure_cmd_number"));
		ce.setConfigure_cmd_number(configure_cmd_number);

		int[] configure_cmd_tag = String2Ints(request.getParameterValues("configure_cmd_tag"));
		
		

		String[] time = request.getParameterValues("time");
		String[] wYear = new String[time.length];
		String[] iMonth =new String[time.length];
		String[] iDay =new String[time.length];
		String[] iHour =new String[time.length];
		String[] iMinute =new String[time.length];
		for(int i=0;i<time.length-1;i++){

			if(configure_cmd_tag[i] == 1){
				String[] s1 = time[i].split("-");
				wYear[i] = s1[0];
				iMonth[i] =s1[1];
				String[] s2 = s1[2].split("T");
				iDay[i] = s2[0];
				String[] s3 = s2[1].split(":");
				iHour[i] = s3[0];
				iMinute[i] = s3[1];
			}
		}
//		for(int i=0;i<time.length;i++){
//			System.out.println("year"+i+":"+wYear[i]);
//			System.out.println("iMonth"+i+":"+iMonth[i]);
//			System.out.println("iDay"+i+":"+iDay[i]);
//			System.out.println("iHour"+i+":"+iHour[i]);
//			System.out.println("iMinute"+i+":"+iMinute[i]);
//		}
		
		String[] iSecond = request.getParameterValues("second");
		//2
		String[] terminal_address = request.getParameterValues("terminal_address");
		String[] resource_code = request.getParameterValues("resource_code");
		int[] terminal_address_length = new int[terminal_address.length];
		for(int i=0;i<terminal_address.length;i++){
			terminal_address_length[i] = terminal_address[i].length();
		}
		//3
		String[] freq = request.getParameterValues("freq");
		String[] symbolrate = request.getParameterValues("symbolrate");
		String[] constellation_mapping = request.getParameterValues("constellation_mapping");
		String[] terminal_number = request.getParameterValues("terminal_number");
		String[] resource_address = request.getParameterValues("resource_address");
		//4
		String[] reback_type = request.getParameterValues("reback_type");
		String[] reback_address = request.getParameterValues("reback_address");
		String[] terminal_number4 = request.getParameterValues("terminal_number4");
		String[] resource_address4 = request.getParameterValues("resource_address4");
		int[] reback_address_length = new int[reback_address .length];
		for(int i=9;i<reback_address.length;i++){
			reback_address_length[i] = reback_address [i].length();
		}
//		String[]  = request.getParameterValues("");
		//5
		String[] reback_period = request.getParameterValues("reback_period");
		String[] terminal_number5 = request.getParameterValues("terminal_number5");
		String[] resource_address5 = request.getParameterValues("resource_address5");
		//6
		String[] volume  = request.getParameterValues("volume");
		String[] terminal_number6 = request.getParameterValues("terminal_number6");
		String[] resource_address6 = request.getParameterValues("resource_address6");
		//7
		String[] parameter_number = request.getParameterValues("parameter_number");
		String[] parameter_tag = request.getParameterValues("parameter_tag");
		String[] terminal_number7 = request.getParameterValues("terminal_number7");
		String[] resource_address7 = request.getParameterValues("resource_address7");
		

		ConfigureCommandEntity[] cce = new ConfigureCommandEntity[configure_cmd_number-1];
		
		int resource_addressCount = 0;
		int resource_address4Count = 0;
		int resource_address5Count = 0;
		int resource_address6Count = 0;
		int resource_address7Count = 0;
		int parameter_tagCount = 0;
//		cce[i].set(String2Int([i]));
//		cce[i].set([i]);
		for(int i=0;i<configure_cmd_number-1;i++){
			cce[i].setwYear(String2Int(wYear[i]));
			cce[i].setiMonth(String2Int(iMonth[i]));
			cce[i].setiDay(String2Int(iDay[i]));
			cce[i].setiHour(String2Int(iHour[i]));
			cce[i].setiMinute(String2Int(iMinute[i]));
			cce[i].setiSecond(String2Int(iSecond[i]));
			//2
			cce[i].setTerminal_address_length(terminal_address_length[i]);
			cce[i].setTerminal_address(terminal_address[i]);
			cce[i].setResource_code(resource_code[i]);
			//3
			cce[i].setFreq(String2Int(freq[i]));
			cce[i].setSymbolrate(String2Int(symbolrate[i]));
			cce[i].setConstellation_mapping(String2Int(constellation_mapping[i]));
			cce[i].setTerminal_number(String2Int(terminal_number[i]));
			String[] Terminal3 = new String[cce[i].getTerminal_number()];
			for(int j=0;j<Terminal3.length;j++){
				Terminal3[i] = resource_address[resource_addressCount];
				resource_addressCount++;
			}
			cce[i].setResource_address(Terminal3);
			//4
			cce[i].setReback_type(String2Int(reback_type[i]));
			cce[i].setReback_address_length(reback_address_length[i]);
			cce[i].setReback_address(reback_address[i]);
			cce[i].setTerminal_number4(String2Int(terminal_number4[i]));
			String[] Terminal4 = new String[cce[i].getTerminal_number4()];
			for(int j=0;j<Terminal4.length;j++){
				Terminal4[i] = resource_address4[resource_address4Count];
				resource_address4Count++;
			}
			cce[i].setResource_code4(Terminal4);
			//5
			cce[i].setReback_period(String2Int(reback_period[i]));
			cce[i].setTerminal_number5(String2Int(terminal_number5[i]));
			String[] Terminal5 = new String[cce[i].getTerminal_number5()];
			for(int j=0;j<Terminal5.length;j++){
				Terminal5[i] = resource_address5[resource_address5Count];
				resource_address5Count++;
			}
			cce[i].setResource_code5(Terminal5);
			//6
			cce[i].setVolume(String2Int(volume[i]));
			cce[i].setTerminal_number6(String2Int(terminal_number6[i]));
			String[] Terminal6 = new String[cce[i].getTerminal_number6()];
			for(int j=0;j<Terminal6.length;j++){
				Terminal6[i] = resource_address6[resource_address6Count];
				resource_address6Count++;
			}
			cce[i].setResource_code6(Terminal6);
			//7
			cce[i].setParameter_number(String2Int(parameter_number[i]));
			
		}
	}

}
