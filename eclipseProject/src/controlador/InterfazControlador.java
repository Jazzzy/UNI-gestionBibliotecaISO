package controlador;

import java.util.ArrayList;
import java.util.Date;

import org.w3c.dom.Document;

public interface InterfazControlador {
	
	static final Integer dia = 0;
	static final Integer mes = 1;
	static final Integer ano = 2;
	
	
	Document BorrarUsuario(Integer id);
	Document AnadirUsuario(String nombre, String DNI, boolean sexo, Date fechaNacimiento, String direccion, String telefono, String email);
	Document ModificarUsuario(Integer id, String nombre, String DNI, boolean sexo, Date fechaNacimiento, String direccion, String telefono, String email);
	Document VisualizarUsuario(Integer id);
	Document AnadirLibro(String titulo, Date fecha_compra, String iSBN, ArrayList<String> autores, Date ano_edicion, String editorial);
	Document BorrarLibro(Integer id);
	Document ModificarLibro(Integer id, String titulo, Date fecha_compra, String iSBN, ArrayList<String> autores, Date ano_edicion, String editorial);
	Document VisualizarLibro(Integer id);
	Document ImportarDesdeFichero(String ruta);
	Document BuscarLibro(String titulo, String autor);
	Document MostrarEstadisticasValoresBruto(Integer opcion);
	Document MostrarEstadisticasMedias(Integer opcion);
	Document MostrarEstadisticasPorcentajes(Integer opcion);
	Document MostrarEstadisticasHistogramas(Integer opcion);
	Document AnadirPrestamo(Integer id_usuario, Integer id_fondo, Date inicio, Date fin);
	Document ModificarPrestamo(Integer id_prestamo, Integer id_usuario, Integer id_fondo, Date inicio, Date fin);
	Document BorrarPrestamo(Integer id);

}
