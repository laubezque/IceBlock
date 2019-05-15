package aiss.model.resource;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import aiss.model.blablacar.search.Trip;

public class BlablacarResourceTest {
	
	@Test
	public void getBlablacarSearch() throws IOException {

	String departurePlace = "Sevilla";
	String arrivalPlace = "Cadiz";
	String departureDate = "15/05/2019";



	
	Trip[] trips = BlablacarResource.getTripsWith(departurePlace, arrivalPlace, departureDate);

	assertNotNull("The search returned null", trips);
	
	System.out.println("The search for the trip: " + departurePlace + " - " + arrivalPlace + " - " + departureDate + " returned this trips:" + trips);

	}

}
