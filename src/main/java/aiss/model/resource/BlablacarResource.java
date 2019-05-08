package aiss.model.resource;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;

import org.json.JSONObject;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.api.files.FileServicePb.FileContentType.ContentType;
import com.google.appengine.api.search.query.ExpressionParser.negation_return;

import aiss.model.blablacar.search.Trip;
import aiss.model.tickermaster.Embedded;

public class BlablacarResource extends HttpServlet {

	private static final String BLABLACAR_API_KEY = "46410bf6eee240cbbc7d9eef6a0dc210";
	private static final long serialVersionUID = 1L;
	private static String URLBaseBlablacarSearch = "https://public-api.blablacar.com";
	private static String URLBlablacarTrips = "/api/v2/trips";
	private static final Logger log = Logger.getLogger(BlablacarResource.class.getName());
	// private static String IDIOM_CODE = "ES";
	private static final String LOCALE = "es_ES";
	private static final String _FORMAT = "json";
	private static final String CUR = "EUR";

	public static Trip[] getTripsWith(String dep, String ar, String date) throws JsonParseException, JsonMappingException, IOException {

		String uri = URLBaseBlablacarSearch + URLBlablacarTrips + "?fn=" + dep + "&tn=" + ar + "&locale=" + LOCALE + "&"
				+ "_format=" + _FORMAT + "&" + "cur=" + CUR + "&de=" + date;
		// +"&key="+BLABLACAR_API_KEY;
		ClientResource cr = new ClientResource(uri);
		
		cr.setQueryValue("key", BLABLACAR_API_KEY);
		cr.setQueryValue("Content-Type", "application/json");
		
		log.log(Level.WARNING,"-------------------Blablacar uri:" + cr.getStatus());


		Trip[] trip = null;
		
		try {
//			trip = cr.get(Trip.class);
//			trip.getAdditionalProperties();
			
			Representation response = cr.get();
			log.log(Level.FINE,"Response---------------------------------------------------------- : " );
			
			ObjectMapper JSON2Object = new ObjectMapper();
			JsonRepresentation b = new JsonRepresentation(response.getText());
			JSONObject a = b.getJsonObject();
			
			trip = JSON2Object.readValue(a.get("trips").toString(), Trip[].class);
			
		} catch (RuntimeException rt) {
			log.warning("Error when retrieving all Events: " + cr.getResponse().getStatus());
		}



		return trip;

	}


}
