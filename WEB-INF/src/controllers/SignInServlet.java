package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.getRequestDispatcher("sign_in.jsp").forward(request,response);
	}
}
