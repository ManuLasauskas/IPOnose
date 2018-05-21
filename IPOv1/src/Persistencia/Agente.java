package Persistencia;

import java.sql.*;

public class Agente {
	//instancia del agente
    protected static Agente mInstancia=null;
    //Conexion con la base de datos
    protected static Connection mBD;
	//Identificador ODBC de la base de datos
    private static String url="jdbc:ucanaccess://";
    //Driven para conectar con bases de datos Microsoft Access 
    private static String ruta="D:/Dropbox/IPO/Las ventanitas/src/Persistencia/bd.accdb";
    private static String ruta1="C:/Users/josel/Dropbox/IPO/Las ventanitas/src/Persistencia/bd.accdb";
    private static String ruta2 = "C:/Users/USUARIO/Dropbox/IPO/Las ventanitas/src/Persistencia/bd.accdb";
    
    //Constructor
    public Agente(String ruta)throws Exception {
    	conectar(ruta);
    }
    
 
    //Metodo para realizar la conexion a la base de datos 
    private void conectar(String ruta) throws Exception {
         mBD=DriverManager.getConnection(url+ruta);
    }

    
    //Metodo para desconectar de la base de datos
    public void desconectar() throws Exception{
    	mBD.close();
    }

    //Metodo para realizar una insercion en la base de datos
    public int insert(String SQL) throws SQLException, Exception{ 
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
    }
    
    //Metodo para realizar una eliminacion en la base de datos
    public int delete(String SQL) throws SQLException,Exception{
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
    }
    
    //Metodo para realizar una eliminacion en la base de datos
    public int update(String SQL) throws SQLException,Exception{
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
    }
    
    
	public ResultSet select(String SQL) throws SQLException,Exception{
		/*Metodo para realizar una busqueda o seleccion de informacion enla base de datos
	    *El m�todo select develve un vector de vectores, donde cada uno de los vectores
	    *que contiene el vector principal representa los registros que se recuperan de la base de datos.
	    */	
		PreparedStatement select = mBD.prepareStatement(SQL); // Se prepara la sentencia del select
		

	    ResultSet s = select.executeQuery(); // Ejecutamos la sentencia select 
	    
    	return s;
    	
	}
	
}
