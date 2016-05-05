package estadistico;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import accesoADatos.VOFondo;

public class EstadisticoCalculoPorcentajes extends Estadistico {
	Float porcentajeDeLibrosEnUnDiaSobreElMes (Date dia){
		ArrayList<VOFondo> resultadosDia = this.accesoDatos.getFondosByFechas(dia, dia);
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(dia);
		calendario.set(Calendar.DAY_OF_MONTH, 1);
		Date inicio = calendario.getTime();
		calendario.add(Calendar.MONTH, 1);
		calendario.add(Calendar.DAY_OF_MONTH, -1);
		Date fin = calendario.getTime();
		ArrayList<VOFondo> resultadosMes = this.accesoDatos.getFondosByFechas(inicio, fin);
            if(resultadosMes.size()==0) return -1.f;
	    return (resultadosDia.size() / resultadosMes.size())*100.0f;
	}
	
	Float porcentajeDeLibrosEnUnaSemanaSobreElAno(Date semana){
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(semana);
		Date inicio = calendario.getTime();
		calendario.add(Calendar.DAY_OF_MONTH, 7);
		Date fin = calendario.getTime();
		ArrayList<VOFondo> resultadosSemana = this.accesoDatos.getFondosByFechas(inicio, fin);
		calendario.set(Calendar.DAY_OF_YEAR, 1);
		inicio = calendario.getTime();
		calendario.add(Calendar.YEAR, 1);
		calendario.add(Calendar.DAY_OF_YEAR, -1);
		fin = calendario.getTime();
		ArrayList<VOFondo> resultadosAno = this.accesoDatos.getFondosByFechas(inicio, fin);
                if(resultadosAno.size()==0) return -1.f;
	    return (resultadosSemana.size() / resultadosAno.size())*100.0f;
	}
}
