package comando;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import modelo.Usuario;

public class Cadastrar implements Comando{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EntityManager manager = (EntityManager) request.getAttribute("EntityManager");
		Usuario usuario = new Usuario();
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		UsuarioDAO usuarioDAO = new UsuarioDAO(manager);
		
		if (!usuario.getLogin().equals("") && usuario.getSenha().length() > 6) {
			usuarioDAO.salvar(usuario);
			return "/login.jsp";
		}
		else
			return "/cadastro.jsp";
	}
	
}
