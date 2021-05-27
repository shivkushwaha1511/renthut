package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class User {
	private int userId;
	private String name;
	private String email;
	private String password;
	private String address;
	private String activationCode;
	private Status statusId;
	private City cityId;
	private int contactNo;
	private String profilePic;
	
	public User() {
		
	}
	
	public User(String name, String email, String password, String address, String activationCode) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.activationCode = activationCode;
	}

	public User(String email, String activationCode) {
		super();
		this.email = email;
		this.activationCode = activationCode;
	}

	public void signUp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "insert into users (name,email,password,address,activation_code) value (?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,name);
			ps.setString(2,email);
			
			StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
			String encryptedPassword = encryptor.encryptPassword(password);
			
			ps.setString(3,encryptedPassword);
			ps.setString(4,address);
			ps.setString(5,activationCode);
			
			ps.executeUpdate();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean activateUser() {
		boolean activate = false;
		int row;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "UPDATE users SET status_id=1,activation_code=NULL WHERE email=? AND activation_code=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,activationCode);
			
			row = ps.executeUpdate();		
			if(row == 1)
				activate = true;
			
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return activate;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
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