package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import objects.MazeObject;

public class SqlScores {
	
	private static SqlScores instance;
	
//	Makes an instance of SqlScores available.
	public static SqlScores getInstance() {
		if (instance == null) {
			instance = new SqlScores();
		}
		return instance;
	}
	
//	Submits a game score to the database.
	public void submitScore(MazeObject maze, String name) {
		String query = "INSERT INTO game(maze_id, player_name, wealth) VALUES (" + maze.getMazeID() + ", '" + name + "', " + maze.getWealth() + ");";
		Connection con = SqlConnection.getInstance().getConnection();
		try {
			Statement stat = con.createStatement();
			stat.executeUpdate(query);
			stat.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't write score to database!");
		}
	}
	
//	Generates a scores table from the database.
	public String getScores() {
		String response = "";
		String query ="SELECT * FROM game;";
		Connection con = SqlConnection.getInstance().getConnection();
		try {
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(query);
			while (result.next()) {
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't retrieve scores!");
		}
		return response;
	}
}
