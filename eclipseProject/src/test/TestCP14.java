package test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import estadistico.InterfazEstadistico;
import estadistico.InterfazEstadisticoImpl;

public class TestCP14 {

	@Test
	public void testCP114_01() {
		try {
			// Arrange
			InterfazEstadistico ie = new InterfazEstadisticoImpl();
			String testDate = "01-01-1978";
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date;

			date = formatter.parse(testDate);

			// Act
			Float res = ie.porcentajeDeLibrosEnUnDiaSobreElMes(date);

			// Assert
			assertFalse("Devuelve algun libro", res > 0);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Test
	public void testCP114_02() {
		try {
			// Arrange
			InterfazEstadistico ie = new InterfazEstadisticoImpl();
			String testDate = "03-03-1990";
			DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Date date;

			date = formatter.parse(testDate);

			// Act
			Float res = ie.porcentajeDeLibrosEnUnDiaSobreElMes(date);

			// Assert
			assertFalse("No devuelve ningun libro", res <= 0);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
}
