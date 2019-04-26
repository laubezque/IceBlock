package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.googleCalendar.Item;
import aiss.model.googleCalendar.ListEvents;
import aiss.model.resource.GoogleCalendarResource;


public class CalendarInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CalendarInsertController.class.getName());

       
    
    public CalendarInsertController() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Request data
		        String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");

		        Item Event = null;
						
		        if (accessToken != null && !"".equals(accessToken)) {

		            GoogleCalendarResource gdResource = new GoogleCalendarResource(accessToken);

		            if (Event != null) {
			            Item EventoInsertado = gdResource.insertEvent(Event);
		            } else {
		                log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
		                req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
		            }
		        } else {
		            log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
		            req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
		        }
				
				// Forward to contact list view
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
