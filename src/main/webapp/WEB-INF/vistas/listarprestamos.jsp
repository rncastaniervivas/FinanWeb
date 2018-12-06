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
			<h3>${afiliado.nombre} ${afiliado.apellido}</h3>
		
		</div>
	
		<div class="container">
			<h1 class="text-center">Lista de préstamos</h1>
			<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">DNI Afiliado</th>
			      <th scope="col">Valor Del Préstamo</th>
			      <th scope="col">Cuotas</th>
			      <th scope="col">Intereses</th>
			      <th scope="col">Estado</th>
			      <th scope="col">Opciones</th>
			      
			    </tr>
			  </thead>
			  <!-- listar todos los afiados -->
			  <c:forEach items="${prestamos}" var="prestamos">
				  <tbody>
				    <tr>
				      <th scope="row">${prestamos.dni}</th>
				      <th>${prestamos.valor}</th>
				      <td>${prestamos.cuotas}</td>
				      <td>${prestamos.interes}</td>
				      <td>${prestamos.estado}</td>
				      <!-- >td><form action="refinanciar" method="POST" >
				      	  <button type="submit" class="btn btn-info ${prestamos.estado}" name="idPrestamo" value="${prestamos.idPrestamo}" >Refinanciar</button>
				      	  </form>
				      </td>
				      <td><form action="pagarcuota" method="POST" >
				      	  <button type="submit" class="btn btn-info ${prestamos.estado}" name="idPrestamo1" value="${prestamos.idPrestamo}" >Pagar</button>
				      	  </form>
				      </td>
				       <td><form action="cancelarprestamo" method="POST" >
				      	  <button type="submit" class="btn btn-info ${prestamos.estado}" name="idPrestamo2" value="${prestamos.idPrestamo}">Cancelar</button>
				      	  </form>
				      </td -->
				      
				      <!-- pongo esto porqeu lo de arriba no funcionaba -->
				      <td>
				      	<c:if test = "${prestamos.estado == 'activo'}">
					       <form method="POST" >
				      	  	 <button type="submit" class="btn btn-info" name="idPrestamo" value="${prestamos.idPrestamo}" formaction="refinanciar">Refinanciar</button>
				      	  	 <button type="submit" class="btn btn-success" name="idPrestamo1" value="${prestamos.idPrestamo}" formaction="pagarcuota">Pagar</button>
				      	  	 <button type="submit" class="btn btn-info" name="idPrestamo2" value="${prestamos.idPrestamo}" formaction="cancelarprestamo">Cancelar</button>
				      	   </form>
					    </c:if>
				      </td>
				      
				    </tr>
				  </tbody>
			  </c:forEach>
			</table>
			
			<c:if test="${not empty error}">
		        <h4><span>${error}</span></h4>
		        <br>
	        </c:if>
			
		</div>
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
		<script type="text/javascript">
		$(document).ready(function(){
				$(".pagado").css("display","none");
					
		});
		</script>
	
	</body>
</html>