package gosu.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConn {
	
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String dburl  = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuid  = "lck";
	private static String dbpw   = "1234";
	
	private static Connection conn ;
	
	public static Connection getInstace() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl,dbuid,dbpw);
			} catch (SQLException e){
			e.printStackTrace();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	
}
