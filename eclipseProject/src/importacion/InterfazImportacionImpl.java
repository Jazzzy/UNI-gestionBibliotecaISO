package importacion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import accesoADatos.DAOFondo;
import accesoADatos.FactoriaDAO;
import accesoADatos.VOFondo;
import accesoADatos.VOLibro;

public class InterfazImportacionImpl implements InterfazImportacion {

	@Override
	public Integer importarDesdeCSV(String ruta) {

		VODatosImportados importacion;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "; ";

		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");

		try {
			String titulo, fecha_compra, ISBN, autores, ano_edicion, editorial, tipo;
			ArrayList<String> autoresaux = new ArrayList<>();
			ArrayList<VOFondo> fondos = new ArrayList<>();

			VOLibro libroaux;
			br = new BufferedReader(new FileReader(ruta));

			while ((line = br.readLine()) != null) {

				String[] frags = line.split(cvsSplitBy);

				tipo = frags[0];
				fecha_compra = frags[1];
				ISBN = frags[2];
				titulo = frags[3];
				autores = frags[4];
				ano_edicion = frags[5];
				editorial = frags[6];

				if (tipo.equals("L")) {

					String[] autores_split = autores.split("%");

					autoresaux.clear();
					for (String a : autores_split) {
						autoresaux.add(a);
					}

					libroaux = new VOLibro(null, titulo, formatter.parse(fecha_compra), ISBN, autoresaux,
							formatter.parse(ano_edicion), editorial);

					fondos.add((VOFondo) libroaux);
				}

			}

			br.close();

			importacion = new VODatosImportados(fondos);

			FactoriaDAO f = FactoriaDAO.newFactoria();
			DAOFondo u = f.crearDAOFondo();
			
			for (VOFondo fondo : importacion.getFondos()) {
				Integer error = u.anadirLibro((VOLibro) fondo);
				if (error < 0) {
					return new Integer(-1);
				}
			}

			return new Integer(0);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Integer(-1);
	}

}
