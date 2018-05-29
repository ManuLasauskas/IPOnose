package Persistencia;

import java.sql.*;
import java.util.*;
import java.util.Date;

import Dominio.*;

public class Agente {
	//instancia del agente
    protected static Agente mInstancia=null;
    
    ArrayList<usuario> Usuarios;
    
    ArrayList<Proyecto> Proyectos;

    public static Agente getInstance() {
		if(mInstancia ==  null)
			mInstancia = new Agente();
		return mInstancia;
	}
    
    //Constructor
    public Agente() {
    	Usuarios=new ArrayList<usuario>();
    	Proyectos=new ArrayList<Proyecto>();
    	conectar();
    }
    
 
    //Metodo para realizar la conexion a la base de datos 
    private void conectar(){
    	
    	/// Usuarios
		usuario u1= new usuario("03924938B", "Programador", "1234", "joselu@joselu", "Ingeniero Tecnico", "Jose Luis","Mira Serrano");
		usuario u2= new usuario("03974938F", "Lead Ingenier", "1234", "smoke@smoke", "Ingeniero Tecnico",  "Manuel","Garcia Diaz-Santos");

		Usuarios.add(u1);
		Usuarios.add(u2);

		Proyecto p1=new Proyecto("Computacion Cuantica",u1);
		Proyecto p2=new Proyecto("Seguridad Informatica",u2);
					
		p1.AnadirTarea(new Tarea("Prototipar modelo interaccion",new Date(112,7,7,18,25,12),new Date(120,7,7,18,25,12),"Secundario"));
		p2.AnadirTarea(new Tarea("Encontrar al ladron",new Date(118,7,7,18,25,12),new Date(119,7,7,18,25,12),"Primario"));
		
		p1.AnadirAsociado(u2);
		p2.AnadirAsociado(u1);
		
		Proyectos.add(p1);
		Proyectos.add(p2);
    }

    
    //Metodo para desconectar de la base de datos
    public void desconectar(){
    	Usuarios=null;
    	Proyectos=null;
    	mInstancia=null;
    }

    //Metodo para realizar una insercion en la base de datos
    public int insertUsuario(usuario usuario){ 
    	Usuarios.add(usuario);
    	return 1;
    }
    
    public int insertProyecto(Proyecto p) {
    	Proyectos.add(p);
    	return 1;
    }
    
    //Metodo para realizar una eliminacion en la base de datos
    public int deleteProyecto(String nombre){
    	
    	for(int i=0;i<Proyectos.size();i++) {
    		if(Proyectos.get(i).getNombre().equals(nombre)) {
    			Proyectos.remove(i);
    			return 1;
    			
    		}
    	}
    	
    	return 0;
    }
    
    public int deleteUsuario(String nombre){
    	
    	for(int i=0;i<Usuarios.size();i++) {
    		if(Usuarios.get(i).getNombre().equals(nombre)) {
    			Usuarios.remove(i);
    			return 1;
    			
    		}
    	}
    	
    	return 0;
    }
    
    public usuario BuscarUsuario(String DNI){
		usuario user=null;
		for(int i=0;i<Usuarios.size();i++) {
			user=Usuarios.get(i);
			if(user.getUsuario().equals(DNI)) return user; 
		}
		return null;
    }
    
    public Proyecto BuscarProyecto(String nombre) {
		Proyecto proyect=null;
		for(int i=0;i<Proyectos.size();i++) {
			proyect=Proyectos.get(i);
			if(proyect.getNombre().equals(nombre)) return proyect; 
		}
		return null;
	}
    
	public ArrayList<usuario> getUsuarios(){
		return Usuarios;
	}
	
	public ArrayList<Proyecto> getProyectos(){
		return Proyectos;
	}
	
}
