package controls;

import java.sql.Connection;

import sql.SqlConnection;

public class UserControls {
	
	private static UserControls instance;
	
	public static UserControls getInstance() {
		if (instance == null) {
			instance = new UserControls();
		}
		return instance;
	}
	
	public boolean startConnection() {
		Connection con = SqlConnection.getInstance().startDatabaseConnection("mazegame", "@2Cellos");
		if (con != null) {
		return true;
		}
		else {
			return false;
		}
	}
	
	public boolean conCheck() {
		Connection con = SqlConnection.getInstance().getConnection();
		if (con == null) {
			return false;
		}
		else {
			return true;
		}
	}

}
