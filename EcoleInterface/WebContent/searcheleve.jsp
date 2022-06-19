<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Eleve</title>
</head>
<body>
	<div align="center">
		<h1>Rechercher un élèves</h1>
		<div>
		<h2 class="pgtitre">Rechercher par le numero de l'eleve:</h2>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=getelevebynum" method="POST">
			<table>
				<tr>
					<td width="120px">Numero Eleve :</td>
					<td><input type="text" name="numelev" id="numelev" /></td>

					<td width="120px"><input type="submit" value="Valider"
						class="submit" /></td>
			</table>
		</form>
		</div>
		<br>
		<div>
			<h2 class="pgtitre">Rechercher par le numero de chambre:</h2>
			<form name="chambreNo" class="form"
				action="ControleurPrincipal?idaction=getelevesbychambreno" method="POST">
				<table>
					<tr>
						<td width="120px">Numero de chambre :</td>
						<td><input type="number" name="numchamb" id="numchamb" /></td>
	
						<td width="120px"><input type="submit" value="Valider"
							class="submit" /></td>
				</table>
			</form>
		</div>
		<br>
		<div>
			<h2 class="pgtitre">Rechercher par date de naissace</h2>
			<form name="chambreNo" class="form"
				action="ControleurPrincipal?idaction=getelevesbydate" method="POST">
				<table>
					<tr>
						<td width="120px">Année de naissance :</td>
						<td><input type="number" min="1900" max="2099" step="1" name="iddate" id="iddate" /></td>
	
						<td width="120px"><input type="submit" value="Valider"
							class="submit" /></td>
				</table>
			</form>
		</div>
		<br>
		<div>
			<h2 class="pgtitre">Rechercher par nom</h2>
			<form name="chambreNo" class="form"
				action="ControleurPrincipal?idaction=getelevesbynom" method="POST">
				<table>
					<tr>
						
						<td><label>Nom : </label><input type="text" step="1" name="nomeleve" id="nomeleve" /></td>
	
						<td width="120px"><input type="submit" value="Valider"
							class="submit" /></td>
				</table>
			</form>
		</div>
		
	</div>
</body>
</html>