package models;

import java.util.ArrayList;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PropertyType {
	private int propertyTypeId;
	private String propertyType;
	
//	Constants
	
	public static final int ROOM = 1;
	public static final int HOUSE = 2;
	public static final int FLAT = 3;
	public static final int SINGLE_FAMILY = 4;
	public static final int DUPLEX = 5;
	public static final int APARTMENT = 6;
	public static final int VILLA = 7;
	public static final int MANSION = 8;
	public static final int BUNGALOW = 9;
	public static final int NOT_SELECTED = 10;
	
//	Constructor Summary
	
	public PropertyType(int propertyTypeId, String propertyType) {
		this.propertyTypeId = propertyTypeId;
		this.propertyType = propertyType;
	}
	
	public PropertyType(int propertyTypeId) {
		super();
		this.propertyTypeId = propertyTypeId;
	}

//	Method Summary
	
	public static ArrayList<PropertyType> getAllPropertyTypes(){
		ArrayList<PropertyType> types = new ArrayList<PropertyType>();
			Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "select property_type_id,property_type from property_types";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				PropertyType proType = new PropertyType(res.getInt(1),res.getString(2));
				types.add(proType);
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

		return types;
	}
	
//	setter & getters
	
	public int getPropertyTypeId() {
		return propertyTypeId;
	}
	
	public void setPropertyTypeId(int propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}
	
	public String getPropertyType() {
		return propertyType;
	}
	
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
}