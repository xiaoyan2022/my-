package com.util;
import java.sql.Connection;
import java.sql.DriverManager;

/**s
 * 建立数据库连接
 */
public class DBUtils {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://192.168.75.128:3306/stu_help?serverTimezone=GMT&useSSL=false&characterEncoding=utf-8";
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
		DBUtils dbUtils = new DBUtils();
		try {
			System.out.println(dbUtils.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
