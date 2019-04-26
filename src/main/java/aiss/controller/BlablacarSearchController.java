package aiss.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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

		response.getWriter().append("Served at: ").append(request.getContextPath());

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<HTML><HEAD><TITLE>Leyendo parámetros</TITLE></HEAD>");
		pw.println("<BODY BGCOLOR=\"#CCBBAA\">");
		pw.println("<H2>Leyendo parámetros desde un formulario html</H2><P>");
		pw.println("<H2></H2><P>");
		pw.println("<UL>\n");

		String departurePlace = request.getParameter("departurePlace");
		String arrivalPlace = request.getParameter("arrivalPlace");
		String departureDate = request.getParameter("departureDate");

		Links_ URL = BlablacarResource.getTripsWith(departurePlace, arrivalPlace, departureDate);
		Map<String, Object> e = URL.getAdditionalProperties();

		pw.println("Searching for trips from" + departurePlace + "to" + arrivalPlace + "on the date" + departureDate
				+ "<BR>");

		pw.println("links  -> " + e + "<BR>");

		pw.println("</BODY></HTML>");
		pw.close();

	}

}
