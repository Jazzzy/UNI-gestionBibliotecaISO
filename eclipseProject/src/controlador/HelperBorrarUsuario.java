package controlador;

import org.w3c.dom.Document;

import accesoADatos.DAOUsuario;
import accesoADatos.DAOUsuarioImpl;
import accesoADatos.FactoriaDAO;
import accesoADatos.FactoriaDAOImpl;
import accesoADatos.VOUsuario;

public class HelperBorrarUsuario implements Helper {

	Integer id;

	public HelperBorrarUsuario(Integer idaux) {
		id = idaux;
	}

	@Override
	public Document ejecutar() {

		FactoriaDAO f = FactoriaDAO.newFactoria();
		DAOUsuario u = f.crearDAOUsuario();
		Integer error = u.borrarUsuarioById(id);

		if (error == 0) {
			// TODO convertir a Document

		}

		return null;
	}

}
