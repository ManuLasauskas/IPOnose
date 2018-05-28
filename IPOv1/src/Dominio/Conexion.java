package Dominio;
import java.sql.SQLException;
import java.util.*;
import Persistencia.*;

public class Conexion {
	private GestorUsuarios gestor_usr;
	private GestorProyectos gestor_pry;
	private GestorTareas gestor_tar;
	private Agente agente;
	
	public Conexion() throws Exception {
		agente=new Agente();
		gestor_tar=new GestorTareas(agente);
		gestor_usr=new GestorUsuarios(agente);
		gestor_pry=new GestorProyectos(agente,gestor_usr,gestor_tar);
		
	}
	
	public boolean AnadirTarea(Proyecto proyect,String tarea,Date fecha_ini,Date fecha_fin,String prioridad) throws SQLException, Exception {
		if(!proyect.ComprobarTareaExistente(tarea)) {
			Tarea tar=new Tarea(proyect.getNombre(),tarea,fecha_ini,fecha_fin,prioridad);
			if(gestor_tar.AnadirTarea(tar)) {
				proyect.AnadirTarea(tar);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean AnadirProyecto(usuario user,String nombre,ArrayList<String> asociados) throws SQLException, Exception {
		if(gestor_pry.BuscarProyecto(nombre)==null) {
			Proyecto prc=new Proyecto(nombre,user);
			prc.setAsociados(asociados);
			if(gestor_pry.AnadirProyecto(prc)) {
				user.AnadirProyecto(prc);
				return true;
			}  
		}
		return false;
	}
	
	public usuario BuscarUsuario(String user){
		if (gestor_usr.BuscarUsuario(user)!=null){
			return gestor_usr.BuscarUsuario(user);
		}else System.out.println("Usuario no encotrado");
		return null;
	}
	public void marcarLog(usuario us) throws SQLException, Exception{
		gestor_usr.marcarLog(us);
	}
	public boolean RegistrarUsuario(String DNI, String rol, String contrasena,String email, String descripcion,String fecha,String nombre, String apellido) throws SQLException, Exception {
		if(gestor_usr.BuscarUsuario(DNI)==null) {
			return gestor_usr.AnadirUsuario(new usuario(DNI,rol,contrasena,email,descripcion,fecha,nombre,apellido));
		}
		return false;
	}
	
	public usuario loggin(String nombre,char[] contrasena) {
		usuario user=gestor_usr.BuscarUsuario(nombre);
		if((user!=null) && (String.valueOf(contrasena).equals(user.getContrasena()))) {
			return user;
		}
		return null;
	}
	
	/*public void CerrarSesion(usuario user) {
	gestor_usr.CerrarSesion(user);
	}*/
		
}
