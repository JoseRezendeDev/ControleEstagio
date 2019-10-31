package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comando.Comando;

@WebServlet("/controle")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String parametro = request.getParameter("comando");
		String nomeClasse = "comando." + parametro;
		try {
			Class<?> classe = Class.forName(nomeClasse);
			Comando comando = (Comando) classe.newInstance();
			String view = comando.execute(request, response);
			getServletContext().getRequestDispatcher(view).forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
