<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<title>All inscrits</title>

<div class="container mt-5">
	<h1 class="text-center mb-3">All Inscrits</h1>

	<table 
		class="table table-dark table-striped">
		<thead>
			<tr>
				<th>Code</th>
				<th>Num Eleve</th>
				<th>Note</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${allinscrits}" var="inscrit">
				<tr>
					<td><c:out value="${inscrit.code}" /></td>
					<td><c:out value="${inscrit.num}" /></td>
					<td><c:out value="${inscrit.note}" /></td>
					<td>
						<form name="id" class="form"
							action="ControleurPrincipal?idaction=deleteInscritByCodeAndNum"
							method="POST">
							<input class="form-control" id="code" type="hidden" name="code"
								value="<c:out value="${inscrit.code}" />">
							<input class="form-control" id="numelev" type="hidden" name="numelev"
								value="<c:out value="${inscrit.num}" />">
							<button type="submit" class="btn btn-danger">
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-trash3-fill"
									viewBox="0 0 16 16">
  									<path
										d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z" />
								</svg>
							</button>
						</form>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>