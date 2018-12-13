<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/xbootstrap.min.css" rel="stylesheet">
    	<link href="css/xheroic-features.css" rel="stylesheet">
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar nuevo afiliado</title>

</head>
<body>
<script>
    function PostForm() {
        if (IsValid()) {
            $("#lblErrorP").text("");
            document.forms["frmAfiliado"].submit();
        }
    }
    function IsValid() {
        HideDivMessageP();
        var field;
        field = $("#nombre").val();
        if (field.length == 0) {
            $("#lblErrorP").text("Debe ingresar el nombre.");
            ShowDivMessageP();
            return false;
        }
        field = $("#apellido").val();
        if (field.length == 0) {
            $("#lblErrorP").text("Debe ingresar el apellido.");
            ShowDivMessageP();
            return false;
        }
        field = $("#dni").val();
        if (field.length == 0) {
            $("#lblErrorP").text("Debe ingresar el dni.");
            ShowDivMessageP();
            return false;
        }
        field = $("#puesto").val();
        if (field.length == 0) {
            $("#lblErrorP").text("Debe ingresar el puesto.");
            ShowDivMessageP();
            return false;
        }
        field = $("#antiguedad").val();
        if (field.length == 0) {
            $("#lblErrorP").text("Debe ingresar la antiguedad.");
            ShowDivMessageP();
            return false;
        }
        field = $("#sueldo").val();
        if (field.length == 0) {
            $("#lblErrorP").text("Debe ingresar el sueldo.");
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
<div class="panel panel-default">
		    <div class="panel-heading">Nuevo afiliado</div>
		    <div class="panel-body">
		    	<form:form action="afiliadoagregado" modelAttribute="afiliado" method="POST" role="form" name="frmAfiliado">
				  			  
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
				  <div id="divMessagesP" style="display: none;">
					<p align="left">
					<div class="alert alert-danger" style="text-align: left;">
						<label id="lblErrorP"
							style="font-size: 12px; color: firebrick; font-weight: bold; margin-left: 5px;"></label>
					</div>
					</p>
				</div>
				  <div class="form-group row">
				  		<div class="col-lg-2"></div>
				  		<div class="col-lg-10">
						  <button type="submit" onclick="PostForm(); return false;" class="btn btn-success">Agregar nuevo afiliado</button>
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