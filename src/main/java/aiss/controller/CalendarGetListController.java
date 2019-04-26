package aiss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.googleCalendar.ListEvents;
import aiss.model.resource.GoogleCalendarResource;

/**
 * Servlet implementation class CalendarGetListController
 */
public class CalendarGetListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CalendarGetListController.class.getName());

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarGetListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");
        GoogleCalendarResource gdResource = new GoogleCalendarResource(accessToken);

		ListEvents Calendario = gdResource.getList();
				
        if (accessToken != null && !"".equals(accessToken)) {

        	if (Calendario != null) {
        		resp.setContentType("text/html");
        		PrintWriter pw = resp.getWriter();
        		pw.println("<HTML><HEAD><TITLE>Leyendo parámetros</TITLE></HEAD>");
        		pw.println("<BODY BGCOLOR=\"#CCBBAA\">");
        		pw.println("<H2>Leyendo parámetros desde un formulario html</H2><P>");
        		pw.println("<H2></H2><P>");
        		pw.println("<UL>\n");
        		

        		


        		
        		pw.println("Has buscado la palabra -> " + Calendario.getItems().get(0) + "<BR>");

        		pw.println("</BODY></HTML>");
        		pw.close();

    			req.setAttribute("message", "de puta madre ");
    			log.log(Level.FINE, "de puta madre");
    		}
    		else {
    			req.setAttribute("message", "no tan de puta madre");
    			log.log(Level.FINE, "no tan de puta madre");
    		}
        } else {
            log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
            req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
        }	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
