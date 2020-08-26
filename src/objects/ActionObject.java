package objects;

public class ActionObject {
	
	private int actionID;
	private int threatID;
	private boolean isCorrect;
	private String actionName;
	
	public ActionObject(int actionID, int threatID, boolean isCorrect, String actionName) {
		this.actionID = actionID;
		this.threatID = threatID;
		this.isCorrect = isCorrect;
		this.actionName = actionName;
	}
	
	public ActionObject() {
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

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
}
