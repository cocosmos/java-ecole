<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<title>All UV FORM</title>

<div class="container mt-5 text-center">
	<h1 class="pgtitre">List all UV</h1>
	<form name="id" class="form"
		action="ControleurPrincipal?idaction=getAllUv" method="POST">
		 <button type="submit" class="btn btn-primary">Submit</button>
	</form>
		
	<c:if test="${txterro!=null}">
			<div class="mt-5 alert alert-<c:out value="${successornot}" default="danger"/>" role="alert">
				<c:out value="${txterro}"/>
			</div>
		</c:if>
	</div>
