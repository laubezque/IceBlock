package aiss.api.model;

public class Artist {

		private static String id ;
		private static String nombre;
		
		
		
		public static String getId() {
			return id;
		}
		public static void setId(String id) {
			Artist.id = id;
		}
		public static String getNombre() {
			return nombre;
		}
		public static void setNombre(String nombre) {
			Artist.nombre = nombre;
		}
}
