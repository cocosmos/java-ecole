<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<title>Add Livre</title>

<div class="container mt-5">
	<h1 class="text-center">Add a livre</h1>
	<form name="id" action="ControleurPrincipal?idaction=addLivre" method="POST">
	  <div class="mb-3">
	    <label for="cote" class="form-label">Cote number</label>
	    <input type="text" class="form-control" id="cote" name="cote">
	  </div>
	  <div class="mb-3">
	    <label for="titre" class="form-label">Titre</label>
	    <input type="text" class="form-control" id="titre" name="titre">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
		
		<%
		String txterro = (String) request.getAttribute("txterro");
		if(txterro!=null) {
		out.print(txterro);
		}
		%>
	</form>
</div>
