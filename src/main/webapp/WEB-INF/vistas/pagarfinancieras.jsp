<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>pagar a Financieras</title>
<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">

</head>
<body class="container">
	<div class="page-header">
		<h1>Pagar a Financieras</h1>
	</div>
		<div class="col-md-12"><h3>Selecciones financiera</h3>
		</div>	
	<div class="col-md-12">
		
			<c:forEach items="${financieras}" var="finan">
			<div class="col-md-2">
				<form:form  action="realizarpagoafinanciera" modelAttribute="financiera">
				<form:input path="nombre" type="hidden" id="nombre"  value="${finan.nombre}"/>
				<button class="btn btn-success" type="submit">"${finan.nombre }"</button>
				</form:form>
			</div>
			</c:forEach>
	</div>
		<div class="page-header">
		<h3>Listado de Cuotas</h3>
		</div>
<div class="row">
		<table class="table">
			<thead class="thead-light">
				<tr>
			      <th scope="col">Numero de Prestamo</th>
			      <th scope="col">Afiliado</th>
			      <th scope="col">Numero de couta</th>
			      <th scope="col">Fecha Vencimiento</th>
			      <th scope="col">Monto a pagar</th>
			      <th scope="col">Realizar</th>
			    </tr>
			</thead>
		<c:forEach items="${cuotas}" var="cuotas">
				<tr>
			      <th scope="col">${cuotas.prestamo.getIdPrestamo()}</th>
			      <th scope="col">${cuotas.prestamo.afiliado.getNombre()}</th>
			      <th scope="col">${cuotas.idCuota}</th>
			      <th scope="col">${cuotas.fechaDeVencimiento}</th>
			      <th scope="col">${cuotas.monto}</th>
			      <th scope="col">
			      			<form:form action="restarsaldo" modelAttribute="cuota">
							<form:input path="idCuota" id="idCuota" value="${cuotas.idCuota}" type="hidden"/>
							<form:input path="monto" id="monto"  type="hidden" value="${cuotas.monto}"/>
							<button type="submit" class="btn btn-info">pagar</button>
			      			</form:form>
			      		
			    </tr>

		</c:forEach>
		</table>
</div>
<div><p class="lead">Estado de la caja ${montocaja}</p></div>
<!-- iconos https://www.glyphicons.com/  -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>