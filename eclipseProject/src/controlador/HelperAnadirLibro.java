package controlador;

import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import accesoADatos.DAOFondo;
import accesoADatos.FactoriaDAO;
import accesoADatos.VOLibro;

public class HelperAnadirLibro implements Helper {

	private String titulo;
	private Date fecha_compra;
	private String iSBN;
	private ArrayList<String> autores;
	private Date ano_edicion;
	private String editorial;

	public HelperAnadirLibro(String titulo, Date fecha_compra, String iSBN, ArrayList<String> autores, Date ano_edicion,
			String editorial) {
		super();
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
		VOLibro libro = new VOLibro(null, titulo, fecha_compra, iSBN, autores, ano_edicion, editorial);
		Integer error = u.anadirLibro(libro);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element aux = doc.createElement("mensaje");

			if (error == 0) {

				aux.appendChild(doc.createTextNode("El libro ha sido añadido con éxito"));
				doc.appendChild(aux);

			}

			else if (error < 0) {

				aux.appendChild(doc.createTextNode("Ha habido un error con la inserción del libro"));
				doc.appendChild(aux);

			}
			
			return doc;

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

		
	}

}
