package com.dao;

import com.model.Good;
import com.util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class GoodDao {
    
	private Connection conn;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;

	public boolean add(Good good) throws Exception {
		conn = DBUtils.getConnection();
		String sql="insert into good(owner,name,des,time,price)values(?,?,?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1,good.getOwner());
		pstm.setString(2,good.getName());
		pstm.setString(3,good.getDes());
		pstm.setDate(4,good.getTime());
		pstm.setInt(5,good.getPrice());
		return pstm.executeUpdate()>0;
	}

	public boolean del(int gid) throws Exception {
		conn = DBUtils.getConnection();
		String sql="delete from good where gid = ?";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1,gid);
		return pstm.executeUpdate()>0;
	}

	public List<Good> queryAll() {
		List<Good> goods = new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			String sql="select * from good where status = 1";
			pstm=conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()){
				int gid = rs.getInt("gid");
				int owner = rs.getInt("owner");
				String name = rs.getString("name");
				String des = rs.getString("des");
				Date time = rs.getDate("time");
				int price = rs.getInt("price");
				int status = rs.getInt("status");
				goods.add(new Good(gid,owner,name,des,time,price,status));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	public List<Good> queryAllByName(String name) {
		List<Good> goods = new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			String sql="select * from good where name like '%"+name+"%'";
			pstm=conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()){
				int gid = rs.getInt("gid");
				int owner = rs.getInt("owner");
				String name2 = rs.getString("name");
				String des = rs.getString("des");
				Date time = rs.getDate("time");
				int price = rs.getInt("price");
				int status = rs.getInt("status");
				goods.add(new Good(gid,owner,name2,des,time,price,status));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	public List<Good> queryAllBySno(int owner,int status) {
		List<Good> goods = new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			String sql="select * from good where status = ? and owner = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1,status);
			pstm.setInt(2,owner);
			rs = pstm.executeQuery();
			while (rs.next()){
				int gid = rs.getInt("gid");
				String name = rs.getString("name");
				String des = rs.getString("des");
				Date time = rs.getDate("time");
				int price = rs.getInt("price");
				goods.add(new Good(gid,owner,name,des,time,price,status));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goods;
	}

	public Good queryAllById(int gid) {
		Good good = new Good();
		try {
			conn = DBUtils.getConnection();
			String sql="select * from good where gid = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1,gid);
			rs = pstm.executeQuery();
			while (rs.next()){
				int owner = rs.getInt("owner");
				String name = rs.getString("name");
				String des = rs.getString("des");
				Date time = rs.getDate("time");
				int price = rs.getInt("price");
				int status = rs.getInt("status");
				good = new Good(gid,owner,name,des,time,price,status);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return good;
	}

	public int count(int owner,int status) {
		int count = 0;
		try {
			conn = DBUtils.getConnection();
			String sql="select count(*) from good where owner = ? and status = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1,owner);
			pstm.setInt(2,status);
			rs = pstm.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public boolean update(int owner,int gid) throws Exception {
		conn = DBUtils.getConnection();
		String sql="update good set status = 0,owner = ? where gid = ?";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1,owner);
		pstm.setInt(2,gid);
		return pstm.executeUpdate()>0;
	}
}
