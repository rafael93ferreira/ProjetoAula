package br.unama.controle;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import br.unama.DAO.AlunoDAO;
import br.unama.modelo.Aluno;


@WebServlet("/AlunoControle")
public class AlunoControle extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/aluno")
	private DataSource datasource; 
	private AlunoDAO alunoDao;
	
	public void init(ServletConfig config) throws ServletException {
		alunoDao = new AlunoDAO(datasource);
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Aluno> alunos = alunoDao.consultaAlunos();
		request.setAttribute("LISTA-ALUNOS", alunos);
		request.getRequestDispatcher("/ListaAlunos.jsp").forward(request, response);
	}



}
