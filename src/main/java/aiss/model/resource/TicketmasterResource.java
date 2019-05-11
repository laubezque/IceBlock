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

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.ext.json.JsonRepresentation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.repackaged.com.google.gson.JsonObject;

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
	private static String URLBaseTicketMasterDetails = "https://app.ticketmaster.com/discovery/v2/events/";
	private static String IDIOM_CODE = "ES";
	private static final String TICKETMASTER_API_KEY = "nwHQ0avEGxWu0artoxru0IYIA6GxV707";	
	private static final Logger log = Logger.getLogger(TicketmasterResource.class.getName());
	
	public static String getTicketmasterApiKey() {
		return TICKETMASTER_API_KEY;
	}
      
	public static Embedded searchByKeyword(String keyword) throws JSONException, IOException {
		//https://app.ticketmaster.com/discovery/v2/events.json?keyword=devjam&source=universe&countryCode=US&apikey={apikey}
		Embedded e = new Embedded();
		String encodeKeyword = URLEncoder.encode(keyword,"UTF-8");
		
		String URL = URLBaseTicketMasterDiscovery + "keyword=" + encodeKeyword;
			
		URL += "&countryCode=";
				
		URL += IDIOM_CODE;
		
		URL += "&apikey="+TICKETMASTER_API_KEY ;
		
		log.log(Level.FINE,"URL : "+ URL );
		
		ClientResource tm = new ClientResource(URL);
		log.log(Level.FINE,"Esto esta petando." + tm.toString());
		
		
		
		try {
			
			Representation response = tm.get();
			log.log(Level.FINE,"Response---------------------------------------------------------- : "+ response );
			
			ObjectMapper JSON2Object = new ObjectMapper();
			JsonRepresentation b = new JsonRepresentation(response.getText());
			JSONObject a = b.getJsonObject();
			
			e = JSON2Object.readValue(a.get("_embedded").toString(), Embedded.class);
			
		}catch (Exception IAE){
			
			new IllegalArgumentException("No se han encontrado eventos");
			
		}
		
		
		
		return e;
		
	}
	public static Event searchById(String id) throws JSONException, IOException {
        //https://app.ticketmaster.com/discovery/v2/events.json?keyword=devjam&source=universe&countryCode=US&apikey=%7Bapikey%7D
        Event e = new Event();

        String URL = URLBaseTicketMasterDetails + id;

        URL += "&apikey="+TICKETMASTER_API_KEY ;

        log.log(Level.FINE,"URL : "+ URL );

        ClientResource tm = new ClientResource(URL);
        log.log(Level.FINE,"Esto esta petando." + tm.toString());



        try {

            Representation response = tm.get();
            log.log(Level.FINE,"Response---------------------------------------------------------- : "+ response );

            ObjectMapper JSON2Object = new ObjectMapper();
            JsonRepresentation b = new JsonRepresentation(response.getText());
            JSONObject a = b.getJsonObject();

            e = JSON2Object.readValue(a.get("event").toString(), Event.class);

        }catch (Exception IAE){

            new IllegalArgumentException("No se han encontrado eventos");

        }



        return e;

    }
	
}
