<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<title>All Inscrits FORM</title>

<div class="container mt-5 text-center">
	<h2 class="pgtitre">List all Inscrits</h2>
	<form name="id" class="form"
		action="ControleurPrincipal?idaction=getAllInscrits" method="POST">
		 <button type="submit" class="btn btn-primary">Submit</button>
	</form>	
	<%
		String result = (String)request.getAttribute("txtconfirmation");
		if(result!=null){
			out.println(result);
		}
		
		%>
	</div>
