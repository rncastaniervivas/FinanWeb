<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			<h5>Datos del Afiliado</h5>
			<h5>Nombre : ${afiliado.nombre}</h5>
			<h5>Apellido : ${afiliado.apellido}</h5>
			<h5>DNI : ${afiliado.dni}</h5>
			<h5>Valor Total del prestamo: ${prestamo.valor}</h5>
		
		</div>
		<form:form action="totalapagarcuota" modelAttribute="confirm" method="POST" role="form">
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
				  <c:forEach items="${idCuotas}" var="idCuotas">
				    <tr>				    
			  
				      <td scope="row">X</td>
				      <td>${idCuotas}</td>
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
				      <input type="checkbox" id="check" name="check" value="${cuotasnopagas.idCuota}">
		      		  
				      </td>
				        </tr>
			  </c:forEach>
				  
				  </tbody>
			</table>
		</div>
		<input path="dni" type="text" id="dni" name="dni"class="form-control" value="${afiliado.dni}" style="display:none"/>
		<input path="idPrestamo" type="text" id="idPrestamo" name="idPrestamo"class="form-control" value="${prestamo.idPrestamo}"/>
		<button type="submit" class="btn btn-primary mb-2">Confirmar Pago</button>
</form:form>
		

		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	
	</body>
</html>