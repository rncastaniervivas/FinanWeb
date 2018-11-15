<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear nuevo préstamo</title>

		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class = "container">
			<div class="panel panel-default">
			    <div class="panel-heading">Nuevo préstamo</div>
			    <div class="panel-body">
			    <div class="panel panel-default">
			    	<form:form action="listarprestamos" modelAttribute="prestamo" method="POST" class="form-horizontal" role="form">
					  
					  <label class="col-lg-3 control-label">Cuotas:</label>
					  	  <select id="cuota" name="cuota" class="form-control">
							  <option>6</option>
							  <option>12</option>
							  <option>24</option>
							  <option>36</option>
							  <option>72</option>
						  </select>
					  <br>
					  
					  <label class="col-lg-2 control-label">Valor:</label>
					  <input type="text" id="valor" name="valor" placeholder="Valor"  class="form-control">
					  <br>
					  
					  <label class="col-lg-2 control-label">Interes:</label>
					  <input type="text" id="interes" name="interes" placeholder="Interes"  class="form-control">
					  <br>
					  
					  <button type="submit" class="btn btn-success">Crear Préstamo</button>
					  
					</form:form>
					</div>
				</div>
			</div>
</body>
</html>