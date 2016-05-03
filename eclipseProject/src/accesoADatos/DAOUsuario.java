package accesoADatos;

import java.util.ArrayList;

public interface DAOUsuario {

	VOUsuario getUsuarioById(Integer id);

	VOUsuario getUsuarioByNombre(String nombre);

	VOUsuario getUsuarioByEmail(String email);

	VOUsuario getUsuarioByDNI(String DNI);

	ArrayList<VOUsuario> getUsuarios();

	Integer anadirUsuario(VOUsuario usuario);

	Integer borrarUsuario(VOUsuario usuario);

	Integer borrarUsuarioById(Integer id);

	Integer borrarUsuarioByDNI(String DNI);

	Integer modificarUsuario(VOUsuario usuario);

	
}
