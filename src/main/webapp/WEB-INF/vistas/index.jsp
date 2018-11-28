<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>

	<title>FinanWeb</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	
    <link href="css/xbootstrap.min.css" rel="stylesheet">

    <link href="css/xheroic-features.css" rel="stylesheet">
</head>
<body>
	<div>
	    <!-- Navigation -->
	    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	      <div class="container">
	        <a class="navbar-brand" href="${context}/">Finan Web</a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse" id="navbarResponsive">
	          <ul class="navbar-nav ml-auto">
	            <li class="nav-item">
	              <a class="nav-link" href="#">Nosotros</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">Servicios</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">Contacto</a>
	            </li>
	            <li class="nav-item active">
	              <a class="nav-link" href="${context}/login">Inicia Sesion</a>
	            </li>
	          </ul>
	        </div>
	      </div>
	    </nav>
	
	    <!-- Page Content -->
	    <div class="container">
	
	      <!-- Jumbotron Header -->
	      <header class="jumbotron my-4">
	        <h1 class="display-3">Tené tu préstamo hoy!</h1>
	        <p class="lead">El único requisito para acceder a la suma de dinero elegido es demostrar que con el 30% 
	        de tus ingresos los podés pagar la cuota.</p>
	        <a href="#" class="btn btn-primary btn-lg">Pedir Prestamo!</a>
	      </header>
	
	      <!-- Page Features -->
	      <div class="row text-center">
	
	        <div class="col-lg-3 col-md-6 mb-4">
	          <div class="card">
	            <img class="card-img-top" src="http://placehold.it/500x325" alt="">
	            <div class="card-body">
	              <h4 class="card-title">Card title</h4>
	              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
	            </div>
	            <div class="card-footer">
	              <a href="#" class="btn btn-primary">Find Out More!</a>
	            </div>
	          </div>
	        </div>
	
	        <div class="col-lg-3 col-md-6 mb-4">
	          <div class="card">
	            <img class="card-img-top" src="http://placehold.it/500x325" alt="">
	            <div class="card-body">
	              <h4 class="card-title">Card title</h4>
	              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo magni sapiente, tempore debitis beatae culpa natus architecto.</p>
	            </div>
	            <div class="card-footer">
	              <a href="#" class="btn btn-primary">Find Out More!</a>
	            </div>
	          </div>
	        </div>
	
	        <div class="col-lg-3 col-md-6 mb-4">
	          <div class="card">
	            <img class="card-img-top" src="http://placehold.it/500x325" alt="">
	            <div class="card-body">
	              <h4 class="card-title">Card title</h4>
	              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
	            </div>
	            <div class="card-footer">
	              <a href="#" class="btn btn-primary">Find Out More!</a>
	            </div>
	          </div>
	        </div>
	
	        <div class="col-lg-3 col-md-6 mb-4">
	          <div class="card">
	            <img class="card-img-top" src="http://placehold.it/500x325" alt="">
	            <div class="card-body">
	              <h4 class="card-title">Card title</h4>
	              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo magni sapiente, tempore debitis beatae culpa natus architecto.</p>
	            </div>
	            <div class="card-footer">
	              <a href="#" class="btn btn-primary">Find Out More!</a>
	            </div>
	          </div>
	        </div>
	
	      </div>
	      <!-- /.row -->
	
	    </div>
	    <!-- /.container -->
	
	    <!-- Footer -->
	    <footer class="py-5 bg-dark">
	      <div class="container">
	        <p class="m-0 text-center text-white">Copyright &copy; finanWeb 2018</p>
	      </div>
	      <!-- /.container -->
	    </footer>
	
	    <!-- Bootstrap core JavaScript -->
	    <script src="js/jquery.min.js"></script>
	    <script src="js/bootstrap.bundle.min.js"></script>

	</div>
</body>
</html>