package controlador;

import java.util.Date;

import org.w3c.dom.Document;

public interface InterfazControlador {
	
	static final Integer dia = 0;
	static final Integer mes = 1;
	static final Integer ano = 2;
	
	
	Document BorrarUsuario(Integer id);
	Document AnadirUsuario(String nombre, String contrasena, String DNI, Integer sexo, Date fechaNacimiento, String direccion, String telefono, String email);
	Document ModificarUsuario(Integer id, String nombre, String contrasena, String DNI, Integer sexo, Date fechaNacimiento, String direccion, String telefono, String email);
	Document VisualizarUsuario(Integer id);
	Document AnadirFondo(String titulo, String autor, Integer stock, String ISBN, Date anoEdicion, String editorial);
	Document BorrarFondo(Integer id);
	Document ModificarFondo(Integer id, String titulo, String autor, Integer stock, String ISBN, Date anoEdicion, String editorial);
	Document VisualizarFondo(Integer id);
	Document ImportarDesdeFichero(String ruta);
	Document BuscarFondo(String titulo, String autor);
	Document MostrarEstadisticasValoresBruto(Integer opcion);
	Document MostrarEstadisticasMedias(Integer opcion);
	Document MostrarEstadisticasPorcentajes(Integer opcion);
	Document MostrarEstadisticasHistogramas(Integer opcion);
	Document AnadirPrestamo(Integer id_usuario, Integer id_fondo, Date inicio, Date fin);
	Document ModificarPrestamo(Integer id_prestamo, Integer id_usuario, Integer id_fondo, Date inicio, Date fin);
	Document BorrarPrestamo(Integer id);

}
