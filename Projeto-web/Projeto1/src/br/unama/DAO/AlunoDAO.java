package br.unama.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import br.unama.modelo.Aluno;

public class AlunoDAO {
	
	private DataSource datasource;
	private List<Aluno> listaAlunos;
	
	public AlunoDAO() {
		
	}
	
	public AlunoDAO(DataSource ds) {		
		this.datasource = ds;		
	}
	
	public List<Aluno> consultaAlunos(){
		
		listaAlunos = new ArrayList<Aluno>();
		Connection con = null;
		Statement st = null;
		ResultSet result = null;
		
		try {
			//Obter conexção com o banco
			con = datasource.getConnection();
			//criar o SQL
			st = con.createStatement();
			String sql = "Select * from aluno";
			//Executar o SQL
			result = st.executeQuery(sql);
			
			//Processar os dados retornados
			while(result.next()) {
				int idAluno = result.getInt("idAluno");
				String primeiroNome = result.getString("primeiroNome");
				String ultimoNome = result.getString("ultimoNome");
				String email = result.getString("email");
				
				Aluno aluno = new Aluno(idAluno, primeiroNome, ultimoNome, email);
				listaAlunos.add(aluno);				
			}
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return listaAlunos;
	}
	
	public void adiciona(Aluno aluno) {
		
		String sql = "insert into aluno" + "(idAluno, primeiroNome, ultimoNome, email)" + 
		"values(?, ?, ?, ?)";
		Connection con = null;
		
		
		try {
			//obter conexão com o banco
			con = datasource.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, aluno.getIdAluno());
			stmt.setString(2, aluno.getPrimeiroNome());
			stmt.setString(3, aluno.getUltimoNome());
			stmt.setString(4, aluno.getEmail());
			
			//executa
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}

	}
	
	

}
