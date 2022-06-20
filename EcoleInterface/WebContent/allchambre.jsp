<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="ISO-8859-1">
	<link href="style.css" rel="stylesheet">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Chambres</title>
</head>
<body>
	<h2 align="center">Liste de toutes les chambres</h2>
	
		<table style="width: 60%; border: 1px solid black; margin: auto;">
			<thead>
				<tr>
					<th>Numero</th>
					<th>Prix</th>
					<th>Supprimer</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${allchambres}" var="chambre">
					<tr>
						<td><c:out value="${chambre.no}" /></td>
						<td><form name="id" class="form" action="ControleurPrincipal?idaction=updatePrixChambre" method="POST">
							<input id="nochambre" type="hidden" name="nochambre" value="<c:out value="${chambre.no}" />">
							<input id="prixchambre" type="text" name="prixchambre" value="<c:out value="${chambre.prix}" />">
							 <button type="submit" class="btn btn-primary">Modifier</button>
						</form></td>
						<td>
						<form name="id" class="form" action="ControleurPrincipal?idaction=deleteChambre" method="POST">
							<input id="nochambre" type="hidden" name="nochambre" value="<c:out value="${chambre.no}" />">
							 <button type="submit" class="btn btn-danger">Supprimer</button>
						</form>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	
</body>
</html>