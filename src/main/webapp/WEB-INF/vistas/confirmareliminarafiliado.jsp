<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/xbootstrap.min.css" rel="stylesheet">
    	<link href="css/xheroic-features.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar afiliado</title>
</head>
<body>
<div class="panel-heading">Datos del afiliado a eliminar</div>
	<div class="panel-body">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th>Id de Afiliado</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Dni</th>
					<th>Puesto</th>
					<th>Antiguedad</th>
					<th>Sueldo</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${afiliados}" var="lista">
					<tr>
						<td scope="row"> ${lista.idAfiliado}</td>
							<td scope="row">${lista.nombre}</td>
							<td scope="row">${lista.apellido}</td>
							<td scope="row">${lista.dni} </td>
							<td scope="row">${lista.puesto} </td>
							<td scope="row">${lista.antiguedad}</td>
							<td scope="row">${lista.sueldo}</td>
				</c:forEach>
				
				
			</tbody>				
		</table>
		<button type="submit" class="glyphicon glyphicon-remove" action="eliminarafiliado">Eliminar afiliado</button>
	</div>
</body>
</html>