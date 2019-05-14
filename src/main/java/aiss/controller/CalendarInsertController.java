package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.TicketmasterResource;
import aiss.model.tickermaster.Event;


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
			String event_firstURLImage = (String) req.getParameter("event_firstURLImage");
			log.info("----------------------------------" + eventID);
			log.info("----------------------------------" + event_firstURLImage);

			
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
			
			req.getSession().setAttribute("eventID", eventID);
			req.getSession().setAttribute("json", res);
			req.getSession().setAttribute("event_firstURLImage", event_firstURLImage);
			req.getSession().setAttribute("tickets", description);

							
        	resp.sendRedirect("/OpcionesEvento.jsp");

					
				}

	}


