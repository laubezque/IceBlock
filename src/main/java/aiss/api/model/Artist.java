package aiss.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Artist {

		private String id ;
		private String nombre;
		private String descripcion;
		private Integer edad;
		@JsonProperty("url_foto")
		private String urlFoto;
		private String genero;
		@JsonProperty("lista_de_eventos")
		private List<Event> listaDeEventos;
		
		public Artist() {}

		public Artist(String nombre,String descripcion,Integer edad,String urlFoto,String genero,List<Event> listaDeEventos) {
			this.nombre = nombre;
			this.descripcion=descripcion;
			this.edad=edad;
			this.urlFoto=urlFoto;
			this.genero = genero;
			this.listaDeEventos = new ArrayList<Event>();
					
			
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public Integer getEdad() {
			return edad;
		}
		public void setEdad(Integer edad) {
			this.edad = edad;
		}
		public String getUrlFoto() {
			return urlFoto;
		}
		public void setUrlFoto(String urlFoto) {
			this.urlFoto = urlFoto;
		}
		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		public List<Event> getListaDeEventos() {
			return listaDeEventos;
		}
		public void setListaDeEventos(List<Event> listaDeEventos) {
			this.listaDeEventos = listaDeEventos;
		}
		public Event getEvent(String id) {
			if(listaDeEventos==null) {return null;}
			Event evento = null;
			for(Event e : listaDeEventos) {
				if(e.getId().equals(id)) {
					evento = e;
					break;
				}		
			}
			return evento;
			
		}
		
		public void addEvent(Event e) {
			if(listaDeEventos==null) {
				listaDeEventos = new ArrayList<Event>();
			}
			listaDeEventos.add(e);
		}
		
		public void deleteEvent(String id) {
			Event e = getEvent(id);
			if(e!=null) {
				listaDeEventos.remove(e);
			}
		}

		public void addEvent(String eventId) {
			if(listaDeEventos==null) {
				listaDeEventos = new ArrayList<Event>();
			}
			listaDeEventos.add(getEvent(eventId));
			
		}

	
		

}
