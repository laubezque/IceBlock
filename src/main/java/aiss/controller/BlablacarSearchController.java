package aiss.controller;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.blablacar.search.Links_;
import aiss.model.resource.BlablacarResource;

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
		RequestDispatcher rd = null;

		log.log(Level.FINE, "Searching for trips from " + departurePlace + "to" + arrivalPlace + "on" + departureDate);

		

		Links_ l = BlablacarResource.getTripsWith(departurePlace, arrivalPlace, departureDate);
		Map<String, Object> e = l.getAdditionalProperties();

		if (!l.equals(null)) {

			rd = request.getRequestDispatcher("/successBusquedaViaje.jsp");
			request.setAttribute("trips", e);

		} else {

			log.log(Level.SEVERE, "Blablacar object:" + e);
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request,response);
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		pw.println("<HTML><HEAD><TITLE>Leyendo parámetros</TITLE></HEAD>");
//		pw.println("<BODY BGCOLOR=\"#CCBBAA\">");
//		pw.println("<H2>Leyendo parámetros desde un formulario html</H2><P>");
//		pw.println("<H2></H2><P>");
//		pw.println("<UL>\n");

//		pw.println("Searching for trips from" + departurePlace + "to" + arrivalPlace + "on the date" + departureDate
//				+ "<BR>");
//
//		pw.println("links  -> " + e + "<BR>");
//
//		pw.println("</BODY></HTML>");
//		pw.close();

	}
}