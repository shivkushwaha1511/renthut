package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;

import java.io.IOException;
import java.io.InputStream;

public class ShowPropertyUtilsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String path = request.getParameter("path");
	
		ServletOutputStream os = response.getOutputStream();
		
		InputStream is = getServletContext().getResourceAsStream("WEB-INF/uploads/"+path);
		
		if(is == null) {
			is = getServletContext().getResourceAsStream("static/images/defaultproperty.jpg");
		}
		
		byte[] arr = new byte[1024];
		
		int count = 0;
		while((count = is.read(arr))!=-1) {
			os.write(arr);
		}
		
		os.flush();
		os.close();
	}
}