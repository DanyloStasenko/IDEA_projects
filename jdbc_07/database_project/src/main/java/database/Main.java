package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.fabric.jdbc.FabricMySQLDriver;


public class Main {
	
	private static final String HOST = "jdbc:mysql://localhost:3306/mydbtest";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	// private static final String INSERT_NEW = "INSERT INTO users_db VALUES(?,?,?)";
	private static final String GET_ALL = "SELECT * FROM users_db";
	
	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Driver driver = new FabricMySQLDriver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			preparedStatement = connection.prepareStatement(GET_ALL);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				
				System.out.println("ID: " + id 
							+ " \t Username: " + username
							+ " \t Password: " + password);
			}
			
			connection.close();
			preparedStatement.close();
			
			// preparedStatement.setInt(1, 15);
			// preparedStatement.setString(2, "test_1");
			// preparedStatement.setString(3, "test_2");
			// preparedStatement.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Program successfully finished");
	}
}