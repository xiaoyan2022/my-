package com.dao;

import com.model.User;
import com.util.DBUtils;

import java.sql.*;


public class UserDao {
    
	private Connection conn;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;
	
	public boolean checkLogin(String username,String password) throws Exception {
			conn = DBUtils.getConnection();
			String sql="select * from user where username = ? and password = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			return rs.next();
	}

	public boolean register(User user) throws Exception {
		conn = DBUtils.getConnection();
		String sql="insert into user(username,password,nickname,role)values(?,?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,user.getUsername());
		pstm.setString(2,user.getPassword());
		pstm.setString(3,user.getNickname());
		pstm.setInt(4,user.getRole());
		return pstm.executeUpdate()>0;
	}

	public boolean update(User user) throws Exception {
		conn = DBUtils.getConnection();
		String sql="update user set nickname=? where uid = ?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,user.getNickname());
		pstm.setInt(2,user.getUid());
		return pstm.executeUpdate()>0;
	}

	public boolean updatePassword(User user) throws Exception {
		conn = DBUtils.getConnection();
		String sql="update user set password=? where uid = ?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,user.getPassword());
		pstm.setInt(2,user.getUid());
		return pstm.executeUpdate()>0;
	}

	public User queryAllByName(String username) {
		User user = new User();
		try {
			conn = DBUtils.getConnection();
			String sql="select * from user where username = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, username);
			rs = pstm.executeQuery();
			while (rs.next()){
				int uid = rs.getInt("uid");
				String password = rs.getString("password");
				String nickname = rs.getString("nickname");
				int role = rs.getInt("role");
				user = new User(uid,username,password,nickname,role);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public Boolean exist(String nickname) {
		try {
			conn = DBUtils.getConnection();
			String sql="select * from user where nickname = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, nickname);
			rs = pstm.executeQuery();
			return rs.next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public Boolean existName(String username) {
		try {
			conn = DBUtils.getConnection();
			String sql="select * from user where username = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, username);
			rs = pstm.executeQuery();
			return rs.next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
