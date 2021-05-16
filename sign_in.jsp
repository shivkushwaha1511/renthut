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
    <title>Sign In</title>
</head>

<body>
      
	<%@ include file="header.jsp" %>

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
                        <form action="" class="right-form">                    
                            <div class="form-group">
                                <label for="">Email</label>
                                <input type="email" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="">Password</label>
                                <input type="password" class="form-control">
                            </div>                            
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

</body>
</html>