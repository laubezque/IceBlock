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
import aiss.model.resource.TicketmasterResource;
import aiss.model.tickermaster.Dates;
import aiss.model.tickermaster.Embedded;
import aiss.model.tickermaster.Event;
import aiss.model.tickermaster.Start;


public class CalendarInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CalendarInsertController.class.getName());

       
    
    public CalendarInsertController() {
        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Request data
//		string fecha = req.getParameter(name);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");

			String eventID = (String) req.getParameter("event_ID");
			log.info("----------------------------------" + eventID);
					
			
			Event evento = TicketmasterResource.searchById(eventID);
//			log.info("----------------------------------" + evento.getEmbedded().getFirstVenues().getCity().getName());


//			Start date2 = date.getStart();
//			String date3 = date2.getDateTime();
//			String fechaInicio = date3;
//			String fecha = evento.getDates2Date();
//			String hora = evento.getDates2Hour();
//			String fechaInicio = fecha + "T" + hora;

			
			String fechaInicio = evento.getDates().getStart().getDateTime();
			log.info("----------------------------------" + fechaInicio);

			
			
			String timeZone = evento.getDates().getTimezone();
			String location = evento.getEmbedded().getFirstVenues().getCity().getName();
			String description = evento.getUrl();
			String summary = evento.getName();
			log.info("----------------------------------" + timeZone);
			log.info("----------------------------------" + location);
			log.info("----------------------------------" + description);
			log.info("----------------------------------" + summary);



			
			
			String res = "{\"calendarId\": \"primary\"," +
				      "\"resource\": {\"end\": {\"dateTime\": \""+ fechaInicio +"\",\"timeZone\": \""+ timeZone +"\"},"+
	                "\"start\": {\"dateTime\": \""+ fechaInicio +"\",\"timeZone\": \""+ timeZone +"\"},"+
	                "\"description\": \""+ description +"\" , "+
	                "\"location\": \""+ location +"\","+
	                "\"summary\": \""+ summary +"\"}}";
			
			req.getSession().setAttribute("melendi", res);
							
			        if (accessToken != null && !"".equals(accessToken)) {


			            if (evento != null) {
//			            	req.getRequestDispatcher("/busqueda4.jsp").forward(req, resp);
			            	resp.sendRedirect("/busqueda4.jsp");
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

	}


