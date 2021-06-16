<!DOCTYPE html>
<%@page import="com.sun.org.apache.xpath.internal.functions.FuncFloor"%>
<%@page import="models.PropertyFeature"%>
<%@page import="models.User"%>
<%@page import="models.City"%>
<%@page import="models.PropertyType" %>

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
        <div class="container-fluid">
			<div class="row">
				<div class="col-2 left-col">
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
					<div class="right-middle">
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
							                                <select class="form-control" name="city" id="id_city">
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
												<div class="text-center pt-4">
													<button type="submit" class="btn btn-primary font-weight-bold">Update</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane fade <c:if test="${activeTab == 'myProperties'}">active show</c:if>" id="my_properties">
								<div class="display-4 ml-4 pl-2 font-weight-bold mb-3 pt-2" id="dash-text">
									My Properties
								</div>
							</div>
							<div class="tab-pane fade <c:if test="${activeTab == 'addProperty'}">active show</c:if>" id="add_property">
								<div class="display-4 ml-4 pl-2 font-weight-bold mb-5 pt-2" id="dash-text">
									Add Property
								</div>
								<%	PropertyFeature property = (PropertyFeature)session.getAttribute("property");
								if(property != null){ %>
									<div class="hl p-2 mb-3">
										<ul class="nav nav-pills nav-justified ml-5" style="width:25%;">
											<li class="nav-item">
												<a class="nav-link dark-bg dark-hov" href="#details" data-toggle="pill">Details</a>
											</li>
											<li class="nav-item">
												<a class="nav-link dark-bg dark-hov <%if(property != null){ %>active<%} %>" href="#gallery" data-toggle="pill">Gallery</a>
											</li>
										</ul>
									</div>
								<%} %>
									<div class="tab-content">
										<div class="tab-pane fade <%if(property == null){ %>show active<%} %>" id="details">
											<div class="container">
												<div class="row">
													<div class="col px-5">
														<form action="addpropertydetails.do" class="font-weight-bold" method="post">
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Title</label>
																		<input type="text" class="form-control" name="title" value=" <%if(property != null){ %>${property.property.title }<%} %>" autocomplete="off" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Description</label>
																		<textarea class="form-control" name="description" required="required"> <%if(property != null){ %>${property.property.description }<%} %></textarea>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col">		
																	<div class="form-group">
																		<label>City</label>
																		<select class="form-control" name="city" required="required">
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
																		<textarea class="form-control" name="address" required="required"> <%if(property != null){ %>${property.property.address }<%} %></textarea>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Property Type</label>
																		<select class="form-control" class="form-control" name="property_type" required="required">
																		<% ArrayList<PropertyType> types = PropertyType.getAllPropertyTypes(); %>
																			<option value="10">Select</option>
																		
																		<%if(property != null){
																			for(PropertyType type : types){ 
																				if(type.getPropertyTypeId() != property.getProperty().getPropertyType().getPropertyTypeId()){%>
																					<% if(type.getPropertyTypeId()!= PropertyType.NOT_SELECTED){ %>
																						<option value="<%= type.getPropertyTypeId() %>"><%= type.getPropertyType() %></option>
																					<%}}else{%>
																						<option value="<%= type.getPropertyTypeId() %>" selected="selected"><%= type.getPropertyType() %></option>
																				<% }}}else{ %>
																					<% for(PropertyType type : types){ %>
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
																			&nbsp;&nbsp;<input type="radio" name="ele_bill" value="0" <%if(!property.getElectricityBill()){ %>checked="checked"<% }%>>&nbsp;Separate
																			&nbsp;&nbsp;<input type="radio" name="ele_bill" value="1"  <%if(property.getElectricityBill()){ %>checked="checked"<% }%>>&nbsp;Combine
																		<%}else{ %>
																			&nbsp;&nbsp;<input type="radio" name="ele_bill" value="0" checked="checked">&nbsp;Separate
																			&nbsp;&nbsp;<input type="radio" name="ele_bill" value="1">&nbsp;Combine
																		<%} %>
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Bedroom</label>
																		<input type="number" class="form-control" name="bedroom" value="<%if(property != null){ %>${property.bedroom}<%} %>" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Bathroom</label>
																		<input type="number" class="form-control" name="bathroom" value="<%if(property != null){ %>${property.bathroom}<%} %>" required="required">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Room</label>
																		<input type="number" class="form-control" name="room" value="<%if(property != null){ %>${property.roomCount}<%} %>" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Area</label><small>&nbsp;&nbsp;(in sq.m.)</small>
																		<input type="number" class="form-control" name="area" value="<%if(property != null){ %>${property.area}<%} %>" required="required">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Distance From School</label><small>&nbsp;&nbsp;(in KM)</small>
																		<input type="number" class="form-control" name="dist_school" value="<%if(property != null){ %>${property.distFromSchool}<%} %>" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Distance From Hospital</label><small>&nbsp;&nbsp;(in KM)</small>
																		<input type="number" class="form-control" name="dist_hospital" value="<%if(property != null){ %>${property.distFromHospital}<%} %>" required="required">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col-6">
																	<div class="form-group">
																		<label>Floor Type</label>
																		<select class="form-control" class="form-control" name="floor_type" required="required">
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
																		<input type="checkbox" class="custom-control-input" id="tank" name="water_tank">
																		<label class="custom-control-label" for="tank">&nbsp;&nbsp;Water Tank</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="parking" name="parking">
																		<label class="custom-control-label" for="parking">&nbsp;&nbsp;Parking</label>
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="terrace" name="terrace">
																		<label class="custom-control-label" for="terrace">&nbsp;&nbsp;Terrace</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="ventilation" name="ventilation">
																		<label class="custom-control-label" for="ventilation">&nbsp;&nbsp;Ventilation</label>
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="garden" name="garden">
																		<label class="custom-control-label" for="garden">&nbsp;&nbsp;Garden</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="pets" name="pets">
																		<label class="custom-control-label" for="pets">&nbsp;&nbsp;Pets Allowed</label>
																	</div>
																</div>
															</div>

															<div class="text-right pr-2 py-3">
																<button type="submit" class="btn btn-primary font-weight-bold mr-3">Submit</button>
																<a class="btn btn-primary font-weight-bold" href="#gallery" data-toggle="tab">Next</a>
															</div>

														</form>
													</div>
												</div>
											</div>
										</div>
										<div class="tab-pane fade <%if(property != null){ %>show active<%} %>" id="gallery">
											<div class="nav nav-tabs pl-5">
												<a class="nav-link active" data-toggle="tab" href="#exterior">Exterior</a>
												<a class="nav-link" data-toggle="tab" href="#living">Living Room</a>
												<a class="nav-link" data-toggle="tab" href="#bedroom">Bedroom</a>
												<a class="nav-link" data-toggle="tab" href="#kitchen">Kitchen</a>
												<a class="nav-link" data-toggle="tab" href="#dining">Dining Room</a>
												<a class="nav-link" data-toggle="tab" href="#bathroom">Bathroom</a>
												<a class="nav-link" data-toggle="tab" href="#terrace">Terrace</a>
												<a class="nav-link" data-toggle="tab" href="#garden">Garden</a>
											</div>
											
											<div class="tab-content">
												<div class="tab-pane fade show active" id="exterior">1</div>
												<div class="tab-pane fade" id="living">2</div>
												<div class="tab-pane fade" id="bedroom">3</div>
												<div class="tab-pane fade" id="kitchen">4</div>
												<div class="tab-pane fade" id="dining">5</div>
												<div class="tab-pane fade" id="bathroom">6</div>
												<div class="tab-pane fade" id="terrace">7</div>
												<div class="tab-pane fade" id="garden">8</div>
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
	
	<script type="text/javascript">
		Dropzone.autodiscover = false;
		
		Dropzone.options.dpUpload={
			maxFilesize : 2,
			maxFiles : 1,
			addRemoveLinks : true,
			acceptedFiles : ".jpg,.jpeg,.png,.gif",
			autoProcessQueue : false
		};
		
		let dropZone = new Dropzone("#dpUpload",{url:"dpupload.do"});
		
		const dpBtn = document.querySelector("#dp_btn");
		
		dpBtn.addEventListener("click",()=>{
			dropZone.processQueue();
		});
		
		
		
	</script>
</body>
</html>