package controlador;

import org.w3c.dom.Document;

import accesoADatos.DAOFondo;
import accesoADatos.FactoriaDAO;
import accesoADatos.VOLibro;

public class HelperVisualizarLibro implements Helper {

	private Integer id;

	public HelperVisualizarLibro(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public Document ejecutar() {

		FactoriaDAO f = FactoriaDAO.newFactoria();
		DAOFondo u = f.crearDAOFondo();
		VOLibro libro = (VOLibro) u.getFondoById(id);

		if (libro != null) {

			// TODO Document
		}

		return null;
	}

}
