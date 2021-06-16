package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

public class DashboardServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String next = "signin.do";
		
		String myProperties = request.getParameter("activeTabMyProp");
		String addProperty = request.getParameter("activeTabAddProp");
			
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(myProperties != null) {
			session.setAttribute("activeTab","myProperties");
		}
		
		if(addProperty != null) {
			session.setAttribute("activeTab","addProperty");
		}
		
		if(user != null) {
			String activeTab = (String)session.getAttribute("activeTab");
			if(activeTab == null) {
				session.setAttribute("activeTab","profile");
			}
			next = "dashboard.jsp";
		}
		
		request.getRequestDispatcher(next).forward(request, response);;
	}
}