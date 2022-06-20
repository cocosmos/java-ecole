<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="ISO-8859-1">
	<link href="style.css" rel="stylesheet">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Rechercher des chambres</title>
</head>
<body>
	<div class="container">
		<h1 class="pgtitre">Rechercher des chambres</h1>
		<form name="id" action="ControleurPrincipal?idaction=searchChambre" method="POST">
		  <div class="mb-3">
		    <label for="numchambre" class="form-label">Par Numéro de chambre: </label>
		    <input type="number" class="form-control" id="nochambre" name="nochambre">
		  </div>
		<!--   <div class="mb-3">
		    <label for="prixchambre" class="form-label">Prix Chambre</label>
		    <input type="number" class="form-control" id="prixchambre" name="prixchambre"> 
		  </div>-->
		  <button type="submit" class="btn btn-primary">Valider</button>
		</form>
		<form name="id" action="ControleurPrincipal?idaction=searchChambreByEleve" method="POST">
		  <div class="mb-3">
		    <label for="numchambre" class="form-label">Par son Occupant: </label>
		    <input type="number" class="form-control" id="nochambre" name="nochambre">
		  </div>
		  <button type="submit" class="btn btn-primary">Valider</button>
		</form>
		<form name="id" action="ControleurPrincipal?idaction=getChambresByPrice" method="POST">
		  <div class="mb-3">
		    <label for="prixchambre" class="form-label">Prix Chambre</label>
		    <input type="number" class="form-control" id="prixchambre" name="prixchambre"> 
		  </div>
		  <button type="submit" class="btn btn-primary">Valider</button>
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