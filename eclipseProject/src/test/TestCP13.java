package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.w3c.dom.Document;

import controlador.Controlador;
import controlador.InterfazControlador;

public class TestCP13 {

	@Test
	public void testCP13_01() {
		//Arrange
		InterfazControlador ic = new Controlador();
		int opcion  = 3;
		int opcion2 = -1;
		
		//Act
		Document doc = ic.MostrarEstadisticasHistogramas(opcion, opcion2);
		
		//Assert
		
		assertEquals("Devuelve un Document", null, doc);
	}
	
	@Test
	public void testCP13_02() {
		
		//Arrange
		InterfazControlador ic = new Controlador();        
		int opcion  = 3;
		int opcion2 = 0;
		
		//Act
		Document doc = ic.MostrarEstadisticasHistogramas(opcion, opcion2);
		System.out.println(doc);
		//Assert
		
		assertEquals("No devuelve un Document", "[#document: null]", doc.toString());
		
	}
	
	@Test
	public void testCP13_03() {
		//Arrange
		InterfazControlador ic = new Controlador();
		int opcion  = 3;
		int opcion2 = 1;
		
		//Act
		Document doc = ic.MostrarEstadisticasHistogramas(opcion, opcion2);
		
		//Assert
		assertEquals("No devuelve un Document", "[#document: null]", doc.toString());
	}

}
