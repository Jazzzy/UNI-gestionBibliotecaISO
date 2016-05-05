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
import accesoADatos.InterfazAccesoADatos;
import accesoADatos.InterfazAccesoADatosImpl;
import accesoADatos.VOLibro;
import accesoADatos.VOPrestamo;
import accesoADatos.VOUsuario;

public class HelperModificarPrestamo implements Helper {

	private Integer id_prestamo;
	private Integer id_usuario;
	private Integer id_fondo;
	private Date inicio;
	private Date fin;

	public HelperModificarPrestamo(Integer id_prestamo, Integer id_usuario, Integer id_fondo, Date inicio, Date fin) {
		super();
		this.id_prestamo = id_prestamo;
		this.id_usuario = id_usuario;
		this.id_fondo = id_fondo;
		this.inicio = inicio;
		this.fin = fin;
	}

	@Override
	public Document ejecutar() {

		InterfazAccesoADatos ia = new InterfazAccesoADatosImpl(); 
		
		VOUsuario usuario = ia.getUsuarioById(id_usuario);

		VOLibro fondo = (VOLibro) ia.getFondoById(id_fondo);

		VOPrestamo prestamo = new VOPrestamo(id_prestamo, inicio, fin, usuario, fondo);
		Integer error = ia.modificarPrestamo(prestamo);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			Element aux = doc.createElement("mensaje");

			if (error == 0) {

				aux.appendChild(doc.createTextNode("El préstamo ha sido modificado con éxito"));
				doc.appendChild(aux);

			}

			else if (error < 0) {

				aux.appendChild(doc.createTextNode("Ha habido un error con la modificación del préstamo"));
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
