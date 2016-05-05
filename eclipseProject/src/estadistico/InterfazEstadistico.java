package estadistico;
import java.util.Date;
import org.w3c.dom.Document;
import importacion.VODatosImportados;

public interface InterfazEstadistico {
	public Integer librosUltimaSemana();
	public Integer librosUltimoMes();
	public Integer librosUltimoAno();
	public Float mediaDiariaDeLibrosUltimoMes();
	public Float mediaSemanalDeLibrosUltimoAno();
	public Document histogramaComprasDiariasUltimoMes();
	public Document histogramaComprasSemanalesUltimoAno();
	public Float porcentajeDeLibrosEnUnDiaSobreElMes(Date dia);
	public Float porcentajeDeLibrosEnUnaSemanaSobreElAno(Date semana);
	public Integer compararEstadisticos(VODatosImportados di);
}
