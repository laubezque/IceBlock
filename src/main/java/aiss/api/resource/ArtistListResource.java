package aiss.api.resource;

import java.net.URI;
import java.util.ArrayList;
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
import javax.ws.rs.QueryParam;
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
	public Collection<Artist> getAll(@QueryParam("artistName") String artistName,
									@QueryParam("artistGen") String artistGen){
		List<Artist> res = new ArrayList<Artist>();
		for(Artist artist:repository.getAllArtist()) {
			
		
			if((artistName == null || artistName.equals("")||artist.getNombre().equals(artistName))
			&& (artistGen == null || artistGen.equals("")||artist.getGenero().equals(artistGen))) {
				res.add(artist);
			}
		}
		
		return res;
		}
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Artist get(@PathParam("id") String id) throws NotFoundException{
		Artist artista = repository.getArtist(id);
		if( artista== null) {
			throw new NotFoundException("El artista con el id -> "+ id + " no existe. Recuerda el patron es ale-ID ;D");
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
    public Response updateArtist(Artist a) throws NotFoundException {
		Artist oldArtist = repository.getArtist(a.getId());
        if (oldArtist == null) {
            throw new NotFoundException("No hemos encontrado el artista con ID = "+ a.getId() +". Prueba con otro id y recuerda que el formato es ale-id.");            
        }
        
        if (a.getListaDeEventos()!=null)
            throw new BadRequestException("La lista de evento no es editable :O");
        if(!oldArtist.getNombre().contentEquals(a.getNombre()))
        	return Response.status(javax.ws.rs.core.Response.Status.CONFLICT).build();
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
        	throw new NotFoundException("No hemos encontrado el artista con ID = "+ id +". Recuerda que el formato es ale-id.");
        else
            repository.removeArtist(id);
        
        return Response.noContent().build();
    }
	@POST    
    @Path("/{artistId}/{eventId}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response addEvent2Artist(@Context UriInfo uriInfo,@PathParam("artistId") String artistaId, @PathParam("eventId") String eventId) throws NotFoundException
    {                
        
        Artist artist = repository.getArtist(artistaId);
        Event event = repository.getEvent(eventId);
        
        if (artist==null)
            throw new NotFoundException("El artista con id=" + artistaId + " no se ha encontrado");
        
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
            throw new NotFoundException("El artista con id=" + artistaId + " no se ha encontrado");
        
        if (event == null)
            throw new NotFoundException("El evento con id=" + eventId + " no se ha encontrado");
        
        
        repository.removeEvent2Artist(artistaId, eventId);        
        
        return Response.noContent().build();
    }



	
	
}
