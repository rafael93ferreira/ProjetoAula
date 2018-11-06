package br.unama.modelo;

public class Aluno {
	
	private int idAluno;
	private String primeiroNome;
	private String ultimoNome;
	private String email;
	
	
	
	public Aluno() {
		
	}
	public Aluno(int idAluno, String primeiroNome, String ultimoNome, String email) {
		super();
		this.idAluno = idAluno;		
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.email = email;
	}
	
	public Aluno(String primeiroNome, String ultimoNome, String email) {
		super();
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.email = email;
	}

	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getUltimoNome() {
		return ultimoNome;
	}
	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
