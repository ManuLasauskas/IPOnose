package Dominio;

import java.util.*;

public class Proyecto {
	private String nombre;
	private Date fecha_creacion;
	private Date fecha_fin;
	private Usuario usuario;
	private ArrayList<Tarea> tareas;
	private ArrayList<Usuario> asociados;
	private Estado estado;
	private String descripcion;
	
	public Proyecto(String nombre, Usuario usuario, Date fecha_creacion, Date fecha_fin,Estado estado, String descripcion) {
		this.nombre = nombre;
		this.usuario=usuario;
		this.tareas=new ArrayList<Tarea>();
		this.asociados=new ArrayList<Usuario>();
		this.asociados.add(usuario);
		this.descripcion=descripcion;
		this.fecha_creacion=fecha_creacion;
		this.fecha_fin=fecha_fin;
		this.estado=estado;
		
		
		
	}
	
	public Proyecto(String nombre, Usuario usuario,ArrayList<Tarea> tareas) {
		this.nombre = nombre;
		this.usuario=usuario;
		this.tareas=tareas;
		this.asociados=new ArrayList<Usuario>();
		
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	} 
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
	
	public void setAsociados(ArrayList<Usuario> asociados) {
		this.asociados=asociados;
	}
	
	public void AnadirTarea(Tarea tar) {
		tareas.add(tar);
	}
	
	public void AnadirAsociado(Usuario asociado) {
		asociados.add(asociado);
	}
	
	public boolean ComprobarTareaExistente(String nombre) {
		Tarea tar;
		for (int i=0;i<tareas.size();i++) {
			tar=tareas.get(i);
			if(tar.getNombre().equals(nombre)) return true;
		}
		return false;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}
	public Date getFechaCreacion() {
		return fecha_creacion;
	}
	public void setFechaCreacion(Date fecha_creacion) {
		this.fecha_creacion=fecha_creacion;
	}
	public Date getFechaFin() {
		return fecha_fin;
	}
	public void setFechaFin(Date fecha_fin) {
		this.fecha_fin=fecha_fin;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado=estado;
	}
}
