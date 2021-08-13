<!DOCTYPE html>
<%@page import="models.TenantType"%>
<%@page import="java.util.Calendar"%>
<%@page import="utils.PropertyDetails"%>
<%@page import="models.Property"%>
<%@page import="models.PropertyFeature"%>
<%@page import="models.User"%>
<%@page import="models.City"%>
<%@page import="models.PropertyType" %>
<%@ page import="models.PropertyPost" %>

<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <%@ include file="headtags.jsp" %>
    <link rel="stylesheet" href="static/css/dropzone.min.css">
    <link rel="stylesheet" href="static/css/dashboard.css">
    <title>Dashboard</title>
</head>

<body>
      
<%--	<%@ include file="header.jsp" --%>
	
    <div class="body">
<%--    		<nav>
    			<ol class="breadcrumb" id="bread-crumb">
    				<li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
    				<li class="breadcrumb-item active">Dashboard</li>
    			</ol>
    		</nav> --%>
    	</div>
        <div class="container-fluid" id="main-body">
			<div class="row">
				<div class="col-2 sticky-top" id="left-col">
					<div class="text-center pt-3">
                            <a href="/renthut"><img src="static/images/logo.png" class="logo"></a>
                    </div>
					<div class="text-center">
						<img src="showdp.do?path=${user.profilePic }" id="dp">
					</div>
					
					<div class="nav flex-column nav-pills mt-4">
						<a class="nav-link <c:if test="${activeTab == 'profile'}">active</c:if>" data-toggle="pill" href="#profile"><i class="fa fa-user mr-2"></i>My Profile</a>
						<a class="nav-link <c:if test="${activeTab == 'myProperties'}">active</c:if>" data-toggle="pill" href="#my_properties"><i class="fa fa-building mr-2"></i>My Properties</a>
						<a class="nav-link <c:if test="${activeTab == 'addProperty'}">active</c:if>" data-toggle="pill" href="#add_property"><i class="fa fa-plus-square mr-2"></i>Add property</a>
					</div>
				</div>
				
				<div class="col-10" style="padding: 0px;">
					<div class="right-top">
						<div class="row">
							<div class="col-9 font-weight-bold pt-3 pl-5 mr-2">
								<a href="http://localhost:8080/renthut/" class="head-link ml-2">Home</a>
								<a href="" class="head-link ml-4">Contact</a>
							</div>
							<%User user = (User)session.getAttribute("user"); %>
							<div class="col-2 pt-2 ml-5">
								<div class="dropdown">
                           			<button class="btn btn-lite dropdown-toggle font-weight-bold text-primary head-link" data-toggle="dropdown"><%= user.getName() %></button>
	                           		<div class="dropdown-menu">
	                           			<a class="dropdown-item" href="dashboard.do"><i class="fa fa-user mr-3"></i>My Profile</a>
	                           			<a class="dropdown-item" href="dashboard.do?activeTabMyProp=myProperties"><i class="fa fa-building mr-3"></i>My Properties</a>
	                           			<a class="dropdown-item" href="dashboard.do?activeTabAddProp=addProperty"><i class="fa fa-plus-square mr-3"></i>Add Listing</a>
	                           			<a class="dropdown-item" href="logout.do"><i class="fa fa-sign-out mr-3"></i>Log Out</a>
                            		</div>
                           		</div>
							</div>
						</div>
					</div>
					<div class="right-middle pb-5">
						<div class="tab-content">
							<div class="tab-pane fade <c:if test="${activeTab == 'profile'}">active show</c:if>" id="profile">
								<div class="display-4 ml-4 pl-2 font-weight-bold mb-3 pt-2" id="dash-text">
									My Profile
								</div>
								<div class="row">
									<div class="col-4">
										<div class="text-center">
											<img src="showdp.do?path=${user.profilePic}" id="dp" style="background-color: #222629;">
										</div>
										<div class="text-center pt-2">
											<button class="btn btn-primary" id="dp_btn">Upload</button>
										</div>
									</div>
									<div class="col-5 pt-5">
										<form class="dropzone" id="dpUpload">
										</form>
									</div>  
								</div>
								<div class="row">
									<div class="col">
										<div class="container px-5">
											<div id="my-detail">My Details</div>
											<form action="completeprofile.do" class=" font-weight-bold" method="post">
												<div class="row">
													<div class="col">
														<div class="form-group">
							                                <label for="">Name</label>
							                                <input value="${user.name}" type="text" class="form-control" name="name" maxlength="50" minlength="3" autocomplete="off" placeholder="Enter your name">
							                            </div>
													</div>
													<div class="col">
														<div class="form-group">
							                                <label for="">Email</label>
							                                <input disabled="disabled" value="${user.email}" id="email_field" type="email" class="form-control" name="email" autocomplete="off" placeholder="Enter your email">
							                            </div>
													</div>
												</div>
												<div class="row">
													<div class="col">
														<div class="form-group">
							                                <label for="">Address</label>
							                                <textarea class="form-control" name="address" placeholder="Enter your address" id="address">${user.address}</textarea>
						                            	</div>
													</div>
													<div class="col">
														<div class="form-group">
							                                <label for="id_city">City</label>
							                                <select class="form-control" name="city">
							                                	<% ArrayList<City> cities = City.getAllCities(); %>
							                                    <option value="1508">Select</option>
							                                    <% for(City city : cities){ 
							                                    	if(user.getCity().getCityId() == city.getCityId() ){ %>
							                                    	<option value="<%= city.getCityId() %>" selected="selected"><%= city.getCity()+" ("+city.getState().getState()+")" %></option>
							                                    <% }else{ %>
							                                    <% if(city.getCityId()!=City.NOT_SELECTED){ %>
							                                    	<option value="<%= city.getCityId() %>"><%= city.getCity()+" ("+city.getState().getState()+")" %></option>
							                                    <% 	}}} %>
							                                </select>
						                            	</div>
													</div>
												</div>
												<div class="row">
													<div class="col">
														<div class="form-group">
						                            		<label>Contact No.</label>
						                            		<input type="text" name="contact" class="form-control" value="${user.contactNo}" autocomplete="off">
						                            	</div>
													</div>
													<div class="col">
													</div>
												</div>
												<div class="text-center pt-4 ">
													<button type="submit" class="btn btn-primary font-weight-bold">Update</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>

							
							<div class="tab-pane fade <c:if test="${activeTab == 'myProperties'}">active show</c:if>" id="my_properties">
								<div id="prop_listing_text" class="display-4 ml-4 pl-2 font-weight-bold mb-5 pt-2 dash-text">
									My Properties
								</div>
								<% ArrayList<PropertyFeature> properties = PropertyFeature.collectAllProperties(user); %>
								<% for(PropertyFeature property : properties){
									int propId = property.getProperty().getPropertyId();
								%>
								<div id="edit_prop_box_<%=propId %>" class="pt-2" style="position: fixed;top: 0;left: 0;background-color: rgba(0,0,0,0.7);height: 100%;width: 100%;z-index: 1;display: none;">
									<div class="bg-light mx-auto mt-5 rounded" style="overflow-y: scroll; width:70%; height:530px;">
										<div class="row">
											<div class="col-5 display-4 ml-4 pl-2 font-weight-bold mb-3 pt-2 dash-text">
												Edit Property
											</div>
											<div class="col-3 text-right ml-auto fixed-top text-light pr-3 pt-3" style="float: right;">
												<i id="btn_<%=propId %>" class="fa fa-times fa-lg btn-close" style="cursor: pointer;"></i>
											</div>
										</div>
										<div class="row">
											<div class="col">
												<div class="pl-5 py-2 mb-3 bg-white">
													<ul class="nav nav-pills">
														<li class="nav-item">
															<a class="nav-link dark-bg dark-hov active" data-toggle="pill" href="#prop-edit-details">Details</a>
														</li>
														<li class="nav-item">
															<a class="nav-link dark-bg dark-hov" data-toggle="pill" href="#prop-edit-photos">Gallery</a>
														</li>
													</ul>
												</div>
												<div class="tab-content">
													<div class="tab-pane fade show active" id="prop-edit-details">
														<div class="col px-5 font-weight-bold">
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Title</label>
																		<input type="text" class="form-control" name="title" id="id_title_<%=propId %>" value="<%= property.getProperty().getTitle() %>" autocomplete="off" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Description</label>
																		<textarea class="form-control" name="description" id="id_description_<%=propId %>" required="required"><%= property.getProperty().getDescription() %></textarea>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col">		
																	<div class="form-group">
																		<label>City</label>
																		<select class="form-control" name="city" id="id_city_<%=propId %>" required="required">
																			<option value="1508">Select</option>
																			<% for(City city : cities){
																				if(city.getCityId()!= property.getProperty().getCity().getCityId()){
																					if(city.getCityId()!=City.NOT_SELECTED){ %>
																						<option value="<%= city.getCityId() %>"><%= city.getCity()+" ("+city.getState().getState()+")" %></option>
																					<% }}else{%>
																						<option value="<%= city.getCityId() %>" selected="selected"><%= city.getCity()+" ("+city.getState().getState()+")" %></option>
																			<% }} %>
																		</select>
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Address</label>
																		<textarea class="form-control" name="address" id="id_address_<%=propId %>" required="required"><%= property.getProperty().getAddress() %></textarea>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Property Type</label>
																		<select class="form-control" class="form-control" id="id_propertyType_<%=propId %>" name="property_type" required="required">
																		<% ArrayList<PropertyType> types = PropertyType.getAllPropertyTypes(); %>
																			<option value="10">Select</option>
																		
																		<%	for(PropertyType type : types){ 
																				if(type.getPropertyTypeId() != property.getProperty().getPropertyType().getPropertyTypeId()){%>
																					<% if(type.getPropertyTypeId()!= PropertyType.NOT_SELECTED){ %>
																						<option value="<%= type.getPropertyTypeId() %>"><%= type.getPropertyType() %></option>
																				<%}}else{%>
																						<option value="<%= type.getPropertyTypeId() %>" selected="selected"><%= type.getPropertyType() %></option>
																				<% }}%>
																		</select>
																	</div>
																</div>
																<div class="col">
																	<div class="form-group pt-4">
																		<label>Electricity Bill:&nbsp;&nbsp;</label>
																			&nbsp;&nbsp;<input type="radio" name="ele_bill" value="0" id="id_electricityBill_<%=propId %>" <%if(!property.isElectricityBill()){ %>checked="checked"<% }%>>&nbsp;Separate
																			&nbsp;&nbsp;<input type="radio" name="ele_bill" value="1" <%if(property.isElectricityBill()){ %>checked="checked"<% }%>>&nbsp;Combine
																	</div>
																</div>
															</div>
				
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Bedroom</label>
																		<input type="number" class="form-control" name="bedroom" id="id_bedroom_<%=propId %>" value="<%= property.getBedroom() %>" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Bathroom</label>
																		<input type="number" class="form-control" name="bathroom" id="id_bathroom_<%=propId %>" value="<%= property.getBathroom() %>" required="required">
																	</div>
																</div>
															</div>
				
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Room</label>
																		<input type="number" class="form-control" name="room" id="id_room_<%=propId %>" value="<%= property.getRoomCount() %>" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Area</label><small>&nbsp;&nbsp;(in sq.m.)</small>
																		<input type="number" class="form-control" name="area" id="id_area_<%=propId %>" value="<%= property.getArea() %>" required="required">
																	</div>
																</div>
															</div>
				
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Distance From School</label><small>&nbsp;&nbsp;(in KM)</small>
																		<input type="number" class="form-control" name="dist_school" id="id_distSchool_<%=propId %>" value="<%= property.getDistFromSchool() %>" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Distance From Hospital</label><small>&nbsp;&nbsp;(in KM)</small>
																		<input type="number" class="form-control" name="dist_hospital" id="id_distHospital_<%=propId %>" value="<%= property.getDistFromHospital() %>" required="required">
																	</div>
																</div>
															</div>
				
															<div class="row">
																<div class="col-6">
																	<div class="form-group">
																		<label>Floor Type</label>
																		<select class="form-control" class="form-control" name="floor_type" id="id_floorType_<%=propId %>" required="required">
																			<option value="1" <%if(property.getFloorType() == 1){ %>${selected="selected"}<%} %>>Marbel</option>
																			<option value="2" <%if(property.getFloorType() == 2){ %>${selected="selected"}<%} %>>Tiled</option>
																			<option value="3" <%if(property.getFloorType() == 3){ %>${selected="selected"}<%} %>>Cemented</option>
																		</select>
																	</div>
																</div>
															</div>
															<div class="feature-text pl-2 mb-3 ml-2">
																More Features :
															</div>
				
															<div class="row">
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_waterTank_<%=propId %>" <%if(property.isWaterTank()){ %>checked<%} %> name="water_tank">
																		<label class="custom-control-label" for="id_waterTank">&nbsp;&nbsp;Water Tank</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_parking_<%=propId %>" <%if(property.isParking()){ %>checked<%} %> name="parking">
																		<label class="custom-control-label" for="id_parking">&nbsp;&nbsp;Parking</label>
																	</div>
																</div>
															</div>
				
															<div class="row">
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_terrace_<%=propId %>" <%if(property.isTerrace()){ %>checked<%} %> name="terrace">
																		<label class="custom-control-label" for="id_terrace">&nbsp;&nbsp;Terrace</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_ventilation_<%=propId %>" <%if(property.isVentilation()){ %>checked<%} %> name="ventilation">
																		<label class="custom-control-label" for="id_ventilation">&nbsp;&nbsp;Ventilation</label>
																	</div>
																</div>
															</div>
				
															<div class="row">
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_garden_<%=propId %>" <%if(property.isGarden()){ %>checked<%} %> name="garden">
																		<label class="custom-control-label" for="id_garden">&nbsp;&nbsp;Garden</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_pets_<%=propId %>" <%if(property.isPetsAllowed()){ %>checked<%} %> name="pets">
																		<label class="custom-control-label" for="id_pets">&nbsp;&nbsp;Pets Allowed</label>
																	</div>
																</div>
															</div>
															
															<div class="row pt-4 pb-4 px-3">
																<div class="col-7 text-right pr-5">
																	<button id="id_updtbtn_<%= propId%>" class="btn btn-primary font-weight-bold updtBtn">Update</button>
																</div>
																<div class="col-5 text-right">
																</div>
															</div>
														</div>
													</div>
													<div class="tab-pane fade" id="prop-edit-photos">
														<div class="card-columns px-3 pb-3">
														<% ArrayList<String> pics = property.collectAllPropPics(); 
															for(String pic : pics){
														%>
															<img src="showpropimg.do?path=<%= pic %>">
														<%} %>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div id="remove_prop_box_<%=propId %>" class="modal fade">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<h1 class="modal-title">Are You Sure?</h1>
												<button type="button" class="close" data-dismiss="modal">
													<span>&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<p>This is irreversible step,once done can't be rolled back</p>
											</div>
											<div class="modal-footer">
												<a href="removeprop.do?id=<%=propId %>" class="btn btn-danger">Yes</a>
        										<button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
											</div>
										</div>
									</div>
								</div>
							
								<div class="modal fade" id="post_box_<%=propId %>">
									<div class="modal-dialog modal-lg">
										<div class="modal-content">
										<%PropertyPost post = PropertyPost.getPost(propId); %>
											<form action="post.do">
												<input type="hidden" name="propId" value="<%=propId %>">
												<div class="modal-header">
													<h1 class="modal-title"><%=property.getProperty().getTitle() %></h1>
													<div class="custom-control custom-switch mt-3" style="margin-left:310px;">
														<input type="checkbox" name="status" class="custom-control-input" id="id_status_<%=propId %>" <%if(post.getStatus()!=null && post.getStatus().getStatusId()==1){ %>checked<%} %>>
														<label class="text-primary custom-control-label font-weight-bold" for="id_status_<%=propId %>" style="font-size: 18px;">&nbsp;Status</label>
													</div>	
													<button type="button" class="close" data-dismiss="modal">
											          <span>&times;</span>
											        </button>
												</div>
												<div class="modal-body">
													<div class="row px-4">
														<div class="col">
															<div class="form-check">
																<input name="markFill" class="form-check-input" type="checkbox" id="archive">
																<label class="form-check-label" for="archive">
																	Mark As Filled
																</label>
															</div>
														</div>
													</div>
													<div class="container mt-4">
														<div class="row">
															<div class="col">
																<div class="form-group">
																	<label>Rent</label>
																	<input name="rent" class="form-control" type="text" value="<%= post.getRent()%>">
																</div>
															</div>
															<div class="col">
																<div class="form-group">
																	<label>Tenant Type</label>
																	<select class="form-control" name="tenantType">
																		<option value="5">Select</option>
																		<%ArrayList<TenantType> tenantTypes = TenantType.getAllTenantType();
																			for(TenantType tenantType:tenantTypes){
																				if(post.getTenantType().getTenantTypeId()==tenantType.getTenantTypeId()){%>
																					<option value="<%= tenantType.getTenantTypeId()%>" selected><%=tenantType.getTenantType() %></option>
																				<%}else{ %>
																					<option value="<%= tenantType.getTenantTypeId()%>"><%=tenantType.getTenantType() %></option>
																			<%}} %>
																	</select>
																</div>
															</div>
														</div>
														<div class="row">
															<div class="col">
																<div class="form-group">
																	<label>Start Date:</label>
																	<input class="form-control" type="date" disabled="disabled" value="<%= post.getStartDate()%>">
																</div>
															</div>
															<div class="col">
																<div class="form-group">
																	<label>End Date:</label>
																	<% Calendar cal = Calendar.getInstance();
																		cal.setTime(post.getEndDate());
																	%>
																	<input name="endDate" class="form-control" type="date" <% if(cal.get(Calendar.YEAR)!=2000){%>value="<%=post.getEndDate()%>"<%} %>>
																</div>
															</div>
														</div>
													</div>
												</div>
												
												<div class="modal-footer">
													<button type="submit" class="btn btn-success mx-auto">Post</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							
								<div id="prop_listing_box">
									<div style="padding: 0px 100px;">
										<div class="card mt-5 ml-5 shadow" style="border-bottom-right-radius: 30px;border-top-left-radius: 30px;">
											<div class="row">
												<div class="col-4">
													<img src="showpropimg.do?path=<%=property.getProperty().getThumbnail() %>" width="280px" height="210px" style="border-top-left-radius: 30px;">
												</div>
												<div class="col-8">
													<div class="card-body">
														<div class="row">
															<div class="col-8">
																<h2 class="card-title"><%= property.getProperty().getTitle() %></h2>
																<p class="card-text"><%= property.getProperty().getTitle().substring(0,10)%>....</p>
																<p class="card-text"><i class="fa fa-map-marker fa-lg"></i>&nbsp;&nbsp;<%= property.getProperty().getAddress() %></p>														
															</div>
															<div class="col-4 pt-3">
																<button id="view_records" class="btn btn-primary">View Records</button>
															</div>
														</div>
													</div>
													<div class="text-right mr-5 mb-3">
														<button id="id_<%=propId %>" class="btn btn-primary mr-2 btn_prop_edit">Edit</button>
														<button class="btn btn-success mr-2" data-toggle="modal" data-target="#post_box_<%=propId %>">Post</button>
														<button data-toggle="modal" data-target="#remove_prop_box_<%=propId %>" class="btn btn-danger">Remove</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="pt-3" id="prop_records_box" style="display:none;">
										<i id="record_back_btn" class="fa fa-chevron-circle-left fa-3x ml-3 mr-2"></i>
										<div class="display-4 font-weight-bold mb-5 pt-2 dash-text" style="display:inline;">
											Records
										</div>
										<div class="px-5 pt-5">
											<table class="table">
												<thead>
													<tr>
														<th>Sr. No.</th>
														<th>Tenant Name</th>
														<th>Tenant Address</th>
														<th>Visit Date</th>
														<th>Leave Date</th>
														<th>Status</th>
													</tr>
												</thead>
												<tbody>
													
												</tbody>
											</table>
										</div>
									</div>
								<%} %>
							</div>
							
							<div class="tab-pane fade <c:if test="${activeTab == 'addProperty'}">active show</c:if>" id="add_property">
								<div class="display-4 ml-4 pl-2 font-weight-bold mb-5 pt-2">
									<div class="row">
										<div class="col">
											Add Property
										</div>
										<div class="col text-right">
											<a class="btn btn-primary mr-5" href="endsession.do"><i class="fa fa-plus mr-2"></i>New Property</a>
										</div>
									</div>
									<div class="mt-1" id="dash-text"></div>
								</div>
								<% PropertyFeature property = (PropertyFeature)session.getAttribute("property"); %>
									<div class="hl p-2 mb-3" <%if(property == null){ %>style="display: none;"<%} %> id="prop_bar">
										<ul class="nav nav-pills nav-justified ml-5" style="width:25%;">
											<li class="nav-item">
												<a class="nav-link dark-bg dark-hov" href="#details" data-toggle="pill" id="details_pill">Details</a>
											</li>
											<li class="nav-item">
												<a class="nav-link dark-bg dark-hov <%if(property != null){ %>active<%} %>" href="#gallery" data-toggle="pill" id="gallery_pill">Gallery</a>
											</li>
										</ul>
									</div>
									
									<div class="tab-content">
										<div class="tab-pane fade <%if(property == null){ %>show active<%} %>" id="details">
											<div class="container">
												<div class="row">
													<div class="col px-5 font-weight-bold">
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Title</label>
																		<input type="text" class="form-control" name="title" id="id_title" value=" <%if(property != null){ %>${property.property.title }<%} %>" autocomplete="off" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Description</label>
																		<textarea class="form-control" name="description" id="id_description" required="required"> <%if(property != null){ %>${property.property.description }<%} %></textarea>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col">		
																	<div class="form-group">
																		<label>City</label>
																		<select class="form-control" name="city" id="id_city" required="required">
																			<option value="1508">Select</option>
																			 <%if(property != null){ %>
																			<% for(City city : cities){
																				if(city.getCityId()!= property.getProperty().getCity().getCityId()){
																					if(city.getCityId()!=City.NOT_SELECTED){ %>
																						<option value="<%= city.getCityId() %>"><%= city.getCity()+" ("+city.getState().getState()+")" %></option>
																					<% }}else{%>
																						<option value="<%= city.getCityId() %>" selected="selected"><%= city.getCity()+" ("+city.getState().getState()+")" %></option>
																			<% }}}else{ %>
																				<% for(City city : cities){%>
																					<% if(city.getCityId()!=City.NOT_SELECTED){ %>
																						<option value="<%= city.getCityId() %>"><%= city.getCity()+" ("+city.getState().getState()+")" %></option>
																					<% }} %>
																			<%} %>
																		</select>
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Address</label>
																		<textarea class="form-control" name="address" id="id_address" required="required"> <%if(property != null){ %>${property.property.address }<%} %></textarea>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Property Type</label>
																		<select class="form-control" class="form-control" id="id_propertyType" name="property_type" required="required">
																		<% ArrayList<PropertyType> proptypes = PropertyType.getAllPropertyTypes(); %>
																			<option value="10">Select</option>
																		
																		<%if(property != null){
																			for(PropertyType type : proptypes){ 
																				if(type.getPropertyTypeId() != property.getProperty().getPropertyType().getPropertyTypeId()){%>
																					<% if(type.getPropertyTypeId()!= PropertyType.NOT_SELECTED){ %>
																						<option value="<%= type.getPropertyTypeId() %>"><%= type.getPropertyType() %></option>
																					<%}}else{%>
																						<option value="<%= type.getPropertyTypeId() %>" selected="selected"><%= type.getPropertyType() %></option>
																				<% }}}else{ %>
																					<% for(PropertyType type : proptypes){ %>
																						<% if(type.getPropertyTypeId()!= PropertyType.NOT_SELECTED){ %>
																							<option value="<%= type.getPropertyTypeId() %>"><%= type.getPropertyType() %></option>
																						<%}} %>
																				<%} %>
																		</select>
																	</div>
																</div>
																<div class="col">
																	<div class="form-group pt-4">
																		<label>Electricity Bill:&nbsp;&nbsp;</label>
																		<%if(property != null){ %>
																			&nbsp;&nbsp;<input type="radio" name="ele_bill" value="0" id="id_electricityBill" <%if(!property.isElectricityBill()){ %>checked="checked"<% }%>>&nbsp;Separate
																			&nbsp;&nbsp;<input type="radio" name="ele_bill" value="1" <%if(property.isElectricityBill()){ %>checked="checked"<% }%>>&nbsp;Combine
																		<%}else{ %>
																			&nbsp;&nbsp;<input type="radio" name="ele_bill" id="id_electricityBill" value="0" checked>&nbsp;Separate
																			&nbsp;&nbsp;<input type="radio" name="ele_bill" value="1">&nbsp;Combine
																		<%} %>
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Bedroom</label>
																		<input type="number" class="form-control" name="bedroom" id="id_bedroom" value="<%if(property != null){ %>${property.bedroom}<%} %>" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Bathroom</label>
																		<input type="number" class="form-control" name="bathroom" id="id_bathroom" value="<%if(property != null){ %>${property.bathroom}<%} %>" required="required">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Room</label>
																		<input type="number" class="form-control" name="room" id="id_room" value="<%if(property != null){ %>${property.roomCount}<%} %>" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Area</label><small>&nbsp;&nbsp;(in sq.m.)</small>
																		<input type="number" class="form-control" name="area" id="id_area" value="<%if(property != null){ %>${property.area}<%} %>" required="required">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Distance From School</label><small>&nbsp;&nbsp;(in KM)</small>
																		<input type="number" class="form-control" name="dist_school" id="id_distSchool" value="<%if(property != null){ %>${property.distFromSchool}<%} %>" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Distance From Hospital</label><small>&nbsp;&nbsp;(in KM)</small>
																		<input type="number" class="form-control" name="dist_hospital" id="id_distHospital" value="<%if(property != null){ %>${property.distFromHospital}<%} %>" required="required">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col-6">
																	<div class="form-group">
																		<label>Floor Type</label>
																		<select class="form-control" class="form-control" name="floor_type" id="id_floorType" required="required">
																			<option value="4" <%if(property == null){ %>${selected="selected"}<%} %>>Select</option>
																			<option value="1" <%if(property != null && property.getFloorType() == 1){ %>${selected="selected"}<%} %>>Marbel</option>
																			<option value="2" <%if(property != null && property.getFloorType() == 2){ %>${selected="selected"}<%} %>>Tiled</option>
																			<option value="3" <%if(property != null && property.getFloorType() == 3){ %>${selected="selected"}<%} %>>Cemented</option>
																		</select>
																	</div>
																</div>
															</div>
															<div class="feature-text pl-2 mb-3 ml-2">
																More Features :
															</div>

															<div class="row">
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_waterTank" <%if(property != null && property.isWaterTank()){ %>checked<%} %> name="water_tank">
																		<label class="custom-control-label" for="id_waterTank">&nbsp;&nbsp;Water Tank</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_parking" <%if(property != null && property.isParking()){ %>checked<%} %> name="parking">
																		<label class="custom-control-label" for="id_parking">&nbsp;&nbsp;Parking</label>
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_terrace" <%if(property != null && property.isTerrace()){ %>checked<%} %> name="terrace">
																		<label class="custom-control-label" for="id_terrace">&nbsp;&nbsp;Terrace</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_ventilation" <%if(property != null && property.isVentilation()){ %>checked<%} %> name="ventilation">
																		<label class="custom-control-label" for="id_ventilation">&nbsp;&nbsp;Ventilation</label>
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_garden" <%if(property != null && property.isGarden()){ %>checked<%} %> name="garden">
																		<label class="custom-control-label" for="id_garden">&nbsp;&nbsp;Garden</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="id_pets" <%if(property != null && property.isPetsAllowed()){ %>checked<%} %> name="pets">
																		<label class="custom-control-label" for="id_pets">&nbsp;&nbsp;Pets Allowed</label>
																	</div>
																</div>
															</div>
															
															<div class="row pt-4 pb-4 px-3">
																<div class="col-7 text-right pr-5">
																	<button id="id_updtBtn" class="btn btn-primary font-weight-bold">Submit</button>
																</div>
																<div class="col-5 text-right">
																<%--	<button id="id_nextBtn" class="btn btn-primary font-weight-bold">Next</button> --%>
																</div>
															</div>
													</div>
												</div>
											</div>
										</div>
										<div class="tab-pane fade <%if(property != null){ %>show active<%} %>" id="gallery">
											<div id="thumbnail_box">
												<div class="ml-5 pl-3 mt-5" style="width:30%; border-bottom:3px solid rgb(0,123,255)">
													<h3>Upload Thumbnail</h3>
												</div>
												<div class="p-5">
													<form class="dropzone" id="thumb_upload">
													</form>
												</div>
												<div class="row text-left mt-1 px-5">
													<div class="col-7 text-right pr-5">
														<button class="btn btn-primary" id="thumb_upload">Upload</button>
													</div>
													<div class="col-5 text-right">
														<button class="btn btn-primary" id="thumb_next">Next</button>
													</div>
												</div>
											</div>
											
											<div id="property_pics_box" style="display:none;">
												<div class="nav nav-tabs pl-5">
													<a class="nav-link active" data-toggle="tab" href="#id_exterior">Exterior</a>
													<a class="nav-link" data-toggle="tab" href="#id_living">Living Room</a>
													<a class="nav-link" data-toggle="tab" href="#id_bedRoom">Bedroom</a>
													<a class="nav-link" data-toggle="tab" href="#id_kitchen">Kitchen</a>
													<a class="nav-link" data-toggle="tab" href="#id_dining">Dining Room</a>
													<a class="nav-link" data-toggle="tab" href="#id_bathRoom">Bathroom</a>
													<a class="nav-link" data-toggle="tab" href="#id_Terrace">Terrace</a>
													<a class="nav-link" data-toggle="tab" href="#id_Garden">Garden</a>
												</div>
											
												<div class="tab-content">
													<div class="tab-pane fade show active" id="id_exterior">
														<div class="p-5">
															<form class="dropzone pic" id="picup_exterior">
															</form>
														</div>
														<div class="col-7 text-left mt-4" style="float: right">
															<button class="btn btn-primary" id="btn_exterior">Upload</button>
														</div>
													</div>
													<div class="tab-pane fade" id="id_living">
														<div class="p-5">
															<form class="dropzone pic" id="picup_living">
															</form>
														</div>
														<div class="col-7 text-left mt-4" style="float: right">
															<button class="btn btn-primary" id="btn_living">Upload</button>
														</div>
													</div>
													<div class="tab-pane fade" id="id_bedRoom">
														<div class="p-5">
															<form class="dropzone pic" id="picup_bedroom">
															</form>
														</div>
														<div class="col-7 text-left mt-4" style="float: right">
															<button class="btn btn-primary" id="btn_bedroom">Upload</button>
														</div>
													</div>
													<div class="tab-pane fade" id="id_kitchen">
														<div class="p-5">
															<form class="dropzone pic" id="picup_kitchen">
															</form>
														</div>
														<div class="col-7 text-left mt-4" style="float: right">
															<button class="btn btn-primary" id="btn_kitchen">Upload</button>
														</div>
													</div>
													<div class="tab-pane fade" id="id_dining">
														<div class="p-5">
															<form class="dropzone pic" id="picup_dining">
															</form>
														</div>
														<div class="col-7 text-left mt-4" style="float: right">
															<button class="btn btn-primary" id="btn_dining">Upload</button>
														</div>
													</div>
													<div class="tab-pane fade" id="id_bathRoom">
														<div class="p-5">
															<form class="dropzone pic" id="picup_bathroom">
															</form>
														</div>
														<div class="col-7 text-left mt-4" style="float: right">
															<button class="btn btn-primary" id="btn_bathroom">Upload</button>
														</div>
													</div>
													<div class="tab-pane fade" id="id_Terrace">
														<div class="p-5">
															<form class="dropzone pic" id="picup_terrace">
															</form>
														</div>
														<div class="col-7 text-left mt-4" style="float: right">
															<button class="btn btn-primary" id="btn_terrace">Upload</button>
														</div>
													</div>
													<div class="tab-pane fade" id="id_Garden">
														<div class="p-5">
															<form class="dropzone pic" id="picup_garden">
															</form>
														</div>
														<div class="col-7 text-left mt-4" style="float: right">
															<button class="btn btn-primary" id="btn_garden">Upload</button>
														</div>
													</div>
												</div>
																																			
												<div class="row text-left mt-4 px-4">
													<div class="col-4">
														<button class="btn btn-primary" id="pic_next">Previous</button>
													</div>
												</div>
											</div>
										</div>
									</div>	
							</div>
						</div>
					</div>
					
				<% session.setAttribute("activeTab",null); %>
				</div>
			</div>
        </div>

	<script type="text/javascript" src="static/js/dropzone.min.js"></script>
	<script type="text/javascript" src="static/js/dashboard.js"></script>
	
 	<script type="text/javascript">
		Dropzone.autodiscover = false;
		
		Dropzone.options.dpUpload={
			maxFilesize : 2,
			maxFiles : 1,
			addRemoveLinks : true,
			acceptedFiles : ".jpg,.jpeg,.png,.gif",
			autoProcessQueue : false
		};
		
		let dpDropZone = new Dropzone("#dpUpload",{url:"dpupload.do"});
		
		const dpBtn = document.querySelector("#dp_btn");
		
		dpBtn.addEventListener("click",()=>{
			dpDropZone.processQueue();
		});	
		
		/* ******************************************** */
		Dropzone.autodiscover = false;
		
		Dropzone.options.thumb_upload = {
				maxFilesize : 2,
				maxFiles : 1,
				addRemoveLinks : true,
				acceptedFiles : ".jpg,.jpeg,.png,.gif",
				autoProcessQueue : false
		};
		
		let thumbDropZone = new Dropzone("#thumb_upload",{url:"thumbupload.do"});
		
		//const thumb_upload = document.querySelector("#thumb_upload"); already in js
		
		thumb_upload.addEventListener("click",()=>{
			thumbDropZone.processQueue();
		});
		
		/* ******************************************************* */
		const pic_types = document.querySelectorAll(".pic");
		
		pic_types.forEach((type,count)=>{
			Dropzone.autodiscover = false;
			
			Dropzone.options[type.id] = {
					maxFilesize : 2,
					maxFiles : 3,
					addRemoveLinks : true,
					acceptedFiles : ".jpg,.jpeg,.png,.gif",
					autoProcessQueue : false
			};
			
			count++;
			
			let picDropzone = new Dropzone("#"+type.id,{url:"picsupload.do?picTypeId="+count});
			
			const btn = document.querySelector("#btn_"+type.id.substring(6));
			btn.dz = picDropzone;
			
			btn.addEventListener("click",(event)=>{
				event.target.dz.processQueue();
			});
		});
		
	</script> 
</body>
</html>