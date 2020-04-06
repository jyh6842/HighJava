package homework.jdbc.MVC.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//static
	
	
	public static Connection getInstance() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "jyh6842", "java");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
