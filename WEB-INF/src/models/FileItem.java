package models;

public class FileItem {
	private int fileItemId;
	private Property propertyId;
	private String fileItemPath;
	private boolean fileItemType;
	private MediaType mediaTypeId;
	
	public int getFileItemId() {
		return fileItemId;
	}
	
	public void setFileItemId(int fileItemId) {
		this.fileItemId = fileItemId;
	}
	
	public Property getPropertyId() {
		return propertyId;
	}
	
	public void setPropertyId(Property propertyId) {
		this.propertyId = propertyId;
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
	
	public MediaType getMediaTypeId() {
		return mediaTypeId;
	}
	
	public void setMediaTypeId(MediaType mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}
	
}