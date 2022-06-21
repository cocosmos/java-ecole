<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>Search Eleve</title>

<div class="container mt-5">
	<h1 class="text-center mb-3">Search Eleve</h1>


	<form name="id" class="form"
		action="ControleurPrincipal?idaction=getelevebynum" method="POST">
		<label for="numelev" class="form-label">Numero Eleve :</label>
		<div class="mb-3 input-group ">
			<input class="form-control" type="text" name="numelev" id="numelev" />
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>

	<form name="chambreNo" class="form"
		action="ControleurPrincipal?idaction=getelevesbychambreno"
		method="POST">
		<label for="numelev" class="form-label">Numero de chambre :</label>
		<div class="mb-3 input-group ">
			<input class="form-control" type="number" name="numchamb"
				id="numchamb" />
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>

	</form>

	<form name="chambreNo" class="form"
		action="ControleurPrincipal?idaction=getelevesbydate" method="POST">
		<label for="numelev" class="form-label">Année de naissance :</label>
		<div class="mb-3 input-group ">
			<input class="form-control" type="number" min="1900" max="2099"
				step="1" name="iddate" id="iddate" />
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>

	<form name="chambreNo" class="form"
		action="ControleurPrincipal?idaction=getelevesbynom" method="POST">
		<label class="form-label">Nom : </label>
		<div class="mb-3 input-group ">
			<input class="form-control" type="text" step="1" name="nomeleve"
				id="nomeleve" />
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>

</div>
