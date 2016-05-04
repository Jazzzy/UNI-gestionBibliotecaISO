package controlador;

import org.w3c.dom.Document;

public class HelperMostrarEstadisticas implements Helper {

	Integer opcion;

	public HelperMostrarEstadisticas(Integer opcion) {
		super();
		this.opcion = opcion;
	}

	@Override
	public Document ejecutar() {

		switch (opcion) {

		case 0: // Valores bruto

			break;

		case 1: // Medias

			break;

		case 2: // Porcentajes

			break;

		case 3: // Histogramas

			break;

		default:
			return null;

		}

		return null;
	}

}
