package controlador;

import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import accesoADatos.DAOUsuario;
import accesoADatos.FactoriaDAO;
import accesoADatos.VOUsuario;

public class HelperAnadirUsuario implements Helper {

	private String nombre;
	private String DNI;
	private boolean sexo;
	private Date fechaNacimiento;
	private String direccion;
	private String telefono;
	private String email;

	public HelperAnadirUsuario(String nombre, String DNI, boolean sexo, Date fechaNacimiento, String direccion,
			String telefono, String email) {
		super();
		this.nombre = nombre;
		this.DNI = DNI;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	@Override
	public Document ejecutar() {

		FactoriaDAO f = FactoriaDAO.newFactoria();
		DAOUsuario u = f.crearDAOUsuario();
		VOUsuario user = new VOUsuario(null, nombre, DNI, sexo, fechaNacimiento, direccion, telefono, email);
		Integer error = u.anadirUsuario(user);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element aux = doc.createElement("mensaje");

			if (error == 0) {

				aux.appendChild(doc.createTextNode("El usuario ha sido añadido con éxito"));
				doc.appendChild(aux);

			}

			else if (error < 0) {

				aux.appendChild(doc.createTextNode("Ha habido un error con la inserción del usuario"));
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
