<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- Bootstrap core CSS -->
	<link href="css/bootstrap.min.css" rel="stylesheet" >
	<!-- Bootstrap theme -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar nuevo afiliado</title>
</head>
<body>
<div class="panel panel-default">
		    <div class="panel-heading">Nuevo afiliado</div>
		    <div class="panel-body">
		    	<form:form action="afiliadoagregado" modelAttribute="afiliado" method="POST" role="form">
				  			  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Nombre:</label>
					  <div class="col-lg-10">
					  	<form:input path="nombre" type="text" id="nombre" placeholder="Nombre"  class="form-control"/>
					  </div>
				  </div>
				  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Apellido:</label>
					  <div class="col-lg-10">
					  	<form:input path="apellido" name="apellido" type="text" id="apellido" placeholder="Apellido" class="form-control"/>
					  </div>
				  </div>
				  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Dni:</label>
				  	  <div class="col-lg-10">
				  	  	<form:input path="dni" type="text" id="dni" name="dni" placeholder="Dni" class="form-control"/>
				  	  </div>
				  </div>
				  
				   <div class="form-group row">
					  <label class="col-lg-2 control-label">Puesto:</label>
				  	  <div class="col-lg-10">
				  	  	<form:input path="puesto" name="puesto" type="text" id="puesto" placeholder="Puesto" class="form-control"/>
				  	  </div>
				  </div>
				  
				   <div class="form-group row">
					  <label class="col-lg-2 control-label">Antiguedad:</label>
				  	  <div class="col-lg-10">
				  	  	<form:input path="antiguedad" name="antiguedad" type="text" id="antiguedad" placeholder="Antiguedad" class="form-control"/>
				  	  </div>
				  </div>
				  
				   <div class="form-group row">
					  <label class="col-lg-2 control-label">Sueldo:</label>
				  	  <div class="col-lg-10">
				  	  	<form:input path="sueldo" type="text" id="sueldo" name="sueldo" placeholder="Sueldo" class="form-control"/>
				  	  </div>
				  </div>
				  
				  <div class="form-group row">
				  		<div class="col-lg-2"></div>
				  		<div class="col-lg-10">
						  <button type="submit" class="btn btn-success">Agregar nuevo afiliado</button>
						</div>
				  </div>
				</form:form>
			</div>
		<div>
	</div>
</div>
<br>
<c:if test="${not empty error}">
 <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	

</body>
</html>