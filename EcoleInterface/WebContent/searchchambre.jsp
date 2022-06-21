<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>Search chamber</title>
<div class="container mt-5">
	<h1 class="pgtitre">Search chamber</h1>
	<form name="id" action="ControleurPrincipal?idaction=searchChambre"
		method="POST">
		<label for="nochambre" class="form-label">By numero of
			chamber: </label>
		<div class="mb-3 input-group">
			<input type="number" class="form-control" id="nochambre" required
				name="nochambre">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
	<form name="id"
		action="ControleurPrincipal?idaction=getChambreByEleveNum"
		method="POST">
		<label for="numelev" class="form-label">By numero of occupant:
		</label>
		<div class="mb-3 input-group">

			<input type="text" class="form-control" id="numelev" required
				name="numelev">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>

	</form>
	<form name="id"
		action="ControleurPrincipal?idaction=getChambresByPrice" method="POST">
		<label for="prixchambre" class="form-label">Price of chamber
			superior at :</label>
		<div class="mb-3 input-group">

			<input type="number" class="form-control" id="prixchambre" required
				name="prixchambre">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>

	</form>
	<%
	String txterro = (String) request.getAttribute("txterro");
	if (txterro != null) {
		out.print(txterro);
	}
	%>
</div>
