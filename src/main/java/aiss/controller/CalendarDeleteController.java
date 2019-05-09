package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.googleCalendar.Item;
import aiss.model.resource.GoogleCalendarResource;

/**
 * Servlet implementation class CalendarDeleteController
 */
public class CalendarDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CalendarDeleteController.class.getName());

  
    public CalendarDeleteController() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
			String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");
            GoogleCalendarResource gdResource = new GoogleCalendarResource(accessToken);

			String id = req.getParameter("id");
			boolean success = gdResource.deleteEvent(id);
					
	        if (accessToken != null && !"".equals(accessToken)) {

	        	if (success) {
	    			req.setAttribute("message", "Se ha borrao");
	    			log.log(Level.FINE, "Event with id=" + id + " se ha borrao");
	    		}
	    		else {
	    			req.setAttribute("message", "no se ha podio borra");
	    			log.log(Level.FINE, "Event with id=" + id + " no se ha borrao");
	                req.getRequestDispatcher("/error.jsp").forward(req, resp);

	    		}
	        } else {
	            log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
	            req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
	        }	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");
        GoogleCalendarResource gdResource = new GoogleCalendarResource(accessToken);
     
		String id = req.getParameter("id");
				
        if (accessToken != null && !"".equals(accessToken)) {
        	
    		boolean success = gdResource.deleteEvent(id);

        	
        	if (success) {
    			req.setAttribute("message", "Se ha borrao");
    			log.log(Level.FINE, "Event with id=" + id + " se ha borrao");
                req.getRequestDispatcher("/Calendario.jsp").forward(req, resp);
                

    		}
    		else {
    			req.setAttribute("message", "no se ha podio borra");
    			log.log(Level.FINE, "Event with id=" + id + " no se ha borrao");
                req.getRequestDispatcher("/error.jsp").forward(req, resp);

    		}
        } else {
            log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
            req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
        }			
	}

}
