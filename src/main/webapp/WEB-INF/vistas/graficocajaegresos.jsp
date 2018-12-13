<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gráfico caja egresos</title>
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/xbootstrap.min.css" rel="stylesheet">
    	<link href="css/xheroic-features.css" rel="stylesheet">
</head>
<body>
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
		
		new Chart(document.getElementById("bar-chart"), {
		    type: 'bar',
		    scaleOverride : true,
		    scaleStartValue : 0,
		    data: {
		      labels: ["${mes1}", "${mes2}", "${mes3}", "${mes4}", "${mes5}", "${mes6}", "${mes7}", "${mes8}", "${mes9}", "${mes10}", "${mes11}","${mes12}" ],
		      datasets: [
		        {
		          label: "Dinero",
		          backgroundColor: ["#3e95cd", "#8e5ea2","#3cba9f","#e8c3b9","#c45850","#c43853","#c42855","#c44850","#c46850","#c40850","#c39850","#c35850"],
		          data: [${ingreso1}, ${ingreso2}, ${ingreso3}, ${ingreso4}, ${ingreso5}, ${ingreso6}, ${ingreso7}, ${ingreso8}, ${ingreso9}, ${ingreso10}, ${ingreso11}, ${ingreso12}]
		        }
		      ]
		    },
		    options: {
		      legend: { display: false },
		      title: {
		        display: true,
		        text:'Egresos mensuales'
		      }
		    }
		});
	});
	</script>

<br>
		<a href="/FinanWeb/home"><button class="btn btn-primary btn-lg" type ="submit">Inicio</button></a>
		<br>

</body>
</html>