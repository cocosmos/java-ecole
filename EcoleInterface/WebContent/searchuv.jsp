<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search UV</title>
</head>
<body>
	<div class="container">
		<h1 class="pgtitre">Search UV</h1>
		<form name="id" action="ControleurPrincipal?idaction=getUvByCode" method="POST">
		  <div class="mb-3">
		    <label for="nocode" class="form-label" >By code of UV: </label>
		    <input type="text" class="form-control" id="nocode" required name="nocode">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<form name="id" action="ControleurPrincipal?idaction=getUvByNbhSuperior" method="POST">
		  <div class="mb-3">
		    <label for="nbhsuperior" class="form-label">Number of Hours superior at :</label>
		    <input type="number" class="form-control" id="nbhsuperior" required name="nbhsuperior"> 
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