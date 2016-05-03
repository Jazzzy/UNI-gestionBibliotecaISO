package importacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import accesoADatos.VOLibro;

public class InterfazImportacionImpl implements InterfazImportacion {

	@Override
	public VODatosImportados importarDesdeCSV(String ruta) {

		VODatosImportados importacion;

		CsvReader libros_import;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");

		try {
			String titulo, fecha_compra, ISBN, autores, ano_edicion, editorial;
			ArrayList<String> autoresaux = new ArrayList<>();
			ArrayList<VOLibro> libros = new ArrayList<>();

			VOLibro libroaux;

			libros_import = new CsvReader(ruta);
			libros_import.readHeaders();

			while (libros_import.readRecord()) {

				titulo = libros_import.get(0);
				fecha_compra = libros_import.get(1);
				ISBN = libros_import.get(2);
				autores = libros_import.get(3);
				ano_edicion = libros_import.get(4);
				editorial = libros_import.get(5);

				String[] autores_split = autores.split("%");

				autoresaux.clear();
				for (String a : autores_split) {
					autoresaux.add(a);
				}

				libroaux = new VOLibro(null, titulo, formatter.parse(fecha_compra), ISBN, autoresaux,
						formatter.parse(ano_edicion), editorial);

				libros.add(libroaux);

			}

			libros_import.close();

			importacion = new VODatosImportados(libros);

			return importacion;

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

		return null;
	}

}
