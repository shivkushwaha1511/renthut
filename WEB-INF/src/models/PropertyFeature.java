package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PropertyFeature {
	private int featureId;
	private Property property;
	private int roomCount;
	private int bedroom;
	private int bathroom;
	private boolean electricityBill;
	private int area;
	private boolean waterTank;
	private boolean parking;
	private int distFromSchool;
	private int distFromHospital;
	private boolean terrace;
	private boolean ventilation;
	private boolean petsAllowed;
	private int floorType;
	private boolean garden;
	
//	Constructor Summary
	public PropertyFeature() {}
	
	public PropertyFeature(Property property,int roomCount, int bedroom, int bathroom, boolean electricityBill, int area,
			boolean waterTank, boolean parking, int distFromSchool, int distFromHospital, boolean terrace,
			boolean ventilation, boolean petsAllowed, int floorType, boolean garden) {
		super();
		this.property = property;
		this.roomCount = roomCount;
		this.bedroom = bedroom;
		this.bathroom = bathroom;
		this.electricityBill = electricityBill;
		this.area = area;
		this.waterTank = waterTank;
		this.parking = parking;
		this.distFromSchool = distFromSchool;
		this.distFromHospital = distFromHospital;
		this.terrace = terrace;
		this.ventilation = ventilation;
		this.petsAllowed = petsAllowed;
		this.floorType = floorType;
		this.garden = garden;
	}
	
//	Method Summary
	public static ArrayList<PropertyFeature> getAllProperties(String searchvalue){
		ArrayList<PropertyFeature> properties = new ArrayList<PropertyFeature>();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "SELECT * FROM property_features AS f INNER JOIN properties AS p INNER JOIN cities AS c INNER JOIN property_posts as pp WHERE p.property_id = f.property_id AND p.city_id = c.city_id AND pp.property_id=p.property_id AND pp.status_id=1 AND p.title LIKE '%"+searchvalue+"%'";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery(query);
			
			while(rs.next()) {
				PropertyFeature feature = new PropertyFeature();
				Property property = new Property();
				
				feature.setFeatureId(rs.getInt(1));
				feature.setRoomCount(rs.getInt(3));
				feature.setBedroom(rs.getInt(4));
				feature.setBathroom(rs.getInt(5));
				feature.setElectricityBill(rs.getBoolean(6));
				feature.setArea(rs.getInt(7));
				feature.setWaterTank(rs.getBoolean(8));
				feature.setParking(rs.getBoolean(9));
				feature.setDistFromSchool(rs.getInt(10));
				feature.setDistFromHospital(rs.getInt(11));
				feature.setTerrace(rs.getBoolean(12));
				feature.setVentilation(rs.getBoolean(13));
				feature.setPetsAllowed(rs.getBoolean(14));
				feature.setFloorType(rs.getInt(15));
				feature.setGarden(rs.getBoolean(16));
				property.setPropertyId(rs.getInt(17));
				property.setUser(new User(rs.getInt(18)));
				property.setStatus(new Status(rs.getInt(19)));
				property.setTitle(rs.getString(20));
				property.setAddress(rs.getString(21));
				property.setDescription(rs.getString(23));
				property.setPropertyType(new PropertyType(rs.getInt(24)));
				property.setNoOfPeople(rs.getInt(25));
				property.setThumbnail(rs.getString(26));
				property.setCity(new City(rs.getInt(27),rs.getString(28)));
				
				feature.setProperty(property);
				
				properties.add(feature);
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
		
		return properties;
	}
	
	
	public ArrayList<String> collectAllPropPics(){
		ArrayList<String> pics = new ArrayList<String>();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "select file_item_path from file_items where property_id=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, this.getProperty().getPropertyId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				pics.add(rs.getString(1));
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
		
		
		return pics;
	}
	
	public static ArrayList<PropertyFeature> collectAllProperties(User user){
		ArrayList<PropertyFeature> features = new ArrayList<PropertyFeature>();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "SELECT * FROM property_features AS f INNER JOIN properties AS p WHERE p.property_id=f.property_id AND p.user_id=? AND p.status_id=1";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,user.getUserId());
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				PropertyFeature feature = new PropertyFeature();
				Property property = new Property();
				
				feature.setFeatureId(rs.getInt(1));
				feature.setRoomCount(rs.getInt(3));
				feature.setBedroom(rs.getInt(4));
				feature.setBathroom(rs.getInt(5));
				feature.setElectricityBill(rs.getBoolean(6));
				feature.setArea(rs.getInt(7));
				feature.setWaterTank(rs.getBoolean(8));
				feature.setParking(rs.getBoolean(9));
				feature.setDistFromSchool(rs.getInt(10));
				feature.setDistFromHospital(rs.getInt(11));
				feature.setTerrace(rs.getBoolean(12));
				feature.setVentilation(rs.getBoolean(13));
				feature.setPetsAllowed(rs.getBoolean(14));
				feature.setFloorType(rs.getInt(15));
				feature.setGarden(rs.getBoolean(16));
				property.setPropertyId(rs.getInt(17));
				property.setStatus(new Status(rs.getInt(19)));
				property.setTitle(rs.getString(20));
				property.setAddress(rs.getString(21));
				property.setCity(new City(rs.getInt(22)));
				property.setDescription(rs.getString(23));
				property.setPropertyType(new PropertyType(rs.getInt(24)));
				property.setNoOfPeople(rs.getInt(25));
				property.setThumbnail(rs.getString(26));
				
				feature.setProperty(property);
				
				features.add(feature);
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
		
		
		return features;
	}
	
	
	public boolean savePropertyFeatures() {
		boolean flag = false;
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");

			String	query = "INSERT INTO property_features (property_id,room_count,bedroom,bathroom,"
						+ "electricity_bill,area,water_tank,parking,dist_from_school,dist_from_hospital,"
						+ "terrace,ventilation,pets_allowed,floor_type,garden) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
				
			ps.setInt(1,property.getPropertyId());
			ps.setInt(2,roomCount);
			ps.setInt(3,bedroom);
			ps.setInt(4,bathroom);
			ps.setBoolean(5,electricityBill);
			ps.setInt(6,area);
			ps.setBoolean(7,waterTank);
			ps.setBoolean(8,parking);
			ps.setInt(9,distFromSchool);
			ps.setInt(10,distFromHospital);
			ps.setBoolean(11,terrace);
			ps.setBoolean(12,ventilation);
			ps.setBoolean(13,petsAllowed);
			ps.setInt(14,floorType);
			ps.setBoolean(15,garden);
			
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
	
	public boolean updatePropertyFeatures(int roomCount,int bedroom,int bathroom,boolean electricityBill,int area,boolean waterTank,boolean parking,int distFromSchool,int distFromHospital,boolean terrace,boolean ventilation,boolean petsAllowed,int floorType,boolean garden) {
		boolean flag = false;
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String	query = "UPDATE property_features SET room_count=?,bedroom=?,bathroom=?,"
						+ "electricity_bill=?,area=?,water_tank=?,parking=?,dist_from_school=?,dist_from_hospital=?,"
						+ "terrace=?,ventilation=?,pets_allowed=?,floor_type=?,garden=? WHERE property_id=?";
				
			PreparedStatement	ps = con.prepareStatement(query);
				
			ps.setInt(1,roomCount);
			ps.setInt(2,bedroom);
			ps.setInt(3,bathroom);
			ps.setBoolean(4,electricityBill);
			ps.setInt(5,area);
			ps.setBoolean(6,waterTank);
			ps.setBoolean(7,parking);
			ps.setInt(8,distFromSchool);
			ps.setInt(9,distFromHospital);
			ps.setBoolean(10,terrace);
			ps.setBoolean(11,ventilation);
			ps.setBoolean(12,petsAllowed);
			ps.setInt(13,floorType);
			ps.setBoolean(14,garden);
			ps.setInt(15,property.getPropertyId());
			
			if(ps.executeUpdate()==1) {
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
	
//	Setters & Getters
	
	public int getFeatureId() {
		return featureId;
	}

	public void setFeatureId(int featureId) {
		this.featureId = featureId;
	}
	
	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}


	public int getRoomCount() {
		return roomCount;
	}
	
	public void setRoomCount(int roomCount) {
		this.roomCount = roomCount;
	}
	
	public int getBedroom() {
		return bedroom;
	}
	
	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}
	
	public int getBathroom() {
		return bathroom;
	}
	
	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}
	
	public boolean isElectricityBill() {
		return electricityBill;
	}
	
	public void setElectricityBill(boolean electricityBill) {
		this.electricityBill = electricityBill;
	}
	
	public int getArea() {
		return area;
	}
	
	public void setArea(int area) {
		this.area = area;
	}
	
	public boolean isWaterTank() {
		return waterTank;
	}
	
	public void setWaterTank(boolean waterTank) {
		this.waterTank = waterTank;
	}
	
	public boolean isParking() {
		return parking;
	}
	
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	
	public int getDistFromSchool() {
		return distFromSchool;
	}
	
	public void setDistFromSchool(int distFromSchool) {
		this.distFromSchool = distFromSchool;
	}
	
	public int getDistFromHospital() {
		return distFromHospital;
	}
	
	public void setDistFromHospital(int distFromHospital) {
		this.distFromHospital = distFromHospital;
	}
	
	public boolean isTerrace() {
		return terrace;
	}
	
	public void setTerrace(boolean terrace) {
		this.terrace = terrace;
	}
	
	public boolean isVentilation() {
		return ventilation;
	}
	
	public void setVentilation(boolean ventilation) {
		this.ventilation = ventilation;
	}
	
	public boolean isPetsAllowed() {
		return petsAllowed;
	}
	
	public void setPetsAllowed(boolean petsAllowed) {
		this.petsAllowed = petsAllowed;
	}
	
	public int getFloorType() {
		return floorType;
	}
	
	public void setFloorType(int floorType) {
		this.floorType = floorType;
	}
	
	public boolean isGarden() {
		return garden;
	}
	
	public void setGarden(boolean garden) {
		this.garden = garden;
	}

}