package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	public DatabaseConnection() {

	}

	/**
	 * Gets the connection.
	 * 
	 * @return the connection
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/clinic", "root", "");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		return connection;
	}

}
