package aiss.model.resource;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;

import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;

import com.google.appengine.api.files.FileServicePb.FileContentType.ContentType;

import aiss.model.blablacar.search.Trip;

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

	public static Trip getTripsWith(String dep, String ar, String date) {

		String uri = URLBaseBlablacarSearch + URLBlablacarTrips + "?fn=" + dep + "&tn=" + ar + "&locale=" + LOCALE + "&"
				+ "_format=" + _FORMAT + "&" + "cur=" + CUR + "&de=" + date;
		// +"&key="+BLABLACAR_API_KEY;
		ClientResource cr = new ClientResource(uri);
		addHeader(cr, "Content-Type", "application/json");

		addHeader(cr, "key", BLABLACAR_API_KEY);

		Trip trip = null;

		System.out.println(uri);

		try {
			trip = cr.get(Trip.class);
			trip.getAdditionalProperties();
			
		} catch (RuntimeException rt) {
			log.warning("Error when retrieving all Events: " + cr.getResponse().getStatus());
		}

		log.log(Level.FINE, "Blablacar uri:" + trip.getAdditionalProperties());

		return trip;

	}

	@SuppressWarnings("unchecked")
	public static void addHeader(ClientResource cr, String headerName, String headerValue) {
		Series<Header> headers = (Series<Header>) cr.getRequest().getAttributes()
				.get(HeaderConstants.ATTRIBUTE_HEADERS);

		if (headers == null) {
			headers = new Series<Header>(Header.class);
			cr.getRequest().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
		}
		headers.add(headerName, headerValue);
	}

}
