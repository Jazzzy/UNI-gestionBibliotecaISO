package estadistico;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class EstadisticoCalculoHistogramas extends Estadistico {
	public Document histogramaComprasDiariasUltimoMes() {
		try {
			//Generar instancia del documento
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			//Introduccion del esqueleto y los metadatos del histograma
			Element elementoRaiz = doc.createElement("histogram");
	        doc.appendChild(elementoRaiz);
	        Element titulo = doc.createElement("title");
	        Element leyenda_hor = doc.createElement("xtitle");
	        Element leyenda_ver = doc.createElement("ytitle");
	        elementoRaiz.appendChild(titulo);
	        elementoRaiz.appendChild(leyenda_hor);
	        elementoRaiz.appendChild(leyenda_ver);
	        titulo.appendChild(doc.createTextNode("Compras diarias del ultimo mes."));
	        leyenda_hor.appendChild(doc.createTextNode("Dias"));
	        leyenda_ver.appendChild(doc.createTextNode("Fondos comprados."));
	        Element valores = doc.createElement("values");
	        elementoRaiz.appendChild(valores);
	        
	        //Obtencion de valores
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Calendar calendario = Calendar.getInstance();
	        calendario.add(Calendar.DAY_OF_MONTH, -30);
	        Date fecha = calendario.getTime();
	        for(int i=0;i<30;i++){
	        	int cantidad = this.accesoDatos.getFondosByFechas(fecha, fecha).size();
	        	Element registro = doc.createElement("registry");
	        	valores.appendChild(registro);
	        	Element quantity = doc.createElement("quantity");
	        	Element date = doc.createElement("date");
	        	registro.appendChild(quantity);
	        	registro.appendChild(date);
	        	quantity.appendChild(doc.createTextNode(Integer.toString(cantidad)));
	        	date.appendChild(doc.createTextNode(dateFormat.format(fecha)));
	        	calendario.add(Calendar.DAY_OF_MONTH, 1);
	        }
			return doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Document histogramaComprasSemanalesUltimoAno() {
		try {
			//Generar instancia del documento
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			
			//Introduccion del esqueleto y los metadatos del histograma
			Element elementoRaiz = doc.createElement("histogram");
	        doc.appendChild(elementoRaiz);
	        Element titulo = doc.createElement("title");
	        Element leyenda_hor = doc.createElement("xtitle");
	        Element leyenda_ver = doc.createElement("ytitle");
	        elementoRaiz.appendChild(titulo);
	        elementoRaiz.appendChild(leyenda_hor);
	        elementoRaiz.appendChild(leyenda_ver);
	        titulo.appendChild(doc.createTextNode("Compras semanales del ultimo año."));
	        leyenda_hor.appendChild(doc.createTextNode("Semanas"));
	        leyenda_ver.appendChild(doc.createTextNode("Fondos comprados."));
	        Element valores = doc.createElement("values");
	        elementoRaiz.appendChild(valores);
	        
	        //Obtencion de valores
	        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        Calendar calendario = Calendar.getInstance();
	        Calendar calendario_aux = Calendar.getInstance();
	        calendario.add(Calendar.DAY_OF_YEAR, -1);
	        //Calendario auxiliar para la fecha del ultimo dia de la semana
	        calendario_aux.add(Calendar.DAY_OF_YEAR, -1);
	        calendario_aux.add(Calendar.DAY_OF_MONTH, 6);
	        Integer semanas = calendario.getWeeksInWeekYear();
	        Date fecha = calendario.getTime();
	        Date fecha_fin = calendario_aux.getTime();
	        for(int i=0;i<semanas;i++){
	        	int cantidad = this.accesoDatos.getFondosByFechas(fecha, fecha_fin).size();
	        	Element registro = doc.createElement("registry");
	        	valores.appendChild(registro);
	        	Element quantity = doc.createElement("quantity");
	        	Element date = doc.createElement("date");
	        	registro.appendChild(quantity);
	        	registro.appendChild(date);
	        	quantity.appendChild(doc.createTextNode(Integer.toString(cantidad)));
	        	date.appendChild(doc.createTextNode(dateFormat.format(fecha)));
	        	calendario.add(Calendar.WEEK_OF_YEAR, 1);
	        	calendario_aux.add(Calendar.WEEK_OF_YEAR, 1);
	        }
			return doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
	}
}
