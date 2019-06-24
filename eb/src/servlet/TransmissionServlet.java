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
import transmission.DigitalTelevision;
import transmission.Medium;
import transmissionEntity.AnalogFMEntity;
import transmissionEntity.Auxiliary_dataEntity;
import transmissionEntity.CertificateEntity;
import transmissionEntity.ConfigureEntity;
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
		
		try{
			switch(transType){
			case 1:medium(request,response);
				break;
			case 2:analogFM(request,response);
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
		int length=afm1.AnalogFMMake(ae);
		ae.setLength(length-2);
		
		afm2.AnalogFMMake(ae);
		System.out.println(ae.toString());
	}
	
	public void terrestrial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public void trumpet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	
}
