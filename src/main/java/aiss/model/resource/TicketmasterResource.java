package aiss.model.resource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.restlet.resource.ClientResource;

import aiss.model.tickermaster.Embedded;
import aiss.model.tickermaster.Embedded_;
import aiss.model.tickermaster.Event;


/**
 * Servlet implementation class TicketmasterResource
 */
public class TicketmasterResource extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String URLBaseTicketMasterDiscovery = "https://app.ticketmaster.com/discovery/v2/events.json?";
	private static String IDIOM_CODE = "ES";
	private static final String TICKETMASTER_API_KEY = "nwHQ0avEGxWu0artoxru0IYIA6GxV707";	
	private static final Logger log = Logger.getLogger(TicketmasterResource.class.getName());
	
	public static String getTicketmasterApiKey() {
		return TICKETMASTER_API_KEY;
	}
      
	public static Embedded searchByKeyword(String keyword) throws UnsupportedEncodingException {
		//https://app.ticketmaster.com/discovery/v2/events.json?keyword=devjam&source=universe&countryCode=US&apikey={apikey}
		
		String encodeKeyword = URLEncoder.encode(keyword,"UTF-8");
		
		String URL = URLBaseTicketMasterDiscovery + "keyword=" + encodeKeyword;
			
		URL += "&countryCode=";
				
		URL += IDIOM_CODE;
		
		URL += "&apikey="+TICKETMASTER_API_KEY ;
		
		log.log(Level.FINE,"URL : "+ URL );
		
		ClientResource tm = new ClientResource(URL);
		
		Embedded e = tm.get(Embedded.class);
		
		return e;
		
	}
	
}
