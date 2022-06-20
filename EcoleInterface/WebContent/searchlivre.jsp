<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Livre</title>
</head>
<body>
	<div class="container">
		<h1 class="pgtitre">Search Livre</h1>
		<form name="id" action="ControleurPrincipal?idaction=getLivreByCote" method="POST">
		  <div class="mb-3">
		    <label for="nocode" class="form-label" >By cote of Livre: </label>
		    <input type="text" class="form-control" id="cote" required name="cote">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<form name="id" action="ControleurPrincipal?idaction=getAllLivresSharedToEleve" method="POST">
		  <div class="mb-3">
		    <label for="elevnum" class="form-label">Number of Hours superior at :</label>
		    <input type="text" class="form-control" id="elevnum" required name="elevnum"> 
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<%
			String txterro = (String) request.getAttribute("txterro");
			if(txterro!=null) {
			out.print(txterro);
			}
			%>
	</div>
</body>
</html>