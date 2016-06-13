package ec.edu.epn.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.Local;
import ec.edu.epn.modelo.servicios.GestorLocales;


@WebServlet("/admLocal/CrearLocalCtrl")
public class CrearLocalCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CrearLocalCtrl() {
        super();
    }
    // recibir la peticion
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// preparar la información
		String nombre = request.getParameter("txtNombre");
		String telefono = request.getParameter("txtTelefono");
		String ubicacion = request.getParameter("txtUbicacion");
		Local local = new Local();
		local.setNombre(nombre);
		local.setTelefono(telefono);
		local.setUbicacion(ubicacion);
		
		// llamar al modelo
		GestorLocales gl = new GestorLocales();
		String resultado="";
		try {
		  gl.crearLocal(local);
		  resultado="Creacion Exitosa";
		}catch(Exception e){
		  resultado="Error en la creación " + e.getMessage();
		  e.printStackTrace();
		}
		
		
		// publicar los datos devueltos por el modelo
		/*ServletContext application = request.getServletContext();
		   application.setAttribute("Nombre Variable",Objeto);
		  HttpSession session= request.getSession();
		   session.setAttribute("", Objeto);
		   request.setAttribute("", Objeto);*/
		   request.setAttribute("RESULTADO", resultado);  
		 
		// redireccionar a la vista
		RequestDispatcher rd = 
		  request.getServletContext().getRequestDispatcher("/admLocal/crearLocal.jsp");
		
		rd.forward(request,response);
		
	}

}
