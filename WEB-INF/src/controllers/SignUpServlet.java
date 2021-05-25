package controllers;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import utils.GoogleCaptcha;

public class SignUpServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		request.getRequestDispatcher("sign_up.jsp").forward(request,response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		boolean captchaValidate = GoogleCaptcha.validateRequest(request);
		
		if(captchaValidate) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			
			boolean validate = true;
			String err = "<ul>";
			
			Pattern pattern = Pattern.compile("^[A-z a-z]{3,50}$");
			Matcher matcher = pattern.matcher(name);
			if(!matcher.matches()) {
				validate = false;
				err += "<li>Enter Valid Name</li>";
			}
			
			pattern = Pattern.compile("^([A-Za-z][A-Za-z\\d-_]*)@([A-Za-z]{2,})\\.([A-Za-z]{2,5})(\\.[A-Za-z]{2,5})?$");
			matcher = pattern.matcher(email);
			if(!matcher.matches()) {
				validate = false;
				err += "<li>Enter Valid Email</li>";
			}
			
			pattern = Pattern.compile("^[A-Za-z\\d@_-]{8,20}$");
			matcher = pattern.matcher(password);
			if(!matcher.matches()) {
				validate = false;
				err += "<li>Enter Valid Password</li>";
			}
			
			err += "</ul>";
			
			if(validate) {
				User user = new User(name,email,password,address);
				user.signUp();
				response.sendRedirect("index.jsp");;
			}else {
				request.setAttribute("error", err);
				request.getRequestDispatcher("sign_up.jsp").forward(request, response);
			}
		}else {
			
		}
	}
}
