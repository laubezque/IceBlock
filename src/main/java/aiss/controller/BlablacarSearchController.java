package aiss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.blablacar.search.Trip;
import aiss.model.resource.BlablacarResource;
import aiss.model.tickermaster.Embedded;
import aiss.model.tickermaster.Event;

/**
 * Servlet implementation class BlablacarSearchController
 */
public class BlablacarSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(BlablacarSearchController.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BlablacarSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String departurePlace = request.getParameter("departurePlace");
		String arrivalPlace = request.getParameter("arrivalPlace");
		String departureDate = request.getParameter("departureDate");
		RequestDispatcher rd;

		// log.log(Level.FINE, "Searching for trips from " + departurePlace + "to" +
		// arrivalPlace + "on" + departureDate);

		Trip[] trips = BlablacarResource.getTripsWith(departurePlace, arrivalPlace, departureDate);
		// Map<String, Object> e = trip.getAdditionalProperties();

		if (trips != null) {
			Trip[] selectedTrips = fiveTrips(trips);
			// rd = request.getRequestDispatcher("/vistaViajes.jsp");
			request.setAttribute("selectedTrips", selectedTrips);
			request.getRequestDispatcher("/vistaViajes.jsp").forward(request, response);

		} else {

			log.log(Level.SEVERE, "Blablacar object:" + trips);
			rd = request.getRequestDispatcher("/error.jsp");
		}
//		rd.forward(request, response);
//		
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		pw.println("<HTML><HEAD><TITLE>Leyendo parámetros</TITLE></HEAD>");
//		pw.println("<BODY BGCOLOR=\"#CCBBAA\">");
//		pw.println("<H2>Leyendo parámetros desde un formulario html</H2><P>");
//		pw.println("<H2></H2><P>");
//		pw.println("<UL>\n");
//
//		pw.println("Searching for trips from " + departurePlace + " to " + arrivalPlace + " on the date " + departureDate
//				  +"<BR>");
//
//		pw.println("links  -> " + trips[0].getPermanentId() + "<BR>");
//
//		pw.println("</BODY></HTML>");
//		pw.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

	private Trip[] fiveTrips(Trip[] trips) {
		Trip res[] = new Trip[5] ;
		
		if (trips.length<5) {
 			for(int i = 0 ; i<trips.length;i++) {
 				res[i]= trips[i];
 			}
 		}else if (trips.length>=5) {
 			for(int j=0 ; j<5;j++) {
 				res[j]= trips[j];
 			}
 		}
 		return res;
	}

}