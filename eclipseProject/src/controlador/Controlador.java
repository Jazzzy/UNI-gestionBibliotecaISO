package controlador;

import java.util.ArrayList;
import java.util.Date;

import org.w3c.dom.Document;

public class Controlador implements InterfazControlador {

	private Helper h;
	private Document data;

	@Override
	public Document BorrarUsuario(Integer id) {

		h = new HelperBorrarUsuario(id);
		data = h.ejecutar();

		return data;
	}

	@Override
	public Document AnadirUsuario(String nombre, String DNI, boolean sexo, Date fechaNacimiento, String direccion,
			String telefono, String email) {

		h = new HelperAnadirUsuario(nombre, DNI, sexo, fechaNacimiento, direccion, telefono, email);
		data = h.ejecutar();

		return data;
	}

	@Override
	public Document ModificarUsuario(Integer id, String nombre, String DNI, boolean sexo, Date fechaNacimiento,
			String direccion, String telefono, String email) {

		h = new HelperModificarUsuario(id, nombre, DNI, sexo, fechaNacimiento, direccion, telefono, email);
		data = h.ejecutar();

		return data;
	}

	@Override
	public Document VisualizarUsuario(Integer id) {

		h = new HelperVisualizarUsuario(id);
		data = h.ejecutar();

		return data;
	}

	@Override
	public Document ImportarDesdeFichero(String ruta) {

		h = new HelperImportarDesdeFichero(ruta);
		data = h.ejecutar();

		return data;

	}

	@Override
	public Document MostrarEstadisticasValoresBruto(Integer opcion, Integer opcion2) {

		if (opcion == 0 && (opcion2 >= 0 && opcion2 <= 2)) {
			h = new HelperMostrarEstadisticas(opcion, opcion2);
			data = h.ejecutar();

			return data;
		}
		return null;
	}

	@Override
	public Document MostrarEstadisticasMedias(Integer opcion, Integer opcion2) {

		if (opcion == 1 && (opcion2 >= 0 && opcion2 <= 1)) {
			h = new HelperMostrarEstadisticas(opcion, opcion2);
			data = h.ejecutar();

			return data;
		}
		return null;
	}

	@Override
	public Document MostrarEstadisticasPorcentajes(Integer opcion, Integer opcion2, Date fecha) {

		if (opcion == 2 && (opcion2 >= 0 && opcion2 <= 1)) {
			h = new HelperMostrarEstadisticas(opcion, opcion2, fecha);
			data = h.ejecutar();

			return data;
		}

		return null;
	}

	@Override
	public Document MostrarEstadisticasHistogramas(Integer opcion, Integer opcion2) {

		if (opcion == 3 && (opcion2 >= 0 && opcion2 <= 1)) {
			h = new HelperMostrarEstadisticas(opcion, opcion2);
			data = h.ejecutar();

			return data;
		}

		return null;
	}

	@Override
	public Document AnadirPrestamo(Integer id_usuario, Integer id_fondo, Date inicio, Date fin) {

		h = new HelperAnadirPrestamo(id_usuario, id_fondo, inicio, fin);
		data = h.ejecutar();

		return data;
	}

	@Override
	public Document ModificarPrestamo(Integer id_prestamo, Integer id_usuario, Integer id_fondo, Date inicio,
			Date fin) {

		h = new HelperModificarPrestamo(id_prestamo, id_usuario, id_fondo, inicio, fin);
		data = h.ejecutar();

		return data;
	}

	@Override
	public Document BorrarPrestamo(Integer id) {

		h = new HelperBorrarPrestamo(id);
		data = h.ejecutar();

		return data;
	}

	@Override
	public Document AnadirLibro(String titulo, Date fecha_compra, String iSBN, ArrayList<String> autores,
			Date ano_edicion, String editorial) {

		h = new HelperAnadirLibro(titulo, fecha_compra, iSBN, autores, ano_edicion, editorial);
		data = h.ejecutar();

		return data;

	}

	@Override
	public Document BorrarLibro(Integer id) {

		h = new HelperBorrarLibro(id);
		data = h.ejecutar();

		return data;
	}

	@Override
	public Document ModificarLibro(Integer id, String titulo, Date fecha_compra, String iSBN, ArrayList<String> autores,
			Date ano_edicion, String editorial) {

		h = new HelperModificarLibro(id, titulo, fecha_compra, iSBN, autores, ano_edicion, editorial);
		data = h.ejecutar();

		return data;
	}

	@Override
	public Document VisualizarLibro(String ISBN) {

		h = new HelperVisualizarLibro(ISBN);
		data = h.ejecutar();

		return data;

	}

	@Override
	public Document BuscarLibro(String titulo, String autor) {

		h = new HelperBuscarLibro(titulo, autor);
		data = h.ejecutar();

		return data;
	}

}
