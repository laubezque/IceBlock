package aiss.model.resource;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import aiss.model.tickermaster.Embedded;

public class TicketMasterResourceTest3 {
	
	@Test
	public void getEventosSugeridos() throws IOException {
	
	Embedded listaEventos = TicketmasterResource.searchSuggest();

	assertNotNull("The search returned null", listaEventos);
	
	System.out.println("Suggested events returned this Embedded: " + listaEventos + " with this list of events - " + listaEventos.getEvents());

	}

}
