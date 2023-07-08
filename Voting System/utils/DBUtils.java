package utils;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtils {

	private static Connection cn;
	
	public static Connection openConnection() throws SQLException{
		String Url="jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		cn=DriverManager.getConnection(Url,"root","admin123");
		System.out.println("Database Connection Established...");
		return cn;
	}
	
	public static void closeConnection() throws SQLException {
		if(cn!=null) {
			cn.close();
			System.out.println("Database Connection Closed...");
		}
		
	}
}
