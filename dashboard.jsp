<!DOCTYPE html>
<%@page import="models.User"%>
<%@page import="models.City"%>
<%@page import="models.PropertyType" %>

<%@ page import="java.util.ArrayList" %>
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
						<a class="nav-link active" data-toggle="pill" href="#profile">My Profile</a>
						<a class="nav-link" data-toggle="pill" href="#my_properties">My Properties</a>
						<a class="nav-link" data-toggle="pill" href="#add_property">Add property</a>
					</div>
				</div>
				
				<div class="col-10" style="padding: 0px;">
					<div class="right-top"></div>
					<div class="right-middle">
						<div class="display-4 ml-4 pl-2 font-weight-bold mb-3 pt-2" id="dash-text">
							Dashboard
						</div>
						<div class="tab-content">
							<div class="tab-pane fade active show" id="profile">
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
							                                	<% ArrayList<City> cities = City.getAllCities(); 
							                                		User user = (User)session.getAttribute("user");
							                                	%>
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
							<div class="tab-pane fade" id="my_properties"><h1>B</h1></div>
							<div class="tab-pane fade" id="add_property">
									<div class="hl p-2 mb-3">
										<ul class="nav nav-pills nav-justified ml-5" style="width:25%;">
											<li class="nav-item">
												<a class="nav-link active dark-bg dark-hov" href="#details" data-toggle="pill">Details</a>
											</li>
											<li class="nav-item">
												<a class="nav-link dark-bg dark-hov" href="#gallery" data-toggle="pill">Gallery</a>
											</li>
										</ul>
									</div>
									
									<div class="tab-content">
										<div class="tab-pane fade show active" id="details">
											<div class="container">
												<div class="row">
													<div class="col px-5">
														<form action="addpropertydetails.do" class="font-weight-bold" method="post">
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Title</label>
																		<input type="text" class="form-control" name="title" autocomplete="off" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Description</label>
																		<textarea class="form-control" name="description" required="required"></textarea>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col">		
																	<div class="form-group">
																		<label>City</label>
																		<select class="form-control" name="city" required="required">
																			<option value="1508">Select</option>
																			<% for(City city : cities){%>
																			<% if(city.getCityId()!=City.NOT_SELECTED){ %>
																				<option value="<%= city.getCityId() %>"><%= city.getCity()+" ("+city.getState().getState()+")" %></option>
																			<% }} %>
																		</select>
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Address</label>
																		<textarea class="form-control" name="address" required="required"></textarea>
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
																		<% for(PropertyType type : types){ %>
																		<% if(type.getPropertyTypeId()!= PropertyType.NOT_SELECTED){ %>
																			<option value="<%= type.getPropertyTypeId() %>"><%= type.getPropertyType() %></option>
																		<%}} %>
																		</select>
																	</div>
																</div>
																<div class="col">
																	<div class="form-group pt-4">
																		<label>Electricity Bill:&nbsp;&nbsp;</label>
																		&nbsp;&nbsp;<input type="radio" name="ele_bill" value="0" checked="checked">&nbsp;Separate
																		&nbsp;&nbsp;<input type="radio" name="ele_bill" value="1">&nbsp;Combine
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Bedroom</label>
																		<input type="number" class="form-control" name="bedroom" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Bathroom</label>
																		<input type="number" class="form-control" name="bathroom" required="required">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Room</label>
																		<input type="number" class="form-control" name="room" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Area</label><small>&nbsp;&nbsp;(in sq.m.)</small>
																		<input type="number" class="form-control" name="area" required="required">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Distance From School</label><small>&nbsp;&nbsp;(in KM)</small>
																		<input type="number" class="form-control" name="dist_school" required="required">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Distance From Hospital</label><small>&nbsp;&nbsp;(in KM)</small>
																		<input type="number" class="form-control" name="dist_hospital" required="required">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col-6">
																	<div class="form-group">
																		<label>Floor Type</label>
																		<select class="form-control" class="form-control" name="floor_type" required="required">
																			<option value="4" selected="selected">Select</option>
																			<option value="1">Marbel</option>
																			<option value="2">Tiled</option>
																			<option value="3">Cemented</option>
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

															<div class="text-right pr-5 py-3">
																<button type="submit" class="btn btn-primary font-weight-bold">Submit</button>
															</div>

														</form>
													</div>
												</div>
											</div>
										</div>
										<div class="tab-pane fade" id="gallery">
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
		
		
		// Javascript to enable link to tab
		var hash = location.hash.replace(/^#/, '');  // ^ means starting, meaning only match the first hash
		if (hash) {
		    $('.nav-tabs a[href="#' + hash + '"]').tab('show');
		} 

		// Change hash for page-reload
		$('.nav-tabs a').on('shown.bs.tab', function (e) {
		    window.location.hash = e.target.hash;
		})
	</script>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
	
</body>
</html>