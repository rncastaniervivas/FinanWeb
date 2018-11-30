<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<h1>Bienvenidos a Taller Web 1</h1>
			${dni}
			<form action="misprestamos" method="POST" >
				      	  <button type="submit" class="btn btn-info" name="dni" value="${dni}">MisPrestamos</button>
				      	  </form>
			<form action="nuevoprestamo" method="POST" >
				      	  <button type="submit" class="btn btn-info" >NuevoPrestamo</button>
				      	  </form>
			<h2>Buscar Afiliado</h2>
			<form action="buscarafiliado" method="POST" >
				<input type="text" name="dni" placeholder="dni">
				<button type="submit">Buscar</button>
			</form>
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>