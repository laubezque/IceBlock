package aiss.model.resource;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

import aiss.model.tickermaster.Embedded;

public class TicketMasterResourceTest {
	
	@Test
	public void getEventKeyword() throws IOException {

	String keyword = "Melendi";
	
	Embedded embOfEvents = TicketmasterResource.searchByKeyword(keyword);

	assertNotNull("The search returned null", embOfEvents);
	
	System.out.println("The search for " + keyword + " returned this Embedded:" + embOfEvents + " with this list of events - " + embOfEvents.getEvents());

	}

}
