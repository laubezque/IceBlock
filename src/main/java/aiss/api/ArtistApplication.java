package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resource.ArtistListResource;
import aiss.api.resource.EventsResource;

public class ArtistApplication extends Application{
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public ArtistApplication() {
		
		singletons.add(EventsResource.getInstance());
		singletons.add(ArtistListResource.getInstance());


	}
	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	


}
