<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar nueva financiera</title>
<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">

</head>

<body class="container">
<h2>Agregar Nueva Financiera</h2>
<div class="col-lg-6">
	<form:form role="form" action="agregado" method="Post" modelAttribute="financiera">
		<div class="form-group">
		<label>nombre:</label>
		<form:input path="nombre" id="nombre" type="text" class="form-control"/>
		</div>
		<div>
			<label>Monto Capital:</label>
			<form:input path="montoCapital" id="montoCapital" type="text" class="form-control"/>
		</div>
			<div>
			<button type="submit" class="btn btn-success">Agregar</button>
			</div>
	<p>${error}</p>
	

	</form:form>
	<br>
		<a href="/FinanWeb/home"><button class="btn btn-primary btn-lg" type ="submit">Inicio</button></a>
		<br>
</div>
</body>
</html>