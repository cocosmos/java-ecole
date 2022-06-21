<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>All Chambres</title>


	<div class="container mt-5 text-center">
		<h2 class="pgtitre">La liste de toutes les chambres</h2>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=getallChambres" method="POST">
			 <button type="submit" class="btn btn-primary">Valider</button>
		</form>
		<br>
		<h2 class="pgtitre">La liste de toutes les chambres non occupées</h2>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=getallChambresNoOccupied" method="POST">
			 <button type="submit" class="btn btn-primary">Valider</button>
		</form>
		<%
			String result = (String)request.getAttribute("txtconfirmation");
			if(result!=null){
				out.println(result);
			}
			
			%>
	</div>
