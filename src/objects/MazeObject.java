package objects;

import java.util.ArrayList;

public class MazeObject {
	
	private int mazeID;
	private String mazeName;
	private String mazeDifficulty;
	private ArrayList<RoomObject> rooms;
	
	public MazeObject(int mazeID, String mazeName, String mazeDifficulty, ArrayList<RoomObject> rooms) {
		this.mazeID = mazeID;
		this.mazeDifficulty = mazeDifficulty;
		this.mazeName = mazeName;
		this.rooms = rooms;
	}

	public MazeObject() {
	}

	public int getMazeID() {
		return mazeID;
	}

	public void setMazeID(int mazeID) {
		this.mazeID = mazeID;
	}

	public String getMazeName() {
		return mazeName;
	}

	public void setMazeName(String mazeName) {
		this.mazeName = mazeName;
	}

	public String getMazeDifficulty() {
		return mazeDifficulty;
	}

	public void setMazeDifficulty(String mazeDifficulty) {
		this.mazeDifficulty = mazeDifficulty;
	}

	public ArrayList<RoomObject> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<RoomObject> rooms) {
		this.rooms = rooms;
	}
	
	

}
