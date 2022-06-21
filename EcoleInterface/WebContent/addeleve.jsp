<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>Add Eleve</title>

<div class="container mt-5">
		<h1 class=" text-center">Add Eleve</h1>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=addEleve" method="POST">
			<div class="mb-3">
				<label for="numelev" class="form-label">Number</label> 
				<input type="text" class="form-control" id="numelev" name="numelev" required>
			</div>
			<div class="mb-3">
				<label for="nomelev" class="form-label">Name</label> <input
					type="text" class="form-control" id="nomelev" name="nomelev" required>
			</div>
			<div class="mb-3">
				<label for="agelev" class="form-label">Age</label> <input
					type="number" class="form-control" id="agelev" name="agelev" required>
			</div>
			<div class="mb-3">
				<label for="adresselev" class="form-label">Adress</label> <input
					type="text" class="form-control" id="adresselev" name="adresselev" required>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
			
		</form>
		<c:if test="${txterro!=null}">
			<div class="mt-5 alert alert-<c:out value="${successornot}" default="danger"/>" role="alert">
				<c:out value="${txterro}"/>
			</div>
		</c:if>
	</div>