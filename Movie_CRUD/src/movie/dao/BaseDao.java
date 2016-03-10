package movie.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
public static Connection getCon(){
	Connection con = null;
	try {
		con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Hari/Documents/Movie.accdb");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return con;
}

public static void closeCon(Connection con){
	try {
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
