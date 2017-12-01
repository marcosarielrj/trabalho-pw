package jpa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private String valor(HttpServletRequest req, String param, String padrao) {
		String result = req.getParameter(param);
		if (result == null) {
			result = padrao;
		}
		return result;
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String msg;
			String op = valor(req, "operacao", "");
			String login = valor(req, "login", "");
			String senha = valor(req, "senha", "");
			String nome = valor(req, "nome", "");
				
			String pagina = "login.jsp";
			
			if (op.equals("cadastrar")) {
				UsuarioDao.cadastrar(nome, login, senha);
				msg = "Inclusão realizada com sucesso.";
			/*} else if (op.equals("alterarsenha")) {
				UsuarioDao.alterar(login, senha);
				msg = "Alteração realizada com sucesso.";
			} else if (op.equals("excluir")) {
				UsuarioDao.excluir(matricula);
				msg = "Exclusão realizada com sucesso.";
			*/} else if (op.equals("logar")) {
				UsuarioDao.PesquisarLogin(login, senha);
				
				pagina = "logado.jsp";
				msg = "";

			} else if (op.equals("")) {
				
				msg = "";
			} else {
				throw new IllegalArgumentException("Operação \"" + op + "\" não suportada.");
			}
			req.setAttribute("msg", msg);
			//req.setAttribute("professores", UsuarioDao.listar());
			
			req.getRequestDispatcher(pagina).forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
	}
}