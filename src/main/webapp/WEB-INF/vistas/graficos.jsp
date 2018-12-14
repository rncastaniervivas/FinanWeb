<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/xbootstrap.min.css" rel="stylesheet">
    	<link href="css/xheroic-features.css" rel="stylesheet">
<title>Gráficos</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<div>
		<h1 class="text-center">Gráficos de préstamos</h1>
		<br><br>
			<form action="top5afiliados" method="POST" >
			  <button type="submit" class="btn btn-info" name="opcion" value="1">Top 5 de afiliados con mayor préstamo</button>
			</form>
			<br>
			<form action="top5afiliados" method="POST" >
			  <button type="submit" class="btn btn-info" name="opcion" value="2">Top 5 de afiliados con menor préstamo</button>
			</form>
			<br>
			<form action="top5financieras" method="POST" >
			  <button type="submit" class="btn btn-info" name="opcion" value="3">Top 5 de financieras con mayor préstamo</button>
			</form>
			<br>
			<form action="top5financieras" method="POST" >
			  <button type="submit" class="btn btn-info" name="opcion" value="4">Top 5 de financieras con menor préstamo</button>
			</form>
			<br>
	</div>
	
	<div>
		<h1 class="text-center">Gráficos de caja</h1>
		<br>
			<form action="graficocaja" method="POST" >
			  <button type="submit" class="btn btn-info" name="opcion" value="1">Grafico de Ingresos</button>
			</form>
		<br>
			<form action="graficocaja" method="POST" >
			  <button type="submit" class="btn btn-info" name="opcion" value="2">Grafico de Egresos</button>
			</form>
	</div>	
	
		<br>
		<a href="javascript:window.history.go(-1);"><button class="btn btn-primary btn-lg">Regresar</button></a>
		<br>
</body>
</html>