package controlador;

import org.w3c.dom.Document;

import accesoADatos.DAOUsuario;
import accesoADatos.FactoriaDAO;
import accesoADatos.VOUsuario;

public class HelperVisualizarUsuario implements Helper {

	Integer id;

	public HelperVisualizarUsuario(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public Document ejecutar() {

		FactoriaDAO f = FactoriaDAO.newFactoria();
		DAOUsuario u = f.crearDAOUsuario();
		VOUsuario user = u.getUsuarioById(id);

		if (user != null) {
			// TODO Document
		}

		return null;
	}

}
