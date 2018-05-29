package Dominio;
import java.sql.SQLException;
import java.util.*;
import Persistencia.*;

public class Conexion {
	private GestorUsuarios gestor_usr;
	private GestorProyectos gestor_pry;
	private Agente agente;
	
	public Conexion(){
		agente=new Agente();
		gestor_usr=new GestorUsuarios(agente);
		gestor_pry=new GestorProyectos(agente);
		
	}
	
	public boolean AnadirTarea(Proyecto proyect,String tarea,Date fecha_ini,Date fecha_fin,String prioridad){
		if(!proyect.ComprobarTareaExistente(tarea)) {
			Tarea tar=new Tarea(tarea,fecha_ini,fecha_fin,prioridad);
			proyect.AnadirTarea(tar);
			return true;
		}
		return false;
	}
	
	public boolean AnadirProyecto(Usuario user,String nombre,String asociados) throws SQLException, Exception {
		if(gestor_pry.BuscarProyecto(nombre)==null) {
			Proyecto prc=new Proyecto(nombre,user);
			prc.AnadirAsociado(gestor_usr.BuscarUsuario(asociados));
			if(gestor_pry.AnadirProyecto(prc)) {
				user.AnadirProyecto(prc);
				return true;
			}  
		}
		return false;
	}
	
	public Usuario BuscarUsuario(String user){
		if (gestor_usr.BuscarUsuario(user)!=null){
			return gestor_usr.BuscarUsuario(user);
		}else System.out.println("Usuario no encotrado");
		return null;
	}
	public void marcarLog(Usuario us){
		gestor_usr.marcarLog(us);
	}
	public boolean RegistrarUsuario(String DNI, String rol, String contrasena,String email, String descripcion,String fecha,String nombre, String apellido){
		if(gestor_usr.BuscarUsuario(DNI)==null) {
			return gestor_usr.AnadirUsuario(new Usuario(DNI,rol,contrasena,email,descripcion,nombre,apellido));
		}
		return false;
	}
	
	public Usuario loggin(String nombre,char[] contrasena) {
		Usuario user=gestor_usr.BuscarUsuario(nombre);
		if(user!=null){
			System.out.println("Usuario encontrado");
			if (String.valueOf(contrasena).equals(user.getContrasena())) {
				System.out.println("Iniciado correctamente");
				return user;
			}
		} else System.out.println("Usuario no encontrado en la BBDD");
		
		return null;
	}
	
	/*public void CerrarSesion(usuario user) {
	gestor_usr.CerrarSesion(user);
	}*/
		
}
