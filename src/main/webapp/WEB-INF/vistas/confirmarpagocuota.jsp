<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar todos los préstamos</title>
		
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		
		<div class="container">
			<h3>Datos del Afiliado</h3>
			<h3>Nombre : ${afiliado.nombre}</h3>
			<h3>Apellido : ${afiliado.apellido}</h3>
			<h3>DNI : ${afiliado.dni}</h3>
		
		</div>
	<form action="totalpago" method="POST">
		<div class="container">
			<h1 class="text-center">LISTA DE PRESTAMOS</h1>
			<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">Numero de Cuota</th>
			      <th scope="col">Fecha de Vencimiento</th>
			      <th scope="col">Valor</th>
			      <th scope="col">Fecha De Pago</th>
			      <th scope="col">Seleccionar Cuotas a Pagar</th>
			      
			    </tr>
			  </thead>
			  <!-- listar todos los afiados -->
				  <tbody>
				  <c:forEach items="${cuotaspagas}" var="cuotaspagas">
				    <tr>				    
			  
				      <td scope="row">X</td>
				      <td>${cuotaspagas.fechaDeVencimiento}</td>
				      <td>${cuotaspagas.monto}</td>
				      <td>${cuotaspagas.fechaDePago }</td>
				      <td>
				      Pagada
				      </td>
			  
			  </tr>
			  </c:forEach>
			  
			  <c:forEach items="${cuotasnopagas}" var="cuotasnopagas">
			  <tr>
				      <td scope="row">X</td>
				      <td>${cuotasnopagas.fechaDeVencimiento}</td>
				      <td>${cuotasnopagas.monto}</td>
				      <td>Sin Pagar</td>
				      <td>
				      <input type="checkbox" id="${cuotasnopagas.idCuota}" name="${cuotasnopagas.idCuota}" value="${cuotasnopagas.monto}">
				      </td>
				        </tr>
			  </c:forEach>
				  
				  </tbody>
			</table>
		</div>
		<button type="submit" class="btn btn-primary mb-2">Confirmar Pago</button>
	</form>
		

		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	
	</body>
</html>