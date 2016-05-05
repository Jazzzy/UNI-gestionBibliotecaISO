package controlador;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import accesoADatos.DAOUsuario;
import accesoADatos.FactoriaDAO;
import accesoADatos.VOFondo;
import accesoADatos.VOLibro;
import accesoADatos.VOUsuario;

public class HelperVisualizarUsuario implements Helper {

	Integer id;

	public HelperVisualizarUsuario(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public Document ejecutar() {

		FactoriaDAO f = FactoriaDAO.newFactoria();
		DAOUsuario u = f.crearDAOUsuario();
		VOUsuario user = u.getUsuarioById(id);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			if (user != null) {
				
					Element aux = doc.createElement("usuario");
					Element nombre = doc.createElement("nombre");
					Element dni = doc.createElement("dni");
					Element sexo = doc.createElement("sexo");
					Element fecha_nacimiento = doc.createElement("fechaDeNacimiento");
					Element direccion = doc.createElement("direccion");
					Element telefono = doc.createElement("telefono");
					Element email = doc.createElement("email");

					nombre.appendChild(doc.createTextNode(user.getNombre()));
					dni.appendChild(doc.createTextNode(user.getDni()));
					if(user.isSexo()){
						sexo.appendChild(doc.createTextNode("Masculino"));
					}
					else{
						sexo.appendChild(doc.createTextNode("Femenino"));	
					}
					fecha_nacimiento.appendChild(doc.createTextNode(user.getFecha_nacimiento().toString()));
					direccion.appendChild(doc.createTextNode(user.getDireccion()));
					telefono.appendChild(doc.createTextNode(user.getTelefono()));
					email.appendChild(doc.createTextNode(user.getEmail()));

					aux.appendChild(nombre);
					aux.appendChild(dni);
					aux.appendChild(sexo);
					aux.appendChild(fecha_nacimiento);
					aux.appendChild(direccion);
					aux.appendChild(telefono);
					aux.appendChild(email);
					doc.appendChild(aux); // Añadimos la etiqueta correspondiente a este libro que contiene todos los datos
				
			} else {
				Element aux = doc.createElement("mensaje");
				aux.appendChild(doc.createTextNode("Ha habido un error con la visualización del usuario"));
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
