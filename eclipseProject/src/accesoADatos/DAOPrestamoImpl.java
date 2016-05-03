package accesoADatos;

import java.util.ArrayList;
import java.util.Date;

public class DAOPrestamoImpl implements DAOPrestamo{

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
