<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<title>Search Livre</title>

	<div class="container mt-5">
		<h1 class="text-center">Search Livre</h1>
		<form name="id" action="ControleurPrincipal?idaction=getLivreByCote" method="POST">
		<label for="nocode" class="form-label" >By cote of Livre: </label>
		 <div class="mb-3 input-group">
		    
		    <input type="text" class="form-control" id="cote" required name="cote">
		    <button type="submit" class="btn btn-primary">Submit</button>
		  </div>
		  
		</form>
		<form name="id" action="ControleurPrincipal?idaction=getAllLivresSharedToEleve" method="POST">
		  <label for="numelev" class="form-label">Elev num :</label>
		  <div class="mb-3 input-group">
		     <input type="text" class="form-control" id="numelev" required name="numelev"> 
		      <button type="submit" class="btn btn-primary">Submit</button>
		  </div>
		 
		</form>
		<%
			String txterro = (String) request.getAttribute("txterro");
			if(txterro!=null) {
			out.print(txterro);
			}
			%>
	</div>
