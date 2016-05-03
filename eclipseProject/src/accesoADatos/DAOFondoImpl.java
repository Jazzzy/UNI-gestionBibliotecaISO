package accesoADatos;

import java.util.ArrayList;
import java.util.Date;

public class DAOFondoImpl implements DAOFondo{

	@Override
	public VOFondo getFondoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VOFondo getFondoByTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOFondo> getFondosByFechas(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VOFondo getFondoByISBN(String ISBN) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOFondo> getFondos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOFondo> getFondosByAutor(String autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOFondo> getFondosByAnoEdicion(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOFondo> getFondosByEditorial(String editorial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOFondo> getFondosByAutorYTitulo(String autor, String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOLibro> getLibros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer anadirFondo(VOFondo fondo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer anadirLibro(VOLibro libro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modificarFondo(VOFondo fondo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modificarLibro(VOLibro libro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarFondo(VOFondo fondo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarFondo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarFondo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarLibro(String ISBN) {
		// TODO Auto-generated method stub
		return null;
	}

}
