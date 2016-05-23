package test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import importacion.InterfazImportacion;
import importacion.InterfazImportacionImpl;

public class TestCP16 {


	@Test
	public void testCP16_01() {
		//Arrange
		InterfazImportacion ii = new InterfazImportacionImpl();
		String url = "src/csv/7campos.csv";
		//Act
		Integer res = ii.importarDesdeCSV(url);
		
		//Assert
		assertEquals("No acepta la ruta", new Integer(0), res);
		
	}

	
	@Test
	public void testCP16_02() {
		//Arrange
		InterfazImportacion ii = new InterfazImportacionImpl();
		String url = "/";
		
		//Act
		Integer res = ii.importarDesdeCSV(url);
		
		//Assert
		assertEquals("Acepta la ruta", new Integer(-1), res);
		
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testCP16_03() throws ArrayIndexOutOfBoundsException{
		//Arrange
		InterfazImportacion ii = new InterfazImportacionImpl();
		String url = "src/csv/6campos.csv";
		
		//Act
		Integer res = ii.importarDesdeCSV(url);
		
		//Assert
		assertEquals("Acepta la ruta", new Integer(-1), res);
		
	}
}
