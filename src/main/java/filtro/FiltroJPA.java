package filtro;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/controle/*")
public class FiltroJPA implements Filter {
	private EntityManagerFactory factory;
	
	public void destroy() {
		factory.close();
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		EntityManager manager = factory.createEntityManager();
		request.setAttribute("EntityManager", manager);
		manager.getTransaction().begin();
		chain.doFilter(request, response);
		manager.getTransaction().commit();
		manager.close();
	}

	public void init(FilterConfig fConfig) throws ServletException {
		factory = Persistence.createEntityManagerFactory("estagiopu");
	}

}
