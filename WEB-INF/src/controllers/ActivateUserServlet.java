package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;

import javax.servlet.ServletException;

import java.io.IOException;


public class ActivateUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		String next = "index.jsp";
		
		String email = request.getParameter("email");
		String authCode = request.getParameter("authCode");
		
		if(User.activateUser(email,authCode)) {
			next = "sign_in.jsp";
		}
		
		request.getRequestDispatcher(next).forward(request, response);;
	}
}