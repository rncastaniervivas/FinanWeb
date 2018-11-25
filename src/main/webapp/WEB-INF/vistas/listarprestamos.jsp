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
			<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
			  <li class="nav-item">
			    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">Home</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">Profile</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
			  </li>
			</ul>
		</div>
		
		<div class="container">
			<h3>${afiliado.nombre} ${afiliado.apellido}</h3>
		
		</div>
	
		<div class="container">
			<h1 class="text-center">LISTA DE PRESTAMOS</h1>
			<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">Valor</th>
			      <th scope="col">Cuotas</th>
			      <th scope="col">Intereces</th>
			    </tr>
			  </thead>
			  <!-- listar todos los afiados -->
			  <c:forEach items="${prestamos}" var="prestamos">
				  <tbody>
				    <tr>
				      <th scope="row">${prestamos.valor}</th>
				      <td>${prestamos.cuotas}</td>
				      <td>${prestamos.interes}</td>
				      <td><form action="refinanciar" method="POST" >
				      	  <input type="hidden" name="dni" value="${afiliado.dni}">
				      	  <button type="submit" class="btn btn-info" name="idPrestamo" value="${prestamos.idPrestamo}">Refinanciar</button>
				      	  </form>
				      </td>
				    </tr>
				  </tbody>
			  </c:forEach>
			</table>
		</div>
		

		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	
	</body>
</html>