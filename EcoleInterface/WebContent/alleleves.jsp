<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<title>All eleves</title>

<div class="container mt-5 text-center">
	<h1 align="center">List all eleves</h1>

	<table class="table table-dark table-striped">
		<thead>
			<tr>
				<th>Numero</th>
				<th>Nom</th>
				<th>Chambre n°</th>
				<th>Adresse</th>

				<th>Actions</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${allelevs}" var="ele">
				<tr>
					<td><c:out value="${ele.num}" /></td>
					<td><c:out value="${ele.nom}" /></td>
					<td>
						<form name="id" class="form"
							action="ControleurPrincipal?idaction=updatechambrebyeleve"
							method="POST">
							<input name="numelev" id="numelev" type="hidden"
								value="<c:out value="${ele.num}" />">
							<div class="input-group mb-3">
								<select class="form-select" name="nochambre" id="nochambre">
									<option value="">No Chambre</option>
									<c:forEach items="${allchambres}" var="chambre">
										<c:choose>
											<c:when test="${chambre.no == ele.no}">
												<option selected value="<c:out value="${chambre.no}" />"><c:out
														value="${chambre.no}" /> :
													<c:out value="${chambre.prix}" /> CHF
												</option>
											</c:when>
											<c:otherwise>
												<option value="<c:out value="${chambre.no}" />"><c:out
														value="${chambre.no}" /> :
													<c:out value="${chambre.prix}" /> CHF
												</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>

								<button type="submit" class="btn btn-primary">Edit</button>
							</div>
						</form>
					</td>
					<td>
						<form name="id" class="form"
							action="ControleurPrincipal?idaction=updateeleve" method="POST">
							<input name="numelev" id="numelev" type="hidden"
								value="<c:out value="${ele.num}" />">
							<div class="input-group mb-3">
								<input class="form-control" type="text" name="adresselev"
									id="adresselev" value="<c:out value="${ele.adresse}" />">
								<button type="submit" class="btn btn-primary">Edit</button>
							</div>
						</form>
					</td>
					<td>
						<div class="btn-group">
							<form name="id" class="form"
								action="ControleurPrincipal?idaction=getInscritsByEleveNum"
								method="POST">
								<input type="hidden" name="numelev" id="numelev"
									value="<c:out value="${ele.num}" />">
								<button type="submit" class="btn btn-primary">Inscrits</button>
							</form>
							<form name="id" class="form"
								action="ControleurPrincipal?idaction=deleteEleveBynum"
								method="POST">
								<input type="hidden" name="numelev" id="numelev"
									value="<c:out value="${ele.num}" />">
								<button type="submit" class="btn btn-danger">Supprimer</button>
							</form>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
