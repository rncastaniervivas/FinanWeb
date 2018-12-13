<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Alerta Refinanciar</title>
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/xbootstrap.min.css" rel="stylesheet">
    	<link href="css/xheroic-features.css" rel="stylesheet">
	</head>
	<body>
		<div style="width:1024px; margin: 200px auto;">
			<h1>El prestamo con id:<b>${prestamo.idPrestamo}</b> ya fue refinanciado.</h1></br></br>
			<form action="misprestamos" method="POST" >
	    	  <button class="btn btn-primary btn-lg" type="submit" name="dni" value="${afiliado.dni}" >Volver</button>
	    	</form>
		</div>
		
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>