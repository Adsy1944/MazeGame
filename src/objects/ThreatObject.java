package objects;

import java.util.ArrayList;

public class ThreatObject extends ItemObject{

	private ArrayList<ActionObject> actions;
	private int threatId;
	private int forfeit;
	
	public ThreatObject(int threatId, int forfeit, int itemId, ArrayList<ActionObject> actions, String itemName) {
		super(itemName, itemId);
		this.actions = actions;
		this.threatId = threatId;
		this.forfeit = forfeit;
	}
	
	public ArrayList<ActionObject> getActions() {
		return actions;
	}
	public void setActions(ArrayList<ActionObject> actions) {
		this.actions = actions;
	}
	public int getThreatId() {
		return threatId;
	}
	public void setThreatId(int threatId) {
		this.threatId = threatId;
	}
	public int getForfeit() {
		return forfeit;
	}
	public void setForfeit(int forfeit) {
		this.forfeit = forfeit;
	}
	
}