package Dominio;

import java.sql.*;
import java.util.*;
import Persistencia.*;

public class GestorTareas {
	private ArrayList<Tarea> tareas;
	private Agente agente;
	public GestorTareas(Agente agente)throws Exception{
		this.agente=agente;
		this.tareas=new ArrayList<Tarea>();
		ResultSet rs=agente.select("SELECT * FROM tarea");
		while(rs.next()) {
			tareas.add(new Tarea(rs.getString(1),rs.getString(2),rs.getTime(3),rs.getTime(4),rs.getString(5)));
		}
	}
	
	public ArrayList<Tarea> ObtenerAsignacionAProyecto(String proyecto){
		ArrayList<Tarea> tareas=new ArrayList<Tarea>();
		Tarea x;
		for(int i=0;i<this.tareas.size();i++) {
			x=this.tareas.get(i);
			if(x.getProyecto().equals(proyecto)) {
				tareas.add(x);
			}
		}
		return tareas;
	}
	
	public boolean AnadirTarea(Tarea tar) throws SQLException, Exception {
		if(agente.insert("INSERT INTO tarea VALUES ( '"+tar.getProyecto() +"','"+tar.getNombre()+"','"+tar.getFecha_ini()+"','" +tar.getFecha_fin()+"','"+tar.getPrioridad()+ "');")!=1) return false;
		tareas.add(tar);
		return true;
	}
	
}
