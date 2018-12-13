<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Nuevo Prestamo</title>

	<!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
	<script>
    function PostForm() {
        if (IsValid()) {
            $("#lblErrorP").text("");
            document.forms["frmPrestamo"].submit();
        }
    }
    function IsValid() {
        HideDivMessageP();
        var field;
        field = $("#valor").val();
        if (field.length == 0) {
            $("#lblErrorP").text("Debe ingresar un valor para el prestamo.");
            ShowDivMessageP();
            return false;
        }
        return true;
    }
    function ShowDivMessageP() {
        scroll(0, 0);
        $("#divMessagesP").show("slow", function () { });
    }
    function HideDivMessageP() {
        $("#divMessagesP").hide();
    }
</script>
	<div class="container">
		<form:form action="validar-nuevo-prestamo" method="POST" modelAttribute="afiliado" name="frmPrestamo">
		  <form:input type="hidden" path="dni" value="${afiliado.dni}"/>
		  <form:input type="hidden" path="idAfiliado" value="${afiliado.idAfiliado}"/>
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label >Nombre</label>
		      <input type="text" class="form-control" value="${afiliado.nombre}" id="inputNombre" disabled>
		    </div>
		    <div class="form-group col-md-6">
		      <label >Apellido</label>
		      <input type="text" class="form-control" value="${afiliado.apellido}" id="inputApellido" disabled>
		    </div>
		    <div class="form-group col-md-6">
		      <label >Prestamo maximo disponible</label>
		      <input type="text" class="form-control" value="${disponible}" id="inputApellido" disabled>
		    </div>
		    <div class="form-group col-md-4"></div>
		    <div class="form-group col-md-4"></div>
		    <div class="form-group col-md-6">
		    	<label class="col-lg-2 control-label">Cuotas</label>
				<div class="col-lg-10">
					<select name="cuotas" id="cuotas" class="form-control">
						<option value="6">6</option>
						<option value="12">12</option>
						<option value="24">24</option>
						<option value="36">36</option>
						<option value="72">72</option>
					</select>
				</div>
		    </div>
		    <div class="form-group col-md-6">
		      <label >Nuevo Monto</label>
		      <input id="valor" name="valor" type="text" class="form-control" id="inputMonto">
		    </div>
		     <div class="form-group col-md-6"></div>
		     <div class="form-group col-md-6"></div>
		     <div class="form-group col-md-6">
		    	<label class="col-lg-2 control-label">Financieras</label>
				<div class="col-lg-10">
					<select name="nombreF" id="nombreF" class="form-control">
						
						<c:forEach items="${financieras}" var="lista">
						<option value="${lista.nombre}">${lista.nombre} (${lista.montoCapital})</option>
						</c:forEach>
					
					</select>
				</div>
			    </div>
			    		     <div id="divMessagesP" style="display: none;">
                        <p align="left">
                            <div class="alert alert-danger" style="text-align: left;">
                                <label id="lblErrorP" style="font-size: 12px; color: firebrick; font-weight: bold; margin-left: 5px;"></label>
                            </div>
                        </p>
			 </div>
		    <div class="form-group col-md-10">
			    <c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>
		    </div>
			    
			   
		    <div class="form-group col-md-4">
		    	<button class="btn btn-info" type="submit" onclick="PostForm(); return false;">Dar Prestamo</button>
			</div>
		  </div>
		</form:form>
	</div>
	
	<div class="container">
		<h1 class="text-center">Lista de préstamos existentes</h1>
		<table class="table">
		  <thead class="thead-light">
		    <tr>
		      <th scope="col">Valor</th>
		      <th scope="col">Cuotas</th>
		      <th scope="col">Intereses</th>
		      <th scope="col">Estado</th>
		      
		    </tr>
		  </thead>
		  <!-- listar todos los afiados -->
		  <c:forEach items="${prestamos}" var="prestamos">
			  <tbody>
			    <tr>
			      <th scope="row">${prestamos.valor}</th>
			      <td>${prestamos.cuotas}</td>
			      <td>${prestamos.interes}</td>
			      <td>${prestamos.estado}</td>
			    </tr>
			  </tbody>
		  </c:forEach>
		</table>
	</div>
	
		<br>
		<a href="javascript:window.history.go(-1);"><button class="btn btn-primary btn-lg">Regresar</button></a>
		<br>
		<br>
		<a href="/FinanWeb/home"><button class="btn btn-primary btn-lg" type ="submit">Inicio</button></a>
		<br>
	
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>