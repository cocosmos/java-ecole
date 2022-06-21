<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<title>All Eleve</title>


<div class="container mt-5 text-center">
		<h1 class="pgtitre">List all eleves</h1>
		<form name="id" class="form"
			action="ControleurPrincipal?idaction=getallEleves" method="POST">
			<button type="submit" class="btn btn-primary">Submit</button>
			
		</form>
		<%
			String result = (String)request.getAttribute("txtconfirmation");
			if(result!=null){
				out.println(result);
			}
			
			%>
	</div>


