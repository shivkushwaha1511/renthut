package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TenantType {
	private int tenantTypeId;
	private String tenantType;
	
	public TenantType() {
		
	}
	
	public TenantType(int tenantTypeId,String tenantType) {
		this.tenantTypeId = tenantTypeId;
		this.tenantType = tenantType;
	}
	
	public TenantType(int tenantTypeId) {
		this.tenantTypeId = tenantTypeId;
	}
	
	public static ArrayList<TenantType> getAllTenantType(){
		ArrayList<TenantType> types = new ArrayList<TenantType>();
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/renthut?user=root&password=1234");
			
			String query = "SELECT * FROM tenant_types WHERE tenant_type_id BETWEEN 1 AND 4";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				types.add(new TenantType(rs.getInt(1),rs.getString(2)));
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
	
	public int getTenantTypeId() {
		return tenantTypeId;
	}
	
	public void setTenantTypeId(int tenantTypeId) {
		this.tenantTypeId = tenantTypeId;
	}
	
	public String getTenantType() {
		return tenantType;
	}
	
	public void setTenantType(String tenantType) {
		this.tenantType = tenantType;
	}
}