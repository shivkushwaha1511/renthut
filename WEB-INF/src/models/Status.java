package models;

public class Status {
	private int statusId;
	private String status;
	
//	Constants
	public static final int ACTIVE = 1;
	public static final int INACTIVE = 2;
	public static final int BLOCKED = 3;
	public static final int ENDED = 4;
	public static final int PROFILE_INCOMPLETE = 5;
	
//	constructor summary
	
	public Status(int statusId) {
		this.statusId = statusId;
	}
	
	
//	getters & setters
	public int getStatusId() {
		return statusId;
	}
	
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}	
}