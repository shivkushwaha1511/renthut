<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,shrink-to-fit=no">
    <link rel="stylesheet" href="static/css/bootstrap.css">
    <link rel="stylesheet" href="static/css/common.css">
    <link rel="stylesheet" href="static/css/sign.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
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
                                <small class="form-text" id="help_name">Enter alphabets only(min-3)</small>
                                <small class="form-text hide" id="err_name">Invalid name</small>
                            </div>
                            <div class="form-group">
                                <label for="">Email</label>
                                <input value="${param.email}" type="email" class="form-control" name="email" autocomplete="off" placeholder="Enter your email">
                                <small class="form-text" id="help_email">Enter valid email</small>
                                <small class="form-text hide" id="err_email">Invalid Email</small>
                            </div>
                            <div class="form-group">
                                <label for="">Password</label>
                                <input type="password" class="form-control" name="password" maxlength="20" minlength="8" placeholder="Enter your password">
                                <small class="form-text" id="help_password">Combination of alphabets,numbers & symbols(@,-,_)</small>
                                <small class="form-text hide" id="err_password">Invalid Password</small>
                            </div>
                            <div class="form-group">
                                <label for="">Address</label>
                                <textarea class="form-control" name="address" placeholder="Enter your address" id="address"></textarea>
                                <small class="form-text hide" id="err_address">Enter Address</small>
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
	
	<script src="static/js/sign.js"></script>

</body>
</html>