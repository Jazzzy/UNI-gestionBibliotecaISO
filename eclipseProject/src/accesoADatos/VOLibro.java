package accesoADatos;

import java.util.ArrayList;
import java.util.Date;

public class VOLibro extends VOFondo {

	private String ISBN;
	private ArrayList<String> autores;
	private Date ano_edicion;
	private String editorial;

	public VOLibro(Integer id, String titulo, Date fecha_compra, String iSBN,
			ArrayList<String> autores, Date ano_edicion, String editorial) {
		super(id, titulo, fecha_compra);
		ISBN = iSBN;
		this.autores = autores;
		this.ano_edicion = ano_edicion;
		this.editorial = editorial;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public ArrayList<String> getAutores() {
		return autores;
	}

	public void setAutores(ArrayList<String> autores) {
		this.autores = autores;
	}

	public Date getAno_edicion() {
		return ano_edicion;
	}

	public void setAno_edicion(Date ano_edicion) {
		this.ano_edicion = ano_edicion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

}
