package Dominio;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import Persistencia.*;

public class GestorUsuarios {
	private Agente agente;
	public GestorUsuarios(Agente agente){
		this.agente=agente;
	}
	
	
	public usuario BuscarUsuario(String DNI){
			return agente.BuscarUsuario(DNI);
	}
	
	
	
	public boolean AnadirUsuario(usuario usr){
		agente.insertUsuario(usr);
		return true;
	}
}
