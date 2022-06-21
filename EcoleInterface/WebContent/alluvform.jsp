<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<title>All UV FORM</title>

<div class="container mt-5 text-center">
	<h1 class="pgtitre">List all UV</h1>
	<form name="id" class="form"
		action="ControleurPrincipal?idaction=getAllUv" method="POST">
		 <button type="submit" class="btn btn-primary">Submit</button>
	</form>
		
	<%
		String result = (String)request.getAttribute("txtconfirmation");
		if(result!=null){
			out.println(result);
		}
		
		%>
	</div>
