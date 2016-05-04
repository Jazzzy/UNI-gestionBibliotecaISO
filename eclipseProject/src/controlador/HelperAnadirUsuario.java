package controlador;

import java.util.Date;

import org.w3c.dom.Document;

import accesoADatos.DAOUsuario;
import accesoADatos.FactoriaDAO;
import accesoADatos.VOUsuario;

public class HelperAnadirUsuario implements Helper {

	private String nombre;
	private String DNI;
	private boolean sexo;
	private Date fechaNacimiento;
	private String direccion;
	private String telefono;
	private String email;

	public HelperAnadirUsuario(String nombre, String DNI, boolean sexo, Date fechaNacimiento,
			String direccion, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.DNI = DNI;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	@Override
	public Document ejecutar() {

		FactoriaDAO f = FactoriaDAO.newFactoria();
		DAOUsuario u = f.crearDAOUsuario();
		VOUsuario user = new VOUsuario(null, nombre, DNI, sexo, fechaNacimiento, direccion, telefono, email);
		Integer error = u.anadirUsuario(user);

		if (error == 0) {
			// TODO Document
		}

		return null;
	}

}
