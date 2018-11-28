<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todos los afiliados</title>
</head>
<body>
	<div class="container">
			<h1 class="text-center">Lista de afiliados</h1>
			<table class="table">
			  <thead class="thead-light">
			    <tr>
			      <th scope="col">Nombre</th>
			      <th scope="col">Apellido</th>
			      <th scope="col">Dni</th>
			      <th scope="col">Puesto</th>
			      <th scope="col">Antiguedad</th>
			      <th scope="col">Sueldo</th>
			    </tr>
			  </thead>
			  <!-- listar todos los afiliados -->
			  <c:forEach items="${afiliado}" var="afiliado">
				  <tbody>
				    <tr>
				      <th scope="row">${afiliado.nombre}</th>
				      <td scope="row">${afiliado.apellido}</td>
				      <td scope="row">${afiliado.dni}</td>
				      <td scope="row">${afiliado.puesto}</td>
				      <td scope="row">${afiliado.antiguedad}</td>
				      <td scope="row">${afiliado.sueldo}</td>
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