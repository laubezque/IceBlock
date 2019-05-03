package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.GoogleCalendarResource;

/**
 * Servlet implementation class CalendarQuickAddController
 */
public class CalendarQuickAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CalendarQuickAddController.class.getName());

       
    public CalendarQuickAddController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");
        GoogleCalendarResource gdResource = new GoogleCalendarResource(accessToken);
     
		String string = req.getParameter("string");
				
        if (accessToken != null && !"".equals(accessToken)) {
        	
    		boolean success = gdResource.quickAddEvent(string);
 	
        	if (success) {
    			req.setAttribute("message", "Se ha añadido correctamente");
    			log.log(Level.FINE, "Event with string=" + string + " se ha creado");
                req.getRequestDispatcher("/Calendario.jsp").forward(req, resp);

    		}
    		else {
    			req.setAttribute("message", "no se ha podio crear");
    			log.log(Level.FINE, "Event with string=" + string + " no se ha creao");
                req.getRequestDispatcher("/error.jsp").forward(req, resp);

    		}
        } else {
            log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
            req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
        }			
	}

	

}
