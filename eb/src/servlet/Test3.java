package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test3 extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		request.setAttribute("password", "789456");
		System.out.println(request.getParameterValues("username").toString());
		System.out.println(request.getParameter("password"));
		if(request.getParameter("password") != null){
			ArrayList<String> att = new ArrayList<String>();
		}
		
	}

}
