<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear nuevo pr�stamo</title>

		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<h1>vista perdida</h1>
	<!--div class = "container">
		<div class="panel panel-default">
		    <div class="panel-heading">Nuevo pr�stamo</div>
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
				  	  	<form:input path="dni" type="text" id="dni" class="form-control" value="${dni}" style="display:none"/>
				  	  
				  <div class="form-group row">
					  <label class="col-lg-2 control-label">Valor</label>
					  <div class="col-lg-10">
					  	<form:input path="valor" type="text" id="valor" placeholder="Valor"  class="form-control"/>
					  </div>
				  </div>
				  
				  <div class="form-group row">
				  		<div class="col-lg-2"></div>
				  		<div class="col-lg-10">
						  <button type="submit" class="btn btn-success">Crear Pr�stamo</button>
						</div>
				  </div>
				</form:form>
				
				<br>
				<a href="/FinanWeb/home"><button class="btn btn-primary btn-lg" type ="submit">Inicio</button></a>
				<br>
				
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
	</div-->
</body>
</html>