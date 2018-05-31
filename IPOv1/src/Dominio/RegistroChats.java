package Dominio;
import java.util.*;

public class RegistroChats {

	private Usuario user;
	ArrayList<String> Chat;
	
	public RegistroChats(Usuario u) {
		user=u;
		Chat=new ArrayList<String>();
		
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public ArrayList<String> getChat(){
		return Chat;
	}
	
	public void AnadirMensaje(String Mensaje) {
		Chat.add(Mensaje);
	}
	
}
