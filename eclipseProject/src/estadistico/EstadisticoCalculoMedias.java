package estadistico;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import accesoADatos.VOFondo;

public class EstadisticoCalculoMedias extends Estadistico {
	Float mediaDiariaDeLibrosUltimoMes(){
		Calendar calendario = Calendar.getInstance();
		Date hoy = calendario.getTime();
		calendario.add(Calendar.MONTH, -1);
		Date desde = calendario.getTime();
		ArrayList<VOFondo> resultados = this.accesoDatos.getFondosByFechas(desde , hoy);
		long dif = hoy.getTime() - desde.getTime();
	    long diferenciaTiempo = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
		float media = resultados.size() / diferenciaTiempo;
	    return media;
	}
	Float mediaSemanalDeLibrosUltimoAno(){
		Calendar calendario = Calendar.getInstance();
		Date hoy = calendario.getTime();
		calendario.add(Calendar.YEAR, -1);
		Date desde = calendario.getTime();
		ArrayList<VOFondo> resultados = this.accesoDatos.getFondosByFechas(desde , hoy);
		long dif = hoy.getTime() - desde.getTime();
	    long diferenciaTiempo = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	    float semanas = diferenciaTiempo / 7.f;
		float media = resultados.size() / semanas;
	    return media;
	}
}
