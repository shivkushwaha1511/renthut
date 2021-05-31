package models;

public class City {
	private int cityId;
	private String city;
	private State stateId;
	
//	constructor summary
	
	public City(int cityId,String city) {
		this.cityId = cityId;
		this.city = city;
	}
	
//	getters & setters
	
	public int getCityId() {
		return cityId;
	}
	
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public State getStateId() {
		return stateId;
	}
	
	public void setStateId(State stateId) {
		this.stateId = stateId;
	}
}