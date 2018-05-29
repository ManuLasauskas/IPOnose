package Dominio;

import java.util.*;

public class Proyecto {
	private String nombre;
	private usuario usuario;
	private ArrayList<Tarea> tareas;
	private ArrayList<usuario> asociados;
	
	public Proyecto(String nombre, usuario usuario) {
		this.nombre = nombre;
		this.usuario=usuario;
		this.tareas=new ArrayList<Tarea>();
		this.asociados=new ArrayList<usuario>();
		
	}
	
	public Proyecto(String nombre, usuario usuario,ArrayList<Tarea> tareas) {
		this.nombre = nombre;
		this.usuario=usuario;
		this.tareas=tareas;
		this.asociados=new ArrayList<usuario>();
		
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
	
	public usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(usuario usuario) {
		this.usuario=usuario;
	}
	
	public void setAsociados(ArrayList<usuario> asociados) {
		this.asociados=asociados;
	}
	
	public void AnadirTarea(Tarea tar) {
		tareas.add(tar);
	}
	
	public void AnadirAsociado(usuario asociado) {
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
}
