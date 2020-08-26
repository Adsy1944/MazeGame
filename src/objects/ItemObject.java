package objects;

public class ItemObject {
	
	private String itemName;
	private int itemId;
	private int roomId;

	public ItemObject(String itemName, int itemId) {
		this.itemId = itemId;
		this.itemName = itemName;
	}
	
	public ItemObject() {
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
}
