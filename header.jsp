<%@ page import="models.User" %>
    <div class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col" style="padding: 0;">      
                    <div class="row fixed-top head-bg">
                        <div class="col-4 pt-3 head-link">
                                <a href="about.do" class="text-white ml-5">About Us</a>
                                <a href="contact.do" class="text-white ml-3">Contact Us</a>
                        </div>
                        <div class="col-4 text-center py-2">
                            <a href="/renthut"><img src="static/images/logo.png"></a>
                        </div>
                        <div class="col-4 pt-3 head-link text-right">
                        	<% User user = (User)session.getAttribute("user"); 
                        		if(user == null){
                        	%>
	                            <a href="signin.do" class="text-white mr-3">Sign In</a>
	                            <a href="signup.do" class="text-white mr-5 pl-3 vl-head">Sign Up</a>
                            <%}else{ %>
                            	<div class="row">
	                            	<div class="col-9 pl-auto" style="padding-right: 5px;">
		                            	<div class="dropdown">
		                            		<button class="btn btn-lite dropdown-toggle text-white font-weight-bold" data-toggle="dropdown"><%= user.getName() %></button>
		                            		<div class="dropdown-menu">
		                            			<a class="dropdown-item" href="dashboard.do"><i class="fa fa-user mr-3"></i>My Profile</a>
		                            			<a class="dropdown-item" href="dashboard.do?activeTabMyProp=myProperties"><i class="fa fa-building mr-3"></i>My Properties</a>
		                            			<a class="dropdown-item" href="dashboard.do?activeTabAddProp=addProperty"><i class="fa fa-plus-square mr-3"></i>Add Listing</a>
		                            			<a class="dropdown-item" href="logout.do"><i class="fa fa-sign-out mr-3"></i>Log Out</a>
		                            		</div>
		                            	</div>
	                            	</div>
	                            	<div class="col-3 pr-auto" style="padding-left: 0px;">
		                            	<a href="logout.do" class="btn head-btn text-white mr-4">LogOut</a>
		                            </div>
		                         </div>
                            <%} %>
                        </div>
                    </div>       
                </div>
            </div>
        </div>
    </div>