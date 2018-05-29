package Dominio;

import java.sql.*;
import java.util.*;
import Persistencia.*;

public class GestorProyectos {
	private Agente agente;
	public GestorProyectos(Agente agent) {
		this.agente=agent;
	}
	
	public Proyecto BuscarProyecto(String nombre) {
		return agente.BuscarProyecto(nombre);
	}
	
	public boolean AnadirProyecto(Proyecto pry){
		agente.insertProyecto(pry);
		return true;
		
	}
	
}
