<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Chambres</title>
</head>
<body>
	<div align="center">
		<h2 class="pgtitre">La liste de tous les chambres</h2>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=getallChambres" method="POST">
			 <button type="submit" class="btn btn-primary">Valider</button>
		</form>
	</div>
</body>
</html>