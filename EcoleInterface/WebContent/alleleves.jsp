<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="ISO-8859-1">
	<link href="style.css" rel="stylesheet">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Ecole</title>
</head>
<body>
	<h2 align="center">Liste de tous les élèves</h2>
	
	<table style="width: 60%; border: 1px solid black; margin: auto;">
		<thead>
			<tr>
				<th>Numero</th>
				<th>Nom</th>
				<th>Chambre n°</th>
				<th>Adresse</th>
				
				<th>Suppression</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${allelevs}" var="ele">
				<tr>
					<td><c:out value="${ele.num}" /></td>
					<td><c:out value="${ele.nom}" /></td>
					<td>
					<form name="id" class="form" action="ControleurPrincipal?idaction=updatechambrebyeleve" method="POST">
						<input name="numelev" id="numelev" type="hidden" value="<c:out value="${ele.num}" />">
						<input type="text" name="nochambre" id="nochambre" value="<c:if test="${ele.no != 0}" ><c:out value="${ele.no}" /></c:if>">
						<button type="submit" class="btn btn-primary">Modifier</button>
					</form>
					
					</td>
					<td>
					<form name="id" class="form" action="ControleurPrincipal?idaction=updateeleve" method="POST">
							<input name="numelev" id="numelev" type="hidden" value="<c:out value="${ele.num}" />">
							<input type="text" name="adresselev" id="adresselev" value="<c:out value="${ele.adresse}" />">
							 <button type="submit" class="btn btn-primary">Modifier</button>
					</form>
					
					</td>
					<td>
						<form name="id" class="form" action="ControleurPrincipal?idaction=deleteEleveBynum" method="POST">
							<input type="hidden" name="numelev" id="numelev" value="<c:out value="${ele.num}" />">
							 <button type="submit" class="btn btn-danger">Supprimer</button>
						</form>
						</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>