<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajout Eleve</title>
</head>
<body>
	<div align="center">
		<h1 class="pgtitre">Ajouter un eleve</h1>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=addEleve" method="POST">
			<table>
				<tr>
					<td width="120px">Numero Eleve :</td>
					<td><input type="text" name="numelev" id="numelev" /></td>
				</tr>
				<tr>
					<td width="120px">Nom Eleve :</td>
					<td><input type="text" name="nomelev" id="nomelev" /></td>
				</tr>
				<tr>
					<td width="120px">Age :</td>
					<td><input type="text" name="agelev" id="agelev" /></td>
				</tr>
				<tr>
					<td width="120px">Adresse :</td>
					<td><input type="text" name="adresselev" id="adresselev" /></td>
				</tr>
				<tr>
					<td width="120px"><input type="submit" value="Valider"
						class="submit" /></td>
				</tr>
			</table>
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