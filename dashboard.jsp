<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="models.City"%>
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
						<img src="showdp.do?${user.profilePic }" id="dp">
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
							<div class="tab-pane fade active show" id="profile"><h1>A</h1></div>
							<div class="tab-pane fade" id="my_properties"><h1>B</h1></div>
							<div class="tab-pane fade" id="add_property">
								<div>
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
													<div class="col">
														<form action="">
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Title</label>
																		<input type="text" class="form-control">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Description</label>
																		<textarea class="form-control"></textarea>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col">		
																	<div class="form-group">
																		<label>City</label>
																		<% ArrayList<City> cities = City.getAllCities(); %>
																		<select class="form-control">
																			<option value="1508">Select</option>
																			<% for(City city : cities){%>
																				<option value="<%= city.getCityId() %>"><%= city.getCity()+" ("+city.getState().getState()+")" %></option>
																			<% } %>
																		</select>
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Address</label>
																		<textarea class="form-control"></textarea>
																	</div>
																</div>
															</div>
															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Property Type</label>
																		<select class="form-control" class="form-control">
																			<option>Select</option>
																		</select>
																	</div>
																</div>
																<div class="col">
																	<div class="form-group pt-4">
																		<label>Electricity Bill:&nbsp;&nbsp;</label>
																		&nbsp;&nbsp;<input type="radio" name="bill" value="separate" checked="checked">&nbsp;Separate
																		&nbsp;&nbsp;<input type="radio" name="bill" value="combine">&nbsp;Combine
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Bedroom</label>
																		<input type="number" class="form-control">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Bathroom</label>
																		<input type="number" class="form-control">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Room</label>
																		<input type="number" class="form-control">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Area</label><small>  (in sq.m.)</small>
																		<input type="text" class="form-control">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="form-group">
																		<label>Distance From School</label><small>  (in KM)</small>
																		<input type="number" class="form-control">
																	</div>
																</div>
																<div class="col">
																	<div class="form-group">
																		<label>Distance From Hospital</label><small>  (in KM)</small>
																		<input type="number" class="form-control">
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col-6">
																	<div class="form-group">
																		<label>Floor Type</label>
																		<select class="form-control" class="form-control">
																			<option>Select</option>
																		</select>
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="tank">
																		<label class="custom-control-label" for="tank">&nbsp;&nbsp;Water Tank</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="parking">
																		<label class="custom-control-label" for="parking">&nbsp;&nbsp;Parking</label>
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="terrace">
																		<label class="custom-control-label" for="terrace">&nbsp;&nbsp;Terrace</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="ventilation">
																		<label class="custom-control-label" for="ventilation">&nbsp;&nbsp;Ventilation</label>
																	</div>
																</div>
															</div>

															<div class="row">
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="garden">
																		<label class="custom-control-label" for="garden">&nbsp;&nbsp;Garden</label>
																	</div>
																</div>
																<div class="col">
																	<div class="custom-control custom-switch">
																		<input type="checkbox" class="custom-control-input" id="pets">
																		<label class="custom-control-label" for="pets">&nbsp;&nbsp;Pets Allowed</label>
																	</div>
																</div>
															</div>

															<div class="text-right pr-5 py-3">
																<button type="submit" class="btn btn-primary font-weight-bold">Next</button>
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
        </div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

</body>
</html>