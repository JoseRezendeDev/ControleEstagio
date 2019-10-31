package comando;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import modelo.Administrador;
import modelo.Aluno;
import modelo.Empresa;
import modelo.Supervisor;
import modelo.Usuario;

public class Logar implements Comando{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EntityManager manager = (EntityManager) request.getAttribute("EntityManager");
		Usuario usuario = new Usuario();
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		String url = "/login.jsp";
		if (usuarioDAO.autentica(usuario)) {
			HttpSession sessao = request.getSession(true);
			sessao.setAttribute("usuario", usuario);
			if (usuario instanceof Administrador)
				url = "/administrador.jsp";
			else if (usuario instanceof Empresa)
				url = "/empresa.jsp";
			else if (usuario instanceof Supervisor)
				url = "/supervisor.jsp";
			else if (usuario instanceof Aluno)
				url = "/aluno.jsp";
		} else {
			request.setAttribute("mensagem", "Login ou senha inválido");
		}
		return url;
	}

}
