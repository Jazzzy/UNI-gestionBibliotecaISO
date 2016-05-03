package accesoADatos;

import java.util.Date;

public class VOFondo {

	private Integer id;
	private String titulo;
	private Date fecha_compra;
	private Integer ejemplares;

	public VOFondo(Integer id, String titulo, Date fecha_compra, Integer ejemplares) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fecha_compra = fecha_compra;
		this.ejemplares = ejemplares;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha_compra() {
		return fecha_compra;
	}

	public void setFecha_compra(Date fecha_compra) {
		this.fecha_compra = fecha_compra;
	}

	public Integer getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Integer ejemplares) {
		this.ejemplares = ejemplares;
	}

}
