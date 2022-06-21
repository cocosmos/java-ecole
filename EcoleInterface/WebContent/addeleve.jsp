<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>Add Eleve</title>


		<h1 class="pgtitre text-center">Add Eleve</h1>
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
					type="text" class="form-control" id="agelev" name="agelev" required>
			</div>
			<div class="mb-3">
				<label for="adresselev" class="form-label">Adress</label> <input
					type="text" class="form-control" id="adresselev" name="adresselev" required>
			</div>


			<button type="submit" class="btn btn-primary">Submit</button>
			<%
			String txterro = (String) request.getAttribute("txterro");
			if (txterro != null) {
				out.print(txterro);
			}
			%>
		</form>
	</div>