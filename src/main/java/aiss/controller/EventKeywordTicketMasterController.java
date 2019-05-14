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
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import org.eclipse.jetty.util.log.Log;
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
	

	private static final Logger log = Logger.getLogger(EventKeywordTicketMasterController.class.getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventKeywordTicketMasterController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Embedded embOfEvents = TicketmasterResource.searchSuggest();
		if (embOfEvents != null) {
			Integer tmp = embOfEvents.getEvents().size();
			
			List<Event> tablaEventos = getInfoOfEvent(embOfEvents,tmp);
			request.setAttribute("tablaEventos", tablaEventos);
			
			
			
			
			request.getRequestDispatcher("VistaListaEventos.jsp").forward(request, response);

		} else {
			// Deberia redirigir a una página de error que explicara que no hay eventos disponibles
			request.getRequestDispatcher("/error.jsp");
		}

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Tomamos el parametro keyword y llamamos ha searchByKeyword nos devuelve un embedded.
		String keyword =(String) request.getParameter("key_word");
		log.info("----------------------------------" + keyword);

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

	}

	private List<Event> getInfoOfEvent(Embedded embOfEvents,Integer tmp) {
		List<Event> res = new ArrayList<>();
		Integer i=0;
		if (tmp > 10) {
			tmp=10;
					};
		while(i < tmp) {
			
			res.add(embOfEvents.getEvents().get(i));
			
			i ++;
		}

		return res;
	}

}
	
	
	
	
	
	

	
	
	
	
	
	
	

