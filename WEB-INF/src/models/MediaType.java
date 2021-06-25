package models;

public class MediaType {
	private int mediaTypeId;
	private String mediaType;
	
	public static String[] TYPES = {"exterior","living_room","bedroom","kitchen","dining_room","bathroom","terrace","garden"};
	
	public MediaType(int mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}
	
	public int getMediaTypeId() {
		return mediaTypeId;
	}
	
	public void setMediaTypeId(int mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}
	
	public String getMediaType() {
		return mediaType;
	}
	
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
}