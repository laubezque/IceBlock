package aiss.api.resource;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;

import javassist.NotFoundException;

public class ArtistListResource {

	private static ArtistListResource _instance= null;
	ArtistRepository repository;
	
	private ArtistListResource() {
		repository= MapArtistRepository.getInstance();
		
	}
	
	public static ArtistListResource getInstance() {
		if(_instance==null) {
			_instance = new ArtistListResource();
			return _instance;
		}
	}
	@GET
	@Produces("application/json")
	public Collection<ArtistList> getAll(){
		return repository.getAllArtist();
		}
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Artist get(@PathParam("id") String id){
		Artist artista = repository.getArtist(id);
		if(list== null) {
			throw new NotFoundException("El artista con el id -> "+ id + " no existe. Has probado con Melendi :D");
		}
		return artist;
		}
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public Response addArtist(@Context UriInfo uriInfo,Artist artist){
		if(artist.getName()= null || "".equals(artist.getName())) {
			throw new BadRequestException("El nombre del artista no puede ser null ni una cadena vacía.");
		}
		repository.addArtist(artist);
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(),"get");
		URI uri = ub.build(artist.getId());
		ResponseBuilder resp = Response.created(uri);
		return resp.build();
		}
	
	
}
