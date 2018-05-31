package Dominio;

import java.text.SimpleDateFormat;
import java.util.*;

public class Tarea {
	private String nombre;
	private Date fecha_ini;
	private Date fecha_fin;
	private Prioridad prioridad;
	private Estado estado;
	private Usuario responsable;
	private SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
	private String descripcion;

	
	public Tarea( String nombre, Date fecha_ini, Date fecha_fin, Prioridad prioridad, Estado estado, Usuario responsable, String descripcion) {
		this.nombre = nombre;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.prioridad = prioridad;
		this.estado=estado;
		this.responsable=responsable;
		this.descripcion=descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}
	public String getFechaInicioString() {
		return format.format(fecha_ini);
	}
	public String getFechaFinString() {
		return format.format(fecha_fin);
	}
	public void setEstado(Estado estado) {
		this.estado=estado;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setResponsable(Usuario responsable) {
		this.responsable=responsable;
	}
	public Usuario getResponsable() {
		return responsable;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
}
