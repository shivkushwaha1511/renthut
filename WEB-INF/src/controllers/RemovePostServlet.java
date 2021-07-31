package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.PropertyPost;
import models.User;

import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/removepost.do")

public class RemovePostServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String next = "signin.do";
		
		if(user!=null) {
			int propId = Integer.parseInt(request.getParameter("propId"));
			
//			PropertyPost.removePost(propId);
			
			next = "dashboard.do";
		}
		
		response.sendRedirect(next);
	}
}
