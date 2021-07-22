package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Property {
	private int propertyId;
	private User user;
	private Status status; 
	private String title;
	private String address;
	private City city;
	private String description;
	private PropertyType propertyType;
	private int noOfPeople;
	private String thumbnail;
	
//	Constructor Summary
	public Property() {}
	
	public Property(int propertyId) {
		this.propertyId = propertyId;
	}
	
	public Property(User user,String title, String address, City city,
			String description, PropertyType propertyType) {
		super();
		this.user = user;
		this.title = title;
		this.address = address;
		this.city = city;
		this.description = description;
		this.propertyType = propertyType;
	}

	//	Method Summary
	public static boolean removeProperty(int propertyId) {
		Connection con = null;
		boolean flag = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			String query = "UPDATE properties SET status_id=4 WHERE property_id=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, propertyId);
			
			ps.executeUpdate();
			
			flag = true;
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	
	public void saveThumbnail(String path) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "UPDATE properties SET thumbnail=? where property_id=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,path);
			ps.setInt(2,propertyId);
			ps.executeUpdate();
					
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public boolean addPropertyDetails() {
		boolean flag = false;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");

				String query = "INSERT INTO properties (user_id,title,address,city_id,description,property_type_id) VALUE (?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
				
				ps.setInt(1,user.getUserId());
				ps.setString(2,title);
				ps.setString(3,address);
				ps.setInt(4,city.getCityId());
				ps.setString(5,description);
				ps.setInt(6,propertyType.getPropertyTypeId());
				
				if(ps.executeUpdate()==1) {
					ResultSet res = ps.getGeneratedKeys();
					
					if(res.next()) {
						this.propertyId = res.getInt(1);
					}
					
					flag = true;
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
		
		return flag;
	}
	
	public boolean UpdatePropertyDetails(String title,String address,City city,String description,PropertyType propertyType) {
		boolean flag = false;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String	query = "UPDATE properties SET title=?,address=?,city_id=?,description=?,property_type_id=? WHERE property_id=?";
			PreparedStatement	ps = con.prepareStatement(query);

				ps.setString(1,title);
				ps.setString(2,address);
				ps.setInt(3,city.getCityId());
				ps.setString(4,description);
				ps.setInt(5,propertyType.getPropertyTypeId());
				ps.setInt(6,propertyId);
				
				if(ps.executeUpdate() == 1) {
					flag = true;
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
		
		return flag;
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
	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
}
