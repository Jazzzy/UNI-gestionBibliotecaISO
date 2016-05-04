package importacion;

public class GestorImportacionCSV extends GestorImportacion {

	public GestorImportacionCSV(String ruta) {
		super(ruta);
	}

	public VODatosImportados importar() {
		
		
		InterfazImportacion imp = new InterfazImportacionImpl();
		VODatosImportados aux;
		aux = imp.importarDesdeCSV(ruta);
		
		return aux;

	}

}
