package controlador;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import importacion.GestorImportacionCSV;
import importacion.VODatosImportados;

public class HelperImportarDesdeFichero implements Helper {

	private String ruta;

	public HelperImportarDesdeFichero(String ruta) {
		super();
		this.ruta = ruta;
	}

	@Override
	public Document ejecutar() {

		GestorImportacionCSV imp = new GestorImportacionCSV(ruta);
		Integer error = imp.importar();

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element aux = doc.createElement("mensaje");

			if (error == 0) {

				aux.appendChild(doc.createTextNode("La importación ha sido un éxito"));
				doc.appendChild(aux);

			}

			else if (error < 0) {

				aux.appendChild(doc.createTextNode("Ha habido un error con la importación"));
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
