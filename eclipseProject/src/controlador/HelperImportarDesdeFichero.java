package controlador;

import org.w3c.dom.Document;

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
		VODatosImportados datosimp = imp.importar();

		if (datosimp != null) {

			// TODO Document
		}

		return null;
	}

}
