package aiss.model.repository;

import java.util.Collection;
import java.util.List;

import aiss.api.model.Artist;
import aiss.api.model.Event;

public interface ArtistListRepository {

	 public void addArtist(Artist a);
	 public List<Artist> getAllArtist();
	 public Artist getArtist(String id);
	 public void removeArtist(String id);
	 public void upDateArtist(String id,Artist artista);
	
	 public void addEvent(Event a);
	 public List<Event> getAllEvents();
	 public Event getEvent(String id);
	 public void removeEvent(String id);
	 public void upDateEvent(String id,Event artista);
	 
	 public void addEvent2Artist(String artistaId, String eventId);
	 public void removeEvent2Artist(String artistaId, String eventId); 
	 
	 
}
