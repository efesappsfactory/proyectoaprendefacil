<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, ec.edu.epn.modelo.Local" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administración de Locales</title>
   <link rel="stylesheet" href="estilos.css" />
</head>
<body>
   <% String tituloPagina="Administración de Locales"; %>
   <%@include file="../commons/header.jsp" %>
   
   <section>
    
     <a href="crearLocal.jsp">Crear Local</a>
     
     <h2>Busqueda</h2>
       
     <form action="BuscarLocalesCtrl" method="get">
         Nombre: <input type="text" name="nombreBusqueda" />
         <input type="submit" value="Buscar"/> 
     </form>
     
     <table>
        <tr>
           <th>Id</th>
           <th>Nombre</th>
           <th>Telefono</th>
           <th>Ubicacion</th>
           <th>Actualizar</th>
           <th>Eliminar</th>
        </tr>
        <%
          List<Local> locales = (List<Local>)
                  request.getAttribute("LOCALES");
          if (locales!=null){
            for(Local l: locales) {
        %>
         <tr>
           <td><%= l.getId() %></td>
           <td><%= l.getNombre() %></td>
           <td><%= l.getTelefono() %></td>
           <td><%= l.getUbicacion() %></td>
           <td><a href="/admLocal/ActualizarLocalCtrl?id=<%= l.getId() %>"> Actualizar </a></td>
           <td>Eliminar<%= l.getId() %></td>
         </tr>
          <%
           }
          }
        %>
     </table>
   
   </section>
   <footer>
      <%@include file="../commons/footer.jsp" %>
   </footer>
</body>
</html>