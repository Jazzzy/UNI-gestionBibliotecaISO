package controlador;

import org.w3c.dom.Document;

import accesoADatos.DAOFondo;
import accesoADatos.FactoriaDAO;

public class HelperBorrarLibro implements Helper {

	private Integer id;

	public HelperBorrarLibro(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public Document ejecutar() {

		FactoriaDAO f = FactoriaDAO.newFactoria();
		DAOFondo u = f.crearDAOFondo();
		Integer error = u.borrarFondo(id);

		if (error == 0) {

			// TODO Document
		}

		return null;
	}

}
