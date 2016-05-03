package accesoADatos;

import java.util.Date;

public class VOPrestamo {

	private Integer id;
	private Date fecha_inicio;
	private Date fecha_fin;
	private VOUsuario usuario;
	private VOFondo fondo;
	
	public VOPrestamo(Integer id, Date fecha_inicio, Date fecha_fin, VOUsuario usuario, VOFondo fondo) {
		super();
		this.id = id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.usuario = usuario;
		this.fondo = fondo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public VOUsuario getUsuario() {
		return usuario;
	}
	public void setUsuario(VOUsuario usuario) {
		this.usuario = usuario;
	}
	public VOFondo getFondo() {
		return fondo;
	}
	public void setFondo(VOFondo fondo) {
		this.fondo = fondo;
	}
	
	
	
}
