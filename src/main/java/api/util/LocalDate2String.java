package api.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.util.StdConverter;

public class LocalDate2String extends StdConverter<LocalDate,String>{

	@Override
	public String convert(LocalDate fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return formatter.format(fecha);
	}

}
