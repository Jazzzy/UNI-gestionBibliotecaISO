package controlador;

import java.util.Date;

import org.w3c.dom.Document;

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
		
		if(error == 0){
			
			//TODO Document
		}
		
		
		return null;
	}

}
