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
	<h2>Liste de tous les élèves</h2>
	<table style="width: 60%; border: 1px solid black; margin: auto;">
		<thead>
			<tr>
				<th>Numero</th>
				<th>Nom</th>
				<th>Adresse</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allelevs}" var="ele">
				<tr>
					<td><c:out value="${ele.num}" /></td>
					<td><c:out value="${ele.nom}" /></td>
					<td><c:out value="${ele.adresse}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>