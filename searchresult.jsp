<%@ page import="java.util.ArrayList" %>
<%@ page import="models.PropertyFeature" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="headtags.jsp" %>
    <link rel="stylesheet" href="static/css/sign.css">
    <title>Search Results</title>
</head>

<body>
      
	<%@ include file="header.jsp" %>
	<% String searchvalue = request.getParameter("searchvalue"); %>
    <div class="main-body">
        <div class="container text-white">
            <div class="row mb-3">
            	<div class="col" style="border-bottom: 3px solid white">
	            	<h1 class="pl-2 mt-4">Search Results For <%= searchvalue %></h1>
            	</div>
            </div>
            <% ArrayList<PropertyFeature> properties = PropertyFeature.getAllProperties(searchvalue); %>
            <div class="row">
            	<div class="col">
            		<div class="row" style="margin-left: 120px;">
            			<%if(!properties.isEmpty()){
            			for(PropertyFeature property: properties){ %>
          				<div class="card col-3 mr-5 mt-5" style="width:30%;padding-left:0px;padding-right:0px;">
          					<img src="showpropimg.do?path=<%= property.getProperty().getThumbnail() %>" class="card-img-top">
          					<div class="card-body text-dark">
          						<h5 class="card-title font-weight-bold"><%=property.getProperty().getTitle() %></h5>
          						<p class="card-text font-weight-bold"><i class="fa fa-map-marker fa-lg mr-2"></i><%=property.getProperty().getCity().getCity() %></p>
          						<p class="card-text"><%=property.getProperty().getDescription() %>....</p>
          						<a href="#" class="btn btn-primary">Buy</a>
          					</div>
          				</div>
          				<%}}else{ %>
          					<h1>No Result Found</h1>
          				<%} %>
					</div>
        		</div>
            </div>
        </div>
    </div>
    
	<%@ include file="footer.jsp" %>
	
</body>
</html>