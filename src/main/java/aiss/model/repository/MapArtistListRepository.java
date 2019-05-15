package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import aiss.api.model.Artist;
import aiss.api.model.Event;

public class MapArtistListRepository implements ArtistListRepository{
	
	Map<String ,Event> eventMap;
	
	Map<String ,Artist> artistMap;
	private static MapArtistListRepository instance=null;
	
	private int index=0;
	private int indexEvent=0;
	
	public static MapArtistListRepository getInstance() {
		
		if(instance == null) {
			instance = new MapArtistListRepository();
			instance.init();
		}
		return instance;
	}
	public void init() {
		
		artistMap = new HashMap<String,Artist>();
		
		//Create artist
		
	}
	@Override
	public void addArtist(Artist artista) {
		String id= "ale-"+index++;
		artista.setId(id);
		artistMap.put(id, artista);
		
	}
	@Override
	public List<Artist> getAllArtist() {
		Collection<Artist> ls = artistMap.values();		
		return (List<Artist>) ls;
	}
	@Override
	public Artist getArtist(String id) {
		return artistMap.get(id);
	}
	@Override
	public void removeArtist(String id) {
		artistMap.remove(id);
		
	}
	@Override
	public void upDateArtist(String id,Artist artist) {
		artistMap.put(id, artist);
		
	}
	@Override
	public void addEvent(Event e) {
		String id= "eve-"+indexEvent+"-ale";
		e.setId(id);
		eventMap.put(id, e);
	}
	@Override
	public List<Event> getAllEvents() {
		Collection<Event> ls = eventMap.values();		
		return (List<Event>) ls;
	}
	@Override
	public Event getEvent(String id) {
		
		return eventMap.get(id);
	}
	@Override
	public void removeEvent(String id) {
		eventMap.remove(id);
		
	}
	@Override
	public void upDateEvent(String id, Event e) {
		eventMap.put(id, e);
		
	}
	@Override
	public void addEvent2Artist(String artistaId, String eventId) {
		getArtist(artistaId).addEvent(eventId);
	}
	@Override
	public void removeEvent2Artist(String artistaId, String eventId) {
		getArtist(artistaId).deleteEvent(eventId);		
	}
	
	
}
