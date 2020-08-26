package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
	
	private static SqlConnection instance;
	private Connection connection;
	
//	Makes an instance of the class available to the JSP.
	public static SqlConnection getInstance() {
		if (instance == null) {
			instance = new SqlConnection();
		}
		return instance;
	}

//	Starts the connection to the database using a passed username and password.
	public Connection startDatabaseConnection(String username, String password) {
		String url = "jdbc:mysql://localhost:3306/maze_game?user=" + username + "&password=" + password;
		String forName = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(forName);
			connection = DriverManager.getConnection(url);
			System.out.println("DB connected successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't connect to database!");
		}
		return connection;
	}
	
//	Makes the connection available to other classes.
	public Connection getConnection() {
		return connection;
	}
	
//	Closes the SQL connection.
	public void closeConnection() {
		try {
			connection.close();
			connection = null;
			instance = null;
		} catch (SQLException e) {
			System.err.println("Couldn't close connection!");
			e.printStackTrace();
		}
	}
}
