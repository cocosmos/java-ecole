<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<title>Search UV</title>

	<div class="container mt-5">
		<h1 class="text-center">Search UV</h1>
		<form name="id" action="ControleurPrincipal?idaction=getUvByCode" method="POST">
		   <label for="nocode" class="form-label" >By code of UV: </label>
		<div class="mb-3 input-group">
		   
		    <input type="text" class="form-control" id="nocode" required name="nocode">
		     <button type="submit" class="btn btn-primary">Submit</button>
		  </div>
		 
		</form>
		<form name="id" action="ControleurPrincipal?idaction=getUvByNbhSuperior" method="POST">
		   <label for="nbhsuperior" class="form-label">Number of Hours superior at :</label>
		  	<div class="mb-3 input-group">
		 
		    <input type="number" class="form-control" id="nbhsuperior" required name="nbhsuperior"> 
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
