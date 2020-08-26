package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import objects.*;

public class SqlBuildQueries {
	
	private static SqlBuildQueries instance;
	private ArrayList<RoomObject> roomsMemory;
	
//	Makes an instance of the class available.
	public static SqlBuildQueries getInstance() {
	if (instance == null) {
		instance = new SqlBuildQueries();
	}
	return instance;
	}
	
//	Generates and returns the selected maze object.
	public MazeObject getMaze(int mazeId) {
		MazeObject maze = new MazeObject();
		String query = "SELECT * FROM maze WHERE maze_id = " + mazeId + ";";
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
	
//	Generates and returns the rooms for the selected maze.
	public ArrayList<RoomObject> getRooms(int mazeId) {
		ArrayList<RoomObject> rooms = new ArrayList<RoomObject>();
		String query = "SELECT * FROM room WHERE maze_id = " + mazeId + ";";
		Connection con = SqlConnection.getInstance().getConnection();
		try {
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(query);
			while (result.next()) {
				RoomObject room = new RoomObject();
				room.setMazeID(mazeId);
				room.setRoomID(Integer.parseInt(result.getString("room_id")));
				room.setRoomName(result.getString("room_name"));
				System.out.println("Loading " + room.getRoomName());
				room.setNorthPassage(getPassage(Integer.parseInt(result.getString("north_passage"))));
				room.setEastPassage(getPassage(Integer.parseInt(result.getString("east_passage"))));
				room.setSouthPassage(getPassage(Integer.parseInt(result.getString("south_passage"))));
				room.setWestPassage(getPassage(Integer.parseInt(result.getString("west_passage"))));
				rooms.add(room);
				
			}
			result.close();
			stat.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't retrieve rooms! Maze ID: " + mazeId);
		}
		roomsMemory = rooms;
		return rooms;
	}
	
//	Gets the selected room.
	public RoomObject getRoom(int roomId) {
		RoomObject result = null;
				for (int i = 0; i < roomsMemory.size(); i++) {
			if (roomsMemory.get(i).getRoomID() == roomId) {
				result = roomsMemory.get(i);
			}
		}
		return result;
	}
	
//	Generates and returns the selected passage.
	public PassageObject getPassage(int passageId) {
		PassageObject passage = new PassageObject();
		String query = "SELECT * FROM passage WHERE passage_id = " + passageId + ";";
		Connection con = SqlConnection.getInstance().getConnection();
		try {
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(query);
			while (result.next()) {
				passage.setPassageId(Integer.parseInt(result.getString("passage_id")));
				System.out.println("Loading Passage ID: " + passage.getPassageId());
				passage.setExit(result.getBoolean("is_exit"));
				passage.setLeadsToInt(Integer.parseInt(result.getString("leads_to")));
			}
			result.close();
			stat.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't retrieve passage! Passage ID: " + passageId);
		}
		return passage;
	}
	
//	Generates and returns the items for a room.
	public ArrayList<ItemObject> getItems(int roomId) {
		ArrayList<ItemObject> items = new ArrayList<ItemObject>();
		String threatQuery = "select item.item_id, item_name, room_id, threat_id, forfeit FROM item JOIN threat ON item.item_id = threat.item_id WHERE room_id= " + roomId + ";"; 
		String treasureQuery = "select item.item_id, item_name, room_id, reasure_id, coins FROM item JOIN treasure ON item.item_id = threat.item_id WHERE room_id= " + roomId + ";"; 
		Connection con = SqlConnection.getInstance().getConnection();
		try {
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(threatQuery);
			while (result.next()) {
				ThreatObject item = new ThreatObject();
				item.setItemId(Integer.parseInt(result.getString("item_id")));
				item.setItemName(result.getString("item_name"));
				System.out.println("Loading " + item.getItemName());
				item.setForfeit(Integer.parseInt(result.getString("forfeit")));
				item.setRoomId(Integer.parseInt(result.getString("room_id")));
				item.setThreatId(Integer.parseInt(result.getString("threat_id")));
				item.setActions(getActions(item.getThreatId()));
				items.add(item);
			}
			result.close();
			stat.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't retrieve Threats! Room ID: " + roomId);
		}
		try {
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(treasureQuery);
			while (result.next()) {
				TreasureObject item = new TreasureObject();
				item.setItemId(Integer.parseInt(result.getString("item_id")));
				item.setItemName(result.getString("item_name"));
				System.out.println("Loading " + item.getItemName());
				item.setRoomId(Integer.parseInt(result.getString("room_id")));
				item.setTreasureId(Integer.parseInt(result.getString("treasure_id")));
				item.setValue(Integer.parseInt(result.getString("coins")));
				items.add(item);
			}
			result.close();
			stat.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't retrieve treasures! Room ID: " + roomId);
			
		}
		return items;
	}
	
//	Generates and returns the actions for a selected threat
	public ArrayList<ActionObject> getActions(int threatId) {
		ArrayList<ActionObject> actions = new ArrayList<ActionObject>();
		String query = "SELECT * FROM action WHERE threat_id = " + threatId + ";";
		Connection con = SqlConnection.getInstance().getConnection();
		try {
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery(query);
			while (result.next()) {
				ActionObject action = new ActionObject();
				action.setActionID(Integer.parseInt(result.getString("action_id")));
				action.setCorrect(result.getBoolean("is_correct"));
				action.setThreatID(Integer.parseInt(result.getString("threat_id")));
				action.setActionName(result.getString("action_name"));
				System.out.println("Loading " + action.getActionName());
				actions.add(action);
			}
			result.close();
			stat.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println("Couldn't load actions! threat ID: " + threatId);
		}
		
		return actions;
	}

}
