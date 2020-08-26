package objects;

public class TreasureObject extends ItemObject {
	
	private int treasureId;
	private int value;
	private boolean collected = false;
	
	public TreasureObject(int treasureId, int itemId, int value, String itemName) {
		super(itemName, itemId);
		this.treasureId = treasureId;
		this.value = value;
	}

	public TreasureObject() {
	}

	public int getTreasureId() {
		return treasureId;
	}

	public void setTreasureId(int treasureId) {
		this.treasureId = treasureId;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isCollected() {
		return collected;
	}

	public void setCollected(boolean collected) {
		this.collected = collected;
	}

}
