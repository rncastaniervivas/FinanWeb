<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Modificar financiera</title>
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/xbootstrap.min.css" rel="stylesheet">
    	<link href="css/xheroic-features.css" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
</head>
<body class="container">
<script>
		function PostForm() {
			if (IsValid()) {
				$("#lblErrorP").text("");
				document.forms["frmFinanciera"].submit();
			}
		}
		function IsValid() {
			HideDivMessageP();
			var field;
			field = $("#nombre").val();
			if (field.length == 0) {
				$("#lblErrorP")
						.text("Debe ingresar un nombre para la financiera.");
				ShowDivMessageP();
				return false;
			}
			field = $("#montoCapital").val();
			if (field.length == 0) {
				$("#lblErrorP")
						.text("Debe ingresar un valor.");
				ShowDivMessageP();
				return false;
			}
			return true;
		}
		function ShowDivMessageP() {
			scroll(0, 0);
			$("#divMessagesP").show("slow", function() {
			});
		}
		function HideDivMessageP() {
			$("#divMessagesP").hide();
		}
	</script>
	
<h2>Modificar Financiera</h2>
<div class="col-lg-6">
<form:form role="form" action="modificado" method="Post" modelAttribute="financiera" name="frmFinanciera">

			<div class="form-group">
			<label>nombre:</label><br>
			<form:input path="nombre" id="nombre" class="form-control" type="text" placeholder="${finan.nombre}" />
			</div>
			<div class="form-group">
			<label>Monto Capital:</label><br>
			<form:input path="montoCapital" id="montoCapital" class="form-control" type="text" placeholder="${finan.montoCapital}" />
			</div>
			<div id="divMessagesP" style="display: none;">
					<p align="left">
					<div class="alert alert-danger" style="text-align: left;">
						<label id="lblErrorP"
							style="font-size: 12px; color: firebrick; font-weight: bold; margin-left: 5px;"></label>
					</div>
				</div>
<form:input path="idFinanciera" id="idFinanciera" type="hidden" value="${finan.idFinanciera}" />
<button type="submit" class="btn btn-success" onclick="PostForm(); return false;">Guardar Cambios</button>
<p>${error}</p>
</form:form>
</div>


		<br>
		<a href="javascript:window.history.go(-1);"><button class="btn btn-primary btn-lg">Regresar</button></a>
		<br>
		<br>
		<a href="/FinanWeb/home"><button class="btn btn-primary btn-lg" type ="submit">Inicio</button></a>
		<br>

</body>
</html>