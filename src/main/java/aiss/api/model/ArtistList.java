package aiss.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArtistList {
	
		@JsonProperty("lista_artistas")
		private List<Artist> listaArtistas;
		

		public List<Artist> getListaArtistas() {
			return listaArtistas;
		}

		public void setListaArtistas(List<Artist> listaArtistas) {
			this.listaArtistas = listaArtistas;
		}
}
