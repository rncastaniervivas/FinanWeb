<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar financiera</title>
        <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/xbootstrap.min.css" rel="stylesheet">
    	<link href="css/xheroic-features.css" rel="stylesheet">

</head>
<body class="container">

<jsp:include page="header.jsp" />

<div ></br>
<h1 class="text-center">Mis Financieras</h1></br>

<div class="row">
	<div class="col-md-7">
		<form:form class="form-inline d-iniline" action="agregarfinanciera">
		<button class="btn btn-primary" type="submit">nueva finaciera</button>
		</form:form>
	</div>
	<h4><span>${error}</span></h4>
	<div class="col-md-5">
		<form:form class="form" action="encontrado" mothod="Post" modelAttribute="financiera">
			<form:input type="text"  path="nombre" id="nombre" placeholder="Frances"/>
			<button type="submit" class="btn-success"><span class="glyphicon glyphicon-search"></span> Buscar Financiera</button>
		</form:form>
	</div>
</div>

</br>

<table class=" table">
<thead class="thead-light">
			    <tr>
			      <th scope="col"><h4>Id Financiera</h4></th>
			      <th scope= "col"><h4>Nombre</h4></th>
			      <th scope= "col"><h4>Monto Capital</h4></th>
			      <th scope= "row"><h4>Opciones</h4></th>
			    </tr>
</thead>
<c:forEach items="${financieras}" var="lista">
<tbody>
				    <tr>
				      <th scope= "col">${lista.idFinanciera}</th>
				      <th scope= "col">${lista.nombre }</th>
				      <th scope= "col">${lista.montoCapital}</th>
				      <th scope= "row"><form:form action="eliminado" method="Post" modelAttribute="financiera">
						<form:input path="idFinanciera" id="idFinanciera" type="hidden" value="${lista.idFinanciera}"/>
						<form:input path="nombre" id="nombre" readonly="readonly" type="hidden" value="${lista.nombre}" />
						<form:input path="montoCapital" id="montoCapital" readonly="readonly" type="hidden" value="${lista.montoCapital}" />
							<button class="btn btn-danger" type="submit"><span class="glyphicon glyphicon-remove"></span> eliminar</button>
							<button class="btn btn-info" type="submit" formaction="modificarfinanciera"><span class="glyphicon glyphicon-align-justify"></span> modificar</button>
							<button class="btn btn-success" type="submit" formaction="pagarfinancieras"><span class=" glyphicon glyphicon-align-justify"></span> pagar</button>
								</form:form>
								</th>
				    </tr>
</tbody>
</c:forEach>
</table>
<p>${erroeliminar}</p>
</div>

		<br>
		<a href="javascript:window.history.go(-1);"><button class="btn btn-primary btn-lg">Regresar</button></a>
		<br>
		
<!-- iconos https://www.glyphicons.com/  -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>