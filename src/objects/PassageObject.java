package objects;

public class PassageObject {
	
	private int passageId;
	private boolean isExit;
	private RoomObject leadsTo;
	private int leadsToInt;
	
	public PassageObject() {
		
	}
	
	public PassageObject(int passageId, boolean isExit, RoomObject leadsTo) {
		this.passageId = passageId;
		this.isExit = isExit;
		this.leadsTo = leadsTo;
	}

	public int getPassageId() {
		return passageId;
	}

	public void setPassageId(int passageId) {
		this.passageId = passageId;
	}

	public boolean isExit() {
		return isExit;
	}

	public void setExit(boolean isExit) {
		this.isExit = isExit;
	}

	public RoomObject getLeadsTo() {
		return leadsTo;
	}

	public void setLeadsTo(RoomObject leadsTo) {
		this.leadsTo = leadsTo;
	}

	public int getLeadsToInt() {
		return leadsToInt;
	}

	public void setLeadsToInt(int leadsToInt) {
		this.leadsToInt = leadsToInt;
	}
	
}
