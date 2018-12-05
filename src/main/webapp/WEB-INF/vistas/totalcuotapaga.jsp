<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Listar todos los pr�stamos</title>
		
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		
		<div class="container">
			<ul class="list-group">
				<h3 class="list-group-item">Datos del Afiliado</h3>
				
				<div class="input-group input-group-sm">
  					<span class="input-group-addon">Nombre:</span>
  					<li class="list-group-item">${afiliado.nombre}</li>
				</div>
				
				<div class="input-group input-group-sm">
  					<span class="input-group-addon">Apellido:</span>
  					<li class="list-group-item">${afiliado.apellido}</li>
				</div>
				
				<div class="input-group input-group-sm">
  					<span class="input-group-addon">Dni:</span>
  					<li class="list-group-item">${afiliado.dni}</li>
				</div>
				<div class="input-group input-group-sm">
  					<span class="input-group-addon">Valor Total del prestamo:</span>
  					<li class="list-group-item">${prestamo.valor}</li>
				</div>
			</ul>
		</div>
		<form:form action="finalizarpagocuota" modelAttribute="confirm" method="POST" role="form">
		<div class="container">
			<h1 class="text-center">Lista de pr�stamos</h1>
			<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">Valor</th>
			      <th scope="col">Fecha De Vencimiento</th>
			      <th scope="col">Valor</th>
			      
			    </tr>
			  </thead>
			  <!-- listar todos los afiados -->
				  <tbody>
				  			  
			  <c:forEach items="${cuotasnopagas}" var="cuotasnopagas">
			  <tr>
				      <td scope="row">${cuotasnopagas.monto}</td>
				      <td>${cuotasnopagas.fechaDeVencimiento}</td>
				      <td>${cuotasnopagas.monto}</td>
				        </tr>
				      <input type="text" id="check" name="check" value="${cuotasnopagas.idCuota}" style="display:none">
			  </c:forEach>
				  <td>Total</td>
				  <td></td>
				  <td>${totalcuota}</td>
				  </tbody>
			</table>
		</div>
		<input path="dni" type="text" id="dni" name="dni"class="form-control" value="${afiliado.dni}" style="display:none"/>
		<input path="idPrestamo" type="text" id="idPrestamo" name="idPrestamo"class="form-control" value="${prestamo.idPrestamo}" style="display:none"/>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
		<button type="submit" class="btn btn-success mb-2">Confirmar Pago</button>
</form:form>
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