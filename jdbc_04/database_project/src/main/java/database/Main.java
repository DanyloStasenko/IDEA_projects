package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class Main {
	
	private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public static void main(String[] args) {
		
		Connection connection;
		
		try {
			
			Driver driver = new FabricMySQLDriver();
			DriverManager.registerDriver(driver);
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			if (!connection.isClosed()) {
				System.out.println("Database connected");
			}
			
			connection.close();
			
			if (connection.isClosed()) {
				System.out.println("Connection closed");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error loadind driver");
		}
		
		System.out.println("successfully finished");
	}
}