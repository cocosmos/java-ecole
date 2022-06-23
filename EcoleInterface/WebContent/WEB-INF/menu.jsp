<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
	<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
	<link href="./resources/style.css" rel="stylesheet">


</head>

<body class=" bg-dark text-white">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" aria-label="Eighth navbar example">
    <div class="container">
      <a class="navbar-brand" href="index.jsp">Ecole Mipam</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample07" aria-controls="navbarsExample07" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarsExample07">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle active" href="#" id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false">Eleves</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown07">
              <li><a class="dropdown-item" href="addeleve.jsp">Add Eleve</a></li>
				<li><a class="dropdown-item" href="alleleveform.jsp">All Eleves</a></li>
				<li><a class="dropdown-item" href="searcheleve.jsp">Search Eleve</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle active" href="#" id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false">Chambres</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown07">
             <li><a class="dropdown-item" href="addchambre.jsp">Add Chambre</a></li>
				<li><a class="dropdown-item" href="allchambreform.jsp">All Chambres</a></li>
				<li><a class="dropdown-item" href="searchchambre.jsp">Search Chambre</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle active" href="#" id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false">Uv</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown07">
				  <li><a class="dropdown-item" href="alluvform.jsp">All UV</a></li>
				<li><a class="dropdown-item" href="searchuv.jsp">Search UV</a></li>
            </ul>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle active" href="#" id="dropdown07" data-bs-toggle="dropdown" aria-expanded="false">Livres</a>
            <ul class="dropdown-menu" aria-labelledby="dropdown07">
             	<li><a class="dropdown-item" href="addlivre.jsp">Add Livre</a></li>
				<li><a class="dropdown-item" href="alllivreform.jsp">All Livres</a></li>
				<li><a class="dropdown-item" href="searchlivre.jsp">Search Livres</a></li>
            </ul>
          </li>
           <li class="nav-item dropdown">
           		<a class="nav-link active" href="allinscritsform.jsp">All Inscrits</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  </body>
</html>