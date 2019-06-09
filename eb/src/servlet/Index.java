package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EBIEntity.EB;
import service.EBService;

public class Index extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EBService ebs=new EBService();
		List<EB> eb;
		try {
			eb = ebs.findAll();
			for(int i = 0 ; i < eb.size() ; i++) {
				if(eb.get(i).getEBI().getEBContent()[0].getHeadline().equals("")){
					eb.get(i).getEBI().getEBContent()[0].setHeadline("未知");
				}
				if(eb.get(i).getEBI().getEBMainInfo().getSender().equals("")){
					eb.get(i).getEBI().getEBMainInfo().setSender("未知");
				}
				if(eb.get(i).getEBI().getEBMainInfo().getEventLevel().equals("")){
					eb.get(i).getEBI().getEBMainInfo().setEventLevel("未知");
				}
				if(eb.get(i).getEBI().getEBMainInfo().getEventType().equals("")){
					eb.get(i).getEBI().getEBMainInfo().setEventType("未知");
				}
				if(eb.get(i).getEBI().getPublishStrategy().getBroadcastDateTime().equals("")){
					eb.get(i).getEBI().getPublishStrategy().setBroadcastDateTime("未知");
				}
				
			}
			request.setAttribute("eb", eb);
//			System.out.println(eb.get(0).getEBI().getEBMainInfo().getInfoID());
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	

}
