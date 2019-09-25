package aiss.model.resource;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class GoogleCalendar2ResourceTest {
    private final static String access_token = "ya29.GlsZB9A8l7LkxxFAuoj07SoF1wwuQV8PCgeU7G2eHEx9Q8BX41gKt0lqIo80qEQFivMsZpDroxXQWga-gJ4CYELWhxE_ZXP82OWG7N76EbKiBw8sNcMtOdPx6tdZ";

    //Es necesario cambiar las id's por las válidas
	
	@Test
	public void DeleteEvent() throws IOException  {
		Boolean evento, evento2, evento3;
		GoogleCalendarResource gdResource = new GoogleCalendarResource(access_token);
		String idPrimerEvento = "neki22snn4gh0ar4aocfjmhuso";
		String idSegundoEvento = "60b7dn3ua2un5iqpgiu6pj0ceo";
		String idTerceroEvento = "ksoqohkmsjkd0uf4bsj3k1hlbs";

		
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
