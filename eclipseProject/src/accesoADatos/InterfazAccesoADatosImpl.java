package accesoADatos;

import java.util.ArrayList;
import java.util.Date;

public class InterfazAccesoADatosImpl implements InterfazAccesoADatos {

	@Override
	public VOUsuario getUsuarioById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VOUsuario getUsuarioByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VOUsuario getUsuarioByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VOUsuario getUsuarioByDNI(String DNI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOUsuario> getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer anadirUsuario(VOUsuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarUsuario(VOUsuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarUsuarioById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarUsuarioByDNI(String DNI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modificarUsuario(VOUsuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

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

	@Override
	public VOPrestamo getPrestamoById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosByUsuario(Integer id_usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosByFondo(Integer id_fondo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosPendientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosPendientesDeUsuario(Integer id_usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosByFecha(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VOPrestamo> getPrestamosByFechaYUsuario(Date desde, Date hasta, Integer id_usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer anadirPrestamo(VOPrestamo prestamo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer modificarPrestamo(VOPrestamo prestamo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer borrarPrestamo(Integer id_prestamo) {
		// TODO Auto-generated method stub
		return null;
	}

}
