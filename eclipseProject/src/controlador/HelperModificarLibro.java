package controlador;

import java.util.ArrayList;
import java.util.Date;

import org.w3c.dom.Document;

import accesoADatos.DAOFondo;
import accesoADatos.FactoriaDAO;
import accesoADatos.VOLibro;

public class HelperModificarLibro implements Helper {

	private Integer id;
	private String titulo;
	private Date fecha_compra;
	private String iSBN;
	private ArrayList<String> autores;
	private Date ano_edicion;
	private String editorial;

	public HelperModificarLibro(Integer id, String titulo, Date fecha_compra, String iSBN, ArrayList<String> autores,
			Date ano_edicion, String editorial) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fecha_compra = fecha_compra;
		this.iSBN = iSBN;
		this.autores = autores;
		this.ano_edicion = ano_edicion;
		this.editorial = editorial;
	}

	@Override
	public Document ejecutar() {

		FactoriaDAO f = FactoriaDAO.newFactoria();
		DAOFondo u = f.crearDAOFondo();
		VOLibro libro = new VOLibro(id, titulo, fecha_compra, iSBN, autores, ano_edicion, editorial);
		Integer error = u.modificarLibro(libro);

		if (error == 0) {

			// TODO Document
		}
		return null;
	}

}
