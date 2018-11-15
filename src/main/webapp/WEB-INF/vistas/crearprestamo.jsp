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
		    	<form:form action="crearprestamo" modelAttribute="prestamo" method="POST" role="form">
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Cuotas</label>
					  <div class="col-lg-10">
					  	  <form:select path="cuotas" id="cuotas" class="form-control">
							  <option value="6">6</option>
							  <option value="12">12</option>
							  <option value="24">24</option>
							  <option value="36">36</option>
							  <option value="72">72</option>
						  </form:select>
					  </div>
				  </div>
				  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Valor</label>
					  <div class="col-lg-10">
					  	<form:input path="valor" type="text" id="valor" placeholder="Valor"  class="form-control"/>
					  </div>
				  </div>
				  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Interes</label>
				  	  <div class="col-lg-10">
				  	  	<form:input path="interes" type="text" id="interes" placeholder="Interes"  class="form-control"/>
				  	  </div>
				  </div>
				  
				  <div class="form-group row">
				  		<div class="col-lg-2"></div>
				  		<div class="col-lg-10">
						  <button type="submit" class="btn btn-success">Crear Préstamo</button>
						</div>
				  </div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>