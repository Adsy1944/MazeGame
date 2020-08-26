package objects;

import java.util.ArrayList;

public class RoomObject {
	
	private int roomID;
	private String roomName;
	private int mazeID;
	private PassageObject northPassage;
	private PassageObject eastPassage;
	private PassageObject southPassage;
	private PassageObject westPassage;
	private int deposit;
	private ArrayList<ItemObject> items;
	
	public RoomObject(int roomID, String roomName, int mazeID, PassageObject northPassage, PassageObject eastPassage, 
			PassageObject southPassage, PassageObject westPassage, int deposit, ArrayList<ItemObject> items) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.mazeID = mazeID;
		this.northPassage = northPassage;
		this.eastPassage = eastPassage;
		this.southPassage = southPassage;
		this.westPassage = westPassage;
		this.deposit = deposit;
		this.items = items;
	}

	public RoomObject() {
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getMazeID() {
		return mazeID;
	}

	public void setMazeID(int mazeID) {
		this.mazeID = mazeID;
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

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public ArrayList<ItemObject> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemObject> items) {
		this.items = items;
	}
	
}
