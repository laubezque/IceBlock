package aiss.api.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.model.Artist;
import aiss.api.model.Event;
import aiss.model.repository.ArtistListRepository;
import aiss.model.repository.MapArtistListRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Path("/events")
public class EventsResource {
	
	    public static EventsResource _instance=null;
	    ArtistListRepository repository;
	    
	    private EventsResource(){
	        repository=MapArtistListRepository.getInstance();
	    }
	    
	    public static EventsResource getInstance()
	    {
	        if(_instance==null)
	            _instance=new EventsResource();
	        return _instance; 
	    }
	    
	    @GET
	    @Produces("application/json")
	    public Collection<Event> getAll(@QueryParam("eventName") String eventName,
										@QueryParam("artistGen") String eventPlace)
	    {List<Event> res = new ArrayList<Event>();
		for(Event e:repository.getAllEvents()) {
			
		
			if((eventName == null || eventName.equals("")||e.getNombre().equals(eventName))
			&& (eventPlace == null || eventPlace.equals("")||e.getLugar().equals(eventPlace))) {
				res.add(e);
			}
		}
	        return res;
	    }
	    
	    
	    @GET
	    @Path("/{id}")
	    @Produces("application/json")
	    public Event get(@PathParam("id") String id)
	    {
	        Event e = repository.getEvent(id);
	        if(e == null) {
	        	throw new NotFoundException("El evento con id = "+ id+ " no esta disponible");
	        }
	        
	        return e;
	    }
	    
	    @POST
	    @Consumes("application/json")
	    @Produces("application/json")
	    public Response addEvent(@Context UriInfo uriInfo, Event e) {
	    	if (e.getNombre() == null || "".equals(e.getNombre()))
	            throw new NotFoundException("El atributo nombre, es necesario.");
	        
	    	if (e.getFecha() == null || "".equals(e.getFecha().toString()))
	    		 throw new NotFoundException("El atributo fecha, es necesario.Recuerda es un LocalDate.");

	        repository.addEvent(e);

	        // Builds the response. Returns the event the has just been added.
	        UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
	        URI uri = ub.build(e.getId());
	        ResponseBuilder resp = Response.created(uri);
	        resp.entity(e);            
	        return resp.build();

	    }
	    
	    
	    @PUT
	    @Consumes("application/json")
	    public Response updateEvent(Event event) {
	    	Event oldEvent = repository.getEvent(event.getId());
	    	if(oldEvent== null){
	    		throw new BadRequestException("El evento es necesario.Recuerda que no es posible actualizar algo inexistente.");
	    	}
	    	 if(!oldEvent.getNombre().contentEquals(event.getNombre()))
	         	return Response.status(javax.ws.rs.core.Response.Status.CONFLICT).build();
	    	 
	    	if (oldEvent.getNombre() == null || "".equals(oldEvent.getNombre()))
	            throw new BadRequestException("El atributo nombre, es necesario.");
	        
//	    	if (oldEvent.getFecha() == null || "".equals(oldEvent.getFecha().toString()))
//	    		 throw new BadRequestException("El atributo fecha, es necesario.Recuerda es un LocalDateTime.");
	    	
	    	if (oldEvent.getDescripcion() == null || "".equals(oldEvent.getDescripcion()))
	    		 throw new BadRequestException("El atributo fecha, es necesario.Recuerda es un LocalDateTime.");
	    	
	    	if (oldEvent.getLugar() == null || "".equals(oldEvent.getLugar()))
	    		 throw new BadRequestException("El atributo fecha, es necesario.Recuerda es un LocalDateTime.");
	    	
	        return Response.noContent().build();
	    }
	    
	    @DELETE
	    @Path("/{id}")
	    public Response removeEvent(@PathParam("id") String eventId) {
	    	Event event2BRemove = repository.getEvent(eventId);
	    	if(event2BRemove == null) {
	    		throw new NotFoundException("El evento es necesario.Recuerda que no es posible borrar algo inexistente.");
	    	}else {
	    		repository.removeEvent(eventId);
	    	}
	        return Response.noContent().build();
	    }
	    
	}


