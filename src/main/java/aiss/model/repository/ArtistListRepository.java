package aiss.model.repository;

import java.util.Collection;
import java.util.List;

import aiss.api.model.Artist;
import aiss.api.model.Event;

public interface ArtistListRepository {

	//Operaciones de los artistas.end-point: /artist
	 public void addArtist(Artist a);
	 public Collection<Artist> getAllArtist();
	 public Artist getArtist(String id);
	 public void removeArtist(String id);
	 public void upDateArtist(String id,Artist artista);
	
	//Operaciones de los eventos.end-point: /events
	 public void addEvent(Event a);
	 public Collection<Event> getAllEvents();
	 public Event getEvent(String id);
	 public void removeEvent(String id);
	 public void upDateEvent(String id,Event artista);
	 
	 //Propieadeades de eliminacion de eventos de una listas de eventos de un artista
	 //Recordadar que sigue el end-point /artist
	 public void addEvent2Artist(String artistaId, String eventId);
	 public void removeEvent2Artist(String artistaId, String eventId); 
	 
	 
}
