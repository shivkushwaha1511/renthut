package models;

public class PropertyPost {
	private int postId;
	private Property propertyId;
	private User userId;
	private int rent;
	private Status statusId;
	private String startDate;
	private String endDate;
	private TenantType tenantTypeId;
	
	public int getPostId() {
		return postId;
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public Property getPropertyId() {
		return propertyId;
	}
	
	public void setPropertyId(Property propertyId) {
		this.propertyId = propertyId;
	}
	
	public User getUserId() {
		return userId;
	}
	
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	public int getRent() {
		return rent;
	}
	
	public void setRent(int rent) {
		this.rent = rent;
	}
	
	public Status getStatusId() {
		return statusId;
	}
	
	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public TenantType getTenantTypeId() {
		return tenantTypeId;
	}
	
	public void setTenantTypeId(TenantType tenantTypeId) {
		this.tenantTypeId = tenantTypeId;
	}
}