package controllers;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.MediaType;
import models.User;
import utils.EmailSender;
import utils.GoogleCaptcha;
import utils.MessageTemplate;
import java.util.Random;

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
			
//			-----------------------Validation------------------------------
			boolean validate = true;
			String err = "<ul>";
			
			Pattern pattern = Pattern.compile("^[A-z a-z]{3,50}$");
			Matcher matcher = pattern.matcher(name);
			if(!matcher.matches()) {
				validate = false;
				err += "<li>Enter Valid Name</li>";
			}
			
			pattern = Pattern.compile("^([a-z][a-z\\d-_]*)@([a-z]{2,})\\.([a-z]{2,5})(\\.[a-z]{2,5})?$");
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
			
//			------------------------/Validation-----------------------------
			if(validate) {
				
				Long authCode = new Random().nextLong();
				
				if(authCode<0) {
					authCode = authCode*-1;
				}
				
				User user = new User(name,email,password,address,Long.toString(authCode));
				
				if(user.signUp()) {	
					ServletContext context = request.getServletContext();
					String parentpath = context.getRealPath("/WEB-INF/uploads");
					File file = new File(parentpath,email);
					file.mkdir();
					
					String message = MessageTemplate.activateAccount(name,email,authCode);
					String subject = "Activate Account";
					EmailSender.sendEmail(email,subject, message);
					
					response.sendRedirect("verify_email.jsp");;
				}else {
					err += "<li>User Already Exists</li></ul>";
					request.setAttribute("error", err);
					request.getRequestDispatcher("sign_up.jsp").forward(request, response);
				}
			}else {
				err += "</ul>";
				request.setAttribute("error", err);
				request.getRequestDispatcher("sign_up.jsp").forward(request, response);
			}
		}else {
//			Google Recaptcha fail
		}
	}
}
