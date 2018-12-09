<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
			      <th scope="col">Id</th>
			      <th scope="col">Nombre</th>
			      <th scope="col">Apellido</th>
			      <th scope="col">Dni</th>
			      <th scope="col">Antiguedad</th>
			      <th scope="col">Sueldo</th>
			      <th schope="col">Opciones</th>
			      
			    </tr>
			  </thead>
			  <!-- listar todos los afiliados -->
			  <c:forEach items="${afiliados}" var="lista">
				  <tbody>
				    <tr>
				      <td scope="col">${lista.idAfiliado}</td>
				      <td scope="col">${lista.nombre}</td>
				      <td scope="col">${lista.apellido}</td>
				      <td scope="col">${lista.dni}</td>
				      <td scope="col">${lista.antiguedad}</td>
				      <td scope="col">${lista.sueldo}</td>
				      <td scope="row">
				      	<form:form action="eliminarafiliado" method="POST" modelAttribute="afiliado">
					      	<form:input path="idAfiliado" id="idAfiliado" type="hidden" value="${lista.idAfiliado}"/>
							<form:input path="nombre" id="nombre" readonly="readonly" type="hidden" value="${lista.nombre}" />
							<form:input path="apellido" id="apellido" readonly="readonly" type="hidden" value="${lista.apellido}" />
							<form:input path="dni" id="dni" readonly="readonly" type="hidden" value="${lista.dni}" />
							<form:input path="puesto" id="puesto" readonly="readonly" type="hidden" value="${lista.puesto}" />
							<form:input path="antiguedad" id="antiguedad" readonly="readonly" type="hidden" value="${lista.antiguedad}" />
							<form:input path="sueldo" id="sueldo" readonly="readonly" type="hidden" value="${lista.sueldo}" />
							
							<button class="btn btn-danger" type="submit"><span class="glyphicon glyphicon-remove"></span>Eliminar</button>
							<button class="btn btn-info" type="submit" formaction="modificarafiliado"><span class="glyphicon glyphicon-align-justify"></span>Modificar</button>
							<button class="btn btn-success" type="submit" formaction="nuevoprestamo">Nuevo Prestamo</button>
							<button class="btn btn-info" name="dni" formaction="misprestamos" value="${lista.dni}">Mis Prestamos</button>
						</form:form>
					  </td>
				    </tr>
				  </tbody>
			  </c:forEach>
			</table>
		</div>
		<br>
		<form:form class="form-inline d-iniline" action="agregarafiliado">
			<br>
			<button class="btn btn-primary btn-lg" type="submit">Nuevo afiliado</button>
		</form:form>
			<c:if test="${not empty error}">
		        <h4><span>${error}</span></h4>
		        <br>
	        </c:if>	
		
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