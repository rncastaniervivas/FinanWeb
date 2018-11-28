<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <!-- link href="css/bootstrap.min.css" rel="stylesheet" -->
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.csss" rel="stylesheet">
	    <link href="css/stylelogin.css" rel="stylesheet">
	    
	    <link href="css/xbootstrap.min.css" rel="stylesheet">
    	<link href="css/xheroic-features.css" rel="stylesheet">
	</head>
	<body>
	
	    <!-- Navigation -->
	    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	      <div class="container">
	        <a class="navbar-brand" href="${context}/">Finan Web</a>
	        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	          <span class="navbar-toggler-icon"></span>
	        </button>
	        <div class="collapse navbar-collapse" id="navbarResponsive">
	          <ul class="navbar-nav ml-auto">
	            <li class="nav-item">
	              <a class="nav-link" href="#">Nosotros</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">Servicios</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="#">Contacto</a>
	            </li>
	            <li class="nav-item active">
	              <a class="nav-link" href="${context}/login">Inicia Sesion</a>
	            </li>
	          </ul>
	        </div>
	      </div>
	    </nav>
		
		<div class = "container">
			<div id="loginbox" style="width: 400px; display: block; margin: 70px auto;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
				<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
					<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
				<form:form action="validar-login" method="POST" modelAttribute="usuario">
			    	<h3 class="form-signin-heading">Iniciar Sesion</h3>
					<hr class="colorgraph"><br>

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<div class="form-group">
    					<label for="email">Email</label>
						<form:input path="email" id="email" type="email" class="form-control" />
					</div>
					
					<div class="form-group">
    					<label for="password">Contrase�a</label>
						<form:input path="password" type="password" id="password" class="form-control"/>     		  
					</div>
					
					<button class="btn btn-primary btn-lg btn-block" type="Submit"/>Ingresar</button>
				</form:form>

				<%--Bloque que es visible si el elemento error no está vacío	--%>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>	
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
