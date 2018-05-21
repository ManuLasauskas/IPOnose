package Dominio;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import Persistencia.*;

public class GestorUsuarios {
	private ArrayList<usuario> usuarios;
	private Agente agente;
	public GestorUsuarios(Agente agente) throws Exception,SQLException {
		this.agente=agente;
		this.usuarios=new ArrayList<usuario>();
		ResultSet rsu=agente.select("SELECT * FROM user");
		
		while(rsu.next()) {
			System.out.println(rsu.getString(7));
			usuarios.add(new usuario(rsu.getString(1),rsu.getString(2),rsu.getString(3),rsu.getString(4),rsu.getString(5),rsu.getString(6),rsu.getString(7),rsu.getString(8)));
		}
	}
	
	
	public usuario BuscarUsuario(String DNI){
			usuario user=null;
			for(int i=0;i<this.usuarios.size();i++) {
				user=this.usuarios.get(i);
				if(user.getUsuario().equals(DNI)) return user; 
			}
			return null;
	}
	public void marcarLog(usuario us) throws SQLException, Exception{
		System.out.println(us.getFechaString());
		agente.update("UPDATE user SET ult_conex='"+us.getFechaString()+"' WHERE usuario="+us.getUsuario());
	}
	
	public boolean AnadirUsuario(usuario usr) throws SQLException, Exception {
		SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String fecha = formato.format(usr.getUlt_conex());
		System.out.println(fecha);
		if(agente.insert("INSERT INTO user VALUES( '"+usr.getUsuario() +"','"+usr.getRol()+"','"+usr.getContrasena()+"','" +usr.getEmail()+"','" +usr.getDescripcion()+ "','"+fecha+"','"+usr.getNombre()+"','"+usr.getApellido()+"');")!=1) return false;
		System.out.println("AÑADIDO");
		this.usuarios.add(usr);
		return true;
	}
}
