package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.DBUtils;

public class UserDao {
    
	private Connection conn;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;
	
	public boolean checkLogin(String username,String password) {
		try {
			conn = DBUtils.getConnection();
			String sql="select * from user where username = ? and password = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public User queryAllById(int uid) throws Exception {
		User user = new User();
		conn=DBUtils.getConnection();
		stm = conn.createStatement();
		String sql="select * from user where uid = "+uid;
		rs=stm.executeQuery(sql);
		while(rs.next()) {
			String username = rs.getString("username");
			String password = rs.getString("password");
			String nickname=rs.getString("nickname");
			user = new User(uid,username,password,nickname);
		}
		return user;
	}
	
	public User queryAllByName(String username) throws Exception {
		User user = new User();
		conn=DBUtils.getConnection();
		String sql="select * from user where username = ? ";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1, username);
		rs = pstm.executeQuery();
		while(rs.next()) {
			int uid = rs.getInt("id");
			String username1 = rs.getString("username");
			String password = rs.getString("password");
			String nickname=rs.getString("nickname");
			user = new User(uid,username1,password,nickname);
		}
		return user;
	}

	
	public boolean register(User user) throws Exception {
		conn = DBUtils.getConnection();
		String sql="insert into user(username,password,nickname)values(?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,user.getUsername());
		pstm.setString(2,user.getPassword());
		pstm.setString(3,user.getNickname());
		return pstm.executeUpdate()>0;
	}
	
	
	
	public boolean updateUserById(User user) throws Exception {
		conn = DBUtils.getConnection();
		String sql="update user set nickname=? where id="+user.getId();
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,user.getNickname());
		return pstm.executeUpdate()>0;
	}
}
