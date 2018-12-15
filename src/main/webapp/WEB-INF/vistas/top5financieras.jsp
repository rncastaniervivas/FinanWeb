<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Top 5 financieras</title>
		
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/xbootstrap.min.css" rel="stylesheet">
    	<link href="css/xheroic-features.css" rel="stylesheet">
	</head>
	<body>
	
		<jsp:include page="header.jsp" /></br></br>
		
		<div class="container">
		
			<div id="canvas-container" style="width:50%;">
			<canvas id="bar-chart" width="500" height="350"></canvas>
			</div>
			<!-- Placed at the end of the document so the pages load faster -->
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
			<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
			<script src="js/bootstrap.min.js" type="text/javascript"></script>
	
		<script type="text/javascript" src="js/Chart.bundle.min.js"></script>
		
	<script type="text/javascript">
		$(document).ready(function(){
			//los 5 afiliados que sacaron el mayor prestamo
			new Chart(document.getElementById("bar-chart"), {
			    type: 'bar',
			    data: {
			      labels: ["${nomafil1}", "${nomafil2}", "${nomafil3}", "${nomafil4}", "${nomafil5}"],
			      datasets: [
			        {
			          label: "Dinero",
			          backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850"],
			          data: [${numafil1},${numafil2},${numafil3},${numafil4},${numafil5}]
			        }
			      ]
			    },
			    options: {
			      legend: { display: false },
			      title: {
			        display: true,
			        text: 'Los 5 Financieras con el prestamo mas alto registrado'
			      }
			    }
			});
		});
		</script>
		
			<br>
			<a href="javascript:window.history.go(-1);"><button class="btn btn-primary btn-lg">Regresar</button></a>
			<br>
			<br>
			<!-- a href="/FinanWeb/home"><button class="btn btn-primary btn-lg" type ="submit">Inicio</button></a-->
			<br>
		</div>
	</body>
</html>