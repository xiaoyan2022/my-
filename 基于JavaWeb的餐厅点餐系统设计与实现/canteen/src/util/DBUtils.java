package util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://192.168.75.128:3306/bookstore?serverTimezone=GMT&useSSL=false&characterEncoding=utf-8";
	private static String username = "root";
	private static String password = "root";

	public static Connection getConnection() throws Exception {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
	}

	public static void close(Connection conn) throws Exception  {
               if (conn!=null) {
            	   conn.close();
			}
	}
	
	public static void main(String[] args) {
		try {
			Connection connection = DBUtils.getConnection();
			System.out.println(connection);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
