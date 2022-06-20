<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All UV FORM</title>
</head>
<body>
<div align="center">
	<h1 class="pgtitre">List all UV</h1>
	<form name="id" class="form"
		action="ControleurPrincipal?idaction=getAllUV" method="POST">
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