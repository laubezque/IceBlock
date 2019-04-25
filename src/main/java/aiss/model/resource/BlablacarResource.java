package aiss.model.resource;

import javax.servlet.http.HttpServlet;

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
	private static String origen;
	
	
	public static String getURLTrips() {
		
		String result = URLBaseBlablacarSearch + URLBlablacarTrips + "?" 
		+ "locale=" + LOCALE + "&" + "_format=" + _FORMAT + "&" + "cur=" + CUR + "key=" + BLABLACAR_API_KEY;
		
		return result;
	}
	
	

}
