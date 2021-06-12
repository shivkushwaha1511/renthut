package models;

import java.util.ArrayList;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class City {
	private int cityId;
	private String city;
	private State state;
	
//	Constant
	public static final int NOT_SELECTED = 1508;
	
//	constructor summary
	public City(int cityId) {
		this.cityId = cityId;
	}
	
	public City(int cityId,String city) {
		this.cityId = cityId;
		this.city = city;
	}
	
	public City(int cityId,String city,State state) {
		this.cityId = cityId;
		this.city = city;
		this.state = state;
	}
//	Method Summary
	
	public static ArrayList<City> getAllCities(){
		ArrayList<City> cities = new ArrayList<City>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "SELECT city_id,city,c.state_id,state FROM cities AS c INNER JOIN states AS s WHERE c.state_id = s.state_id ORDER BY city ASC";
			
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				City c = new City(rs.getInt(1),rs.getString(2),new State(rs.getInt(3),rs.getString(4)));
				cities.add(c);
			}
			
			con.close();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return cities;
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
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
}