package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import EBIEntity.Attachment;

public class Test extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/test.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//获取文件上传对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		
		//设置文件大小限制
		sfu.setFileSizeMax(1024*1024*2);//2M
		
		//获取FileItems
		try {
			List<FileItem> items=sfu.parseRequest(request);
//			ArrayList<Attachment> att= new ArrayList<Attachment>();
			Integer count =0;
			
			for(FileItem item:items){
				if(item.isFormField()){
					String name = item.getFieldName();
                    // 解决普通输入项数据中文乱码问题
                    String value = item.getString("UTF-8");
                    // value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    request.setAttribute(name, value);
                    request.setAttribute("ceshi","shuchu");
                    System.out.println(name+"="+value);
				}else{
					count++;
//					System.out.println("附件次数"+count);
				}
	
			}
			
			
			System.out.println("附件zong次数"+count);
			System.out.println(request.getAttribute("time"));
			Attachment att[]=new Attachment[count];	
			for(int i=0;i<count;i++){
				att[i]=new Attachment();
			}
			System.out.println(att.length);
			int temp =0;
			
//			for(FileItem item:items){
//				if(item.isFormField()){
//					String name = item.getFieldName();
//                    // 解决普通输入项数据中文乱码问题
//                    String value = item.getString("UTF-8");
//                    // value = new String(value.getBytes("iso8859-1"),"UTF-8");
//                    
//					if(name.equals("AttDescription")){
//						att[temp].setAttDescription(value);
//						System.out.println( "附件内容"+att[0].toString());
//						temp++;
//					}else{
//						
//					}
//				}else{
//					//文件的MIME类型，如text/plain
////					System.out.println(item.getContentType());
//					//字段名，即<input> 中的name值
////					System.out.println(item.getFieldName());
//					//文件名
//					System.out.println(item.getName());
//					System.out.println("temp="+temp);
////					att[temp].setAttName(item.getName());
//					//文件大小
////					System.out.println(item.getSize());
//					//文本内容
////					System.out.println(item.getString());
//					
//					//指定文件保存目录
//					
//					String path = "E:/Myeclipse/workspace/eb/files/";
//					
//					//后缀名
//					String suffix = item.getName().split("\\.")[1];
//					String savePath = path+"1."+suffix;
////					System.out.println(savePath);
//					item.write(new File(savePath));
//					//删除临时文件
//					item.delete();
//					
//					
//				}
//				
//			}
			System.out.println(att.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(request.getParameter("ceshi"));
	
	}

}
