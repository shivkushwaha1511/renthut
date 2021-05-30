package models;

public class Status {
	private int statusId;
	private String status;
	
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