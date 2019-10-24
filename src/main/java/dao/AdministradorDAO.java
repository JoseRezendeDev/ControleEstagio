package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modelo.Administrador;
import util.ConnectionLojaFactory;

public class AdministradorDAO {
	
	public void gravar(Administrador admin) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectionLojaFactory.getConnection();
			String sql = "insert into administrador (login, senha, nome) " +
							"values (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getLogin());
			ps.setString(2, admin.getSenha());
			ps.setString(3, admin.getNome());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
