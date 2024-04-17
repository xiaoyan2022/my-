package com.dao;

import com.model.User;
import com.util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    
	private Connection conn;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;
	
	public boolean checkLogin(int sno,String pwd) throws Exception {
			conn = DBUtils.getConnection();
			String sql="select * from user where sno = ? and pwd = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, sno);
			pstm.setString(2, pwd);
			rs = pstm.executeQuery();
			return rs.next();
	}

	public boolean register(User user) throws Exception {
		conn = DBUtils.getConnection();
		String sql="insert into user(sno,pwd,name,sex,college,time)values(?,?,?,?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1,user.getSno());
		pstm.setString(2,user.getPwd());
		pstm.setString(3,user.getName());
		pstm.setString(4,user.getSex());
		pstm.setString(5,user.getCollege());
		pstm.setDate(6,user.getTime());
		return pstm.executeUpdate()>0;
	}

//	public boolean update(User user) throws Exception {
//		conn = DBUtils.getConnection();
//		String sql="update user set sno=?,tel=?,address=? where uid = ?";
//		pstm=conn.prepareStatement(sql);
//		pstm.setInt(1,user.getSno());
//		pstm.setString(2,user.getPwd());
//		pstm.setString(3,user.getName());
//		pstm.setString(4,user.getSex());
//		pstm.setString(5,user.getCollege());
//		pstm.setDate(6,user.getCreate());
//		return pstm.executeUpdate()>0;
//	}

	public boolean updatePassword(User user) throws Exception {
		conn = DBUtils.getConnection();
		String sql="update user set pwd=? where sno = ?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,user.getPwd());
		pstm.setInt(2,user.getSno());
		return pstm.executeUpdate()>0;
	}

	public User queryAllBySno(int sno) {
		User user = new User();
		try {
			conn = DBUtils.getConnection();
			String sql="select * from user where sno = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, sno);
			rs = pstm.executeQuery();
			while (rs.next()){
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String college = rs.getString("college");
				Date time = rs.getDate("time");
				int account = rs.getInt("account");
				int status = rs.getInt("status");
				user = new User(sno,pwd,name,sex,college,time,account,status);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public List<User> collegeList() {
		List<User> colleges = new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			String sql="select distinct college from user";
			pstm=conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()){
				String college = rs.getString("college");
				colleges.add(new User(college));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colleges;
	}

	public Boolean exist(int sno) {
		try {
			conn = DBUtils.getConnection();
			String sql="select * from user where sno = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, sno);
			rs = pstm.executeQuery();
			return rs.next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean updateUser(User user) {
		try {
			conn = DBUtils.getConnection();
			String sql="update user set name=?,sex=?,college=? where sno = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getSex());
			pstm.setString(3, user.getCollege());
			pstm.setInt(4, user.getSno());
			return pstm.executeUpdate()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
