<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="headtags.jsp" %>
    <link rel="stylesheet" href="static/css/sign.css">
    <title>Sign In</title>
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>

<body>
      
	<%@ include file="header.jsp" %>
	
	<% String error = (String)request.getAttribute("error"); %>

    <div class="main-body">
        <div class="container">
            <div class="row body-bg">
                <div class="col-5 left-text pl-4">
                    <div class="left-vl" style="height:500px;">
                        <p class="left-top-text ml-2">Welcome Back!</p>
                        <p class="left-bottom-text">Renthut Welcomes You!!</p>
                    </div>
                </div>
                <div class="col-7 right-text">
                    <div class="right" style="margin-top:50px;">
                        <p class="right-text-top">SignIn</p>
                        <a href="signup.do" class="text-white ml-5" style="font-size:18px;">Register a user?</a>
                        
                        <% if(error != null){ %>
	                        <div class="err-box pt-3 w-75">
	                        	<%= error %>	
	                        </div>
                        <% } %>
                        
                        <form action="signin.do" method="post" class="right-form">                    
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
                            <div class="g-recaptcha mt-5" style="padding-left:40px;" data-sitekey="6LdtcecaAAAAAIR-dal3QPvbdt5Ixb98veWLqjeO"></div>

                            <div class="text-center">
                                <button type="submit" class="btn head-btn btn-reg mt-5">SignIn</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
	<%@ include file="footer.jsp" %>
	
	<script src="static/js/signin.js"></script> 

</body>
</html>