<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">

</head>
<body class="text-center">
<h2>Agregar Nueva Financiera</h2>
<form:form class="form-inline d-iniline" action="agregado" method="Post" modelAttribute="financiera">
<form:input path="nombre" id="nombre" type="text" class="form-control"/>
<button type="submit" class="btn btn-success">Agregar</button>
<p>${error}</p>

</form:form>

</body>
</html>