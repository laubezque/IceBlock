package aiss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.repackaged.com.google.common.base.Ticker;
import com.google.apphosting.utils.remoteapi.RemoteApiPb.Request;

import aiss.model.resource.TicketmasterResource;
import aiss.model.tickermaster.Embedded;
import aiss.model.tickermaster.Embedded_;
import aiss.model.tickermaster.Event;
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

		
		
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<HTML><HEAD><TITLE>Leyendo parámetros</TITLE></HEAD>");
		pw.println("<BODY BGCOLOR=\"#CCBBAA\">");
		pw.println("<H2>Leyendo parámetros desde un formulario html</H2><P>");
		pw.println("<H2></H2><P>");
		pw.println("<UL>\n");
		
		String keyword = request.getParameter("key_word");
		Embedded URL = TicketmasterResource.searchByKeyword(keyword);
		Map<String, Object> e = URL.getAdditionalProperties();
		
		//split(e);
		

		// [_embedded, _links, page]
		
		pw.println("Has buscado la palabra -> " + keyword + "<BR>");
//		pw.println("URL -> " + e.get("_embedded") + "<BR>");
		split(e.get("_embedded").toString(),PropiedadesEventosTM.IMAGEN_URL);

		pw.println("URL -> " + e + "<BR>");
		
		pw.println("</BODY></HTML>");
		pw.close();

		
	}

	private String split(String str,PropiedadesEventosTM var) {
		String res = "";
		String[] split = str.split("_embedded="); 
		res = res + split[1];
		String[] img = res.split("images=");
		String[] imagenFrag = img[1].split(", postalCode=");
		
		//################################################################################# CodigoPostal  #############################################################################
		
		String[] zonaHorariaFrag = imagenFrag[1].split(", timezone=");
		String url = zonaHorariaFrag[0];
		String zonaHoraria = zonaHorariaFrag[1];
		
		//################################################################################# Imagenes  #################################################################################
		String imagen = img[1];
		String[] camposImagen = imagen.split(",");
		
		switch(var) {
		
			case IMAGEN_RATIO:
				String imagenRatio = camposImagen[0].replace("[{", "");
				res = imagenRatio;
				break;
			
			case IMAGEN_URL:
				String imagenUrl = camposImagen[1];
				res = imagenUrl;
				break;
			
			case IMAGEN_WIDTH:
				String imagenWidth = camposImagen[2];
				res = imagenWidth;
				break;
				
			case IMAGEN_HEIGHT:
				String imagenHeight = camposImagen[3];
				res = imagenHeight;
				break;
			
			case IMAGEN_FALLBACK:
				String imagenFallback = camposImagen[4].replace("}]", "");
				res = imagenFallback;
				break;
		}
		
		
		return zonaHoraria;
		
	}


}
	
	
	
	
	
	

	
	
	
	
	
	
	

