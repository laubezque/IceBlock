package aiss.api;

import java.util.HashSet;
import java.util.Set;

public class ArtistApplication {
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	
	public ArtistaApplication() {
		
		singletons.add(ConcertsResource.getInstance());
		singletons.add(PlaylistResource.getInstance());
		singletons.add(Artist.getInstance());

	}
	
	public Set<Class<?>> getClasses() {
		return classes;
	}
	public Set<Object> getSingletons() {
		return singletons;
	}
	


}
