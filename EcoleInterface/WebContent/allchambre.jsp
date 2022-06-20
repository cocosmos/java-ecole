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
	<h1 align="center">List all chambres</h1>
	
		<table style="width: 60%;margin: auto;" class="table table-dark table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>Prix</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${allchambres}" var="chambre">
					<tr>
						<td><c:out value="${chambre.no}" /></td>
						<td><form name="id" class="form" action="ControleurPrincipal?idaction=updatePrixChambre" method="POST">
							<input id="nochambre" type="hidden" name="nochambre" value="<c:out value="${chambre.no}" />">
							<div class="input-group mb-3">
 <input class="form-control" id="prixchambre" type="text" name="prixchambre" value="<c:out value="${chambre.prix}" />">
							 <button type="submit" class="btn btn-primary">Modifier</button>
</div>
							
						</form></td>
						<td>
						<form name="id" class="form" action="ControleurPrincipal?idaction=deleteChambre" method="POST">
							<input class="form-control" id="nochambre" type="hidden" name="nochambre" value="<c:out value="${chambre.no}" />">
							 <button type="submit" class="btn btn-danger"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
  <path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z"/>
</svg></button>
						</form>
						</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	
</body>
</html>