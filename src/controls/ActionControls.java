package controls;


import objects.ItemObject;
import objects.MazeObject;
import objects.ThreatObject;
import objects.TreasureObject;

public class ActionControls {
	
	private static ActionControls instance;
	
//	Makes and instance of ActionControls available.
	public static ActionControls getInstance() {
		if (instance == null) {
			instance = new ActionControls();
		}
		return instance;
	}
	
//	Generates actions HTML for the navigation screen.
	public String getItem(ItemObject item) {
		String response = "";
//		This makes the threats.
		if (item.getClass().equals(ThreatObject.class)) {
			System.out.println("Threat found! " + item.getItemName());
				ThreatObject threat = (ThreatObject)item;
			if (threat.isDefeated() == false) {
			String line = "<tr><td></td><td><label>" + threat.getItemName() + "</label></td><td>";
			line += "<tr>";
			for (int i = 0; i < threat.getActions().size(); i++) {
				line += "<td><form action='action.jsp'><input hidden type='text' id='action' name='action' value='" + threat.getActions().get(i).getActionID() + "'><input hidden type='text' id='room' name='room' value='" + threat.getRoomId() + "'>"
			+"<button id='weapon' name='weapon' class='btn btn-lg btn-dark' type='submit'>" +  threat.getActions().get(i).getActionName() + "</button></form></td>";
			}
			response += line;
			response += "</tr>";
			}
		}
//		This makes the treasures.
		else if (item.getClass().equals(TreasureObject.class)) {
			System.out.println("Treasure found! " + item.getItemName());
			TreasureObject treasure = (TreasureObject)item;
			System.out.println(treasure.getTreasureId());
			if (treasure.isCollected() == false) {
			String line = "<tr><td></td><td><label>" + treasure.getItemName() + "</label></td><td>";
			line += "<tr><td></td><td><form action='collect.jsp'><input hidden type='text' id='value' name='value' value='" + treasure.getTreasureId() +"'><input hidden type='text' id='room' name='room' value='" + treasure.getRoomId() + "'>"
			+ "<button id='collect' name='collect' class='btn btn-lg btn-dark' type='submit'>" + "Collect</button></form></td><td></td>";
			response += line;
			response += "</tr>";
			}
		}
		
		return response;
	}
	
//	Completes an action selected by the user to defeat a threat.
	public int doAction(MazeObject maze, int actionId) {
		int response = 0;
		for (int i = 0; i < maze.getRooms().size(); i++) {
			for (int j = 0; j < maze.getRooms().get(i).getItems().size(); j++) {
				if (maze.getRooms().get(i).getItems().get(j).getClass().equals(ThreatObject.class)) {
					for (int k = 0; k < ((ThreatObject) maze.getRooms().get(i).getItems().get(j)).getActions().size(); k++) {
						if (((ThreatObject) maze.getRooms().get(i).getItems().get(j)).getActions().get(k).getActionID() == actionId) {
							if (((ThreatObject) maze.getRooms().get(i).getItems().get(j)).getActions().get(k).isCorrect()) {
								((ThreatObject) maze.getRooms().get(i).getItems().get(j)).setDefeated(true);
								response -= 0;
							} else {
								response -= ((ThreatObject) maze.getRooms().get(i).getItems().get(j)).getForfeit();
							}
						}
					}
				}
			}
		}
		return response;
	}
	
//	Collects treasure.
	public int collectTreasure(MazeObject maze, int room, int treasure) {
		int response = 0;
		for (int i = 0; i < maze.getRooms().size(); i++) {
			if (maze.getRooms().get(i).getRoomId() == room) {
				for (int j = 0; j < maze.getRooms().get(i).getItems().size(); j++) {
					if (maze.getRooms().get(i).getItems().get(j).getClass().equals(TreasureObject.class)) {
						if (((TreasureObject)maze.getRooms().get(i).getItems().get(j)).getTreasureId() == treasure) {
							response = ((TreasureObject)maze.getRooms().get(i).getItems().get(j)).getValue();
							((TreasureObject)maze.getRooms().get(i).getItems().get(j)).setCollected(true);
						}
					}
				}
			}
		}
		return response;
	}
	
//	This resets the current game values.
	public void resetGame(MazeObject maze) {
		maze.setWealth(0);
		for (int i = 0; i < maze.getRooms().size(); i++) {
			maze.getRooms().get(i).setDeposit(false);
			for(int j = 0; j < maze.getRooms().get(i).getItems().size(); j++) {
				if (maze.getRooms().get(i).getItems().get(j).getClass().equals(ThreatObject.class)) {
					((ThreatObject)maze.getRooms().get(i).getItems().get(j)).setDefeated(false);
				}
				else if (maze.getRooms().get(i).getItems().get(j).getClass().equals(TreasureObject.class)) {
					((TreasureObject)maze.getRooms().get(i).getItems().get(j)).setCollected(false);
				}
			}
		}
	}

}
