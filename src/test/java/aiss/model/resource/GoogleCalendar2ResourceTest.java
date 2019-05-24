package aiss.model.resource;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class GoogleCalendar2ResourceTest {
    private final static String access_token = "ya29.GlsQB9zBExFvjOBVyaLeBya1FO0uOJAWd8BH9oul-vAGBKkN-RE85lBly9mVIH36dGxpeYUeyegIjBg3gzGVt6aF-PxUiUV8kw7gtHZjNyr9-IsI6QsRgryw4OhI";

    //Es necesario cambiar las id's por las válidas
	
	@Test
	public void DeleteEvent() throws IOException  {
		Boolean evento, evento2, evento3;
		GoogleCalendarResource gdResource = new GoogleCalendarResource(access_token);
		String idPrimerEvento = "besgebfcri71kkjdalllqbdg8s";
		String idSegundoEvento = "mk1m6fi02rki7lrff2dbmgc798";
		String idTerceroEvento = "35206t3ak8ropu3pl1gcu5g110";

		
		evento = gdResource.deleteEvent(idPrimerEvento);
		evento2 = gdResource.deleteEvent(idSegundoEvento);
		evento3 = gdResource.deleteEvent(idTerceroEvento);

		
		assertTrue("Error when deleting the event", evento);
		assertTrue("Error when deleting the event", evento2);
		assertTrue("Error when deleting the event", evento3);

		System.out.println("Delete of - " + idPrimerEvento + " returned:" + evento);
		System.out.println("Delete of - " + idSegundoEvento + " returned:" + evento2);
		System.out.println("Delete of - " + idTerceroEvento + " returned:" + evento3);

		
		
	}

}
