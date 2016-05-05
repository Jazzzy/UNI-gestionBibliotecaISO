package estadistico;

import accesoADatos.InterfazAccesoADatos;
import accesoADatos.InterfazAccesoADatosImpl;
import importacion.VODatosImportados;

public class ComparacionEstadisticos {
	private InterfazAccesoADatos accesoDatos;
	
	public ComparacionEstadisticos(){
		this.accesoDatos = new InterfazAccesoADatosImpl();
	}
	
	Integer comprararEstadisticos(VODatosImportados di){
		return null;
	}
}
