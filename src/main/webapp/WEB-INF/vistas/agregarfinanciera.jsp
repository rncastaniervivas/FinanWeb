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
<body>
	<div class = "container">
		<div class="panel panel-default">
		    <div class="panel-heading">Nueva financiera</div>
		    <div class="panel-body">
		    	<form:form action="agregado" modelAttribute="financiera" method="POST" role="form">
				  			  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Nombre:</label>
					  <div class="col-lg-10">
					  	<form:input path="nombre" type="text" id="nombre" placeholder="Nombre"  class="form-control"/>
					  </div>
				  </div>
				  
				  <div class="form-group row">
				  		<div class="col-lg-2"></div>
				  		<div class="col-lg-10">
						  <button type="submit" class="btn btn-success">Agregar financiera</button>
						</div>
				  </div>
				  <p>${error}</p>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>