package controllers;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Status;
import models.User;
import utils.GoogleCaptcha;

public class SignInServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.getRequestDispatcher("sign_in.jsp").forward(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String next = "sign_in.jsp";	
		boolean validate = true;
		String error = "<ul>";
		
		if(GoogleCaptcha.validateRequest(request)) {
			HttpSession session = request.getSession();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
//			-----------------------Validation-------------------------------
			Pattern pattern = Pattern.compile("^([a-z][a-z\\d-_]*)@([a-z]{2,})\\.([a-z]{2,5})(\\.[a-z]{2,5})?$");
			Matcher matcher = pattern.matcher(email);
			if(!matcher.matches()) {
				validate = false;
				error += "<li>Enter Valid Email</li>";
			}
			
			pattern = Pattern.compile("^[A-Za-z\\d@_-]{8,20}$");
			matcher = pattern.matcher(password);
			if(!matcher.matches()) {
				validate = false;
				error += "<li>Enter Valid Password</li>";
			}
			
//	--------------------------------/Validation-----------------------------------		
			if(validate) {
				User user = new User(email,password);
				if(user.signIn()) {
					int status = user.getStatus().getStatusId();
					if(status == Status.ACTIVE) {
						session.setAttribute("user", user);
						next = "dashboard.do";
					}else if(status == Status.PROFILE_INCOMPLETE){
						session.setAttribute("user", user);
						next = "completeprofile.do";
					}else if(status == Status.BLOCKED) {
//						Blocked Page
					}else if(status == Status.INACTIVE){
//						Email Verification Page
					}else {
//						Ended Page
					}
				}else {
					error += "<li>User with entered credential doesn't exists</li></ul>";
					request.setAttribute("error", error);
					request.getRequestDispatcher(next).forward(request, response);;
				}
			}else {
				error += "</ul>";
				request.setAttribute("error", error);
				request.getRequestDispatcher(next).forward(request, response);;
			}
			
			if(validate) {
				response.sendRedirect(next);
			}
		}else {
//			Captcha Fail Page
		}
		
	}
}
