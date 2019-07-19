package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import transmission.AnalogFM;
import transmission.Medium;
import transmissionEntity.AnalogFMEntity;
import transmissionEntity.MediumEntity;
import transmissionEntity.TrumpetEntity;
import transmissionEntity.White_list;

public class TransmissionServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int type =Integer.parseInt(request.getParameter("type"));
		switch(type){
			case 1:
				request.getRequestDispatcher("/medium.jsp").forward(request, response);
				break;
			case 2:
				request.getRequestDispatcher("/analogFM.jsp").forward(request, response);
				break;
			case 3:
				request.getRequestDispatcher("/cable.jsp").forward(request, response);
				break;
			case 4:
				request.getRequestDispatcher("/terrestrial.jsp").forward(request, response);
				break;
			case 5:
				request.getRequestDispatcher("/trumpet.jsp").forward(request, response);
				break;
			default:;
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
		
//		try{
			switch(transType){
			case 1:medium(request,response);
				break;
			case 2:analogFM(request,response);
				break;
			case 5:trumpet(request,response);
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
		//第二个参数判断是否进行UDP传输
		int length=medium.mediumMake(me,false);
		me.setLength(length);
		medium2.mediumMake(me,true);
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
		if(request.getParameter("type").equals("3")){
			System.out.println("test");
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
		int length=afm1.AnalogFMMake(ae,false);
		ae.setLength(length-2);
		
		afm2.AnalogFMMake(ae,true);
		System.out.println(ae.toString());
	}
	
	public void terrestrial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	//应急广播大喇叭前后端数据交互
	public void trumpet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("trumpet");
		int protocol_type =Integer.parseInt(request.getParameter("protocol_type"), 16);
		TrumpetEntity tt = new TrumpetEntity();
		tt.setProtocol_type(protocol_type);
		

		
		//data_length
		
		//0c
		White_list[] white_list = new White_list[String2Int(request.getParameter("white_list_length"))];
		
		int wlLen = white_list.length;
		for(int i=0;i<wlLen;i++){
			white_list[i] = new White_list();
		}
		int[] oper_type = new int[wlLen];
		int[] phone_number_length = new int[wlLen];
		String[] phone_number = new String[wlLen];
		int[] user_name_length = new int[wlLen];
		String[] user_name = new String[wlLen];
		int[] permission_type = new int[wlLen];
		int[] permission_area_number = new int[wlLen];
		int[] permission_area_length = new int[wlLen];
		String[] permission_area_code = new String[wlLen];
		
//		=String2Ints(request.getParameterValues(""));
//		=request.getParameterValues("");
		
		oper_type=String2Ints(request.getParameterValues("oper_type"));
		phone_number=request.getParameterValues("phone_number");
		for(int i=0;i<wlLen;i++){
			phone_number_length[i] = phone_number[i].length();
		}
		user_name=request.getParameterValues("user_name");
		for(int i=0;i<wlLen;i++){
			user_name_length[i] = user_name[i].length();
		}
		permission_type=String2Ints(request.getParameterValues("permission_type"));
		permission_area_number=String2Ints(request.getParameterValues("permission_area_number"));
		permission_area_code=request.getParameterValues("permission_area_code");
		for(int i=0;i<wlLen;i++){
			permission_area_length[i] = permission_area_code[0].length();
		}
		int count =0;
		for(int i=0;i<wlLen;i++){
			white_list[i].setOper_type(oper_type[i]);
			white_list[i].setPhone_number_length(phone_number_length[i]);
			white_list[i].setPhone_number(phone_number[i]);
			white_list[i].setUser_name_length(user_name_length[i]);
			white_list[i].setUser_name(user_name[i]);
			white_list[i].setPermission_type(permission_type[i]);
			white_list[i].setPermission_area_number(permission_area_number[i]);
			white_list[i].setPermission_area_length(permission_area_length[i]);
			String[] area_code = new String[permission_area_number[i]];
			for(int j=0;j<permission_area_number[i];j++){
				area_code[j] = permission_area_code[count];
				count++;
			}
			white_list[i].setPermission_area_code(area_code);
		}
		tt.setWhite_list(white_list);
		tt.setWhite_list_length(wlLen);
		

		//0d
		tt.setReback_type0d(String2Int(request.getParameter("reback_type0d")));
		tt.setReback_cycle(String2Int(request.getParameter("reback_cycle")));
		tt.setReback_address0d(request.getParameter("reback_address0d"));
		tt.setReback_address_length0d(tt.getReback_address0d().length());
		
		//0e
		tt.setFront_code0e(request.getParameter("front_code0e"));
		tt.setOutput_channel_id(String2Int(request.getParameter("output_channel_id")));
		tt.setOutput_channel_state(String2Int(request.getParameter("output_channel_state")));
		
		//0f
		tt.setFront_code0f(request.getParameter("front_code0f"));
		tt.setInput_channel_id(String2Int(request.getParameter("input_channel_id")));
		tt.setInput_channel_state(String2Int(request.getParameter("input_channel_state")));
		
		//10
		tt.setFront_code10(request.getParameter("front_code10"));
		tt.setEbm_id(request.getParameter("ebm_id"));
		tt.setTask_type(String2Int(request.getParameter("task_type")));
		tt.setStartTime(String2Long(request.getParameter("startTime")));
		tt.setEndTime(String2Long(request.getParameter("endTime")));
		
		
		//11
		tt.setFront_code11(request.getParameter("front_code11"));
		
		//41
		int certauth_number41 = String2Int(request.getParameter("certauth_number41"));
		
		int cert_number41 = String2Int(request.getParameter("cert_number41"));
		
		
		int[] certauth_length41 = new int[certauth_number41];
		String[] certauth41 = request.getParameterValues("certauth41");
		int[] certh_length41 = new int[cert_number41];
		String[] certh41 = request.getParameterValues("certh41");
		
		for(int i=0;i<certauth_number41;i++){
			certauth_length41[i]=certauth41[i].length();
		}
		for(int i=0;i<cert_number41;i++){
			certh_length41[i] = certh41[i].length();
		}
		
		tt.setCertauth_number41(certauth_number41);
		tt.setCertauth_length41(certauth_length41);
		tt.setCertauth41(certauth41);
		tt.setCert_number41(cert_number41);
		tt.setCerth_length41(certh_length41);
		tt.setCerth41(certh41);
		
		//05
		int logic_address_number = String2Int(request.getParameter("logic_address_number"));
		String[] physical_address = request.getParameterValues("physical_address");
		int[] physical_address_length = new int[logic_address_number];
		for(int i=0;i<logic_address_number;i++){
			physical_address_length[i] = physical_address[i].length();
		}
		String[] logic_address = request.getParameterValues("logic_address");
		int[] logic_address_length = new int[logic_address_number];
		for(int i=0;i<logic_address_number;i++){
			logic_address_length[i] = logic_address[i].length();
		}
		tt.setLogic_address_number(logic_address_number);
		tt.setPhysical_address_length(physical_address_length);
		tt.setPhysical_address(physical_address);
		tt.setLogic_address(logic_address);
		tt.setLogic_address_length(logic_address_length);
		
		//06
		tt.setVolume(String2Int(request.getParameter("volume")));
		tt.setResource_code_type06(String2Int(request.getParameter("resource_code_type06")));
		tt.setResource_code_number06(String2Int(request.getParameter("resource_code_number06")));
		String[] resource_code06=request.getParameterValues("resource_code06");
		tt.setResource_code06(resource_code06);
		int resource_code_length06 =0;
		for(int i=0;i<resource_code06.length;i++){
			resource_code_length06 = resource_code06[i].length();
		}
		tt.setResource_code_length06(resource_code_length06);
		
		//07
		tt.setReback_type07(String2Int(request.getParameter("reback_type07")));
		tt.setReback_address07(request.getParameter("reback_address07"));
		tt.setReback_address_length07(tt.getReback_address07().length());
		tt.setResource_code_type07(String2Int(request.getParameter("resource_code_type07")));
		tt.setResource_code_number07(String2Int(request.getParameter("resource_code_number07")));
		String[] resource_code07=request.getParameterValues("resource_code07");
		tt.setResource_code07(resource_code07);
		int resource_code_length07 =0;
		for(int i=0;i<resource_code07.length;i++){
			resource_code_length07 = resource_code07[i].length();
		}
		tt.setResource_code_length07(resource_code_length07);
		System.out.println(tt.toString());
//		tt.set(request.getParameter(""));
//		tt.set(String2Int(request.getParameter("")));
	}
	
	
	
}
