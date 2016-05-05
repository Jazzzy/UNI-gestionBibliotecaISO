package importacion;

import java.util.ArrayList;

import org.w3c.dom.Document;

import accesoADatos.VOFondo;
import accesoADatos.VOLibro;

public class VODatosImportados {

	ArrayList<VOFondo> fondos;
	

	public VODatosImportados(ArrayList<VOFondo> fondos) {
		super();
		this.fondos = fondos;
	}


	public ArrayList<VOFondo> getFondos() {
		return fondos;
	}

	public void setFondos(ArrayList<VOFondo> fondos) {
		this.fondos = fondos;
	}


}
