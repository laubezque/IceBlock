package aiss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.blablacar.search.ArrivalPlace;
import aiss.model.blablacar.search.DeparturePlace;
import aiss.model.blablacar.search.Trip;
import aiss.model.resource.BlablacarResource;

/**
 * Servlet implementation class BlablacarSearchController
 */
public class BlablacarSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlablacarSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		//Cargar los viajes
		
//		Trip viaje = Trip.
		
		
//		DeparturePlace departurePlace = request.getParameter(departurePlace);
//		ArrivalPlace arrivalPlace = request.getParameter(arrivalPlace);
//		Date departureDate =  request.getAttribute(departureDate);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<HTML><HEAD><TITLE>Leyendo parámetros</TITLE></HEAD>");
		pw.println("<BODY BGCOLOR=\"#CCBBAA\">");
		pw.println("<H2>Leyendo parámetros desde un formulario html</H2><P>");
		pw.println("<H2></H2><P>");
		pw.println("<UL>\n");
		pw.println("URL -> " + BlablacarResource.getURLTrips()+ "<BR>");

		pw.println("</BODY></HTML>");
		pw.close();

		doGet(request, response);
	}

}

