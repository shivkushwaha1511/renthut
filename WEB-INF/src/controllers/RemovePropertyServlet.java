package controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Property;
import models.User;

public class RemovePropertyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String next = "signin.do";
		
		if(user!=null) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Property.removeProperty(id);
			
			session.setAttribute("activeTab","myProperties");
			
			next = "dashboard.do";
		}
		
		response.sendRedirect(next);
	}
}
