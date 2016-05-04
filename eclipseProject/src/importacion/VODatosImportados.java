package importacion;

import java.util.ArrayList;

import org.w3c.dom.Document;

import accesoADatos.VOFondo;
import accesoADatos.VOLibro;

public class VODatosImportados {

	ArrayList<VOFondo> fondos;
	Integer librosUltimaSemana;
	Integer librosUltimoMes;
	Integer librosUltimoAno;
	Integer mediaDiariaDeLibrosUltimoMes;
	Integer mediaSemanalDeLibrosUltimoAno;
	Document histogramaComprasDiariasUltimoMes;
	Document histogramaComprasSemanalesUltimoAno;
	Float porcentajeDeLibrosEnUnDiaSobreElMes;
	Float porcentajeDeLibrosEnUnaSemanaSobreElAno;

	public VODatosImportados(ArrayList<VOFondo> fondos) {
		super();
		this.fondos = fondos;
	}

	public VODatosImportados(ArrayList<VOFondo> fondos, Integer librosUltimaSemana, Integer librosUltimoMes,
			Integer librosUltimoAno, Integer mediaDiariaDeLibrosUltimoMes, Integer mediaSemanalDeLibrosUltimoAno,
			Document histogramaComprasDiariasUltimoMes, Document histogramaComprasSemanalesUltimoAno,
			Float porcentajeDeLibrosEnUnDiaSobreElMes, Float porcentajeDeLibrosEnUnaSemanaSobreElAno) {
		super();
		this.fondos = fondos;
		this.librosUltimaSemana = librosUltimaSemana;
		this.librosUltimoMes = librosUltimoMes;
		this.librosUltimoAno = librosUltimoAno;
		this.mediaDiariaDeLibrosUltimoMes = mediaDiariaDeLibrosUltimoMes;
		this.mediaSemanalDeLibrosUltimoAno = mediaSemanalDeLibrosUltimoAno;
		this.histogramaComprasDiariasUltimoMes = histogramaComprasDiariasUltimoMes;
		this.histogramaComprasSemanalesUltimoAno = histogramaComprasSemanalesUltimoAno;
		this.porcentajeDeLibrosEnUnDiaSobreElMes = porcentajeDeLibrosEnUnDiaSobreElMes;
		this.porcentajeDeLibrosEnUnaSemanaSobreElAno = porcentajeDeLibrosEnUnaSemanaSobreElAno;
	}

	public ArrayList<VOFondo> getFondos() {
		return fondos;
	}

	public void setFondos(ArrayList<VOFondo> fondos) {
		this.fondos = fondos;
	}

	public Integer getLibrosUltimaSemana() {
		return librosUltimaSemana;
	}

	public void setLibrosUltimaSemana(Integer librosUltimaSemana) {
		this.librosUltimaSemana = librosUltimaSemana;
	}

	public Integer getLibrosUltimoMes() {
		return librosUltimoMes;
	}

	public void setLibrosUltimoMes(Integer librosUltimoMes) {
		this.librosUltimoMes = librosUltimoMes;
	}

	public Integer getLibrosUltimoAno() {
		return librosUltimoAno;
	}

	public void setLibrosUltimoAno(Integer librosUltimoAno) {
		this.librosUltimoAno = librosUltimoAno;
	}

	public Integer getMediaDiariaDeLibrosUltimoMes() {
		return mediaDiariaDeLibrosUltimoMes;
	}

	public void setMediaDiariaDeLibrosUltimoMes(Integer mediaDiariaDeLibrosUltimoMes) {
		this.mediaDiariaDeLibrosUltimoMes = mediaDiariaDeLibrosUltimoMes;
	}

	public Integer getMediaSemanalDeLibrosUltimoAno() {
		return mediaSemanalDeLibrosUltimoAno;
	}

	public void setMediaSemanalDeLibrosUltimoAno(Integer mediaSemanalDeLibrosUltimoAno) {
		this.mediaSemanalDeLibrosUltimoAno = mediaSemanalDeLibrosUltimoAno;
	}

	public Document getHistogramaComprasDiariasUltimoMes() {
		return histogramaComprasDiariasUltimoMes;
	}

	public void setHistogramaComprasDiariasUltimoMes(Document histogramaComprasDiariasUltimoMes) {
		this.histogramaComprasDiariasUltimoMes = histogramaComprasDiariasUltimoMes;
	}

	public Document getHistogramaComprasSemanalesUltimoAno() {
		return histogramaComprasSemanalesUltimoAno;
	}

	public void setHistogramaComprasSemanalesUltimoAno(Document histogramaComprasSemanalesUltimoAno) {
		this.histogramaComprasSemanalesUltimoAno = histogramaComprasSemanalesUltimoAno;
	}

	public Float getPorcentajeDeLibrosEnUnDiaSobreElMes() {
		return porcentajeDeLibrosEnUnDiaSobreElMes;
	}

	public void setPorcentajeDeLibrosEnUnDiaSobreElMes(Float porcentajeDeLibrosEnUnDiaSobreElMes) {
		this.porcentajeDeLibrosEnUnDiaSobreElMes = porcentajeDeLibrosEnUnDiaSobreElMes;
	}

	public Float getPorcentajeDeLibrosEnUnaSemanaSobreElAno() {
		return porcentajeDeLibrosEnUnaSemanaSobreElAno;
	}

	public void setPorcentajeDeLibrosEnUnaSemanaSobreElAno(Float porcentajeDeLibrosEnUnaSemanaSobreElAno) {
		this.porcentajeDeLibrosEnUnaSemanaSobreElAno = porcentajeDeLibrosEnUnaSemanaSobreElAno;
	}

}
