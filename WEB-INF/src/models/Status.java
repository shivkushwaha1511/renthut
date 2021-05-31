package models;

public class Status {
	private int statusId;
	private String status;
	
//	Constants
	public static int ACTIVE = 1;
	public static int INACTIVE = 2;
	public static int BLOCKED = 3;
	
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