package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.List;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.Property;
import models.PropertyFeature;
import models.User;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

public class ThumbnailUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(ServletFileUpload.isMultipartContent(request) && user!=null) {
			ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
			List<FileItem> fileItems = null;
			
			try {
				fileItems = sfu.parseRequest(request);
				FileItem fileItem = fileItems.get(0);
				
				String fileName = fileItem.getName();
				
				String folderPath = getServletContext().getRealPath("/WEB-INF/uploads/");
				
				File file = new File(folderPath+user.getEmail(),fileName);
				
				PropertyFeature propertyFeature = (PropertyFeature)session.getAttribute("property"); 
				Property property = propertyFeature.getProperty();
				
				if(property.getThumbnail()!=null) {
					File delFile = new File(folderPath,property.getThumbnail());
					delFile.delete();
				}
				
				try {
					fileItem.write(file);
					property.saveThumbnail(user.getEmail()+"/"+fileName);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}catch(FileUploadException e) {
				e.printStackTrace();
			}
		}
	}
}



















