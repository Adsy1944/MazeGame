package objects;

import java.util.ArrayList;

public class RoomObject {
	
	private int roomId;
	private String roomName;
	private int mazeId;
	private PassageObject northPassage;
	private PassageObject eastPassage;
	private PassageObject southPassage;
	private PassageObject westPassage;
	private boolean deposit;
	private ArrayList<ItemObject> items;
	
	public RoomObject(int roomId, String roomName, int mazeId, PassageObject northPassage, PassageObject eastPassage, 
			PassageObject southPassage, PassageObject westPassage, boolean deposit, ArrayList<ItemObject> items) {
		this.roomId = roomId;
		this.roomName = roomName;
		this.mazeId = mazeId;
		this.northPassage = northPassage;
		this.eastPassage = eastPassage;
		this.southPassage = southPassage;
		this.westPassage = westPassage;
		this.deposit = deposit;
		this.items = items;
	}
	
	public RoomObject() {
	}
		
	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getMazeId() {
		return mazeId;
	}

	public void setMazeId(int mazeId) {
		this.mazeId = mazeId;
	}

	public PassageObject getNorthPassage() {
		return northPassage;
	}

	public void setNorthPassage(PassageObject northPassage) {
		this.northPassage = northPassage;
	}

	public PassageObject getEastPassage() {
		return eastPassage;
	}

	public void setEastPassage(PassageObject eastPassage) {
		this.eastPassage = eastPassage;
	}

	public PassageObject getSouthPassage() {
		return southPassage;
	}

	public void setSouthPassage(PassageObject southPassage) {
		this.southPassage = southPassage;
	}

	public PassageObject getWestPassage() {
		return westPassage;
	}

	public void setWestPassage(PassageObject westPassage) {
		this.westPassage = westPassage;
	}

	public boolean getDeposit() {
		return deposit;
	}

	public void setDeposit(boolean deposit) {
		this.deposit = deposit;
	}

	public ArrayList<ItemObject> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemObject> items) {
		this.items = items;
	}
	
}
