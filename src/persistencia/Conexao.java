package persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class Conexao {
	InputStreamReader inputStreamReader = null;

    private static Properties properties = new Properties();
    

    public void load() {
        try {
        	
        	inputStreamReader = new InputStreamReader(new FileInputStream(new File("conf.properties")), "UTF-8");
            properties.load(inputStreamReader);
        } catch (IOException e) {
        	System.err.println("conf.properties not found");
        }
    }

  	public Connection getConexao(){
		load();
		try {
			Class.forName(properties.getProperty("DRIVER_CLASS"));
			String URL_BASE = properties.getProperty("URL") + properties.getProperty("BASE");
			return DriverManager.getConnection(URL_BASE, 
					properties.getProperty("USUARIO"), 
					properties.getProperty("SENHA"));
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException - ");
			e.printStackTrace();
		}catch (SQLException e) {
			System.err.println("SQLException");
			e.printStackTrace();
			
		}
		return null;
	}
}
