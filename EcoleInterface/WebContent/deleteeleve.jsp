<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Supprimer un élève</title>
</head>
<body>
<div align="center">
		<h1 class="pgtitre">Supprimer un eleve</h1>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=deleteEleveBynum" method="POST">
			<label>Numero Eleve :</label>
			<input type="text" name="numelev" id="numelev" required/>
			<input type="submit" value="Valider" class="submit" onclick="confirm('Etes vous de vouloir supprimer cet Eleve ?')"/>
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