package objects;

public class GameObject {
	
	private int gameID;
	private MazeObject maze;
	private UserObject user;
	private int wealth;
	
	public GameObject(int gameID, MazeObject maze, UserObject user, int wealth) {
		this.gameID = gameID;
		this.maze = maze;
		this.user = user;
		this.wealth = wealth;
	}

	public int getGameID() {
		return gameID;
	}

	public void setGameID(int gameID) {
		this.gameID = gameID;
	}

	public MazeObject getMaze() {
		return maze;
	}

	public void setMaze(MazeObject maze) {
		this.maze = maze;
	}

	public UserObject getUser() {
		return user;
	}

	public void setUser(UserObject user) {
		this.user = user;
	}

	public int getWealth() {
		return wealth;
	}

	public void setWealth(int wealth) {
		this.wealth = wealth;
	}
	
	

}
