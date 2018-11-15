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
	    <link href="${context}/css...">
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
			<h1 class="text-center">LISTA DE FINANCIERAS A PAGAR</h1>
			<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Nombre Financiera</th>
			      <th scope="col">Numero de couta</th>
			      <th scope="col">Monto a pagar</th>
			      <th scope="col">Realizar</th>
			    </tr>
			  </thead>
			  <!-- listar todos los afiados -->
			  <c:forEach items="${financieras}" var="financiera">
				  <tbody>
				    <tr>
				      <th scope="row">${financiera.idFinanciera}</th>
				      <td>${financiera.nombre}</td>
				      <td>prueba(1 de 12)</td>
				      <td>prueba(0)</td>
				      <td><button type="button" class="btn btn-success">Pagar</button></td>
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