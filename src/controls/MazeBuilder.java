package controls;

import objects.MazeObject;
import objects.RoomObject;
import sql.SqlBuildQueries;

public class MazeBuilder {
	
	private static MazeBuilder instance;
	
	public static MazeBuilder getInstance() {
		if (instance == null) {
			instance = new MazeBuilder();
		}
		return instance;
	}
	
	public MazeObject constructMaze(int mazeId) {
		MazeObject maze = new MazeObject();
		maze = SqlBuildQueries.getInstance().getMaze(mazeId);
		maze.setRooms(SqlBuildQueries.getInstance().getRooms(mazeId));
		for (int i = 0; i < maze.getRooms().size(); i++) {
			RoomObject room = maze.getRooms().get(i);
			room.getEastPassage().setLeadsTo(SqlBuildQueries.getInstance().getRoom(room.getEastPassage().getLeadsToInt()));
			room.getNorthPassage().setLeadsTo(SqlBuildQueries.getInstance().getRoom(room.getNorthPassage().getLeadsToInt()));
			room.getSouthPassage().setLeadsTo(SqlBuildQueries.getInstance().getRoom(room.getSouthPassage().getLeadsToInt()));
			room.getWestPassage().setLeadsTo(SqlBuildQueries.getInstance().getRoom(room.getWestPassage().getLeadsToInt()));
		}
		return maze;
	}

}
