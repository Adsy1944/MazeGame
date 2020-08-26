package objects;

public class UserObject {

	private int userID;
	private String username;
	
	public UserObject(int userID, String username) {
		this.username = username;
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
