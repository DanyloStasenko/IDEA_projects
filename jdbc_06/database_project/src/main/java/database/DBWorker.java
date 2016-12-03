package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBWorker {
	
	private static final String HOST = "jdbc:mysql://localhost:3306/mydbtest";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private Connection connection;
	
	public DBWorker() {
		
		try {
			connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}
}
