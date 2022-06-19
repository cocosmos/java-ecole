<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Eleve</title>
</head>
<body>
	<div align="center">
		<h2 class="pgtitre">La liste de tous les élèves</h2>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=getallEleves" method="POST">
			<input type="submit" value="All Eleves" class="submit" />
		</form>
	</div>
</body>
</html>