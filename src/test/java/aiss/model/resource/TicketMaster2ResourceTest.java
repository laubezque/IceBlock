package aiss.model.resource;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import aiss.model.tickermaster.Event;

public class TicketMaster2ResourceTest {
	
	@Test
	public void getEventID() throws IOException {

	String id = "Z698xZ2qZadDP";
	
	Event evento = TicketmasterResource.searchById(id);

	assertNotNull("The search returned null", evento);
	
	System.out.println("The search for id" + id + " returned this event:" + evento + " with name and date - " + evento.getName() + " - " + evento.getDates().getStart().getDateTime());

	}

}
