package controlador;

import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import accesoADatos.DAOFondo;
import accesoADatos.DAOPrestamo;
import accesoADatos.DAOUsuario;
import accesoADatos.FactoriaDAO;
import accesoADatos.VOLibro;
import accesoADatos.VOPrestamo;
import accesoADatos.VOUsuario;

public class HelperAnadirPrestamo implements Helper {

	private Integer id_usuario;
	private Integer id_fondo;
	private Date inicio;
	private Date fin;

	public HelperAnadirPrestamo(Integer id_usuario, Integer id_fondo, Date inicio, Date fin) {
		super();
		this.id_usuario = id_usuario;
		this.id_fondo = id_fondo;
		this.inicio = inicio;
		this.fin = fin;
	}

	@Override
	public Document ejecutar() {

		FactoriaDAO f = FactoriaDAO.newFactoria();
		DAOPrestamo p = f.crearDAOPrestamo();

		DAOUsuario u = f.crearDAOUsuario();
		VOUsuario usuario = u.getUsuarioById(id_usuario);

		DAOFondo fo = f.crearDAOFondo();
		VOLibro fondo = (VOLibro) fo.getFondoById(id_fondo);

		VOPrestamo prestamo = new VOPrestamo(null, inicio, fin, usuario, fondo);
		Integer error = p.anadirPrestamo(prestamo);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element aux = doc.createElement("mensaje");

			if (error == 0) {

				aux.appendChild(doc.createTextNode("El préstamo se ha añadido con éxito"));
				doc.appendChild(aux);

			}

			else if (error < 0) {

				aux.appendChild(doc.createTextNode("Ha habido un error con la inserción del préstamo"));
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
