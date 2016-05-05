package controlador;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import accesoADatos.DAOUsuario;
import accesoADatos.DAOUsuarioImpl;
import accesoADatos.FactoriaDAO;
import accesoADatos.FactoriaDAOImpl;
import accesoADatos.InterfazAccesoADatos;
import accesoADatos.InterfazAccesoADatosImpl;
import accesoADatos.VOUsuario;

public class HelperBorrarUsuario implements Helper {

	Integer id;

	public HelperBorrarUsuario(Integer idaux) {
		id = idaux;
	}

	@Override
	public Document ejecutar() {

		InterfazAccesoADatos ia = new InterfazAccesoADatosImpl(); 
		Integer error = ia.borrarUsuarioById(id);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element aux = doc.createElement("mensaje");

			if (error == 0) {

				aux.appendChild(doc.createTextNode("El usuario ha sido eliminado con éxito"));
				doc.appendChild(aux);

			}

			else if (error < 0) {

				aux.appendChild(doc.createTextNode("Ha habido un error con la eliminación del usuario"));
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
