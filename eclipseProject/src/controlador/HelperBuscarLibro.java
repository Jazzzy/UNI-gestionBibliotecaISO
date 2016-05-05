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
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			if (fondosaux != null) {
				ArrayList<VOLibro> libros = new ArrayList<>();
				for (VOFondo fo : fondosaux) {

					libros.add((VOLibro) fo);
				}

				for (VOLibro libro : libros) {

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

				}
				
			} else {
				Element aux = doc.createElement("mensaje");
				aux.appendChild(doc.createTextNode("No hay libros coincidentes con sus parámetros de búsqueda"));
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
