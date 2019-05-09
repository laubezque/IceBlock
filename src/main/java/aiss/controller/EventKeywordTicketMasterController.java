package aiss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import org.jboss.resteasy.util.Encode;

import com.google.appengine.repackaged.com.google.common.base.Ticker;
import com.google.apphosting.utils.remoteapi.RemoteApiPb.Request;

import aiss.model.resource.TicketmasterResource;
import aiss.model.tickermaster.Embedded;
import aiss.model.tickermaster.Embedded_;
import aiss.model.tickermaster.Event;
import aiss.model.tickermaster.Image;
import aiss.utility.PropiedadesEventosTM;


/**
 * Servlet implementation class EventKeywordTicketMasterController
 */
public class EventKeywordTicketMasterController extends HttpServlet {
	
	private String URLBaseTicketMasterDiscovery = "https://app.ticketmaster.com/discovery/v2/events.json?";
	private String API_KEY = TicketmasterResource.getTicketmasterApiKey();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventKeywordTicketMasterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		pw.println("<HTML><HEAD><TITLE>Leyendo parámetros</TITLE><meta charset=\"UTF-8\"/></HEAD>");
//		pw.println("<BODY BGCOLOR=\"#CCBBAA\">");
//		pw.println("<H2>Leyendo parámetros desde un formulario html</H2><P>");
//		pw.println("<H2></H2><P>");
//		pw.println("<UL>\n");
		
		String keyword = request.getParameter("key_word");
		
		Embedded embOfEvents = TicketmasterResource.searchByKeyword(keyword);
		if (embOfEvents != null) {
			Integer tmp = embOfEvents.getEvents().size();
			
			List<Event> tablaEventos = getInfoOfEvent(embOfEvents,tmp);
			request.setAttribute("tablaEventos", tablaEventos);
			
			
			
			
			request.getRequestDispatcher("VistaListaEventos.jsp").forward(request, response);

		} else {
			// Deberia redirigir a una página de error que explicara que no hay eventos disponibles
			request.getRequestDispatcher("/error.jsp");
		}
		


		
//		pw.println("Has buscado la palabra -> " + keyword + "<BR>");
//		
//		pw.println("Este es el texto que sale -> " + eventString + "<BR>");
//		
//
//		pw.println("URL -> " + event.getAdditionalProperties() + "<BR>");
//		
//		pw.println("</BODY></HTML>");
//		pw.close();

		
	}

	private List<Event> getInfoOfEvent(Embedded embOfEvents,Integer tmp) {
		List<Event> res = new ArrayList<>();
		Integer i=0;
		if (tmp > 4) {
			tmp=4;
					};
		while(i < tmp) {
			
			res.add(embOfEvents.getEvents().get(i));
			
			i ++;
		}
//		String urlFoto = event.getEvents().get(0).getImages().get(0).getUrl();
//		String NombreEvento = event.getEvents().get(0).getName();
//		String urlAEvento = event.getEvents().get(0).getUrl();
//		String Fecha = event.getEvents().get(0).getDates().toString();
//		
//		request.setAttribute("Foto", urlFoto);
//		request.setAttribute("NombreEvento", NombreEvento);
//		request.setAttribute("URLEvento", urlAEvento);
//		request.setAttribute("Fecha", Fecha);
		return res;
	}
}
	
	
	
	
	
	

	
	
	
	
	
	
	

