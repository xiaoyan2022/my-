package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import model.User;
import util.DBUtils;

public class UserDaoImpl implements UserDao{
	
	private Connection conn;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;

	@Override
	public List<User> queryAll() {
		List<User> users = new ArrayList<>();
		try {
			conn=DBUtils.getConnection();
			stm = conn.createStatement();
			String sql="select * from user";
			rs=stm.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String nickname = rs.getString("nickname");
				String address = rs.getString("address");
				String tel = rs.getString("telphone");
				users.add(new User(id, username, password, nickname, address, tel));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User queryByName(String name) {
		User user = new User();
		try {
			conn=DBUtils.getConnection();
			String sql="select * from user where username = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			rs=pstm.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String nickname = rs.getString("nickname");
				String address = rs.getString("address");
				String tel = rs.getString("telphone");
				user = new User(id, username, password, nickname, address, tel);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean login(User user) {
		try {
			conn=DBUtils.getConnection();
			String sql="select * from user where username = ? and password = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			rs = pstm.executeQuery();
			return rs.next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean register(User user) {
		try {
			conn=DBUtils.getConnection();
			String sql="insert into user(username,password,nickname) values(?,?,?) ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getUsername());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getNickname());
			return pstm.executeUpdate()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		try {
			conn=DBUtils.getConnection();
			String sql="update user set nickname=?,address=?,telphone=? where id = ? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getNickname());
			pstm.setString(2, user.getAddress());
			pstm.setString(3, user.getTel());
			pstm.setInt(4, user.getId());
			return pstm.executeUpdate()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean password(User user) {
		try {
			conn=DBUtils.getConnection();
			String sql="update user set password=? where id = ? ";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getPassword());
			pstm.setInt(2, user.getId());
			return pstm.executeUpdate()>0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
