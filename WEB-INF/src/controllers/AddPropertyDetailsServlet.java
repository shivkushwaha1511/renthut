package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import javax.servlet.ServletException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import models.City;
import models.Property;
import models.PropertyFeature;
import models.PropertyType;
import models.User;
import utils.PropertyDetails;

public class AddPropertyDetailsServlet extends HttpServlet{
//	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
//		String next = "signin.do";
//		
//		HttpSession session = request.getSession();
//		User user = (User)session.getAttribute("user");
//		
//		if(user!=null) {
//					
//			String title = request.getParameter("title");
//			String description = request.getParameter("description");
//			int cityId = Integer.parseInt(request.getParameter("city"));
//			String address = request.getParameter("address");
//			int propertyTypeId = Integer.parseInt(request.getParameter("property_type"));
//			int eleBill_I = Integer.parseInt(request.getParameter("ele_bill"));
//			int bedroom = Integer.parseInt(request.getParameter("bedroom"));
//			int bathroom = Integer.parseInt(request.getParameter("bathroom"));
//			int room = Integer.parseInt(request.getParameter("room"));
//			int area = Integer.parseInt(request.getParameter("area"));
//			int dist_school = Integer.parseInt(request.getParameter("dist_school"));
//			int dist_hospital = Integer.parseInt(request.getParameter("dist_hospital"));
//			int floor_type = Integer.parseInt(request.getParameter("floor_type"));
//			String water_tank_I = request.getParameter("water_tank");
//			String parking_I = request.getParameter("parking");
//			String terrace_I = request.getParameter("terrace");
//			String ventilation_I = request.getParameter("ventilation");
//			String garden_I = request.getParameter("garden");
//			String pets_I = request.getParameter("pets");
//			
//			boolean eleBill = false;
//			boolean water_tank = false;
//			boolean parking = false;
//			boolean terrace = false;
//			boolean ventilation = false;
//			boolean garden = false;
//			boolean pets = false;
//			
//			if(eleBill_I == 1) {
//				eleBill = true;
//			}
//			
//			if(water_tank_I != null) {
//					water_tank = true;
//			}		
//			
//			if(parking_I != null) {
//				parking = true;
//			}
//			
//			if(terrace_I != null) {
//				terrace = true;
//			}
//			
//			if(ventilation_I != null) {
//				ventilation = true;
//			}
//			
//			if(garden_I != null) {
//				garden = true;
//			}
//			
//			if(pets_I != null) {
//				pets = true;
//			}
//			
//			PropertyType proType = new PropertyType(propertyTypeId);
//			City city = new City(cityId); 
//			
//			Property property = null;
//			PropertyFeature feature = (PropertyFeature)session.getAttribute("property");
//			
//			if(feature!=null) {
//				property = feature.getProperty();
//				if(property.UpdatePropertyDetails(title,address,city,description,proType)) {
//					property.setTitle(title);
//					property.setAddress(address);
//					property.setDescription(description);
//					property.setPropertyType(proType);
//				}
//
//				if(feature.updatePropertyFeatures(room,bedroom,bathroom,eleBill,area,water_tank,parking,dist_school,dist_hospital,terrace,ventilation,pets,floor_type,garden)) {
//					feature.setRoomCount(room);
//					feature.setBedroom(bedroom);
//					feature.setBathroom(bathroom);
//					feature.setElectricityBill(eleBill);
//					feature.setArea(area);
//					feature.setWaterTank(water_tank);
//					feature.setParking(parking);
//					feature.setDistFromSchool(dist_school);
//					feature.setDistFromHospital(dist_hospital);
//					feature.setTerrace(terrace);
//					feature.setVentilation(ventilation);
//					feature.setPetsAllowed(pets);
//					feature.setFloorType(floor_type);
//					feature.setGarden(garden);
//				}
//			}else {
//				property = new Property(user,title,address,city,description,proType);
//				property.addPropertyDetails();
//				
//				feature = new PropertyFeature(property,room,bedroom,bathroom,eleBill,area,water_tank,parking,dist_school,dist_hospital,terrace,ventilation,pets,floor_type,garden);
//				feature.savePropertyFeatures();
//			}
//			
//			session.setAttribute("property", feature);
//			
//			session.setAttribute("activeTab","addProperty");
//			
//			next="dashboard.do";
//		}
//		
//		response.sendRedirect(next);
//	}
//	###################################################################################
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null) {
			
			boolean flag1 = false;
			boolean flag2 = false;
			
			Gson gson = new Gson();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			
			PropertyDetails propdetails = gson.fromJson(br, PropertyDetails.class);
			
			String title = propdetails.getTitle();
			String description = propdetails.getDescription();
			int cityId = propdetails.getCity();
			String address = propdetails.getAddress();
			int propertyTypeId = propdetails.getProperty_type();
			int eleBill_I = propdetails.getEle_bill();
			int bedroom = propdetails.getBedroom();
			int bathroom = propdetails.getBathroom();
			int room = propdetails.getRoom();
			int area = propdetails.getArea();
			int dist_school = propdetails.getDist_school();
			int dist_hospital = propdetails.getDist_hospital();
			int floor_type = propdetails.getFloor_type();
			int water_tank_I = propdetails.getWater_tank();
			int parking_I = propdetails.getParking();
			int terrace_I = propdetails.getTerrace();
			int ventilation_I = propdetails.getVentilation();
			int garden_I = propdetails.getGarden();
			int pets_I = propdetails.getPets();

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
			
			if(water_tank_I == 1) {
					water_tank = true;
			}		
			
			if(parking_I == 1) {
				parking = true;
			}
			
			if(terrace_I == 1) {
				terrace = true;
			}
			
			if(ventilation_I == 1) {
				ventilation = true;
			}
			
			if(garden_I == 1) {
				garden = true;
			}
			
			if(pets_I == 1) {
				pets = true;
			}
			
			PropertyType proType = new PropertyType(propertyTypeId);
			City city = new City(cityId); 
			
			Property property = null;
			PropertyFeature feature = (PropertyFeature)session.getAttribute("property");
			
			if(feature!=null) {
				property = feature.getProperty();
				if(property.UpdatePropertyDetails(title,address,city,description,proType)) {
					property.setTitle(title);
					property.setAddress(address);
					property.setDescription(description);
					property.setPropertyType(proType);
				}

				if(feature.updatePropertyFeatures(room,bedroom,bathroom,eleBill,area,water_tank,parking,dist_school,dist_hospital,terrace,ventilation,pets,floor_type,garden)) {
					feature.setRoomCount(room);
					feature.setBedroom(bedroom);
					feature.setBathroom(bathroom);
					feature.setElectricityBill(eleBill);
					feature.setArea(area);
					feature.setWaterTank(water_tank);
					feature.setParking(parking);
					feature.setDistFromSchool(dist_school);
					feature.setDistFromHospital(dist_hospital);
					feature.setTerrace(terrace);
					feature.setVentilation(ventilation);
					feature.setPetsAllowed(pets);
					feature.setFloorType(floor_type);
					feature.setGarden(garden);
				}
			}else {
				property = new Property(user,title,address,city,description,proType);
				flag1 = property.addPropertyDetails();
				
				feature = new PropertyFeature(property,room,bedroom,bathroom,eleBill,area,water_tank,parking,dist_school,dist_hospital,terrace,ventilation,pets,floor_type,garden);
				flag2 = feature.savePropertyFeatures();
				
				if(flag1 && flag2) {
					System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
					session.setAttribute("property", feature);
					String propertyJson = gson.toJson(feature);
					response.getWriter().print(propertyJson);
				}else {
					response.getWriter().print("failed");					
				}
			}
			
			session.setAttribute("activeTab","addProperty");
					
		}else {
			response.getWriter().print("expired");
		}
	}
}
