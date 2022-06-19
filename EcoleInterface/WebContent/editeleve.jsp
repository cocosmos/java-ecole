<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier l'adresse d'un Eleve</title>
</head>
<body>
	<div align="center">
		<h1 class="pgtitre">Modifier l'adresse d'un Eleve</h1>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=updateeleve" method="POST">
			
			<label for="numelev">Numero actuel de Eleve :</label>
			<input type="text" name="numelev" id="numelev" /><br>

			<label>Nouvelle Adresse :</label>
			<input type="text" name="adresselev" id="adresselev" /><br>
			<br><input type="submit" value="Valider" class="submit" />
			<br>
			<%
			String txterro = (String) request.getAttribute("txterro");
			if(txterro!=null) {
			out.print(txterro);
			}
			%>
		</form>
	</div>
</body>
</html>