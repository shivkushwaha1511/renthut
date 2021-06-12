package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.City;
import models.User;

import javax.servlet.ServletException;

import java.io.IOException;

public class CompleteProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String next = "complete_profile.jsp";
		
		if(user == null) {
			next = "signin.do";
		}
		request.getRequestDispatcher(next).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String next = "signin.do";
		
		if(user != null) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			int cityId = Integer.parseInt(request.getParameter("city"));
			City city = new City(cityId);
			String contact = request.getParameter("contact");
			
			if(user.updateProfile(name,address,city,contact)) {
				next = "dashboard.do";
			}
		}
		
		response.sendRedirect(next);
	}
}
