<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/xbootstrap.min.css" rel="stylesheet">
    	<link href="css/xheroic-features.css" rel="stylesheet">
    	<title>FinanWeb</title>
	</head>
	<body>
	<jsp:include page="header.jsp" />
		<div class = "container">
			
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="foto1.jpg" alt="Chania">
      <div class="carousel-caption">
        <h3>Préstamos accesibles</h3>
        <p>Te ofrecemos todas las garantias necesarias para tu próximo proyecto</p>
      </div>
    </div>

    <div class="item">
      <img src="foto2.jpg" alt="Chicago">
      <div class="carousel-caption">
        <h3>Solo con tu recibo de sueldo</h3>
        <p>Descontamos tu cuota del préstamo de tu recibo de sueldo</p>
      </div>
    </div>

    <div class="item">
      <img src="foto3.jpg" alt="New York">
      <div class="carousel-caption">
        <h3>Beneficios exclusivos</h3>
        <p>Servicio ofrecido para el personal del Servicio Penitenciario</p>
      </div>
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>