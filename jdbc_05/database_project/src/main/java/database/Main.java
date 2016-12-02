package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

public class Main {
	
	private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public static void main(String[] args) {
		
		try {
			
			Driver driver = new FabricMySQLDriver();
			DriverManager.registerDriver(driver);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error loadind driver");
		}
		
		try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Statement statement = connection.createStatement();) {
			
			// inserting data into DB:
			// statement.execute("INSERT INTO animal (anim_name, anim_desc) VALUES ('elephant', 'big animal')");
			
			
			// updating data:
			// int result = statement.executeUpdate("UPDATE animal SET anim_name='other elephant' where id = 1");
			// System.out.println("We updated " + result + " row (-s)");
			
			
			// getting ResultSet (only select queries)
			//ResultSet resultSet = statement.executeQuery("SELECT * FROM animal");
			
			
			// we can also execute 'package of queries' using 'addBatch' method
			statement.addBatch("INSERT INTO animal (anim_name, anim_desc) VALUES ('batch test 1', 'no description')");
			statement.addBatch("INSERT INTO animal (anim_name, anim_desc) VALUES ('batch test 2', 'no description')");
			statement.addBatch("INSERT INTO animal (anim_name, anim_desc) VALUES ('batch test 3', 'no description')");
			
			// statement.executeBatch(); 	// execute
			statement.clearBatch(); 		// clear
			
			boolean status = statement.isClosed();
			System.out.println("statement.isClosed() = " + status);
			
			/*	more methods: 
				statement.getConnection();
				statement.close();
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Program sucessfully finished");
	}
}