package Persistencia;

import java.sql.*;
import java.util.*;
import java.util.Date;

import Dominio.*;

public class Agente {
	//instancia del agente    
    ArrayList<Usuario> Usuarios;
    
    ArrayList<Proyecto> Proyectos;
    
    ArrayList<String> ChatLog;
    
    //Constructor
    public Agente() {
    	Usuarios=new ArrayList<Usuario>();
    	Proyectos=new ArrayList<Proyecto>();
    	conectar();
    }
    
    private static Agente instancia;
    public static Agente getInstance() {
    	if (instancia==null) instancia=new Agente();
    	return instancia;
    }
    
 
    //Metodo para realizar la conexion a la base de datos 
    private void conectar(){
    	
    	InicializarDatos();

    }

    
    //Metodo para desconectar de la base de datos
    public void desconectar(){
    	Usuarios=null;
    	Proyectos=null;
    }
    
    public ArrayList<String> GetHistorialMensajes(){
    	return ChatLog;
    }
    
    public void ActualizarHistorialMensajes(String Mensaje) {
    	ChatLog.add(Mensaje);
    }

    //Metodo para realizar una insercion en la base de datos
    public int insertUsuario(Usuario usuario){ 
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
    
    public Usuario BuscarUsuario(String DNI){
		Usuario user=null;
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
    
	public ArrayList<Usuario> getUsuarios(){
		return Usuarios;
	}
	
	public ArrayList<Proyecto> getProyectos(){
		return Proyectos;
	}
	
	private void InicializarDatos() {
		Calendar init=Calendar.getInstance();
    	Calendar end = Calendar.getInstance();
    	
		init.set(2017, 6, 3, 12, 0, 0);
		end.set(2017, 12,28,15,0,0);
		Date rep = init.getTime();
		Date rep2=end.getTime();
		
		Usuario u1= new Usuario("03924938", "Programador", "1234", "joselu@joselu", "Ingeniero Tecnico", "Jose Luis","Mira Serrano");
		Usuario u2= new Usuario("05715980", "Lead Ingenier", "1234", "smoke@smoke", "Ingeniero Tecnico",  "Manuel","Garcia Diaz-Santos");

		Usuarios.add(u1);
		Usuarios.add(u2);
	
		
		Proyecto p1=new Proyecto("Computacion Cuantica",u2,rep,rep2,Estado.COMPLETADA,"Este proyecto tiene como objetivo incorporar la compuntación a la fisica cuántica");
		
		end.set(2017,10,1,15,0,0);
		p1.AnadirTarea(new Tarea("Prototipar modelo interaccion",init.getTime(),end.getTime(),Prioridad.MODERADA,Estado.COMPLETADA, u2,"Construccion del prototipo del modelo para seguir los pasos"));
		
		init.set(2017,10,2,9,0,0);
		end.set(2017,12,28,15,0,0);
		p1.AnadirTarea(new Tarea("Integracion en dispositivos",init.getTime(),end.getTime(),Prioridad.MODERADA, Estado.ACTIVA,u2,"Proceso de integrar el nuevo prototipo funcional dentro de dispositivos portatiles"));
		
		init.set(2018, 4,3,13,30,0);
		end.set(2020, 11,13,16,45,0);
		rep=init.getTime();
		rep2=end.getTime();
		Proyecto p2=new Proyecto("Seguridad Informatica",u2,rep,rep2,Estado.ACTIVA,"Tratamos de encontrar soluciones a los problemas de los hackers");
		
		init.set(2018,11,2,9,0,0);
		end.set(2018,12,28,14,0,0);
		p2.AnadirTarea(new Tarea("Encontrar al ladron",init.getTime(),end.getTime(),Prioridad.BAJA, Estado.TARDÍA,u1,"Rastrear todas las pistas que el ladrón ha dejado"));
		
		init.set(2018,6,2,9,0,0);
		end.set(2018,9,28,14,0,0);
		p2.AnadirTarea(new Tarea("Diseño nuevo firewall",init.getTime(),end.getTime(),Prioridad.MODERADA, Estado.ACTIVA,u1,"Construcción del nuevo firewall especializado en ladrones de diamantes"));
		
		init.set(2018,9,2,9,0,0);
		end.set(2018,11,28,14,0,0);
		p2.AnadirTarea(new Tarea("Revision modelo de comunicacion",init.getTime(),end.getTime(),Prioridad.ALTA, Estado.COMPLETADA,u2,"No hay más que hablar señoria"));
		
		Proyectos.add(p1);
		Proyectos.add(p2);
	}
	
}
