package aiss.model.resource;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import aiss.model.resource.GoogleCalendarResource;

public class GoogleCalendarResourceTest {
	
    private final static String access_token = "ya29.GlsQB9zBExFvjOBVyaLeBya1FO0uOJAWd8BH9oul-vAGBKkN-RE85lBly9mVIH36dGxpeYUeyegIjBg3gzGVt6aF-PxUiUV8kw7gtHZjNyr9-IsI6QsRgryw4OhI";

    //Es necesario utilizar un token válido para que funcione

@Test
public void quickAddEvent() throws IOException  {
	Boolean evento, evento2, evento3;
	GoogleCalendarResource gdResource = new GoogleCalendarResource(access_token);
	String primerEvento = "Evento simple 20:45 17/05/2019";
	String segundoEvento = "Evento simple dos 20:45 18/05/2019";
	String terceroEvento = "Evento simple tres 20:45 19/05/2019";

	
	evento = gdResource.quickAddEvent(primerEvento);
	evento2 = gdResource.quickAddEvent(segundoEvento);
	evento3 = gdResource.quickAddEvent(terceroEvento);
	
	assertTrue("Error when adding the event", evento);
	assertTrue("Error when adding the event", evento2);
	assertTrue("Error when adding the event", evento3);

	System.out.println("Insert of - " + primerEvento + " returned:" + evento);
	System.out.println("Insert of - " + segundoEvento + " returned:" + evento2);
	System.out.println("Insert of - " + terceroEvento + " returned:" + evento3);

	
	
}


}

