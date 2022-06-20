<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="ISO-8859-1">
	<link href="style.css" rel="stylesheet">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Search chamber</title>
</head>
<body>
	<div class="container">
		<h1 class="pgtitre">Search chamber</h1>
		<form name="id" action="ControleurPrincipal?idaction=searchChambre" method="POST">
		  <div class="mb-3">
		    <label for="nochambre" class="form-label" >By numero of chamber: </label>
		    <input type="number" class="form-control" id="nochambre" required name="nochambre">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<form name="id" action="ControleurPrincipal?idaction=getChambreByEleveNum" method="POST">
		  <div class="mb-3">
		    <label for="numelev" class="form-label">By numero of occupant: </label>
		    <input type="text" class="form-control" id="numelev" required name="numelev">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<form name="id" action="ControleurPrincipal?idaction=getChambresByPrice" method="POST">
		  <div class="mb-3">
		    <label for="prixchambre" class="form-label">Price of chamber superior at :</label>
		    <input type="number" class="form-control" id="prixchambre" required name="prixchambre"> 
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