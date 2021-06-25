package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileItem {
	private int fileItemId;
	private Property property;
	private String fileItemPath;
	private boolean fileItemType;
	private MediaType mediaType;
	
	public FileItem(){	
	}
	
	public FileItem(Property property, String fileItemPath, boolean fileItemType, MediaType mediaType) {
		super();
		this.property = property;
		this.fileItemPath = fileItemPath;
		this.fileItemType = fileItemType;
		this.mediaType = mediaType;
	}


	public void savePic() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "INSERT INTO file_items (property_id,file_item_path,file_item_type,media_type_id) value (?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,property.getPropertyId());
			ps.setString(2,fileItemPath);
			ps.setBoolean(3,fileItemType);
			ps.setInt(4,mediaType.getMediaTypeId());
			
			ps.executeUpdate();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public int getFileItemId() {
		return fileItemId;
	}
	
	public void setFileItem(int fileItemId) {
		this.fileItemId = fileItemId;
	}
	
	public Property getProperty() {
		return property;
	}
	
	public void setPropertyId(Property property) {
		this.property = property;
	}
	
	public String getFileItemPath() {
		return fileItemPath;
	}
	
	public void setFileItemPath(String fileItemPath) {
		this.fileItemPath = fileItemPath;
	}
	
	public boolean isFileItemType() {
		return fileItemType;
	}
	
	public void setFileItemType(boolean fileItemType) {
		this.fileItemType = fileItemType;
	}
	
	public MediaType getMediaType() {
		return mediaType;
	}
	
	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}
	
}