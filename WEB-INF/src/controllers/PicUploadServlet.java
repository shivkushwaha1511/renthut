package controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import models.MediaType;
import models.PropertyFeature;
import models.User;

public class PicUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(ServletFileUpload.isMultipartContent(request) && user!=null) {
			ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
			
			List<FileItem> items = null;
			try {
				PropertyFeature property = (PropertyFeature)session.getAttribute("property");
				
				items = sfu.parseRequest(request);		
				FileItem item = items.get(0);
				
				String fileName = item.getName();
				
				int lastIndex = fileName.lastIndexOf(".");
				String fileType = fileName.substring(lastIndex+1);
				
				boolean fileItemType = true;
				
				if(fileType.equals("jpg") || fileType.equals("jpeg") || fileType.equals("png") || fileType.equals("gif")) {
					fileItemType = false;
				}
				
				int picTypeId = Integer.parseInt(request.getParameter("picTypeId"));
				
				String folderPath = getServletContext().getRealPath("/WEB-INF/uploads/");
				
				File file = new File(folderPath+user.getEmail()+"/"+property.getProperty().getPropertyId()+"_"+property.getProperty().getTitle()+"/"+MediaType.TYPES[picTypeId-1],fileName);
				
				try {
					item.write(file);
					
					models.FileItem fileItem = new models.FileItem(property.getProperty(), user.getEmail()+"/"+property.getProperty().getPropertyId()+"_"+property.getProperty().getTitle()+"/"+MediaType.TYPES[picTypeId-1]+"/"+fileName,fileItemType,new MediaType(picTypeId));
					fileItem.savePic();
				
				}catch(Exception e) {
					e.printStackTrace();
				};
			}catch(FileUploadException e) {
				e.printStackTrace();
			}
		}
	}
}































