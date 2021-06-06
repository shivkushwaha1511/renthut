package controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowDpServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String path = request.getParameter("path");
		
		ServletOutputStream os = response.getOutputStream();
		
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream("/WEB-INF/uploads/"+path);
		
		if(is == null) {
			is = context.getResourceAsStream("static/images/user_dp.png");
		}
		
		byte[] arr = new byte[1024];
		
		int c=0;
		while((c=is.read(arr))!=-1) {
			os.write(arr);
		}
		
		os.flush();
		os.close();
	}
}
