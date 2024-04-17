package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**s
 * 建立数据库连接
 */
public class DBUtils {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://192.168.75.128:3306/blog_sys?useSSL=false&characterEncoding=utf-8";
	private static String username = "root";
	private static String password = "root";

	public static Connection getConnection() throws Exception {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
	}

	public static void close(Connection conn) throws Exception  {
               if (conn!=null) {
            	   conn.close();//conn占用大量资源，必须关闭，其他的会自动关闭，占用资源几乎可以忽略		
			}
	}
	
	public static void main(String[] args) {
		DBUtils dbUtils = new DBUtils();
		try {
			dbUtils.getConnection();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
		
	}
}
