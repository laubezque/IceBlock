package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.google.calendar.Files;
import aiss.model.resource.GoogleCalendarResource;

/**
 * Servlet implementation class LoginGoogle
 */
public class LoginGoogleController extends HttpServlet {
	 private static final Logger log = Logger.getLogger(LoginGoogleController.class.getName());

	    @Override
	    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

	        String accessToken = (String) req.getSession().getAttribute("GoogleCalendar-token");

	        if (accessToken != null && !"".equals(accessToken)) {

	            GoogleCalendarResource gdResource = new GoogleCalendarResource(accessToken);
	            Files files = gdResource.getFiles();

	            if (files != null) {
	                req.setAttribute("files", files);
	                req.getRequestDispatcher("/busqueda.jsp").forward(req, resp);
	            } else {
	                log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
	                req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
	            }
	        } else {
	            log.info("Trying to access Google Calendar without an access token, redirecting to OAuth servlet");
	            req.getRequestDispatcher("/AuthController/GoogleCalendar").forward(req, resp);
	        }
	    }

	    @Override
	    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
	        doGet(req, resp);
	    }
}
