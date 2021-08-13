<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="headtags.jsp" %>
    <title>Renthut</title>
</head>

<body>
    <div class="container-fluid">
    	<div class="row">
    		<div class="col" style="padding:0;">  
			    <div class="banner jumbotron jumbotron-fluid banner-img">
			    	<%@ include file="header.jsp" %>
					
					<div class="text-light text-center" style="margin-top: 200px;">
			    			<p style="font-size: 100px;">FIND HOME</p>
			    			<p style="font-size: 50px;">WITHOUT ROAM<p>
			    	</div>
			    	<div style="margin-top: 20px; margin-left:330px;">
				    	<form class="form-inline" action="homesearch.do">
						  <input class="form-control text-light" id="home_search_bar" name="searchvalue" type="search" placeholder="Search">
						  <button class="btn btn-outline" type="submit"><i class="fa fa-search text-light fa-3x"></i></button>
						</form>
			    	</div>
			    </div>
			</div>
	    </div>
	</div>
	
	<%@ include file="footer.jsp" %>
</body>
</html>