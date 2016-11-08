package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidade.Automovel;
import persistencia.Conexao;

public class AutomovelDAO {
	private String INSERE_AUTOMOVEL = "INSERT INTO AUTOMOVEIS(PLACA,ANO) VALUES (?,?)";
	private String SELECIONAR_AUTOMOVEL = "SELECT * FROM AUTOMOVEIS";

	
	public void inserir(Automovel automovel) {
		try (Connection con = new Conexao().getConexao();
				PreparedStatement preparedStatement = con.prepareStatement(INSERE_AUTOMOVEL);) {
			preparedStatement.setString(1, automovel.getPlaca());
			preparedStatement.setString(2, automovel.getAno());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Automovel> listar() {
		ArrayList<Automovel> lista = new ArrayList<>();
		
		try (Connection con = new Conexao().getConexao();
				PreparedStatement preparedStatement = con.prepareStatement(SELECIONAR_AUTOMOVEL);) {
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Automovel automovel = new Automovel();
				automovel.setId(resultSet.getInt("ID"));
				automovel.setPlaca(resultSet.getString("PLACA"));
				automovel.setAno(resultSet.getString("ANO"));
				lista.add(automovel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

}
