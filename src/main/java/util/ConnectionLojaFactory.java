package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionLojaFactory {
	
	public static Connection getConnection() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			return DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/controleEstagio", "sa", "");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
