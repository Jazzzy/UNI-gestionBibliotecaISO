package estadistico;

import accesoADatos.InterfazAccesoADatos;
import accesoADatos.InterfazAccesoADatosImpl;

public class Estadistico {
	protected InterfazAccesoADatos accesoDatos;
	
	public Estadistico(){
		this.accesoDatos = new InterfazAccesoADatosImpl();
	}
}
