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
                        	<form action="complete_profile.do" method="post" style="width:75%; margin-left:30px;">
								<div class="form-group">
	                                <label for="id_city">City</label>
	                                <select class="form-control" name="city" id="id_city">
	                                    <option value="none">Select</option>
	                                    <option value="Jabalpur">Jabalpur</option>
	                                    <option value="Panagar">Panagar</option>
	                                </select>
                            	</div>
                            	
                            	<div class="form-group">
                            		<label>Contact No.</label>
                            		<input type="number" name="contact" class="form-control">
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