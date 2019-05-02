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
		
//		https://public-api.blablacar.com/api/v2/trips
//		?fn=Paris&tn=London&locale=en_GB&_format=json&cur=EUR
//				&fc=48.756%7C7.268&tc=48.756%7C7.268&db=2016-09-05&de=2016-09-07&hb=7&he=14
//				&page=1&seats=1&photo=1&fields=links%2Cprice%2Cpermanent_id
//				&sort=trip_price&order=desc&limit=50&radius=10&radius_from=5
//				&radius_to=15&aa=1&blablalines=1&pmin=2&pmax=142'

		String res = URLBaseBlablacarSearch + URLBlablacarTrips + "?fn=" + dep + "&tn=" + ar +"&locale=" + LOCALE +
				 "&" + "_format=" + _FORMAT + "&" + "cur=" + CUR +"&de=" + date + "&key=" + BLABLACAR_API_KEY;

		log.log(Level.FINE, "Blablacar uri:" + res);
		ClientResource cr = new ClientResource(res);
		Links_ blSearch = cr.get(Links_.class);
		System.out.println();

		return blSearch;

	}

}
