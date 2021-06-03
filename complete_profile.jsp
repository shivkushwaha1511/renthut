<%@ page import="java.util.ArrayList,models.City" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="headtags.jsp" %>
    <link rel="stylesheet" href="static/css/sign.css">
    <title>Complete Profile</title>
</head>

<body>
      
	<%@ include file="header.jsp" %>

    <div class="main-body">
        <div class="container">
            <div class="row body-bg">
                <div class="col-5 left-text">
                    <div class="left-vl pl-4">
                        <p class="left-top-text ml-2">ThankYou For</p>
                        <p class="left-bottom-text">Registering With Us!</p>
                    </div>
                </div>
                <div class="col-7 right-text">
                    <div class="right">
                        <div class="text-center py-5" id="activation-msg-block">
                            <p style="font-size: 20px; font-weight: bold;">Thank You For Verifying Your Email</p>
                        </div>
                        <div class="pl-5 pt-5">
                        	<form action="completeprofile.do" method="post" style="width:75%; margin-left:30px;">
								<div class="form-group">
	                                <label for="">Name</label>
	                                <input value="${user.name}" type="text" class="form-control" name="name" maxlength="50" minlength="3" autocomplete="off" placeholder="Enter your name">
	                                <small class="form-text text-warning" id="help_name">Enter alphabets only(min-3)</small>
	                                <small class="form-text hide text-danger" id="err_name">Invalid name</small>
	                            </div>
	                            <div class="form-group">
	                                <label for="">Email</label>
	                                <input disabled="disabled" value="${user.email}" id="email_field" type="email" class="form-control" name="email" autocomplete="off" placeholder="Enter your email">
	                                <small class="form-text text-warning" id="help_email">Enter valid email</small>
	                                <small class="form-text hide text-danger" id="err_email">Invalid Email</small>
	                            </div>
	                            <div class="form-group">
	                                <label for="">Address</label>
	                                <textarea class="form-control" name="address" placeholder="Enter your address" id="address">${user.address}</textarea>
	                                <small class="form-text hide text-danger" id="err_address">Enter Address</small>
                            	</div>
								<div class="form-group">
	                                <label for="id_city">City</label>
	                                <select class="form-control" name="city" id="id_city">
	                                	<% ArrayList<City> cities = City.getAllCities(); %>
	                                    <option>Select</option>
	                                    <% for(City city : cities){ %>
	                                    	<option value="<%= city.getCityId() %>"><%= city.getCity()+" ("+city.getState().getState()+")" %></option>
	                                    <% } %>
	                                </select>
                            	</div>
                            	
                            	<div class="form-group">
                            		<label>Contact No.</label>
                            		<input type="text" name="contact" class="form-control" value="${user.contactNo}" autocomplete="off">
                            	</div>
                            	
                            	<div class="text-center">
                            		<button type="submit" class="btn head-btn mt-5">Save</button>
                        		</div>
                        	</form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
	<%@ include file="footer.jsp" %>
	
	<script src="static/js/sign.js"></script>

</body>
</html>