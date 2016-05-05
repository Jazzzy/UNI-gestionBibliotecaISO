package controlador;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import accesoADatos.DAOFondo;
import accesoADatos.FactoriaDAO;
import accesoADatos.InterfazAccesoADatos;
import accesoADatos.InterfazAccesoADatosImpl;
import accesoADatos.VOFondo;
import accesoADatos.VOLibro;

public class HelperVisualizarLibro implements Helper {

	private String ISBN;

	public HelperVisualizarLibro(String ISBN) {
		super();
		this.ISBN = ISBN;
	}

	@Override
	public Document ejecutar() {

		InterfazAccesoADatos ia = new InterfazAccesoADatosImpl(); 
		VOFondo fondo =  ia.getFondoByISBN(ISBN);
		VOLibro libro = (VOLibro) fondo;
		
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			if (libro != null) {

				Element aux = doc.createElement("libro");
				Element titulo = doc.createElement("titulo");
				Element fecha_compra = doc.createElement("fechaDeCompra");
				Element iSBN = doc.createElement("ISBN");
				Element autores = doc.createElement("autores");
				Element ano_edicion = doc.createElement("añoDeEdicion");
				Element editorial = doc.createElement("editorial");

				titulo.appendChild(doc.createTextNode(libro.getTitulo()));
				fecha_compra.appendChild(doc.createTextNode(libro.getFecha_compra().toString()));
				iSBN.appendChild(doc.createTextNode(libro.getISBN()));

				for (String autor : libro.getAutores()) {
					Element author = doc.createElement("autor");
					author.appendChild(doc.createTextNode(autor));

					autores.appendChild(author);

				}

				ano_edicion.appendChild(doc.createTextNode(libro.getAno_edicion().toString()));
				editorial.appendChild(doc.createTextNode(libro.getEditorial()));

				aux.appendChild(titulo);
				aux.appendChild(fecha_compra);
				aux.appendChild(iSBN);
				aux.appendChild(autores);
				aux.appendChild(ano_edicion);
				aux.appendChild(editorial);
				doc.appendChild(aux); // Añadimos la etiqueta correspondiente a este libro que contiene todos los datos
			} else {
				Element aux = doc.createElement("mensaje");
				aux.appendChild(doc.createTextNode("Error con la visualización del libro"));
				doc.appendChild(aux);

			}

			return doc;

		} catch (

		ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
