package repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Prog_AEP.BilheteAereo;
import Prog_AEP.CriarConexao;

public class BilheteAereoRepositoryJDBC implements BilheteAereoRepository{ 
	
	public void inserir(BilheteAereo bilheteAereo) throws Exception {
		String sql = "insert into bilheteaereo (voo, origem, destino, data) values (?, ?, ?, ?)";
		
		PreparedStatement statement = CriarConexao.conexao().prepareStatement(sql);
		statement.setInt(1, bilheteAereo.getVoo());
		statement.setString(2, bilheteAereo.getOrigem());
		statement.setString(3, bilheteAereo.getDestino());
		statement.setDate(4, (java.sql.Date) bilheteAereo.getData());
		
		statement.execute();
		statement.close();
	}

	public List<BilheteAereo> obterTodos() throws Exception {
		List<BilheteAereo> bilhetes = new ArrayList<>();
		String sql = "select voo, origem, destino, data from bilheteaereo";
		Statement statement = CriarConexao.conexao().createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next())  {
			int voo = resultSet.getInt("voo");
			String origem = resultSet.getString("origem");
			String destino = resultSet.getString("destino");
			Date data = new java.util.Date(resultSet.getDate("data").getTime());
			BilheteAereo bilheteEncontrado = new BilheteAereo(voo, origem, destino, data);
			bilhetes.add(bilheteEncontrado);
		}
		resultSet.close();
		statement.close();
		
		return bilhetes;
	}

	public void alterar(BilheteAereo bilhete) throws Exception {
		String sql = "update bilheteaereo set origem = ?, destino = ?, data = ? where voo = ?";
		PreparedStatement statement = CriarConexao.conexao().prepareStatement(sql);
		statement.setString(1, bilhete.getOrigem());
		statement.setString(2, bilhete.getDestino());
		statement.setDate(3, (java.sql.Date) bilhete.getData());
		statement.setInt(4,bilhete.getVoo());
		
		statement.execute();
		statement.close();	
	}

	public void excluir(int id) throws Exception {
		String sql = "delete from bilheteaereo where voo = ?";
		PreparedStatement statement = CriarConexao.conexao().prepareStatement(sql);
		statement.setInt(1, id);
		statement.execute();
		statement.close();	
	}
	
}
