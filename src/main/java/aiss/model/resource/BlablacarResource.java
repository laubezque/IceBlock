package aiss.model.resource;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;

import org.restlet.resource.ClientResource;

import aiss.model.blablacar.search.Links_;

public class BlablacarResource extends HttpServlet {

	private static final String BLABLACAR_API_KEY = "46410bf6eee240cbbc7d9eef6a0dc210";
	private static final long serialVersionUID = 1L;
	private static String URLBaseBlablacarSearch = "https://public-api.blablacar.com";
	private static String URLBlablacarTrips = "/api/v2/trips";
	private static final Logger log = Logger.getLogger(BlablacarResource.class.getName());
	private static String IDIOM_CODE = "ES";
	private static final String LOCALE = "es_ES";
	private static final String _FORMAT = "json";
	private static final String CUR = "EUR";



	public static Links_ getTripsWith(String dep, String ar, String date) {
		
	

		String res = URLBaseBlablacarSearch + URLBlablacarTrips + "?&fn=" + dep + "&tn=" + ar + "&de=" + date
				+ "locale=" + LOCALE + "&" + "_format=" + _FORMAT + "&" + "cur=" + CUR + "key=" + BLABLACAR_API_KEY;

		log.log(Level.FINE, "Blablacar uri:" + res);
		ClientResource cr = new ClientResource(res);
		Links_ blSearch = cr.get(Links_.class);

		return blSearch;

	}

}
