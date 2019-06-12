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

import transmission.AnalogFM;
import transmission.Cable;
import transmission.Medium;
import transmissionEntity.AnalogFMEntity;
import transmissionEntity.Auxiliary_dataEntity;
import transmissionEntity.ContentEntity;
import transmissionEntity.Descriptor1;
import transmissionEntity.EBMEntity;
import transmissionEntity.IndexEntity;
import transmissionEntity.MediumEntity;
import transmissionEntity.Multilingual_contentEntity;
import transmissionEntity.Program;
import transmissionEntity.StreamEntity;

public class TransmissionServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int type =Integer.parseInt(request.getParameter("type"));
		if(type == 1){
			request.getRequestDispatcher("/medium.jsp").forward(request, response);
		}else if(type == 2){
			request.getRequestDispatcher("/analogFM.jsp").forward(request, response);
		}else if(type == 3){
			request.getRequestDispatcher("/cable.jsp").forward(request, response);
		}else if(type == 4){
			request.getRequestDispatcher("/terrestrial.jsp").forward(request, response);
		}else if(type == 5){
			request.getRequestDispatcher("/trumpet.jsp").forward(request, response);
		}else if(type == 251){
			request.getRequestDispatcher("/cable251.jsp").forward(request, response);
		}else if(type == 252){
			request.getRequestDispatcher("/cable252.jsp").forward(request, response);
		}else if(type == 253){
			request.getRequestDispatcher("/cable253.jsp").forward(request, response);
		}else if(type == 254){
			request.getRequestDispatcher("/cable254.jsp").forward(request, response);
		}
	}
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
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		Enumeration enu=request.getParameterNames();  
		while(enu.hasMoreElements()){  
		String paraName=(String)enu.nextElement(); 
		
		System.out.println(paraName+": "+request.getParameter(paraName));  
		
		}
		int transType = Integer.parseInt(request.getParameter("transType"));
		
		try{
			switch(transType){
			case 1:medium(request,response);
				break;
			case 2:analogFM(request,response);
				break;
			case 3:cable(request,response);		
				break;
			case 4:terrestrial(request,response);
				break;
			case 5:trumpet(request,response);
				break;
			default:;
			
			}
		}catch(Exception e){
			request.setAttribute("msg","传输失败，请检查数据填写格式是否正确");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		request.setAttribute("msg","传输成功");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
	    	
	}
	
	
	public void medium(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MediumEntity me =new MediumEntity();
		me.setType(String2Int(request.getParameter("type")));
		me.setNumber(request.getParameter("number"));
		me.setSource(request.getParameter("source"));
		me.setAreas(String2Int(request.getParameter("areas")));
		me.setCode(request.getParameterValues("code"));
		me.setDuration(String2Int(request.getParameter("duration")));
		me.setLevel(String2Int(request.getParameter("level")));
		me.setEventType(request.getParameter("eventType"));
		me.setFrequencyType(String2Int(request.getParameter("frequencyType")));
		me.setValue(request.getParameter("value"));
		me.setReceiverSN(request.getParameter("ReceiverSN"));
		me.setCertsAuthSN(String2Int(request.getParameter("CertsAuthSN")));
		me.setCertsCount(String2Int(request.getParameter("CertsCount")));
		me.setCertSNs(request.getParameterValues("CertSNs"));
		me.setSigSN(request.getParameter("SigSN"));
		me.setSignature(request.getParameter("Signature"));
		
		me.setTime(System.currentTimeMillis() / 1000);
		me.setCertificate("123595124562");
		me.setSign("0000000000000000000000000000000000000000000000000000000000000000");
		Medium medium = new Medium();
		Medium medium2 = new Medium();
		
		int length=medium.mediumMake(me);
		me.setLength(length);
		medium2.mediumMake(me);
		System.out.println(me.toString());
	}
	
	public void analogFM(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AnalogFMEntity ae = new AnalogFMEntity();
		ae.setType(String2Int(request.getParameter("type")));
		ae.setLength(0);
		ae.setNumber(String2Int(request.getParameter("number")));
		ae.setCode(request.getParameterValues("code"));
		ae.setTime(System.currentTimeMillis() / 1000);
		ae.setCertificate("123595124562");
		ae.setSign("0000000000000000000000000000000000000000000000000000000000000000");
		
		//0
		ae.setFrequencyPoints(String2Int(request.getParameter("FrequencyPoints")));
		ae.setFrequencyPointPriority(String2Ints(request.getParameterValues("FrequencyPointPriority")));
		ae.setFrequency(String2doubles(request.getParameterValues("Frequency")));
		//1
		ae.setPhysicalAddress(request.getParameter("PhysicalAddress"));
		ae.setPhysicalAddressLength(request.getParameter("PhysicalAddress").length());
		ae.setEquipmentCode(request.getParameter("EquipmentCode"));
		//2
		ae.setInstructions(String2Int(request.getParameter("instructions")));
		ae.setMaintenanceCycle(String2Int(request.getParameter("MaintenanceCycle")));
		//3
		if(request.getParameter("type") == "3"){
			String time=request.getParameter("time");
			String[] str=time.split("-");
			String year = str[0];
			String month = str[1];
			String[] s = str[2].split("T");
			String day = s[0];
			String[] ss = s[1].split(":");
			String hour = ss[0];
			String minute = ss[1];
			ae.setYear(String2Int(year));
			ae.setMonth(String2Int(month));
			ae.setDay(String2Int(day));
			ae.setHour(String2Int(hour));
			ae.setMinute(String2Int(minute));
			ae.setSecond(String2Int(request.getParameter("second")));
		}
		
		//4
		ae.setReturnMode(String2Int(request.getParameter("ReturnMode")));
		ae.setReturnData(request.getParameter("ReturnData"));
		ae.setReturnLength(request.getParameter("ReturnData").length());
		//5
		ae.setReturnCycle(String2Int(request.getParameter("ReturnCycle")));
		//6
		ae.setSigTime(String2Long(request.getParameter("SigTime")));
		ae.setCertificateSN6(request.getParameter("CertificateSN6"));
		ae.setSignature(request.getParameter("Signature"));
		//7
		ae.setNumberOfCertificates(String2Int(request.getParameter("NumberOfCertificates")));
		ae.setCertificateLength(143);//标准数据为143字节
		ae.setCertificateVersion(request.getParameterValues("CertificateVersion"));
		ae.setIssuerSN(request.getParameterValues("IssuerSN"));
		ae.setCertificateSN7(request.getParameterValues("CertificateSN7"));
		ae.setCertificateValidate(request.getParameterValues("CertificateValidate"));
		ae.setPublicKey(request.getParameterValues("PublicKey"));
		ae.setSignatureData(request.getParameterValues("SignatureData"));
		//8
		ae.setNumberOfParameters(String2Int(request.getParameter("NumberOfParameters")));
		ae.setParameterIdentification(String2Ints(request.getParameterValues("ParameterIdentification")));
		//11
		ae.setStart_StopType(String2Int(request.getParameter("Start_StopType")));
		ae.setSwitching(String2Int(request.getParameter("Switching")));
		ae.setEventLevel(String2Int(request.getParameter("EventLevel")));
		ae.setEventtype(request.getParameter("Eventtype"));
		ae.setInfoID(request.getParameter("InfoID"));
		ae.setFrequencyInformation(String2Double(request.getParameter("FrequencyInformation")));
		//12
		ae.setInstructionType(String2Int(request.getParameter("InstructionType")));
		ae.setSwitching12(String2Int(request.getParameter("Switching12")));
		ae.setFrequencyInformation12(String2Double(request.getParameter("FrequencyInformation12")));
		//13
		ae.setInstructionType13(String2Int(request.getParameter("InstructionType13")));
		//14
		ae.setEmergencyType(String2Int(request.getParameter("EmergencyType")));
		ae.setOperationInstruction(String2Int(request.getParameter("OperationInstruction")));
		ae.setExerciseInstructionID(request.getParameter("ExerciseInstructionID"));
		//15
		ae.setTextType(String2Int(request.getParameter("TextType")));
		ae.setCodedCharacterSet(String2Int(request.getParameter("CodedCharacterSet")));
		ae.setInfoID15(request.getParameter("InfoID15"));
		ae.setText(request.getParameter("Text"));
		ae.setTextLength(ae.getText().length());
		//21
		ae.setMaintenanceInstruction(String2Int(request.getParameter("MaintenanceInstruction")));
		//22
		ae.setDailyType(String2Int(request.getParameter("DailyType")));
		ae.setSwitching22(String2Int(request.getParameter("Switching22")));
		ae.setInfoID22(request.getParameter("InfoID22"));
		ae.setFrequencyInformation22(String2Double(request.getParameter("FrequencyInformation22")));
		ae.setVolume22(String2Int(request.getParameter("volume22")));
		//23
		ae.setVolume23(String2Int(request.getParameter("volume23")));
		//24
		ae.setSwitching24(String2Int(request.getParameter("Switching24")));

		
		AnalogFM afm1= new AnalogFM();
		AnalogFM afm2= new AnalogFM();
		int length=afm1.AnalogFMMake(ae);
		ae.setLength(length-2);
		
		afm2.AnalogFMMake(ae);
		System.out.println(ae.toString());
	}
	
	public void cable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		int type = String2Int(request.getParameter("cableType"));
		switch(type){
		case 253:cable253(request,response);
			break;
		case 254:cable254(request,response);
			break;
		case 252:cable252(request,response);
			break;
		case 251:cable251(request,response);
			break;
		default:;
		
		}
	}
	public void terrestrial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public void trumpet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		
		
		int EBM_length=0;
		EBM_length=48+ebm[0].getDetails_channel_program_info_length()+ebm[0].getStream_info_length()+12*ebm[0].getEBM_resource_number();
		ebm[0].setEBM_length(EBM_length);
		
		int section_length=0;
		section_length = 76;
		for(int i=0;i<ebm.length;i++){
			section_length += 2+ebm[i].getEBM_length();
		}
		ie.setSection_length(section_length);
		
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
	}
	
	public void cable252(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(252);
	}
	
	public void cable251(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(251);
	}

}
