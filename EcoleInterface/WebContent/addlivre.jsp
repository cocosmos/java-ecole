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
		
		<c:if test="${txterro!=null}">
			<div class="mt-5 alert alert-<c:out value="${successornot}" default="danger"/>" role="alert">
				<c:out value="${txterro}"/>
			</div>
		</c:if>
	</form>
</div>
