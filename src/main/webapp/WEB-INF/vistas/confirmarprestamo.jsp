<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Nuevo Prestamo</title>
		
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    
	</head>
	
	<body>
		
	
		<div class="container">
			<h1 class="text-center">Lista de cuotas de préstamos impagas</h1>
			<table class="table">
			  <thead class="thead-light">
			    <tr class="bg-danger">
			      <th scope="col">Nro Cuota</th>
			      <th scope="col">Fecha Vencimiento</th>
			      <th scope="col">Valor de cuota + interez</th>
			    </tr>
			  </thead>
			  <!-- listar todos los afiados -->
			  <c:forEach items="${cuotas}" var="cuota">
				  <tbody>
				    <tr class="table-danger">
				      <th scope="row">${cuota.idCuota}</th>
				      <td>${cuota.fechaDeVencimiento}</td>
				      <td>${cuota.monto}</td>
				    </tr>
				  </tbody>
			  </c:forEach>
			</table>
		</div>
		
		<div class="container">
			<form method="POST">
			  <input type="hidden" name="dni" value="${afiliado.dni}">
			  <input type="hidden" name="idAfiliado" value="${afiliado.id}">
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label >Nombre</label>
			      <input type="text" class="form-control" value="${afiliado.nombre}" id="inputNombre" disabled>
			    </div>
			    <div class="form-group col-md-6">
			      <label >Apellido</label>
			      <input type="text" class="form-control" value="${afiliado.apellido}" id="inputApellido" disabled>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputCity">Monto Total A Pagar</label>
			      <!--input type="hidden" name="newCapital" value="${prestamoARef.saldo}"-->
			      <input type="text"  value="${valor}" class="form-control" disabled>                      			      
			    </div>
			    <div class="form-group row">
					<label class="col-lg-2 control-label">Interes anual</label>
					<div class="col-lg-2 control-label">
					  	<input type="text" id="interes" value="35%" class="form-control" disabled>
					</div>
				</div>
			  </div>
			  <div class="form-group col-md-6">
			  	<button type="submit" class="btn btn-primary" formaction="validar-nuevo-prestamo">Aceptar</button>
			  </div>
			<form>
		</div>

		<br>
		<form><button type="submit" class="btn btn-primary  btn-lg" formaction="listarprestamos">Regresar</button></form>
		<br>
		<br>
		<a href="/FinanWeb/home"><button class="btn btn-primary btn-lg">Home</button></a>
		<br>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	
	</body>
</html>