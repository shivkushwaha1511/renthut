package controllers;

import java.util.List;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import models.User;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

public class DpUploadServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(ServletFileUpload.isMultipartContent(request) && user!=null) {
			DiskFileItemFactory dfif = new DiskFileItemFactory();
			ServletFileUpload sfu = new ServletFileUpload(dfif);
			
			List<FileItem> fileItems = null;
			try {
				fileItems = sfu.parseRequest(request);
			
				FileItem fileItem = fileItems.get(0);
				
				String fileName = fileItem.getName();
				
				String parentPath = getServletContext().getRealPath("/WEB-INF/uploads/");
				
				File file = new File(parentPath+user.getEmail(),fileName);
				
				if(user.getProfilePic() != null) {
					File delFile = new File(parentPath,user.getProfilePic());
					delFile.delete();
				}
				
				try {
					fileItem.write(file);
					String filePath = user.getEmail() + "/" + fileName;
					
					user.saveDpPath(filePath);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}catch(FileUploadException e) {
				e.printStackTrace();
			}
		}
	}
}