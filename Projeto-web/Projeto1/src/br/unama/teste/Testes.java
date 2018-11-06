package br.unama.teste;

import br.unama.DAO.AlunoDAO;
import br.unama.modelo.Aluno;

public class Testes {

	public static void main(String[] args) {
		
		
		Aluno aluno = new Aluno();
		
		aluno.setIdAluno(1);
		aluno.setPrimeiroNome("Carlos");
		aluno.setUltimoNome("Mendonça");
		aluno.setEmail("cshenrique02@gmail.com");
		
		AlunoDAO dao = new AlunoDAO();
		
		dao.adiciona(aluno);
		System.out.println("gravado");
		

	}

}
