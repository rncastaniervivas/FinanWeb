<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Caja</title>
		<<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/xbootstrap.min.css" rel="stylesheet">
    	<link href="css/xheroic-features.css" rel="stylesheet">
</head>
<body class="container">
	<jsp:include page="header.jsp" />
<div class="page-header">
<h1 class="text-center">Registros de caja</h1>
</div>
 <div class="table-responsive">
      <table class="table table-bordered table-hover table-striped">
             <thead>
                <tr>
                   <th>Fecha</th>
                   <th>origen Dni Afiliado</th>
                   <th>Ingreso</th>
                   <th>Consepto</th>
                   <th>Prestamo</th>
                   <th>Cuota</th>
                   <th>Destino</th>
                   <th>Egreso</th>                                                                                                                                                  
                </tr>
              </thead>
           	<c:forEach items="${registros}" var="lista" >          		
           			<tbody>
                   <tr>
                      <td> ${lista.fecha} </td>
                      <td> ${lista.origen} </td>
                      <td> ${lista.ingreso} $</td>
                      <td> ${lista.concepto} </td>
                      <td> ${lista.prestamo} </td>
                      <td> ${lista.cuota} </td>
                      <td> ${lista.destino} </td>
                      <td> ${lista.egreso} $</td>
                   </tr>               
              </c:forEach> 
              <tr>
                      <td> </td>
                      <td>  </td>
                      <td> ${montoI} </td>
                      <td>  </td>
                      <td>  </td>
                      <td>  </td>
                      <td>  </td>
                      <td> ${montoE} </td>
                   </tr> 
              </tbody>
       </table>
</div>

<div class="row show-grid">
<div class="col-md-6">
<h2>Total en caja ${caja} </h2>
</div>
</div>                                
                                

		<br>
		<a href="/FinanWeb/home"><button class="btn btn-primary btn-lg" type ="submit">Inicio</button></a>
		<br>
</body>
</html>