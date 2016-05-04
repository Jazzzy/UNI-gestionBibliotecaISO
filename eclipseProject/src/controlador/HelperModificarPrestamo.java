package controlador;

import java.util.Date;

import org.w3c.dom.Document;

import accesoADatos.DAOFondo;
import accesoADatos.DAOPrestamo;
import accesoADatos.DAOUsuario;
import accesoADatos.FactoriaDAO;
import accesoADatos.VOLibro;
import accesoADatos.VOPrestamo;
import accesoADatos.VOUsuario;

public class HelperModificarPrestamo implements Helper {

	private Integer id_prestamo;
	private Integer id_usuario;
	private Integer id_fondo;
	private Date inicio;
	private Date fin;

	public HelperModificarPrestamo(Integer id_prestamo, Integer id_usuario, Integer id_fondo, Date inicio, Date fin) {
		super();
		this.id_prestamo = id_prestamo;
		this.id_usuario = id_usuario;
		this.id_fondo = id_fondo;
		this.inicio = inicio;
		this.fin = fin;
	}

	@Override
	public Document ejecutar() {

		FactoriaDAO f = FactoriaDAO.newFactoria();
		DAOPrestamo p = f.crearDAOPrestamo();

		DAOUsuario u = f.crearDAOUsuario();
		VOUsuario usuario = u.getUsuarioById(id_usuario);

		DAOFondo fo = f.crearDAOFondo();
		VOLibro fondo = (VOLibro) fo.getFondoById(id_fondo);

		VOPrestamo prestamo = new VOPrestamo(id_prestamo, inicio, fin, usuario, fondo);
		Integer error = p.modificarPrestamo(prestamo);

		if (error == 0) {

			// TODO Document
		}
		return null;
	}

}
