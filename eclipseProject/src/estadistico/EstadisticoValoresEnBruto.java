package estadistico;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import accesoADatos.VOFondo;

public class EstadisticoValoresEnBruto extends Estadistico {
	Integer librosUltimaSemana(){
		Calendar calendario = Calendar.getInstance();
		calendario.add(Calendar.DAY_OF_MONTH, -7);
		Date desde = calendario.getTime();
		ArrayList<VOFondo> resultados = this.accesoDatos.getFondosByFechas(desde , new Date());
		return resultados.size();
	}
	
	Integer librosUltimoMes(){
		Calendar calendario = Calendar.getInstance();
		calendario.add(Calendar.MONTH, -1);
		Date desde = calendario.getTime();
		ArrayList<VOFondo> resultados;
		resultados = this.accesoDatos.getFondosByFechas(desde , new Date());
		return resultados.size();
	}
	
	Integer librosUltimoAno(){
		Calendar calendario = Calendar.getInstance();
		calendario.add(Calendar.YEAR, -1);
		Date desde = calendario.getTime();
		ArrayList<VOFondo> resultados;
		resultados = this.accesoDatos.getFondosByFechas(desde , new Date());
		return resultados.size();
	}
}
