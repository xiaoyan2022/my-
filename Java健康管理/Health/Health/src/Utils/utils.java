package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class utils {
  //注册驱动
	static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	//获取数据库连接
	//获取Connection对象
	private static Connection conn;
	public static Connection getConnection() throws SQLException {

			String url = "jdbc:mysql://127.0.0.1/health";
			String user = "root";
			String password = "root";
			
			if(conn == null || conn.isClosed()) {				
				conn = DriverManager.getConnection(url, user, password);
			}
			return conn;
	}
//关闭资源
	public static void Close(Connection conn,Statement stmt,ResultSet rs) throws SQLException {
		if(conn!=null && !conn.isClosed()) {
			conn.close();
		}
		if(stmt!=null && !stmt.isClosed()) {
			stmt.close();
		}
		if(rs!=null && !rs.isClosed()) {
			rs.close();
		}
	
	}
	
}











