<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>All Livre FORM</title>

<div class="container mt-5 text-center">
	<div>
		<h2 class="pgtitre">List all Livres</h2>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=getAllLivres" method="POST">
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<div class="mt-5">
		<h2 class="pgtitre">List all Livres Available</h2>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=getAllLivresAvailable"
			method="POST">
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<span>
		<%
		String result = (String) request.getAttribute("txtconfirmation");
		if (result != null) {
			out.println(result);
		}
		%>
	</span>
</div>
