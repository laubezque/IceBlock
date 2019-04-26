package aiss.model.resource;

import javax.servlet.http.HttpServlet;

import org.restlet.resource.ClientResource;

import aiss.controller.BlablacarSearchController;
import aiss.model.blablacar.search.Links_;

public class BlablacarResource extends HttpServlet {
	
	private static final String BLABLACAR_API_KEY = "46410bf6eee240cbbc7d9eef6a0dc210";
	private static final long serialVersionUID = 1L;
	private static String URLBaseBlablacarSearch = 
			"https://public-api.blablacar.com";
	private static String URLBlablacarTrips = 
			"/api/v2/trips";
	
	private static String IDIOM_CODE = "ES";
	private static final String LOCALE = "es_ES";
	private static final String _FORMAT ="json" ;
	private static final String CUR = "EUR" ;
	
	
	
	public static String getURLTrips() {
		
		String result = URLBaseBlablacarSearch + URLBlablacarTrips + "?" 
		+ "locale=" + LOCALE + "&" + "_format=" + _FORMAT + "&" + "cur=" + CUR + "key=" + BLABLACAR_API_KEY;
		
		
		return result;
	}
	
	public static Links_ getTripsWith(String dep, String ar, String date) {
		
		
		String base = URLBaseBlablacarSearch + URLBlablacarTrips + "?" 
				+ "locale=" + LOCALE + "&" + "_format=" + _FORMAT + "&" + "cur=" + CUR + "key=" + BLABLACAR_API_KEY;
		String res = base + "&fn=" + dep + "&tn=" + ar + "&de=" + date;
		
		
		ClientResource bl = new ClientResource(res);
		Links_ blSearch = bl.get(Links_.class);
		
		return blSearch;
		

	
	}
	
	
	

}
