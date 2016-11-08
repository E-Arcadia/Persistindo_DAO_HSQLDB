package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	private String usuario = "SA";
	private String senha = "";
	private String PathBase = "C:\\Users\\978907\\workspace\\Persistencia\\base\\carros";
	private final String URL = "jdbc:hsqldb:file:" + PathBase + ";shutdown=true;hsqldb.write_delay=false; ";

	
	
	public Connection getConexao(){
		
		try {
			Class.forName(DRIVER_CLASS);
			return DriverManager.getConnection(URL, usuario, senha);
		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException - ");
			e.printStackTrace();
		}catch (SQLException e) {
			System.err.println("SQLException");
		}
		
		System.out.println("Conectou!!!");
		return null;
	}
}
