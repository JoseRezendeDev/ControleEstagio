package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Usuario;

public class UsuarioDAO {
	private EntityManager manager;
	
	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void salvar(Usuario usuario) {
		manager.persist(usuario);
	}

	public boolean autentica(Usuario usuario) {
		Query query = manager.createQuery("select u from Usuario u where u.login = ?1 and u.senha = ?2");
		query.setParameter(1, usuario.getLogin()).setParameter(2, usuario.getSenha());
		try {
			query.getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
}
