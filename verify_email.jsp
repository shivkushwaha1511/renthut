<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="headtags.jsp" %>
    <link rel="stylesheet" href="static/css/sign.css">
    <title>Verify Email</title>
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
                        <div class="text-center py-5" id="activation-msg-block" style="margin-top: 130px;">
                            <p style="font-size: 20px; font-weight: bold;">We have sent you an account activation mail</p>
                            <p style="font-weight: bold;">Click over the link sent in mail</p>
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