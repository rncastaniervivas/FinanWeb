<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar nueva financiera</title>
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
				$("#lblErrorP").text("Debe ingresar el nombre.");
				ShowDivMessageP();
				return false;
			}
			field = $("#montoCapital").val();
			if (field.length == 0) {
				$("#lblErrorP").text("Debe ingresar el Monto Capital.");
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
<h2>Agregar Nueva Financiera</h2>
	<div class="col-lg-6">
		<form:form role="form" action="agregado" method="Post"
			modelAttribute="financiera" name="frmFinanciera">
			<div class="form-group">
				<label>Nombre de la financiera:</label>
				<form:input path="nombre" id="nombre" type="text"
					class="form-control" />
			</div>

			<div>
				<label>Monto Capital:</label>
				<form:input path="montoCapital" id="montoCapital" type="text"
					class="form-control" />
			</div>
			<div id="divMessagesP" style="display: none;">
					<p align="left">
					<div class="alert alert-danger" style="text-align: left;">
						<label id="lblErrorP"
							style="font-size: 12px; color: firebrick; font-weight: bold; margin-left: 5px;"></label>
					</div>
					</p>
				</div>
					</p>
				</div>
			<div>
				<button onclick="PostForm(); return false;" type="submit" class="btn btn-success">Agregar</button>
			</div>
			<p>${error}</p>
		</form:form>
		<br> <a href="/FinanWeb/home"><button
				 class="btn btn-primary btn-lg"
				type="submit">Inicio</button></a> <br>
	</div>
</body>
</html>