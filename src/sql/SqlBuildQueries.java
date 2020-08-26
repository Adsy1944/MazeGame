package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import objects.*;

public class SqlBuildQueries {
	
	private static SqlBuildQueries instance;
	private ArrayList<RoomObject> roomsMemory;
	
	public static SqlBuildQueries getInstance() {
	if (instance == null) {
		instance = new SqlBuildQueries();
	}
	return instance;
	}
	
	public MazeObject getMaze(int mazeId) {
		MazeObject maze = new MazeObject();
		String query = "SELECT * FROM maze WHERE maze_id = " + mazeId;
		Connection con = SqlConnection.getInstance().getConnection();
		try {
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(query);
			while (result.next()) {
				maze.setMazeID(mazeId);
				maze.setMazeName(result.getString("maze_name"));
				maze.setMazeDifficulty(result.getString("maze_difficulty"));
				System.out.println("Maze ID: " + maze.getMazeName());
			}
			result.close();
			stat.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't retrieve maze!");
		}
		return maze;
	}
	
	public ArrayList<RoomObject> getRooms(int mazeId) {
		ArrayList<RoomObject> rooms = new ArrayList<RoomObject>();
		String query = "SELECT * FROM room WHERE maze_id = " + mazeId;
		Connection con = SqlConnection.getInstance().getConnection();
		try {
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(query);
			while (result.next()) {
				RoomObject room = new RoomObject();
				room.setMazeID(mazeId);
				room.setRoomID(Integer.parseInt(result.getString("room_id")));
				System.out.println("Room ID:" + room.getRoomID()); 
				room.setRoomName(result.getString("room_name"));
				System.out.println("Room Name: " + room.getRoomName());
				room.setNorthPassage(getPassage(Integer.parseInt(result.getString("north_passage"))));
				System.out.println("North Passage ID: " + room.getNorthPassage().getPassageId());
				room.setEastPassage(getPassage(Integer.parseInt(result.getString("east_passage"))));
				room.setSouthPassage(getPassage(Integer.parseInt(result.getString("south_passage"))));
				room.setWestPassage(getPassage(Integer.parseInt(result.getString("west_passage"))));
				rooms.add(room);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't retrieve rooms! Maze ID: " + mazeId);
		}
		roomsMemory = rooms;
		return rooms;
	}
	
	public RoomObject getRoom(int roomId) {
		RoomObject result = null;
				for (int i = 0; i < roomsMemory.size(); i++) {
			if (roomsMemory.get(i).getRoomID() == roomId) {
				result = roomsMemory.get(i);
			}
		}
		return result;
	}
	
	public PassageObject getPassage(int passageId) {
		PassageObject passage = new PassageObject();
		String query = "SELECT * FROM passage WHERE passage_id = " + passageId;
		Connection con = SqlConnection.getInstance().getConnection();
		try {
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(query);
			while (result.next()) {
				passage.setPassageId(Integer.parseInt(result.getString("passage_id")));
				System.out.println("Passage ID: " + passage.getPassageId());
				passage.setExit(result.getBoolean("is_exit"));
				System.out.println("Is Exit? " + passage.isExit());
				passage.setLeadsToInt(Integer.parseInt(result.getString("leads_to")));
				System.out.println("Leads to int: " + passage.getLeadsToInt());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't retrieve passage! Passage ID: " + passageId);
		}
		return passage;
	}
	
	public ArrayList<ItemObject> getItems(int roomId) {
		ArrayList<ItemObject> items = new ArrayList<ItemObject>();
		String query = "SELECT * FROM item WHERE room_id = " + roomId; 
		
		
		return items;
	}

}
