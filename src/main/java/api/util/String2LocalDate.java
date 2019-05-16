package api.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class String2LocalDate  extends StdConverter<String, LocalDate> {

	@Override
	public LocalDate convert(String s) {

		

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			return LocalDate.parse(s, formatter);
	
	
	}

}
