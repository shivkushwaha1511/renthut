package controllers;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Property;
import models.PropertyPost;
import models.Status;
import models.TenantType;
import models.User;

import javax.servlet.ServletException;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/post.do")

public class PostDataServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String next = "signin.do";
		
		if(user!=null) {
			
			int status = 2;
			if(request.getParameter("status")!=null) {
				status = 1;
			}
			
			String markFill = request.getParameter("markFill");
			int rent = Integer.parseInt(request.getParameter("rent"));
			int tenantType = Integer.parseInt(request.getParameter("tenantType"));
			String endDate = request.getParameter("endDate");
			Integer propId = Integer.parseInt(request.getParameter("propId"));
			
			if(endDate.isEmpty()) {
				endDate = "2000-01-01";
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			java.util.Date OendDate = null;
			try {
				OendDate = format.parse(endDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date FinalEndDate = new Date(OendDate.getTime());
			
			if(markFill!=null) {
				status = 4;
			}
			
			Status Ostatus = new Status(status);
			TenantType OtenantType = new TenantType(tenantType);
			Property property = new Property(propId);
			
			PropertyPost post = PropertyPost.getPost(propId);
			
			if(post.getPostId()==0) {
				post = new PropertyPost(property,user,rent,FinalEndDate,OtenantType);
				post.savePost();
			}else {
				post.setStatus(Ostatus);
				post.setRent(rent);
				post.setEndDate(FinalEndDate);
				post.setTenantType(OtenantType);
				
				post.updatePost();
			}
			
			session.setAttribute("activeTab","myProperties");
			next = "dashboard.do";
		}
		
		response.sendRedirect(next);
	}
}
