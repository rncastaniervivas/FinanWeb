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
			<div>
				<a name="Prestamos" id="Prestamos"><h3>Prestamos</h3></a>
					<form action="listarprestamos" method="POST">
						<button type ="submit" class="btn btn-info">Listar todos los préstamos</button>
					</form>
					<br>
				
					<form action="top5afiliados" method="POST" >
					  <button type="submit" class="btn btn-info" name="opcion" value="1">Top5AfiliadosConMayorPrestamo</button>
					</form>
					<br>
					<form action="top5afiliados" method="POST" >
					  <button type="submit" class="btn btn-info" name="opcion" value="2">Top5AfiliadosConMenorPrestamo</button>
					</form>
					<br>
					<form action="top5financieras" method="POST" >
					  <button type="submit" class="btn btn-info" name="opcion" value="3">Top5FinancierasConMayorPrestamo</button>
					</form>
					<br>
					<form action="top5financieras" method="POST" >
					  <button type="submit" class="btn btn-info" name="opcion" value="4">Top5FinancierasConMenorPrestamo</button>
					</form>
					<br>
					
					
			</div>
			
			<div>
				<a name="Afiliados" id="Afiliados"><h3>Afiliados</h3></a>
				<br>
					<form action="buscarafiliado" method="POST" >
						<input type="text" name="dni" placeholder="dni">
						<button type="submit">Buscar</button>
					</form>
				<br>
				<form action="agregarafiliado" method ="POST">
					<button type ="submit" class="btn btn-info">Agregar Afiliado</button>
				</form>
				<br>
				<form action= "listarafiliados" method="POST">
					<button type ="submit" class="btn btn-info">Listado de Afiliados</button>
				</form>
				<br>
			</div>
			
			<div>
				<h3>Financiera</h3>
				<br>
					<form action="encontrado" method="POST" >
						<input type="text" name="nombre" placeholder="nombre">
						<button type="submit">Buscar</button>
					</form>
				<br>
					<form action="agregarfinanciera" method="POST">
						<button type="submit" class="btn btn-info">Agregar financiera</button>
					</form>
				<br>
					<form action="pagarfinancieras" method="POST">
						<button type="submit" class="btn btn-info">Pagar a financiera</button>
					</form>
				<br>
					<form action= "financiera" method="POST">
						<button type ="submit" class="btn btn-info">Listado de Financieras</button>
					</form>
			</div>
			<div>
				<h3>Caja</h3>
				<br>
					<form action= "caja" method="POST">
						<button type ="submit" class="btn btn-info">registros de Caja</button>
					</form>
					<br>
					<form action="graficocaja" method="POST" >
					  <button type="submit" class="btn btn-info" name="opcion" value="1">Grafico de Ingresos</button>
					</form>
					<br>
					<form action="graficocaja" method="POST" >
					  <button type="submit" class="btn btn-info" name="opcion" value="2">Grafico de Egresos</button>
					</form>
			
			</div>

		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>