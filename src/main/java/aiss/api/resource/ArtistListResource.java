package aiss.api.resource;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;

import aiss.api.model.Artist;
import aiss.api.model.ArtistList;
import aiss.api.model.Event;
import aiss.model.repository.ArtistListRepository;
import aiss.model.repository.MapArtistListRepository;
import javassist.NotFoundException;

@Path("/artist")
public class ArtistListResource {

	private static ArtistListResource _instance= null;
	ArtistListRepository repository;
	
	private ArtistListResource() {
		repository= MapArtistListRepository.getInstance();
		
	}
	
	public static ArtistListResource getInstance() {
		if(_instance==null) {
			_instance = new ArtistListResource();
			
		}
		return _instance;
	}
	@GET
	@Produces("application/json")
	public Collection<Artist> getAll(){
		return repository.getAllArtist();
		}
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Artist get(@PathParam("id") String id) throws NotFoundException{
		Artist artista = repository.getArtist(id);
		if( artista== null) {
			throw new NotFoundException("El artista con el id -> "+ id + " no existe. Has probado con Melendi :D");
		}
		return artista;
		}
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public Response addArtist(@Context UriInfo uriInfo,Artist artist){
		if(artist.getNombre()== null || "".equals(artist.getNombre())) {
			throw new BadRequestException("El nombre del artista no puede ser null ni una cadena vacía.");
		}
		repository.addArtist(artist);
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(),"get");
		URI uri = ub.build(artist.getId());
		ResponseBuilder resp = Response.created(uri);
		
		return resp.build();
		}
	@PUT
    @Consumes("application/json")
    public Response updatePlaylist(Artist a) throws NotFoundException {
		Artist oldArtist = repository.getArtist(a.getId());
        if (oldArtist == null) {
            throw new NotFoundException("The playlist with id="+ a.getId() +" was not found");            
        }
        
        if (a.getListaDeEventos()!=null)
            throw new BadRequestException("The songs property is not editable.");
        
        // Update nombre
        if (a.getNombre()!=null)
        	oldArtist.setNombre(a.getNombre());
        
        // Update descripcion
        if (a.getDescripcion()!=null)
        	oldArtist.setDescripcion(a.getDescripcion());
        // Update genero
        if (a.getGenero()!=null)
        	oldArtist.setGenero(a.getGenero());
        // Update edad
        if (a.getEdad()!=null)
        	oldArtist.setGenero(a.getGenero());
        
        return Response.noContent().build();
    }
	@DELETE
    @Path("/{id}")
    public Response removeArtist(@PathParam("id") String id) throws NotFoundException {
        Artist toberemoved=repository.getArtist(id);
        if (toberemoved == null)
            throw new NotFoundException("The playlist with id="+ id +" was not found");
        else
            repository.removeArtist(id);
        
        return Response.noContent().build();
    }
	@POST    
    @Path("/{artistId}/{eventId}")
    @Consumes("text/plain")
    @Produces("application/json")
    public Response addEvent2Artist(@Context UriInfo uriInfo,@PathParam("artistId") String artistaId, @PathParam("eventId") String eventId) throws NotFoundException
    {                
        
        Artist artist = repository.getArtist(artistaId);
        Event event = repository.getEvent(eventId);
        
        if (artist==null)
            throw new NotFoundException("el artista con id=" + artistaId + " no se ha encontrado");
        
        if (event == null)
            throw new NotFoundException("El evento con id=" + eventId + " no se ha encontrado");
        
        if (artist.getEvent(eventId)!=null)
            throw new BadRequestException("The song is already included in the playlist.");
            
        repository.addEvent2Artist(artistaId, eventId);        

        // Builds the response
        UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
        URI uri = ub.build(artistaId);
        ResponseBuilder resp = Response.created(uri);
        resp.entity(artist);            
        return resp.build();
    }
	@DELETE
	@Path("/{artistId}/{eventId}")
    public Response removeEvent2Artist(@PathParam("artistId") String artistaId, @PathParam("eventId") String eventId) throws NotFoundException {
        Artist artist = repository.getArtist(artistaId);
        Event event= repository.getEvent(eventId);
        
        if (artist==null)
            throw new NotFoundException("The playlist with id=" + artistaId + " was not found");
        
        if (eventId == null)
            throw new NotFoundException("The song with id=" + eventId + " was not found");
        
        
        repository.removeEvent2Artist(artistaId, eventId);        
        
        return Response.noContent().build();
    }



	
	
}
