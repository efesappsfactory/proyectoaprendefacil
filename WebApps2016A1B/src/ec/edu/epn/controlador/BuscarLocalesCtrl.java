package ec.edu.epn.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.epn.modelo.Local;
import ec.edu.epn.modelo.servicios.GestorLocales;

@WebServlet("/admLocal/BuscarLocalesCtrl")
public class BuscarLocalesCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BuscarLocalesCtrl() {
        super();
    }
    
    //recibe las peticiones
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//preparar la informacion
		String nombreBusqueda = request.getParameter("nombreBusqueda");
		//llamar al modelo
		System.out.print("1");
		GestorLocales gl = new GestorLocales();
		List<Local> locales=null;
		locales = gl.buscarLocales(nombreBusqueda);
		//publicar la informacion
		request.setAttribute("LOCALES", locales);
		//redireccionar a la vista
		System.out.print("2");
		RequestDispatcher rd = 
				request.getServletContext().getRequestDispatcher(
						"/admLocal/administraLocales.jsp");
		rd.forward(request, response);
		System.out.print("3");
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
