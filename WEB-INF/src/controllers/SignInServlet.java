package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import utils.GoogleCaptcha;

public class SignInServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.getRequestDispatcher("sign_in.jsp").forward(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String next = "sign_in.jsp";	
		
		if(GoogleCaptcha.validateRequest(request)) {
			HttpSession session = request.getSession();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			User user = new User(email,password);
			
			if(user.signIn()) {
				session.setAttribute("user", user);
				next = "index.jsp";
			}
		}
		
		response.sendRedirect(next);
		
	}
}
