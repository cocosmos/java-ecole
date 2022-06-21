<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Inscrits FORM</title>
</head>
<body>
<div align="center">
	<h2 class="pgtitre">List all Inscrits</h2>
	<form name="id" class="form"
		action="ControleurPrincipal?idaction=getAllInscrits" method="POST">
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