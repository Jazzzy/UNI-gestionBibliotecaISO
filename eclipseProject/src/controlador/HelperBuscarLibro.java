package controlador;

import java.util.ArrayList;

import org.w3c.dom.Document;

import accesoADatos.DAOFondo;
import accesoADatos.FactoriaDAO;
import accesoADatos.VOFondo;
import accesoADatos.VOLibro;

public class HelperBuscarLibro implements Helper {

	private String titulo;
	private String autor;

	public HelperBuscarLibro(String titulo, String autor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
	}

	@Override
	public Document ejecutar() {

		FactoriaDAO f = FactoriaDAO.newFactoria();
		DAOFondo u = f.crearDAOFondo();
		ArrayList<VOFondo> fondosaux = u.getFondosByAutorYTitulo(autor, titulo);

		if (fondosaux != null) {
			ArrayList<VOLibro> libros = new ArrayList<>();
			for (VOFondo fo : fondosaux) {

				libros.add((VOLibro) fo);
			}

			// TODO Document
		}
		return null;
	}

}
