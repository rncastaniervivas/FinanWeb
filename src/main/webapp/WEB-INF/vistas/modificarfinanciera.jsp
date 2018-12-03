<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Modificar financiera</title>
<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">

</head>
<body class="container">
<h2>Modificar Financiera</h2>
<div class="col-lg-6">
<form:form role="form" action="modificado" method="Post" modelAttribute="financiera">

			<div class="form-group">
			<label>nombre:</label><br>
			<form:input path="nombre" id="nombre" class="form-control" type="text" placeholder="${finan.nombre}" />
			</div>
			<div class="form-group">
			<label>Monto Capital:</label><br>
			<form:input path="montoCapital" id="nombre" class="form-control" type="text" placeholder="${finan.montoCapital}" />
			</div>
<form:input path="idFinanciera" id="idFinanciera" type="hidden" value="${finan.idFinanciera}" />
<button type="submit" class="btn btn-success">Guardar Cambios</button>
<p>${error}</p>
</form:form>
</div>


		<br>
		<a href="/FinanWeb/home"><button class="btn btn-primary btn-lg" type ="submit">Inicio</button></a>
		<br>

</body>
</html>