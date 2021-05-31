<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="headtags.jsp" %>
    <link rel="stylesheet" href="static/css/sign.css">
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <title>Sign Up</title>
</head>

<body>
      
	<%@ include file="header.jsp" %>
	
	<% String error = (String)request.getAttribute("error"); %>

    <div class="main-body">
        <div class="container">
            <div class="row body-bg">
                <div class="col-5 left-text pl-4">
                    <div class="left-vl">
                        <p class="left-top-text ml-2">By Regitering With Us!</p>
                        <p class="left-bottom-text">Find Home Without Roam</p>
                    </div>
                </div>
                <div class="col-7 right-text">
                    <div class="right">
                        <p class="right-text-top">Register</p>
                        <a href="signin.do" class="text-white ml-5" style="font-size:18px;">Already have an account?</a>
                        
                        <% if(error != null){ %>
	                        <div class="err-box pt-3 w-75">
	                        	<%= error %>	
	                        </div>
                        <% } %>
                        
                        <form action="signup.do" class="right-form" method="post">
                            <div class="form-group">
                                <label for="">Name</label>
                                <input value="${param.name}" type="text" class="form-control" name="name" maxlength="50" minlength="3" autocomplete="off" placeholder="Enter your name">
                                <small class="form-text text-warning" id="help_name">Enter alphabets only(min-3)</small>
                                <small class="form-text hide text-danger" id="err_name">Invalid name</small>
                            </div>
                            <div class="form-group">
                                <label for="">Email</label>
                                <input value="${param.email}" id="email_field" type="email" class="form-control" name="email" autocomplete="off" placeholder="Enter your email">
                                <small class="form-text text-warning" id="help_email">Enter valid email</small>
                                <small class="form-text hide text-danger" id="err_email">Invalid Email</small>
                            </div>
                            <div class="form-group">
                                <label for="">Password</label><i class="fa fa-eye ml-3" id="eye-view" style="cursor:pointer;"></i>
                                <input type="password" class="form-control" name="password" id="pass" maxlength="20" minlength="8" placeholder="Enter your password" autocomplete="off">
                                <small class="form-text text-warning" id="help_password">Combination of alphabets,numbers & symbols(@,-,_)</small>
                                <small class="form-text hide text-danger" id="err_password">Invalid Password</small>
                            </div>
                            <div class="form-group">
                                <label for="">Address</label>
                                <textarea class="form-control" name="address" placeholder="Enter your address" id="address"></textarea>
                                <small class="form-text hide text-danger" id="err_address">Enter Address</small>
                            </div>
                     <%--   <div class="form-group">
                                <label for="">City</label>
                                <select class="form-control" name="city">
                                    <option value="none">Select</option>
                                    <option value="Jabalpur">Jabalpur</option>
                                    <option value="Panagar">Panagar</option>
                                </select>
                            </div> --%>
                            
                            <div class="g-recaptcha mt-5" style="padding-left:40px;" data-sitekey="6LdtcecaAAAAAIR-dal3QPvbdt5Ixb98veWLqjeO"></div>

                            <div class="text-center">
                                <button type="submit" class="btn head-btn btn-reg mt-5">Register</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
	<%@ include file="footer.jsp" %>
	
 	<script src="static/js/signup.js"></script>

</body>
</html>