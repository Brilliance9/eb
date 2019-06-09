package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import EBDEntity.*;
import EBIEntity.*;
import service.EBService;

public class EBServlet extends HttpServlet {

	
	
	private String Ext_Name = "gif,jpg,jpeg,png,bmp,swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb,doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2";

	private String makeFileName(String fileName) {
	        // 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
	        return UUID.randomUUID().toString().replaceAll("-", "") + "_" + fileName;
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String method = request.getParameter("method");
		if(method.equals("detail")){
			detail(request,response);
		}else if(method.equals("make")){
			try {
				make(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(method.equals("delete")){
			delete(request,response);
		}
		
	}
	

	
	//查看详细信息
	public void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id=request.getParameter("ID");
		
			EB eb;
			try {
				eb = new EBService().detail(id);
				request.setAttribute("eb", eb);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
		
	}
	
	public void make(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id=request.getParameter("ID");
		EBService ebs=new EBService();
		ebs.make(id);
		request.setAttribute("msg","发送成功");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
	}
	//删除
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id=request.getParameter("ID");
		EBService ebs=new EBService();
		ebs.delete(id);;
		request.setAttribute("msg","删除成功");
		request.getRequestDispatcher("/msg.jsp").forward(request, response);
		
	}
	
	//post请求用于添加预警信息
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			EBI_EBContent ebc[]=new EBI_EBContent[1];
			ebc[0]=new EBI_EBContent();
			
			
			
			
			// 得到上传文件的保存目录，将上传文件存放在WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
	        String savePath = this.getServletContext().getRealPath("WEB-INF/upload");
	        File saveFileDir = new File(savePath);
	        if (!saveFileDir.exists()) {
	            // 创建临时目录
	            saveFileDir.mkdirs();
	        }
	        
	        // 上传时生成临时文件保存目录
	        String tmpPath = this.getServletContext().getRealPath("WEB-INF/tem");
	        File tmpFile = new File(tmpPath);
	        if (!tmpFile.exists()) {
	            // 创建临时目录
	            tmpFile.mkdirs();
	        }

	        // 消息提示
	        String message = "";
	        try {
	            // 使用Apache文件上传组件处理文件上传步骤：
	            // 1.创建一个DiskFileItemFactory工厂
	            DiskFileItemFactory factory = new DiskFileItemFactory();
	            // 设置工厂的缓冲区的大小，当上传的文件大小超过缓冲区的大小时，就会生成一个临时文件存放到指定的临时目录当中
	            factory.setSizeThreshold(1024 * 10);// 设置缓冲区的大小为100KB，如果不指定，那么默认缓冲区的大小是10KB
	            // 设置上传时生成的临时文件的保存目录
	            factory.setRepository(tmpFile);
	            // 2.创建一个文件上传解析器
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            // 监听文件上传进度
	            upload.setProgressListener(new ProgressListener() {

	                @Override
	                public void update(long readedBytes, long totalBytes, int currentItem) {
	                    // TODO Auto-generated method stub
	                    System.out.println("当前已处理：" + readedBytes + "-----------文件大小为：" + totalBytes + "--" + currentItem);
	                }
	            });
	            // 解决上传文件名的中文乱码问题
	            upload.setHeaderEncoding("UTF-8");
	            // 3.判断提交上来的数据是否是上传表单的数据
	            if (!ServletFileUpload.isMultipartContent(request)) {
	                // 按照传统方式获取数据
	                return;
	            }

//	            // 设置上传单个文件的最大值
//	            upload.setFileSizeMax(1024 * 1024 * 1);// 1M
//	            // 设置上传文件总量的最大值，就是本次上传的所有文件的总和的最大值
//	            upload.setSizeMax(1024 * 1024 * 10);// 10M

	            List<FileItem> items=upload.parseRequest(request);
				Integer count =0;
				
				for(FileItem item:items) {
	                
	                // 如果fileitem中封装的是普通的输入想数据
	                if (item.isFormField()) {
					
	                    String name = item.getFieldName();
						
	                    // 解决普通输入项数据中文乱码问题
	                    String value = item.getString("UTF-8");
	                    // value = new String(value.getBytes("iso8859-1"),"UTF-8");
						
						request.setAttribute(name, value);
						
//	                    System.out.println(name + "=" + value);
	                } else// 如果fileitem中封装的是上传文件
	                {
	                    count++;
	                }

	            }
				
				System.out.println("附件zong次数"+count);
				Attachment att[]=new Attachment[count];	
				for(int i=0;i<count;i++){
					att[i]=new Attachment();
				}
					
				int temp =0;
					
	            for(FileItem item:items) {
	                
	                // 如果fileitem中封装的是普通的输入想数据
	                if (item.isFormField()) {
					
	                    String name = item.getFieldName();
						
	                    // 解决普通输入项数据中文乱码问题
	                    String value = item.getString("UTF-8");
	                    // value = new String(value.getBytes("iso8859-1"),"UTF-8");
						
	                   if(name.equals("AttDescription")){
							att[temp].setAttDescription(value);
							
						}else if(name.equals("AttType")){
							att[temp].setAttType(value);
						}else if(name.equals("Digest")){
							att[temp].setDigest(value);
							temp++;
						}
	                } else// 如果fileitem中封装的是上传文件
	                {
	                    // 得到上传文件的文件名
	                    String fileName = item.getName();
	                    System.out.println("文件名：" + fileName);
	                    if (fileName == null && fileName.trim().length() == 0) {
	                        continue;
	                    }
	                    // 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的
	                    // 如: C:\Users\H__D\Desktop\1.txt 而有些则是 ： 1.txt
	                    // 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
	                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
	                    
	                    // 得到上传文件的扩展名
	                    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	                    // 检查扩展名
	                    // 如果需要限制上传的文件类型，那么可以通过文件的扩展名来判断上传的文件类型是否合法
	                    System.out.println("上传的文件的扩展名是：" + fileExt);
	                    

//	                    // 检查文件大小
//	                    if(item.getSize() == 0) continue;
//	                    if(item.getSize() > 1024 * 1024 * 1){
//	                        System.out.println("上传文件大小：" + item.getSize());
//	                        message = message + "文件：" + fileName + "，上传文件大小超过限制大小：" + upload.getFileSizeMax() + "<br/>";
//	                        break;
//	                    }
	                    
	                    
	                    // 得到存文件的文件名
	                    String saveFileName = makeFileName(fileName);
	                    
	                    //保存文件方法一// 获取item中的上传文件的输入流
	                    InputStream is = item.getInputStream();
	                    //创建一个文件输出流
	                    FileOutputStream out = new FileOutputStream(savePath + "\\" + saveFileName);
	                    //创建一个缓冲区
	                    byte buffer[] = new byte[1024];
	                    //判断输入流中的数据是否已经读完的标致
	                    int len = 0;
	                    while((len = is.read(buffer)) > 0){
	                        out.write(buffer, 0, len);
	                    }
	                    //关闭输出流
	                    out.close();
	                    //关闭输入流
	                    is.close();
	                    //删除临时文件
	                    item.delete();
	                    
	                    message = message + "文件：" + fileName + "，上传成功<br/>";
	                    
						att[temp].setAttName(fileName);
						att[temp].setAttSize(String.valueOf(item.getSize()));
						att[temp].setAttSuffix(fileExt);
						att[temp].setAttURL(savePath + "\\" + saveFileName);
	                    
	                    //保存文件方法二
//	                    File uploadedFile = new File(savePath, saveFileName);
//	                    item.write(uploadedFile);
	                    
	                }

	            }
	            ebc[0].setAttachments(att);
	            
	        } catch (FileSizeLimitExceededException e) {
	            message = message + "上传文件大小超过限制<br/>";
	            e.printStackTrace();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
//	            request.setAttribute("message", message);
//	            request.getRequestDispatcher("/msg.jsp").forward(request, response);
	        }
			
			
			
			request.setCharacterEncoding("utf-8");
			
			
			
			EBService ebs=new EBService();
			
			EB eb=new EB();
			
			EBI ebi=new EBI();
			
//			System.out.println("是否有东西"+request.getAttribute("EBIVersion"));
			EBI_EBMainInfo maininfo=new EBI_EBMainInfo();
			maininfo.setEBIVersion(request.getAttribute("EBIVersion").toString());
			maininfo.setInfoID(request.getAttribute("InfoID").toString());
			maininfo.setEBIID(request.getAttribute("InfoID").toString());
			maininfo.setIdentifier(request.getAttribute("Identifier").toString());
			maininfo.setSender(request.getAttribute("Sender").toString());
			maininfo.setSenderCode(request.getAttribute("SenderCode").toString());
			maininfo.setEventType(request.getAttribute("EventType").toString());
			maininfo.setEventLevel(request.getAttribute("EventLevel").toString());
			maininfo.setInfoType(request.getAttribute("InfoType").toString());
			maininfo.setInfoStatus(request.getAttribute("InfoStatus").toString());
			maininfo.setReferenceId(request.getAttribute("ReferenceId").toString());
			maininfo.setIsMediaRes(request.getAttribute("IsMediaRes").toString());
			maininfo.setIsTTS(request.getAttribute("IsTTS").toString());
			maininfo.setInstructions(request.getAttribute("Instructions").toString());
			ebi.setEBMainInfo(maininfo);
			
			
			ebc[0].setLanguage(request.getAttribute("Language").toString());
			ebc[0].setLanguageCode(request.getAttribute("LanguageCode").toString());
			ebc[0].setCodeSet(request.getAttribute("CodeSet").toString());
			ebc[0].setHeadline(request.getAttribute("Headline").toString());
			ebc[0].setEventDescription(request.getAttribute("EventDescription").toString());
			ebc[0].setProgramNum(request.getAttribute("ProgramNum").toString());
			ebc[0].setSigner(request.getAttribute("Signer").toString());
			

			
			ebi.setEBContent(ebc);
			
			EBI_PublishStrategy pub=new EBI_PublishStrategy();
			pub.setBroadcastDateTime(request.getAttribute("BroadcastDateTime").toString());
			System.out.println(request.getAttribute("BroadcastDateTime").toString());
			pub.setOverDateTime(request.getAttribute("OverDateTime").toString());
			pub.setPublishRegion(request.getAttribute("PublishRegion").toString());
			BroadcastStyle bro[]=new BroadcastStyle[1];
			bro[0]=new BroadcastStyle();
			bro[0].setPublishMeans(request.getAttribute("PublishMeans").toString());
			bro[0].setPresentation(request.getAttribute("Presentation").toString());
			bro[0].setPublishFrequency(request.getAttribute("PublishFrequency").toString());
			bro[0].setRollFrequency(request.getAttribute("RollFrequency").toString());
			pub.setBroadcastStyle(bro);
			ebi.setPublishStrategy(pub);
			
			
			if(request.getAttribute("earth").toString().equals("1")){
				ebi.setE1(true);
				EBI_ExtendInfo1 ex1=new EBI_ExtendInfo1();
				ex1.setLocation_code(request.getAttribute("location_code").toString());
				ex1.setPlace(request.getAttribute("place").toString());
				ex1.setEarthquake_time(request.getAttribute("earthquake_time").toString());
				ex1.setLevel(request.getAttribute("level").toString());
				ex1.setDepth(request.getAttribute("depth").toString());
				ex1.setLongitude(request.getAttribute("longitude").toString());
				ex1.setLatitude(request.getAttribute("latitude").toString());
				ex1.setEq_type(request.getAttribute("eq_type").toString());
				ex1.setExpedited_reporting_type(request.getAttribute("expedited_reporting_type").toString());
				ex1.setNearest_provincial_capital(request.getAttribute("nearest_provincial_capital").toString());
				ex1.setShenghui(request.getAttribute("shenghui").toString());
				ex1.setNearest_prefecture(request.getAttribute("nearest_prefecture").toString());
				ex1.setDijishi(request.getAttribute("dijishi").toString());
				ex1.setNearest_county(request.getAttribute("nearest_county").toString());
				ex1.setXianjishi(request.getAttribute("xianjishi").toString());
				ex1.setNearest_village(request.getAttribute("nearest_village").toString());
				ex1.setVillages(request.getAttribute("villages").toString());
				ex1.setNearest_town(request.getAttribute("nearest_town").toString());
				ex1.setTowns(request.getAttribute("towns").toString());
				ex1.setJuli(request.getAttribute("juli").toString());
				ex1.setRange(request.getAttribute("range").toString());
				ex1.setSeismic_information(request.getAttribute("Seismic_information").toString());
				ex1.setWEATHER(request.getAttribute("WEATHER").toString());
				ex1.setAltitude(request.getAttribute("altitude").toString());
				ex1.setPopulation(request.getAttribute("population").toString());
				ex1.setArea(request.getAttribute("area").toString());
				ex1.setGdp(request.getAttribute("gdp").toString());
				ex1.setFive_earthquake(request.getAttribute("five_earthquake").toString());
				ebi.setExtendInfo1(ex1);
			}
			
			if(request.getAttribute("air").toString().equals("1")){
				ebi.setE2(true);
				EBI_ExtendInfo2 ex2=new EBI_ExtendInfo2();
				ex2.setAirport(request.getAttribute("Airport").toString());
				ex2.setAirportcode(request.getAttribute("Airportcode").toString());
				ex2.setInbound_flights(request.getAttribute("Inbound_flights").toString());
				ex2.setOutbound_flights(request.getAttribute("Outbound_flights").toString());
				ex2.setInbound_numberofpeople(request.getAttribute("Inbound_numberofpeople").toString());
				ex2.setOutbound_numberofpeople(request.getAttribute("Outbound_numberofpeople").toString());
				ex2.setInbound_Delayedflights(request.getAttribute("Inbound_Delayedflights").toString());
				ex2.setOutbound_Delayedflights(request.getAttribute("Outbound_Delayedflights").toString());
				ex2.setAirportStatus(request.getAttribute("AirportStatus").toString());
				ex2.setInbound_flights_number(request.getAttribute("Inbound_flights_number").toString());
				ex2.setOutbound_flightsnumber(request.getAttribute("Outbound_flightsnumber").toString());
				ex2.setTime(request.getAttribute("Time").toString());
				ebi.setExtendInfo2(ex2);
			}
			
			
			EBI_Area ar=new EBI_Area();
			ar.setAreaCircle(request.getAttribute("AreaCircle").toString());
			ar.setAreaDescription(request.getAttribute("AreaDescription").toString());
			ar.setAreaPolygon(request.getAttribute("AreaPolygon").toString());
			ebi.setArea(ar);
			
			
			
			EBD ebd= new EBD();
			ebd.setEBDVersion(request.getAttribute("EBDVersion").toString());
			ebd.setEBDID(request.getAttribute("EBDID").toString());
			ebd.setEBDType(request.getAttribute("EBDType").toString());
			EBD_SRC src= new EBD_SRC();
			src.setEBRID(request.getAttribute("SRC_EBRID").toString());
			src.setURL(request.getAttribute("SRC_URL").toString());
			ebd.setSRC(src);
			EBD_DEST dest=new EBD_DEST();
			dest.setEBRID(request.getAttribute("DEST_EBRID").toString());
			ebd.setDEST(dest);
			ebd.setEBDTime(request.getAttribute("EBDTime").toString());
			EBD_RelatedEBD re=new EBD_RelatedEBD();
			re.setEBDID(request.getAttribute("Re_EBDID").toString());
			ebd.setRelatedEBD(re);
			
			EBD_EBM ebm=new EBD_EBM();
			ebm.setEBMVersion(request.getAttribute("EBMVersion").toString());
			ebm.setEBMID(request.getAttribute("EBMID").toString());
			EBM_RelatedInfo mre= new EBM_RelatedInfo();
			mre.setEBIID(request.getAttribute("Re_EBIID").toString());
			mre.setEBMID(request.getAttribute("Re_EBMID").toString());
			ebm.setRelatedInfo(mre);
			EBM_MsgBasicInfo msgb=new EBM_MsgBasicInfo();
			msgb.setSenderName(request.getAttribute("SenderName").toString());
			msgb.setSenderCode(request.getAttribute("SenderCode2").toString());
			msgb.setSendTime(request.getAttribute("SendTime").toString());
			msgb.setEventType(request.getAttribute("EventType2").toString());
			msgb.setSeverity(request.getAttribute("Severity").toString());
			msgb.setStartTime(request.getAttribute("StartTime").toString());
			msgb.setEndTime(request.getAttribute("EndTime").toString());
			msgb.setMsgType(request.getAttribute("MsgType").toString());
			ebm.setMsgBasicInfo(msgb);
			
			EBM_MsgContent msgc =new EBM_MsgContent();
			msgc.setLanguageCode(request.getAttribute("LanguageCode2").toString());
			msgc.setMsgTitle(request.getAttribute("MsgTitle").toString());
			msgc.setMsgDesc(request.getAttribute("MsgDesc").toString());
			msgc.setAreaCode(request.getAttribute("AreaCode").toString());
			msgc.setProgramNum(request.getAttribute("ProgramNum2").toString());
			EBM_MsgC_Auxiliary au=new EBM_MsgC_Auxiliary();
			au.setAuxiliaryType(request.getAttribute("AuxiliaryType").toString());
			au.setAuxiliaryDesc(request.getAttribute("AuxiliaryDesc").toString());
			au.setSize(request.getAttribute("Size").toString());
			au.setDigest(request.getAttribute("Digest2").toString());
			msgc.setAuxiliary(au);
			ebm.setMsgContent(msgc);
			
			EBM_Dispatch dis=new EBM_Dispatch();
			dis.setLanguageCode(request.getAttribute("LanguageCode2").toString());
			EBM_D_EBRAS ra=new EBM_D_EBRAS();
			ra.setEBRID(request.getAttribute("EBRAS_EBRID").toString());
			EBM_D_EBRBS rb=new EBM_D_EBRBS();
			rb.setBrdSysInfo(request.getAttribute("BrdSysInfo").toString());
			rb.setBrdSysType(request.getAttribute("BrdSysType").toString());
			EBM_D_EBRPS rp=new EBM_D_EBRPS();
			rp.setEBRID(request.getAttribute("EBRPS_EBRID").toString());
			EBM_D_EBRRTS rr=new EBM_D_EBRRTS();
			rr.setEBRID(request.getAttribute("EBRRTS_EBRID").toString());
			dis.setEBRAS(ra);
			dis.setEBRBS(rb);
			dis.setEBRPS(rp);
			dis.setEBRRTS(rr);
			ebm.setDispatch(dis);

			ebd.setEBM(ebm);
			
			eb.setEBD(ebd);
			eb.setResource("");
			eb.setEBI(ebi);

			ebs.add(eb);
			request.setAttribute("msg","添加预警信息成功");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			
		}

}
