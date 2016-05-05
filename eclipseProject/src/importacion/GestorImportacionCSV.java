package importacion;

public class GestorImportacionCSV extends GestorImportacion {

	public GestorImportacionCSV(String ruta) {
		super(ruta);
	}

	public Integer importar() {
		
		
		InterfazImportacion imp = new InterfazImportacionImpl();
		Integer aux;
		aux = imp.importarDesdeCSV(ruta);
		
		return aux;

	}

}
