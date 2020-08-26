package controls;

import java.sql.Connection;
import java.util.concurrent.ThreadLocalRandom;

import objects.*;
import sql.SqlConnection;

public class UserControls {
	
	private static UserControls instance;
	private MazeObject maze;
	
	
//	Makes an instance of the class available.
	public static UserControls getInstance() {
		if (instance == null) {
			instance = new UserControls();
		}
		return instance;
	}
	
//	Starts the SQl Connection (Currently with hardcoded connection details, but can be replaced with user credentials).
	public boolean startConnection() {
		Connection con = SqlConnection.getInstance().startDatabaseConnection("mazegame", "@2Cellos");
		if (con != null) {
		return true;
		}
		else {
			return false;
		}
	}
	
//	Checks that the connection is still live.
	public boolean conCheck() {
		Connection con = SqlConnection.getInstance().getConnection();
		if (con == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
//	Build the selected maze, currently hard coded to Maze 1 by UI, but when more mazes available, can be variable.
	public boolean initialiseMaze(int mazeId) {
		maze = null;
		maze = MazeBuilder.getInstance().constructMaze(mazeId);
		if (maze == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
//	Generates a random room number to start the game in.
	public int getStartPosition() {
		int max = maze.getRooms().size();
		int randomStart = ThreadLocalRandom.current().nextInt(1, max + 1);
		return randomStart;
	}
	
//	Gets the selected room.
	public RoomObject getRoom(String pos) {
		int i = Integer.parseInt(pos);
		return NavControls.getInstance().getRoom(maze, i);
	}
	
//	Gets the selected passage
	public PassageObject getPassage(String passageId) {
		int i = Integer.parseInt(passageId);
		return NavControls.getInstance().getPassage(maze,  i);
	}
	

}
