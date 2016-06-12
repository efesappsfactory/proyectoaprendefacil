<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ec.edu.epn.modelo.Local" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <% String tituloPagina="Actualizar Local"; %>
   <%@include file="../commons/header.jsp" %>

   <mark> Resultado: <%= request.getAttribute("RESULTADO") %> </mark> 
 
   <%
      Local local = (Local) request.getAttribute("LOCAL");
   %>

	<form method="post" action="GuardarActualizacionCtrl">
	   Id: <%= local.getId() %>
	   Nombre: <input type="text" name="txtNombre" value="<%= local.getNombre() %>"/>
	   Telefono: <input type="text" name="txtTelefono" value="<%= local.getTelefono() %>" />
	   Ubicacion: <input type="text" name="txtUbicacion" value="<%= local.getUbicacion() %>" />
	
	   <input type="submit" value="Guardar" />
	</form>	
</body>
</html>