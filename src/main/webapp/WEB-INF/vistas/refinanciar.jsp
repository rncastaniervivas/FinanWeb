<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Refinanciar</title>
		
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet">
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    
	</head>
	
	<body>
		
		<div class="container">
			<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
			  <li class="nav-item">
			    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">Home</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">Profile</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">Contact</a>
			  </li>
			</ul>
		</div>
	
		<div class="container">
			<h1 class="text-center">LISTA DE CUOTAS-PRESTAMO IMPAGAS</h1>
			<table class="table">
			  <thead class="thead-light">
			    <tr class="bg-danger">
			      <th scope="col">Nro Cuota</th>
			      <th scope="col">Fecha Vencimiento</th>
			      <th scope="col">Monto Total</th>
			    </tr>
			  </thead>
			  <!-- listar todos los afiados -->
			  <c:forEach items="${cuotas}" var="cuota">
				  <tbody>
				    <tr class="table-danger">
				      <th scope="row">${cuota.idCuota}</th>
				      <td>${cuota.fechaDeVencimiento}</td>
				      <td>${cuota.montoTotal}</td>
				    </tr>
				  </tbody>
			  </c:forEach>
			</table>
		</div>
		
		<div class="container">
			<form action="hacer-refinanciacion" method="POST">
			  <input type="hidden" name="dni" value="${afiliado.dni}">
			  <input type="hidden" name="idPrestamoRef" value="${idPrestamoRef}">
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label >Nombre</label>
			      <input type="text" class="form-control" value="${afiliado.nombre}" id="inputNombre" disabled>
			    </div>
			    <div class="form-group col-md-6">
			      <label >Apellido</label>
			      <input type="text" class="form-control" value="${afiliado.apellido}" id="inputApellido" disabled>
			    </div>
			  </div>
			  <div class="form-row">
			    <div class="form-group col-md-6">
			      <label for="inputCity">Monto Total A Refinanciar</label>
			      <input type="hidden" name="newCapital" value="${MontoARefinanciar}">
			      <input type="text"  value="${MontoARefinanciar}" class="form-control" disabled>                      			      
			    </div>
			    <div class="form-group col-md-4">
			      <label for="inputState">Cuotas</label>
			      <select name="cuotas" id="inputState" class="form-control">
			        <c:forEach begin="1" end="12" varStatus="no">
				        <option value="${cuotasRestante + no.count}"><c:out value="Extender a ${cuotasRestante + no.count} cuotas"/></option>
				    </c:forEach>
			      <select>
			    </div>
			    <div class="form-group row">
					<label class="col-lg-2 control-label">Interes Extra (anual)</label>
					<div class="col-lg-2 control-label">
					  	<input name="interes" type="text" id="interes" value="0.05" class="form-control">
					</div>
				</div>
			  </div>
			  <div class="form-group col-md-6">
			  	<button type="submit" class="btn btn-primary">Aceptar</button>
			  </div>
			<form>
		</div>

		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	
	</body>
</html>