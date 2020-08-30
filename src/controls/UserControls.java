package controls;

import java.sql.Connection;
import java.util.concurrent.ThreadLocalRandom;

import objects.*;
import sql.SqlConnection;
import sql.SqlScores;

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
	
//	Checks that the SQL Connection is still live.
	public boolean conCheck() {
		Connection con = SqlConnection.getInstance().getConnection();
		if (con == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
//	Closes the SQL Connection.
	public void conClose() {
		SqlConnection.getInstance().closeConnection();
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
	
//	Gets the items for the selected room.
	public String getItems(RoomObject room) {
		String response = "";
		for (int i = 0; i < room.getItems().size(); i++) {
			response += ActionControls.getInstance().getItem(room.getItems().get(i));
		}
		return response;
	}
	
//	Completes the selected action and adjusts the total.
	public void doAction(String actionId) {
		int i = Integer.parseInt(actionId);
		int response = ActionControls.getInstance().doAction(maze, i);
		maze.addWealth(response);
	}
	
//	Retrieves the score.
	public int getScore() {
		return maze.getWealth();
	}
	
//	Completes collection of selected treasure and adjusts the score.
	public void collectTreasure(String roomId, String treasureId) {
		int room = Integer.parseInt(roomId);
		int treasure = Integer.parseInt(treasureId);
		int response = ActionControls.getInstance().collectTreasure(maze, room, treasure);
		maze.addWealth(response);
	}
	
//	Sets the score to 0 if the player finishus with a minus score.
	public void scoreCorrector() {
		if (maze.getWealth() < 0) {
			maze.setWealth(0);
		}
	}
	
//	Wipes the maze from memory.
	public void nullifyMaze() {
		maze = null;
	}
	
//	Submits the score to the database.
	public void submitScore(String name) {
		SqlScores.getInstance().submitScore(maze, name);
	}
	
//	Resets the current game.
	public void resetGame() {
		ActionControls.getInstance().resetGame(maze);
	}
	
//	Toggles whether the room has a marker coin deposited.
	public void setDeposit(boolean deposit, String roomId) {
		RoomObject room = getRoom(roomId);
		room.setDeposit(deposit);
		if (deposit == false) {
			maze.addWealth(1);
		}
		else if (deposit = true) {
			maze.addWealth(-1);
		}
	}
	
}
