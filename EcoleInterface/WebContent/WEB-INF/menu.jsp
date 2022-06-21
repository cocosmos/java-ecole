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
<title>Ecole</title>

</head>
<body class="d-flex flex-nowrap bg-dark text-white">

  <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
    <a href="index.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
      <span class="fs-1">Ecole Mipam</span>
    </a>
    <hr>
    <ul class="list-unstyled ps-0" >
      <li class="mb-1">
        <button class="fs-2 btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed nav-link" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">
          Eleves
        </button>
        <div class="collapse show" id="home-collapse">
          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 ">
           		<li><a class="nav-link d-inline-flex text-decoration-none rounded" href="addeleve.jsp">Add Eleve</a></li>
				<li><a class="nav-link d-inline-flex text-decoration-none rounded" href="alleleveform.jsp">All Eleves</a></li>
				<li><a class="nav-link d-inline-flex text-decoration-none rounded" href="searcheleve.jsp">Search Eleve</a></li>
          </ul>
        </div>
      </li>
      <li class="mb-1">
        <button class=" fs-2 btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed nav-link" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
          Chambres
        </button>
        <div class="collapse" id="dashboard-collapse">
          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1">
           	<li><a class="nav-link d-inline-flex text-decoration-none rounded" href="addchambre.jsp">Add Chambre</a></li>
				<li><a class="nav-link d-inline-flex text-decoration-none rounded" href="allchambreform.jsp">All Chambres</a></li>
				<li><a class="nav-link d-inline-flex text-decoration-none rounded" href="searchchambre.jsp">Search Chambre</a></li>
          </ul>
        </div>
      </li>
      <li class="mb-1">
        <button class="fs-2 btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed nav-link" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
          UV
        </button>
        <div class="collapse" id="orders-collapse">
          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1">
          <li><a class="nav-link d-inline-flex text-decoration-none rounded" href="alluvform.jsp">All UV</a></li>
				<li><a class="nav-link d-inline-flex text-decoration-none rounded" href="searchuv.jsp">Search UV</a></li>
          </ul>
        </div>
      </li>
     
      <li class="mb-1">
        <button class="fs-2 btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed nav-link" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
          Livres
        </button>
        <div class="collapse" id="account-collapse">
          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 ">
          	<li><a class="nav-link d-inline-flex text-decoration-none rounded" href="addlivre.jsp">Add Livre</a></li>
				<li><a class="nav-link d-inline-flex text-decoration-none rounded" href="alllivreform.jsp">All Livres</a></li>
				<li><a class="nav-link d-inline-flex text-decoration-none rounded" href="searchlivre.jsp">Search Livres</a></li>
          </ul>
        </div>
      </li>
       <li class="mb-1">
       <button class="fs-2 btn btn-toggle d-inline-flex align-items-center rounded border-0 collapsed nav-link" data-bs-toggle="collapse" data-bs-target="#inscripts-collapse" aria-expanded="false">
        Inscrits
        </button>
        <div class="collapse" id="inscripts-collapse">
          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 ">
           <li><a class="nav-link d-inline-flex text-decoration-none rounded" href="allinscritsform.jsp">All Inscrits</a></li>
          </ul>
        </div>
      </li>
    </ul>
  </div>
<div class="b-example-divider b-example-vr"></div>
  </body>



</html>