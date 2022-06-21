<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<title>Ajout Chambre</title>

	<div class="container mt-5">
		<h1 class="pgtitre">Ajouter une chambre</h1>
		<form name="id" action="ControleurPrincipal?idaction=addchambre" method="POST">
		  <div class="mb-3">
		    <label for="numchambre" class="form-label">Numéro de chambre</label>
		    <input type="number" class="form-control" id="nochambre" name="nochambre">
		  </div>
		  <div class="mb-3">
		    <label for="prixchambre" class="form-label">Prix Chambre</label>
		    <input type="number" class="form-control" id="prixchambre" name="prixchambre">
		  </div>
		  <button type="submit" class="btn btn-primary">Valider</button>
			
			<c:if test="${txterro!=null}">
			<div class="mt-5 alert alert-<c:out value="${successornot}" default="danger"/>" role="alert">
				<c:out value="${txterro}"/>
			</div>
		</c:if>
		</form>
	</div>
