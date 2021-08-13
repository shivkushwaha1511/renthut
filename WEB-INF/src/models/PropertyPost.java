package models;

import java.sql.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PropertyPost {
	private int postId;
	private Property property;
	private User user;
	private int rent;
	private Status status;
	private Date startDate;
	private Date endDate;
	private TenantType tenantType;
	
	public PropertyPost() {
		
	}
	
	public PropertyPost(Property property,User user,int rent,Date endDate,TenantType tenantType) {
		this.property = property;
		this.user = user;
		this.rent = rent;
		this.endDate = endDate;
		this.tenantType = tenantType;
	}
	
//	public static void removePost(int propertyId) {
//		Connection con = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
//			
//			String query = "UPDATE property_posts SET status_id=3 WHERE property_id=? AND status_id=1"; 
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setInt(1, propertyId);
//			
//			ps.executeUpdate();
//			
//		}catch(SQLException|ClassNotFoundException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				con.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	public static PropertyPost getPost(int postId) {
		PropertyPost post = new PropertyPost();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "SELECT post_id,rent,status_id,start_date,end_date,tenant_type_id FROM property_posts WHERE (property_id=?) AND (status_id=1 OR status_id=2)";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, postId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				post.setPostId(rs.getInt(1));
				post.setRent(rs.getInt(2));
				post.setStatus(new Status(rs.getInt(3)));
				post.setStartDate(rs.getDate(4));
				post.setEndDate(rs.getDate(5));
				post.setTenantType(new TenantType(rs.getInt(6)));
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
		
		if(post.tenantType==null) {
			post.setTenantType(new TenantType());
		}
		
		if(post.endDate == null) {
			String	date = "2000-01-01";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			java.util.Date OendDate = null;
			try {
				OendDate = format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			post.endDate = new Date(OendDate.getTime());
		}
		
		return post;
	}
	
	public void updatePost() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "UPDATE property_posts SET status_id=?,rent=?,end_date=?,tenant_type_id=? WHERE post_id=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, status.getStatusId());
			ps.setInt(2, rent);
			ps.setDate(3, endDate);
			ps.setInt(4, tenantType.getTenantTypeId());
			ps.setInt(5, postId);
			
			ps.executeUpdate();
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void savePost() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "INSERT INTO property_posts (property_id,user_id,rent,end_date,tenant_type_id) VALUE (?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, property.getPropertyId());
			ps.setInt(2, user.getUserId());
			ps.setInt(3, rent);
			ps.setDate(4, endDate);
			ps.setInt(5, tenantType.getTenantTypeId());
			
			if(ps.executeUpdate()==1) {
				ResultSet rs = ps.getGeneratedKeys();
				
				if(rs.next()) {
					this.postId = rs.getInt(1); 
				}
			}
			
		}catch(SQLException|ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public int getPostId() {
		return postId;
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public Property getProperty() {
		return property;
	}
	
	public void setProperty(Property property) {
		this.property = property;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getRent() {
		return rent;
	}
	
	public void setRent(int rent) {
		this.rent = rent;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public TenantType getTenantType() {
		return tenantType;
	}
	
	public void setTenantType(TenantType tenantType) {
		this.tenantType = tenantType;
	}
}