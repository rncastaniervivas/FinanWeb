<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
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
<h2>Modificar Financiera</h2>

<form:form role="form" action="modificado" method="Post" modelAttribute="financiera">
<div class="form-group">
<label class="text-left">nombre:</label><br>
<form:input path="nombre" id="nombre" class="" type="text" placeholder="${finan.nombre}"/>
</div>
<form:input path="idFinanciera" id="idFinanciera" type="hidden" value="${finan.idFinanciera}" />
<button type="submit" class="btn btn-success">Guardar Cambios</button>
</form:form>
</body>
</html>