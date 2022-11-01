package connectiondatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
	public static Connection connectionDatabase() {
		Connection conn=null;
				try {
		        	String dbURL = "jdbc:sqlserver://localhost;databaseName=QUANLYTRUONGHOC";
			        String user = "sa";
			        String pass = "xxxxxxxx";
			        
					conn = DriverManager.getConnection(dbURL, user, pass);
					
				} catch (SQLException e) {
				}
				return conn;
				
			}
			public static Connection closeconnection(Connection conn) throws SQLException {
				conn.close();
				return conn;
			}
}
