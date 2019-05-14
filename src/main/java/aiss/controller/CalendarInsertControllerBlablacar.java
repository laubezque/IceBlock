package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.TicketmasterResource;
import aiss.model.tickermaster.Event;

/**
 * Servlet implementation class CalendarInsertControllerBlablacar
 */
public class CalendarInsertControllerBlablacar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(CalendarInsertController.class.getName());

 
    public CalendarInsertControllerBlablacar() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String location1 = (String) req.getParameter("location1");
		String location2 = (String) req.getParameter("location2");
		String fechaInicio = (String) req.getParameter("fechaInicio");
		String timeZone = "Europe/Madrid";
		String description = "Viaje desde " + location1 + " hasta " + location2;
		String summary = "Viaje a " + location2;

		String fechaTransformada = transformacion(fechaInicio);
		
//		log.info("----------------------------------" + evento.getEmbedded().getFirstVenues().getCity().getName());


		
		
		log.info("----------------------------------" + fechaInicio);
		log.info("----------------------------------" + fechaTransformada);
		log.info("----------------------------------" + timeZone);
		log.info("----------------------------------" + location1);
		log.info("----------------------------------" + location2);
		log.info("----------------------------------" + description);
		log.info("----------------------------------" + summary);



		
		
		String res = "{\"calendarId\": \"primary\"," +
			      "\"resource\": {\"end\": {\"dateTime\": \""+ fechaTransformada +"\",\"timeZone\": \""+ timeZone +"\"},"+
                "\"start\": {\"dateTime\": \""+ fechaTransformada +"\",\"timeZone\": \""+ timeZone +"\"},"+
                "\"description\": \""+ description +"\" , "+
                "\"location\": \""+ location1 +"\","+
                "\"summary\": \""+ summary +"\"}}";
		
		req.getSession().setAttribute("json", res);

						
    	resp.sendRedirect("/ViajeCalendario.jsp");

				
			}


	private String transformacion(String fechaInicio) {
//		14/05/2019 15:00:00
//		2019-06-01T20:00:00Z
		String[] splits = fechaInicio.split(" ");
		String[] dateSplits = splits[0].split("/");
		String res = dateSplits[2] + "-" + dateSplits[1] + "-" + dateSplits[0] + "T" + splits[1];
		
		return res;
	}
	

}


