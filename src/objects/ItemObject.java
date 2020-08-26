package objects;

public class ItemObject {
	
	private String itemName;
	private int itemId;
	

	public ItemObject(String itemName, int itemId) {
		this.itemId = itemId;
		this.itemName = itemName;
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
	
}
