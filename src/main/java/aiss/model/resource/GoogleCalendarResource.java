package aiss.model.resource;

import java.util.logging.Logger;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.googleCalendar.Item;
import aiss.model.googleCalendar.ListEvents;

public class GoogleCalendarResource {

    private static final Logger log = Logger.getLogger(GoogleCalendarResource.class.getName());

    private final String access_token;
    private final String uri = "https://www.googleapis.com/calendar/v3/calendars/primary/events";

    public GoogleCalendarResource(String access_token) {
        this.access_token = access_token;
    }

    
    public Item getEvent(String id) {
        ClientResource cr = null;
        Item events = null;
        try {
            cr = new ClientResource(uri + "/" + id + "?access_token=" + access_token);
            events = cr.get(Item.class);

        } catch (ResourceException re) {
            log.warning("Error when retrieving the event: " + cr.getResponse().getStatus());
        }

        return events;

    }

    public ListEvents getList() {
        ClientResource cr = null;
        ListEvents events = null;
        try {
            cr = new ClientResource(uri + "?access_token=" + access_token);
            events = cr.get(ListEvents.class);

        } catch (ResourceException re) {
            log.warning("Error when retrieving all Events: " + cr.getResponse().getStatus());
        }

        return events;

    }
    

    public Item insertEvent(Item event) { //cambiar FileItem por elemento de ticketMaster
    														// y acabarlo

        ClientResource cr = null;
        Item newEvent = null;
        try {
            cr = new ClientResource(uri);
    		cr.setEntityBuffering(true);
            newEvent = cr.post(event, Item.class);
          
        } catch (ResourceException re) {
            log.warning("Error when inserting file: " + cr.getResponse().getStatus());
        }
        return newEvent;
    }
    
    
    public Boolean quickAddEvent(String content) {

    	ClientResource cr = null;
        boolean result = true;
    	try {
    		cr = new ClientResource(uri + "/quickAdd" + "?text=" + content + "&access_token=" + access_token);
    		cr.setEntityBuffering(true);
    		cr.post(content);
    	} catch (ResourceException re) {
    		log.warning("Error when inserting file: " + cr.getResponse().getStatus());
            result = false;
    	}
    	return result;
    }
    
    
    public boolean updateEvent(Item Event) {

        ClientResource cr = null;
        boolean result = true;
        try {
            cr = new ClientResource(uri + "/" + Event.getId() + "?access_token=" + access_token);
            cr.put(Event);
        } catch (ResourceException re) {
            log.warning("Error when updating event: " + cr.getResponse().getStatus());
            result = false;
        }
        return result;
    }

    public boolean deleteEvent(String id) {

        ClientResource cr = null;
        boolean result = true;
        try {
        	
            cr = new ClientResource(uri + "/" + id + "?access_token=" + access_token);
            cr.delete();
        } catch (ResourceException re) {
            log.warning("Error when deleting file: " + cr.getResponse().getStatus());
            result = false;
        }
        return result;

    }
}
  