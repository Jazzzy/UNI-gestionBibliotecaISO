package controlador;

import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import estadistico.InterfazEstadistico;
import estadistico.InterfazEstadisticoImpl;

public class HelperMostrarEstadisticas implements Helper {

	Integer opcion; // Para seleccionar entre valores brutos, porcentajes e histogramas
	Integer opcion2; // Para seleccionar entre las distintas opciones dentro del anterior
	Date fecha;

	public HelperMostrarEstadisticas(Integer opcion, Integer opcion2) {
		super();
		this.opcion = opcion;
		this.opcion2 = opcion2;
	}
	
	public HelperMostrarEstadisticas(Integer opcion, Integer opcion2, Date fecha) {
		super();
		this.opcion = opcion;
		this.opcion2 = opcion2;
		this.fecha = fecha;
	}
	
	

	@Override
	public Document ejecutar() {

		InterfazEstadistico ie = new InterfazEstadisticoImpl();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		switch (opcion) {

		case 0: // Valores bruto
			Integer valorBruto = null;

			try {
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.newDocument();
				Element aux = null;

				if (opcion2 == 0) {
					aux = doc.createElement("librosUltimaSemana");
					valorBruto = ie.librosUltimaSemana();

				} else if (opcion2 == 1) {
					aux = doc.createElement("librosUltimoMes");
					valorBruto = ie.librosUltimoMes();

				} else if (opcion2 == 2) {
					aux = doc.createElement("librosUltimoAño");
					valorBruto = ie.librosUltimoAno();
				}
				aux.appendChild(doc.createTextNode(valorBruto.toString()));
				doc.appendChild(aux);
				
				return doc;

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;

		case 1: // Medias

			Float media = null;

			try {
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.newDocument();
				Element aux = null;

				if (opcion2 == 0) {
					aux = doc.createElement("mediaDiariaDeLibrosUltimoMes");
					media = ie.mediaDiariaDeLibrosUltimoMes();

				} else if (opcion2 == 1) {
					aux = doc.createElement("mediaSemanalDeLibrosUltimoAno");
					media = ie.mediaSemanalDeLibrosUltimoAno();
				}

				aux.appendChild(doc.createTextNode(media.toString()));
				doc.appendChild(aux);
				
				return doc;

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;

		case 2: // Porcentajes
			
			Float porcentaje = null;

			try {
				dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.newDocument();
				Element aux = null;

				if (opcion2 == 0) {
					aux = doc.createElement("porcentajeDeLibrosEnUnDiaSobreElMes");
					porcentaje = ie.porcentajeDeLibrosEnUnDiaSobreElMes(fecha);

				} else if (opcion2 == 1) {
					aux = doc.createElement("porcentajeDeLibrosEnUnaSemanaSobreElAno");
					porcentaje = ie.porcentajeDeLibrosEnUnaSemanaSobreElAno(fecha);
				}

				aux.appendChild(doc.createTextNode(porcentaje.toString()));
				doc.appendChild(aux);
				
				return doc;

			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;

		case 3: // Histogramas
			Document histograma = null;
			if (opcion2 == 0) {
				histograma = ie.histogramaComprasDiariasUltimoMes();
			} else if (opcion2 == 1) {
				histograma = ie.histogramaComprasSemanalesUltimoAno();
			}
			return histograma;

		default:
			return null;

		}
	}

}
