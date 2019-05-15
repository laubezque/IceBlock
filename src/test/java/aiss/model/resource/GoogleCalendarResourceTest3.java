package aiss.model.resource;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class GoogleCalendarResourceTest3 {
	String timeZone = "Europe/Madrid";
	String location = "Sevilla";
	String description = "Concierto de Juan en la casa de su primo";
	String summary = "Concierto Juan";
	
	@Test
	public void quickAddEvent() throws IOException  {
		
		
		String timeZone = "Europe/Madrid";
		String location = "Sevilla";
		String description = "Concierto de Juan en la casa de su primo";
		String summary = "Concierto Juan";
		String fechaInicio = "2019-05-26T17:00:00Z";

		
		String res = "{\"calendarId\": \"primary\"," +
			      "\"resource\": {\"end\": {\"dateTime\": \""+ fechaInicio +"\",\"timeZone\": \""+ timeZone +"\"},"+
              "\"start\": {\"dateTime\": \""+ fechaInicio +"\",\"timeZone\": \""+ timeZone +"\"},"+
              "\"description\": \""+ description +"\" , "+
              "\"location\": \""+ location +"\","+
              "\"summary\": \""+ summary +"\"}}";
		
		

		
		
	}

}
