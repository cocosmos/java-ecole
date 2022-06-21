<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Livre FORM</title>
</head>
<body>
<div align="center">
	<h2 class="pgtitre">List all Livres</h2>
	<form name="id" class="form"
		action="ControleurPrincipal?idaction=getAllLivres" method="POST">
		 <button type="submit" class="btn btn-primary">Submit</button>
	</form>
	<h2 class="pgtitre">List all Livres Available</h2>
	<form name="id" class="form"
		action="ControleurPrincipal?idaction=getAllLivresAvailable" method="POST">
		 <button type="submit" class="btn btn-primary">Submit</button>
	</form>
		
	<%
		String result = (String)request.getAttribute("txtconfirmation");
		if(result!=null){
			out.println(result);
		}
		
		%>
	</div>
</body>
</html>