package controls;

import objects.*;

public class NavControls {
	
	private static NavControls instance;
	
//	Makes an instance of the class available.
	public static NavControls getInstance() {
		if (instance == null) {
			instance = new NavControls();
		}
		return instance;
	}
	
//	Gets the selected room from the maze.
		public RoomObject getRoom(MazeObject maze, int i) {
		RoomObject response = null;
		for (int j = 0; j < maze.getRooms().size(); j++) {
			if (maze.getRooms().get(j).getRoomId() == i) {
				response = maze.getRooms().get(j);
			}
		}
		return response;
	}
		
//		Gets the selected passage from the room.
		public PassageObject getPassage(MazeObject maze, int passageId) {
			PassageObject passage = null;
			for (int i = 0; i < maze.getRooms().size(); i++) {
				if (maze.getRooms().get(i).getNorthPassage().getPassageId() == passageId) {
					passage = maze.getRooms().get(i).getNorthPassage();
				}
				else if (maze.getRooms().get(i).getEastPassage().getPassageId() == passageId) {
					passage = maze.getRooms().get(i).getEastPassage();
				}
				else if (maze.getRooms().get(i).getSouthPassage().getPassageId() == passageId) {
					passage = maze.getRooms().get(i).getSouthPassage();
				}
				else if (maze.getRooms().get(i).getWestPassage().getPassageId() == passageId) {
					passage = maze.getRooms().get(i).getWestPassage();
				}
			}
			return passage;
		}

}
