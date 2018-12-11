<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar todas las cuotas</title>
		
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	
	<body>
		
		</br></br>
		<div class="container">
		  <div class="form-row">
		  	<div class="form-group col-md-4">
		      <label >Dni</label>
		      <input type="text" class="form-control" value="${afiliado.dni}" id="inputApellido" disabled>
		    </div>
		    <div class="form-group col-md-4">
		      <label >Nombre</label>
		      <input type="text" class="form-control" value="${afiliado.nombre}" id="inputNombre" disabled>
		    </div>
		    <div class="form-group col-md-4">
		      <label >Apellido</label>
		      <input type="text" class="form-control" value="${afiliado.apellido}" id="inputApellido" disabled>
		    </div>
		  </div>
		</div>

		<div class="container">
		  <div class="form-row">
		  	<div class="form-group col-md-4">
		      <label >Saldo a Refinanciar</label>
		      <input type="text" class="form-control" value="${prestamoARef.saldo}" id="inputApellido" disabled>
		    </div>
		  </div>
		</div>

		<div class="container">
			<h1 class="text-center">Lista de cuotas</h1>
			<table class="table">
			  <thead class="thead-light">
			    <tr class="bg-danger">
			      <th scope="col">Nro Cuota</th>
			      <th scope="col">Fecha Vencimiento</th>
			      <th scope="col">Monto Interes</th>
			      <th scope="col">Monto Amortizacion</th>
			      <th scope="col">Monto Total</th>
			    </tr>
			  </thead>
			  <!-- listar todos los afiados -->
			  <% int cuotas = 0;%>
			  <c:forEach items="${cuotas}" var="cuota">
				  <tbody>
				    <tr class="table-danger">
				      <th scope="row">${cuota.idCuota}</th>
				      <td>${cuota.fechaDeVencimiento}</td>
				      <td>${cuota.interes}</td>
				      <td>${cuota.montoTotal}</td>
				      <td>${cuota.monto}</td>
				    </tr>
				  </tbody>
				  <% cuotas ++;%>
			  </c:forEach>
			</table>
		</div>
		<form action="hacer-refinanciacion" method="POST">
			<input type="hidden" name="cuotas" value="<%= cuotas %>">
			<input type="hidden" name="idPrestamoARef" value="${prestamoARef.idPrestamo}">
			<input type="hidden" name="dni" value="${afiliado.dni}">
			<button type="submit" class="btn btn-success" name="refinanciar">Aceptar Refinanciacion</button>
		</form>
		
		<br>
		<a href="javascript:window.history.go(-1);"><button class="btn btn-primary btn-lg">Regresar</button></a>
		<br>
		<br>
		<a href="/FinanWeb/home"><button class="btn btn-primary btn-lg" type ="submit">Inicio</button></a>
		<br>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	
	</body>
</html>