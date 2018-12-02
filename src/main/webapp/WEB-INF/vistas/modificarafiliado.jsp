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
<title>Modificar afiliado</title>
</head>
	<body>
			<div class = "container">
		<div class="panel panel-default">
		    <div class="panel-heading">Modificar afiliado</div>
		    <div class="panel-body">
		    	<form:form role="form" action="afiliadomodificado" method="POST" modelAttribute="afiliado">
		    	
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Nombre:</label>
					  <div class="col-lg-10">
					  	<form:input path="nombre" id="nombre" class="" type="text" placeholder="${afili.nombre}"/>
					  </div>
				  </div>
				  				  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Apellido:</label>
					  <div class="col-lg-10">
					  	<form:input path="apellido" id="apellido" class="" type="text" placeholder="${afili.apellido}"/>
					  </div>
				  </div>
				  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Dni:</label>
					  <div class="col-lg-10">
					  	<form:input path="dni" id="dni" class="" type="text" placeholder="${afili.dni}"/>
					  </div>
				  </div>
				  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Puesto:</label>
					  <div class="col-lg-10">
					  	<form:input path="puesto" id="puesto" class="" type="text" placeholder="${afili.puesto}"/>
					  </div>
				  </div>
				  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Antiguedad:</label>
					  <div class="col-lg-10">
					  	<form:input path="antiguedad" id="antiguedad" class="" type="text" placeholder="${afili.antiguedad}"/>
					  </div>
				  </div>
				  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Sueldo:</label>
					  <div class="col-lg-10">
					  	<form:input path="sueldo" id="sueldo" class="" type="text" placeholder="${afili.sueldo}"/>
					  </div>
				  </div>
				  
				  <form:input path="idAfiliado" id="idAfiliado" type="hidden" value="${afili.idAfiliado}" />
				  
				  <div class="form-group row">
				  		<div class="col-lg-2"></div>
				  		<div class="col-lg-10">
						  <button type="submit" class="btn btn-success">Guardar cambios</button>
						</div>
				  </div>
				  <p>${error}</p>
				</form:form>
			</div>
		</div>
	</div>
	</body>
</html>