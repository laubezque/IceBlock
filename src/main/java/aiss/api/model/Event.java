package aiss.api.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import api.util.LocalDate2String;
import api.util.String2LocalDate;


public class Event {
	
		private String id ; 
		private String lugar; 
		private String nombre; 
		
		@JsonDeserialize(converter= String2LocalDate.class)
		private String fecha; 
		private String descripcion; 
		@JsonProperty("capacidad_maxima_del_evento")
		private Integer capacidadMaximaDelEvento; 
		
		public Event() {}
		
		
		public Event(String nombre,String descripcion,String fecha,String lugar,String genero,Integer capacidadMaximaDelEvento) {
			this.nombre=nombre;
			this.descripcion=descripcion;
			this.fecha=fecha;
			this.lugar=lugar;
			this.capacidadMaximaDelEvento= capacidadMaximaDelEvento;							
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getLugar() {
			return lugar;
		}
		public void setLugar(String lugar) {
			this.lugar = lugar;
		}
		
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public Integer getCapacidadMaximaDelEvento() {
			return capacidadMaximaDelEvento;
		}
		public void setCapacidadMaximaDelEvento(Integer capacidadMaximaDelEvento) {
			this.capacidadMaximaDelEvento = capacidadMaximaDelEvento;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		
		
}
