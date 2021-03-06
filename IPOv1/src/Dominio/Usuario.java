package Dominio;

import java.awt.Image;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.ImageIcon;

import Persistencia.Agente;

public class Usuario {

	private String usuario;
	private String rol;
	private String contrasena;
	private String email;
	private String descripcion;
	private String nombre;
	private String apellido;
	private Date ult_conex;
	private Image Img;
	private ArrayList<RegistroChats> RegistroChats;
	private ArrayList<Proyecto> proyectos;
	private DateFormat fm= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Agente ag;

	
	public Usuario(String usuario, String rol, String contrasena, String email, String descripcion, String nombre, String apellido,Image ImgRoute) {
		this.usuario = usuario;
		this.rol = rol;
		this.contrasena = contrasena;
		this.email = email;
		this.descripcion = descripcion;
		marcarlog();
		this.proyectos=new ArrayList<Proyecto>();
		this.nombre=nombre;
		this.apellido=apellido;
		this.RegistroChats=new ArrayList<RegistroChats>();
		Img=ImgRoute;
	}	
	public String getUsuario() {
		return usuario;
	}
	
	public Image getImage() {
		return Img;
	}
	
	public void setImage(Image Image) {
		Img=Image;
	}

	public void EliminarProyecto(String p) {
		for(int i=0;i<proyectos.size();i++) {
			if(proyectos.get(i).getNombre().equals(p)) {
				proyectos.remove(i);
				//Agente.getInstance().deleteProyecto(p);
				break;
			}
		}
	}
	
	public void InicializarRegistro(ArrayList<Usuario> usuarios) {

		for(int i=0;i<usuarios.size();i++) {
			if(!usuarios.get(i).getUsuario().equals(usuario)) {
				RegistroChats.add(new RegistroChats(usuarios.get(i)));
			}
		}
	}
	
	public ArrayList<Usuario> getUsuariosParaChatear(){
		ArrayList<Usuario> x=new ArrayList<Usuario>();
		for(int i=0;i<RegistroChats.size();i++) {
			x.add(RegistroChats.get(i).getUser());
		}
		
		return x;
	}
	
	public ArrayList<String> getUserChat(Usuario user){
		ArrayList<String> ChatLog=null;
		for(int i=0;i<RegistroChats.size();i++) {
			if(RegistroChats.get(i).getUser().getUsuario().equals(user.getUsuario())) {
				ChatLog=RegistroChats.get(i).getChat();
				break;
			}
		}
		return ChatLog;
	}
	
	public void ActualizarChat(Usuario user,String Mensaje) {
		for(int i=0;i<RegistroChats.size();i++) {
			if(RegistroChats.get(i).getUser().getUsuario().equals(user.getUsuario())) {
				RegistroChats.get(i).AnadirMensaje(Mensaje);
				break;
			}
		}
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getUlt_conex() {
		return ult_conex;
	}
	public void setUlt_conex(Date ult_conex) {
		this.ult_conex = ult_conex;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	
	public ArrayList<Proyecto> getproyectos() {
		return proyectos;
	}
	public void setproyectos(ArrayList<Proyecto> proyectos) {
		this.proyectos=proyectos;
	}
	
	public void AnadirProyecto(Proyecto proyecto) {
		this.proyectos.add(proyecto);
		//Agente.getInstance().insertProyecto(proyecto);
	}
	
	public void marcarlog() {
			ult_conex = Calendar.getInstance().getTime();
	}
	public String getFechaString(){
		return fm.format(ult_conex);
	}
}
