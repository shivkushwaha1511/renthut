package models;

public class Property {
	private int propertyId;
	private User userId;
	private String title;
	private String address;
	private City cityId;
	private String description;
	private PropertyType propertyTypeId;
	private int noOfPeople;
	
	public int getPropertyId() {
		return propertyId;
	}
	
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	
	public User getUserId() {
		return userId;
	}
	
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public City getCityId() {
		return cityId;
	}
	
	public void setCityId(City cityId) {
		this.cityId = cityId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public PropertyType getPropertyTypeId() {
		return propertyTypeId;
	}
	
	public void setPropertyTypeId(PropertyType propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}
	
	public int getNoOfPeople() {
		return noOfPeople;
	}
	
	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	
}
