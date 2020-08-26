package objects;

public class ActionObject {
	
	private int actionID;
	private int threatID;
	private boolean isCorrect;
	
	public ActionObject(int actionID, int threatID, boolean isCorrect) {
		this.actionID = actionID;
		this.threatID = threatID;
		this.isCorrect = isCorrect;
	}
	
	public int getActionID() {
		return actionID;
	}
	public void setActionID(int actionID) {
		this.actionID = actionID;
	}
	public int getThreatID() {
		return threatID;
	}
	public void setThreatID(int threatID) {
		this.threatID = threatID;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	
}
