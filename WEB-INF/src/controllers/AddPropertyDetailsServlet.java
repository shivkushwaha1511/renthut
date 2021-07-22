package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import models.City;
import models.MediaType;
import models.Property;
import models.PropertyFeature;
import models.PropertyType;
import models.User;
import utils.PropertyDetails;

public class AddPropertyDetailsServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null) {
			
			boolean flag1 = false;
			boolean flag2 = false;
			
			Gson gson = new Gson();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			
			PropertyDetails propdetails = gson.fromJson(br, PropertyDetails.class);
			
			int id = propdetails.getId();
			String title = propdetails.getTitle();
			String description = propdetails.getDescription();
			int cityId = propdetails.getCity();
			String address = propdetails.getAddress();
			int propertyTypeId = propdetails.getProperty_type();
			boolean eleBill = propdetails.getEle_bill();
			int bedroom = propdetails.getBedroom();
			int bathroom = propdetails.getBathroom();
			int room = propdetails.getRoom();
			int area = propdetails.getArea();
			int dist_school = propdetails.getDist_school();
			int dist_hospital = propdetails.getDist_hospital();
			int floor_type = propdetails.getFloor_type();
			boolean water_tank = propdetails.getWater_tank();
			boolean parking = propdetails.getParking();
			boolean terrace = propdetails.getTerrace();
			boolean ventilation = propdetails.getVentilation();
			boolean garden = propdetails.getGarden();
			boolean pets = propdetails.getPets();

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
				response.getWriter().print("Updated");
				
				session.setAttribute("activeTab","addProperty");
			}else if(id != 0) {
				property = new Property(user,title,address,city,description,proType);
				property.setPropertyId(id);
				property.UpdatePropertyDetails(title,address,city,description,proType);
				
				feature = new PropertyFeature(property,room,bedroom,bathroom,eleBill,area,water_tank,parking,dist_school,dist_hospital,terrace,ventilation,pets,floor_type,garden);
				feature.updatePropertyFeatures(room,bedroom,bathroom,eleBill,area,water_tank,parking,dist_school,dist_hospital,terrace,ventilation,pets,floor_type,garden);
			}else {
				
				property = new Property(user,title,address,city,description,proType);
				flag1 = property.addPropertyDetails();
				
				feature = new PropertyFeature(property,room,bedroom,bathroom,eleBill,area,water_tank,parking,dist_school,dist_hospital,terrace,ventilation,pets,floor_type,garden);
				flag2 = feature.savePropertyFeatures();
				
				if(flag1 && flag2) {
					session.setAttribute("property", feature);
					
					ServletContext context = request.getServletContext();
					String parentpath = context.getRealPath("/WEB-INF/uploads");
					
					File file = new File(parentpath+"/"+user.getEmail(),property.getPropertyId()+"_"+title);
					file.mkdir();
					
					for(int i=0;i<8;i++) {
						new File(parentpath+"/"+user.getEmail()+"/"+property.getPropertyId()+"_"+title,MediaType.TYPES[i]).mkdir();
					}
					
					String propertyJson = gson.toJson(feature);
					response.getWriter().print(propertyJson);
				}else {
					response.getWriter().print("failed");					
				}
				
				session.setAttribute("activeTab","addProperty");
			}
					
		}else {
			response.getWriter().print("expired");
		}
	}
}
