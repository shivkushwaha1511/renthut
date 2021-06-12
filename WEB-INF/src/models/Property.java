package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Property {
	private int propertyId;
	private User user;
	private String propertyTag;
	private String title;
	private String address;
	private City city;
	private String description;
	private PropertyType propertyType;
	private int noOfPeople;
	
//	Constructor Summary
	public Property(User user,String propertyTag, String title, String address, City city,
			String description, PropertyType propertyType) {
		super();
		this.user = user;
		this.propertyTag = propertyTag;
		this.title = title;
		this.address = address;
		this.city = city;
		this.description = description;
		this.propertyType = propertyType;
	}

	//	Method Summary
	public void addPropertyDetails() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "INSERT INTO properties (user_id,property_tag,title,address,city_id,description,property_type_id) VALUE (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1,user.getUserId());
			ps.setString(2,propertyTag);
			ps.setString(3,title);
			ps.setString(4,address);
			ps.setInt(5,city.getCityId());
			ps.setString(6,description);
			ps.setInt(7,propertyType.getPropertyTypeId());
			
			if(ps.executeUpdate()==1) {
				query = "SELECT property_id FROM properties WHERE property_tag=?";
				ps = con.prepareStatement(query);
				ps.setString(1,propertyTag);
				
				ResultSet res = ps.executeQuery();
				
				if(res.next())
					this.propertyId = res.getInt(1);
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
//	Setter & Getters
	
	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String getPropertyTag() {
		return propertyTag;
	}

	public void setPropertyTag(String propertyTag) {
		this.propertyTag = propertyTag;
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
	
	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		this.city = city;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public PropertyType getPropertyType() {
		return propertyType;
	}
	
	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}
	
	public int getNoOfPeople() {
		return noOfPeople;
	}
	
	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	
}
