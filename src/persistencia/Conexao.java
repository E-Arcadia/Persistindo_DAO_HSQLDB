package persistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class Conexao {
    private Properties properties = new Properties();

    public void loadProperties() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("conf.properties"),StandardCharsets.UTF_8)){
           	properties.load(bufferedReader);
        } catch (IOException e) {
        	System.err.println("Arquivo conf.properties não encontrado");
        }
    }

  	public Connection getConexao(){
		loadProperties();
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
