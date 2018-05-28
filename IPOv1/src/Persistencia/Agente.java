package Persistencia;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.*;

public class Agente {
	//instancia del agente
    protected static Agente mInstancia=null;
    //Conexion con la base de datos
    protected static Connection mBD;
    protected static java.io.File dbFile;
    
    //Constructor
    public Agente()throws Exception {
    	conectar();
    }
   
    
 
    //Metodo para realizar la conexion a la base de datos 
    private void conectar() throws Exception {
    	dbFile = java.io.File.createTempFile("tempdb", ".accdb");
    	dbFile.deleteOnExit();
    	java.nio.file.Files.copy(
    			Agente.class.getResourceAsStream("/Resources/bd.accdb"), 
    	        dbFile.toPath(), 
    	        java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    	String connStr = String.format(
    	        "jdbc:ucanaccess://%s;immediatelyReleaseResources=true", 
    	        dbFile.getAbsolutePath());
         mBD=DriverManager.getConnection(connStr);
    }

    
    //Metodo para desconectar de la base de datos
    public void desconectar() throws Exception{
    	Writer fw = new FileWriter(Agente.class.getResource("Resources/bd.accdb").toString());
    	java.nio.file.Files.copy(dbFile.toPath(), Paths.get(Agente.class.getResource("/Resources/bd.accdb").toURI()),java.nio.file.StandardCopyOption.REPLACE_EXISTING);
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
