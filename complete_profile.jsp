<%@ page import="java.util.ArrayList,models.City" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="headtags.jsp" %>
    <link rel="stylesheet" href="static/css/dropzone.min.css">
    <link rel="stylesheet" href="static/css/sign.css">
    <title>Complete Profile</title>
    
    <style type="text/css">
    	#dpUpload{
    		background: none;
    		color:white;
    		border: dashed 2px white;
    		border-radius: 10px;
    	}
    	
    	#dp{
    		border-radius: 50%;
    		width: 230px;
    		height: 230px;
    		margin-left: 80px;
    		margin-bottom: 30px;
    	}
    </style>
</head>

<body>
      
	<%@ include file="header.jsp" %>

    <div class="main-body">
        <div class="container">
            <div class="row body-bg">
                <div class="col-5 left-text">
                    <div class="left-vl pl-4">
                    	<img src="showdp.do?path=${user.profilePic}" id="dp">
                        <p class="left-top-text" style="margin-left: 75px; text-decoration: underline;">Upload display photo</p>
						<form class="dropzone mr-5 my-4" id="dpUpload">
						</form>
						<div style="padding-left: 150px;">						
							<button id="dp-btn" class="btn head-btn">Upload</button>
						</div>
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
	                            </div>
	                            <div class="form-group">
	                                <label for="">Email</label>
	                                <input disabled="disabled" value="${user.email}" id="email_field" type="email" class="form-control" name="email" autocomplete="off" placeholder="Enter your email">
	                            </div>
	                            <div class="form-group">
	                                <label for="">Address</label>
	                                <textarea class="form-control" name="address" placeholder="Enter your address" id="address">${user.address}</textarea>
                            	</div>
								<div class="form-group">
	                                <label for="id_city">City</label>
	                                <select class="form-control" name="city" id="id_city">
	                                	<% ArrayList<City> cities = City.getAllCities(); 
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
	<script type="text/javascript" src="static/js/dropzone.min.js"></script> 
   	
   	<script>
   	Dropzone.autoDiscover = false;
   	
   	Dropzone.options.dpUpload = {
   		maxFilesize : 2,
   		maxFiles : 1,
   		addRemoveLinks: true,
   		acceptedFiles : ".jpeg,.jpg,.png,.gif",
   		autoProcessQueue : false
   	};
   	
   	let	dpDropzone = new Dropzone("#dpUpload",{url: "dpupload.do"});
   	
   	const dpBtn = document.querySelector("#dp-btn");
   	
   	dpBtn.addEventListener("click",()=>{
   		dpDropzone.processQueue();
   		document.querySelector("#dp").style.display = "none";
   	});
   	</script>

</body>
</html>