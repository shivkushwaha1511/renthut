package models;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private String activationCode;
	private Status statusId;
	private City cityId;
	private int contactNo;
	private String profilePic;
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public City getCityId() {
		return cityId;
	}

	public void setCityId(City cityId) {
		this.cityId = cityId;
	}

	public String address() {
		return address;
	}
	
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	
	public String getActivationCode() {
		return activationCode;
	}
	
	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}
	
	public Status getStatusId() {
		return statusId;
	}
	
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	
	public int getContactNo() {
		return contactNo;
	}
	
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
	public String getProfilePic() {
		return profilePic;
	}
	
}