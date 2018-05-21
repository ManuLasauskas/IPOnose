package Dominio;

import java.sql.*;
import java.util.*;
import Persistencia.*;

public class GestorProyectos {
	private ArrayList<Proyecto> proyectos;
	private Agente agente;
	public GestorProyectos(Agente agent,GestorUsuarios usergs, GestorTareas tareags) throws Exception{
		this.agente=agent;
		this.proyectos=new ArrayList<Proyecto>();
		ResultSet rs=agente.select("SELECT * FROM proyecto");
		while(rs.next()) {
			proyectos.add(new Proyecto(rs.getString(1), usergs.BuscarUsuario(rs.getString(2)),tareags.ObtenerAsignacionAProyecto(rs.getString(1))));
		}
		ResultSet rsa=agente.select("SELECT * FROM asociados");
		while(rsa.next()) {
			BuscarProyecto(rsa.getString(1)).AnadirAsociado(rsa.getString(2));
		}
	}
	
	public Proyecto BuscarProyecto(String nombre) {
		Proyecto proyect=null;
		for(int i=0;i<this.proyectos.size();i++) {
			proyect=this.proyectos.get(i);
			if(proyect.getNombre().equals(nombre)) return proyect; 
		}
		return null;
	}
	
	public boolean AnadirProyecto(Proyecto pry) throws SQLException, Exception {
		if(agente.insert("INSERT INTO proyecto VALUES ( '"+pry.getNombre() +"','"+pry.getUsuario().getUsuario()+"');")!=1) return false;
		return true;
		
	}
	
}
