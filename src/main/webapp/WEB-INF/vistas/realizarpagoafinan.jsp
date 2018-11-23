<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Mutual</title>
	
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">

	</head>
	<body>
	
		<h1>Formulario para realizar pago a la mutual</h1>
		<h4>usando esta vista solo para probar</h4>
		Valor del prestamo: ${lcuota.prestamo.valor}
		<c:forEach items="${cuotas}" var="cuota">
			<p>Id:${cuota.idCuota}
				monto:${cuota.monto} 
				interes:${cuota.interes}
				total:${cuota.montoTotal}
				estado:${cuota.estado} 
				fechaPago:${cuota.fechaDePago} 
				fechaVencimiento:${cuota.fechaDeVencimiento}
				
			</p>
		</c:forEach>
	
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>