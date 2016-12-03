package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) {
		
		DBWorker worker = new DBWorker();
		
		String query = "SELECT * FROM users_db";
		// String query = "SELECT * FROM users_db WHERE id=2";
		
		try {
			Statement statement = worker.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			System.out.println(resultSet);
			
			while (resultSet.next()) {
				
				User user = new User();
				
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
				
				System.out.println(user.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// System.out.println("Program successfully finished");
	}
}