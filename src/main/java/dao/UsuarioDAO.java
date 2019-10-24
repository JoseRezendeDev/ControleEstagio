package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Usuario;
import util.ConnectionLojaFactory;

public class UsuarioDAO {

	public boolean autentica(Usuario usuario) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ConnectionLojaFactory.getConnection();
			String sql = "select * from usuario where login = ? and senha = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, usuario.getLogin());
			ps.setString(2, usuario.getSenha());
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}
