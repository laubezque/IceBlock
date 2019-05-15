package aiss.model.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
		eventMap= new HashMap<String,Event>();
		
		//Create events
		
		Event e1 =new Event();
		e1.setCapacidadMaximaDelEvento(10000);
		e1.setDescripcion("Evento cuna de las estrellas");
		e1.setFecha(LocalDateTime.of(LocalDate.of(2020, 1, 31), LocalTime.of(20, 10)));
		e1.setLugar("Madrid");
		e1.setNombre("Gala de los Goya");
		
		Event e2 =new Event();
		e2.setCapacidadMaximaDelEvento(260000);
		e2.setDescripcion("De la rubia a la morena ...");
		e2.setFecha(LocalDateTime.of(LocalDate.of(2019, 1, 1), LocalTime.of(20, 10)));
		e2.setLugar("Vva de la Serena");
		e2.setNombre("Dia de la cerveza");
		addEvent(e2);
		
		Event e3 =new Event();
		e3.setCapacidadMaximaDelEvento(1000);
		e3.setDescripcion("Colorao y al remoho");
		e3.setFecha(LocalDateTime.of(LocalDate.of(2020, 2, 2), LocalTime.of(20, 10)));
		e3.setLugar("El puerto");
		e3.setNombre("Dia del cangrejo");
		addEvent(e3);
		
		Event e4 =new Event();
		e4.setCapacidadMaximaDelEvento(200);
		e4.setDescripcion("Evento exclusivo para afiliados");
		e4.setFecha(LocalDateTime.of(LocalDate.of(2020, 3, 2), LocalTime.of(21, 10)));
		e4.setLugar("Rotas");
		e4.setNombre("Dia de la de Rota");
		addEvent(e4);
		
		Event e5 =new Event();
		e5.setCapacidadMaximaDelEvento(2);
		e5.setDescripcion("Una sola participacion");
		e5.setFecha(LocalDateTime.of(LocalDate.of(2020, 1, 31), LocalTime.of(10, 10)));
		e5.setLugar("Valencia");
		e5.setNombre("Los coches choque");
		addEvent(e5);
		
		Event e6 =new Event();
		e6.setCapacidadMaximaDelEvento(6775456);
		e6.setDescripcion("Como en una sauna");
		e6.setFecha(LocalDateTime.of(LocalDate.of(2020, 1, 21), LocalTime.of(03, 10)));
		e6.setLugar("Sevilla");
		e6.setNombre("Dia del calor");
		addEvent(e6);
		
		Event e7 =new Event();
		e7.setCapacidadMaximaDelEvento(100);
		e7.setDescripcion("En la cima de lo chic");
		e7.setFecha(LocalDateTime.of(LocalDate.of(2020, 2, 11), LocalTime.of(20, 10)));
		e7.setLugar("Pirineos");
		e7.setNombre("La pirinaica");
		addEvent(e7);
		//Crea listaEventos
		List<Event> l1 = new ArrayList<Event>();
		l1.add(e1);
		l1.add(e2);
		l1.add(e4);
		List<Event> l2 = new ArrayList<Event>();
		l2.add(e2);
		l2.add(e4);
		l2.add(e5);
		List<Event> l3 = new ArrayList<Event>();
		l3.add(e1);
		l3.add(e2);
		l3.add(e3);
		
		
		//Crea artistas
		Artist a1 = new Artist();
		a1.setEdad(23);
		a1.setNombre("Ayax");
		a1.setDescripcion("Un cruk");
		a1.setUrlFoto("http://www.hangarburgos.com/wp-content/uploads/2019/03/AYAX.jpg");
		a1.setGenero("Rap");
		a1.setListaDeEventos(l1);
		addArtist(a1);
		
		Artist a2 = new Artist();
		a1.setEdad(23);
		a1.setNombre("Prock");
		a1.setDescripcion("Un cruk");
		a1.setUrlFoto("https://tastethefloor.es/wp-content/uploads/2019/01/15-MS-prok-@davithmadrid-1600x2400.jpg");
		a1.setGenero("Rap");
		a1.setListaDeEventos(l2);
		addArtist(a2);
		
		Artist a3 = new Artist();
		a1.setEdad(23);
		a1.setNombre("Melendi");
		a1.setDescripcion("Un genio músical que nos ha ayudado durante todo el proyecto");
		a1.setUrlFoto("https://tastethefloor.es/wp-content/uploads/2019/01/15-MS-prok-@davithmadrid-1600x2400.jpg");
		a1.setGenero("Rumba-Pop");
		a1.setListaDeEventos(l3);
		addArtist(a3);
		
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
