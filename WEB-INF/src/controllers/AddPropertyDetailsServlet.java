package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.Random;

import models.City;
import models.Property;
import models.PropertyFeature;
import models.PropertyType;
import models.User;

public class AddPropertyDetailsServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		String next = "signin.do";
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user!=null) {
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			int cityId = Integer.parseInt(request.getParameter("city"));
			String address = request.getParameter("address");
			int propertyTypeId = Integer.parseInt(request.getParameter("property_type"));
			int eleBill_I = Integer.parseInt(request.getParameter("ele_bill"));
			int bedroom = Integer.parseInt(request.getParameter("bedroom"));
			int bathroom = Integer.parseInt(request.getParameter("bathroom"));
			int room = Integer.parseInt(request.getParameter("room"));
			int area = Integer.parseInt(request.getParameter("area"));
			int dist_school = Integer.parseInt(request.getParameter("dist_school"));
			int dist_hospital = Integer.parseInt(request.getParameter("dist_hospital"));
			int floor_type = Integer.parseInt(request.getParameter("floor_type"));
			String water_tank_I = request.getParameter("water_tank");
			String parking_I = request.getParameter("parking");
			String terrace_I = request.getParameter("terrace");
			String ventilation_I = request.getParameter("ventilation");
			String garden_I = request.getParameter("garden");
			String pets_I = request.getParameter("pets");
			
			boolean eleBill = false;
			boolean water_tank = false;
			boolean parking = false;
			boolean terrace = false;
			boolean ventilation = false;
			boolean garden = false;
			boolean pets = false;
			
			if(eleBill_I == 1) {
				eleBill = true;
			}
			
			if(water_tank_I != null) {
					water_tank = true;
			}		
			
			if(parking_I != null) {
				parking = true;
			}
			
			if(terrace_I != null) {
				terrace = true;
			}
			
			if(ventilation_I != null) {
				ventilation = true;
			}
			
			if(garden_I != null) {
				garden = true;
			}
			
			if(pets_I != null) {
				pets = true;
			}
			
			PropertyType proType = new PropertyType(propertyTypeId);
			City city = new City(cityId); 
			
			Long tag = new Random().nextLong();
			
			if(tag<0) {
				tag = tag*-1;
			}
			
			String proTag = user.getUserId()+"_"+Long.toString(tag);
			
			Property property = new Property(user,proTag,title,address,city,description,proType);
			property.addPropertyDetails();
			
			PropertyFeature feature = new PropertyFeature(property,room,bedroom,bathroom,eleBill,area,water_tank,parking,dist_school,dist_hospital,terrace,ventilation,pets,floor_type,garden);
			feature.savePropertyFeatures();
			
			session.setAttribute("property", property);
			
			session.setAttribute("activeTab","addProperty");
			
			next="dashboard.do";
		}
		
		response.sendRedirect(next);
	}
}
