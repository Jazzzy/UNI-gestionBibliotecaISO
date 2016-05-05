package estadistico;


import java.util.Date;
import org.w3c.dom.Document;

import importacion.VODatosImportados;

public class InterfazEstadisticoImpl implements InterfazEstadistico {
	
	//Method scheme: instance estadistico of the correct type. Return method callback
	
	@Override
	public Integer librosUltimaSemana() {
		EstadisticoValoresEnBruto estadistico = new EstadisticoValoresEnBruto();
		return estadistico.librosUltimaSemana();
	}

	@Override
	public Integer librosUltimoMes() {
		EstadisticoValoresEnBruto estadistico = new EstadisticoValoresEnBruto();
		return estadistico.librosUltimoMes();
	}

	@Override
	public Integer librosUltimoAno() {
		EstadisticoValoresEnBruto estadistico = new EstadisticoValoresEnBruto();
		return estadistico.librosUltimoAno();
	}

	@Override
	public Float mediaDiariaDeLibrosUltimoMes() {
		EstadisticoCalculoMedias estadistico = new EstadisticoCalculoMedias();
		return estadistico.mediaDiariaDeLibrosUltimoMes();
	}

	@Override
	public Float mediaSemanalDeLibrosUltimoAno() {
		EstadisticoCalculoMedias estadistico = new EstadisticoCalculoMedias();
		return estadistico.mediaSemanalDeLibrosUltimoAno();
	}

	@Override
	public Document histogramaComprasDiariasUltimoMes() {
		EstadisticoCalculoHistogramas estadistico = new EstadisticoCalculoHistogramas();
		return estadistico.histogramaComprasDiariasUltimoMes();
	}

	@Override
	public Document histogramaComprasSemanalesUltimoAno() {
		EstadisticoCalculoHistogramas estadistico = new EstadisticoCalculoHistogramas();
		return estadistico.histogramaComprasSemanalesUltimoAno();
	}

	@Override
	public Float porcentajeDeLibrosEnUnDiaSobreElMes(Date dia) {
		EstadisticoCalculoPorcentajes estadistico = new EstadisticoCalculoPorcentajes();
		return estadistico.porcentajeDeLibrosEnUnDiaSobreElMes(dia);
	}

	@Override
	public Float porcentajeDeLibrosEnUnaSemanaSobreElAno(Date semana) {
		EstadisticoCalculoPorcentajes estadistico = new EstadisticoCalculoPorcentajes();
		return estadistico.porcentajeDeLibrosEnUnaSemanaSobreElAno(semana);
	}

	@Override
	public Integer compararEstadisticos(VODatosImportados di) {
		ComparacionEstadisticos comparador = new ComparacionEstadisticos();
		return comparador.comprararEstadisticos(di);
	}

}
