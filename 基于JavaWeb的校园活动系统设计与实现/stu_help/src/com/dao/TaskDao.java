package com.dao;

import com.model.Task;
import com.util.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TaskDao {
    
	private Connection conn;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;

	public boolean add(Task task) throws Exception {
		conn = DBUtils.getConnection();
		String sql="insert into task(pub,title,des,time,reward,end)values(?,?,?,?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1,task.getPub());
		pstm.setString(2,task.getTitle());
		pstm.setString(3,task.getDes());
		pstm.setDate(4,task.getTime());
		pstm.setInt(5,task.getReward());
		pstm.setDate(6,task.getEnd());
		return pstm.executeUpdate()>0;
	}

	public boolean del(int tid) throws Exception {
		conn = DBUtils.getConnection();
		String sql="delete from task where tid = ?";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1,tid);
		return pstm.executeUpdate()>0;
	}

	public List<Task> queryAll() {
		List<Task> tasks = new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			String sql="select * from task where status = 1";
			pstm=conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()){
				int tid = rs.getInt("tid");
				int pub = rs.getInt("pub");
				String title = rs.getString("title");
				String des = rs.getString("des");
				Date time = rs.getDate("time");
				int reward = rs.getInt("reward");
				int status = rs.getInt("status");
				Date end = rs.getDate("end");
				tasks.add(new Task(tid,pub,title,des,time,reward,status,end));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}

	public List<Task> queryAllByCondition(String title) {
		List<Task> tasks = new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			String sql="select tid,pub,title,des,t.time,reward,t.status,end from " +
					"task t,user u where t.pub = u.sno and t.status = 1 and " +
					"t.title like ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,"%"+title+"%");
			rs = pstm.executeQuery();
			while (rs.next()){
				int tid = rs.getInt("tid");
				int pub = rs.getInt("pub");
				String title2 = rs.getString("title");
				String des = rs.getString("des");
				Date time = rs.getDate("time");
				int reward = rs.getInt("reward");
				int status = rs.getInt("status");
				Date end = rs.getDate("end");
				tasks.add(new Task(tid,pub,title2,des,time,reward,status,end));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}

	public List<Task> queryAllBySno(int pub,int status) {
		List<Task> tasks = new ArrayList<>();
		try {
			conn = DBUtils.getConnection();
			String sql="select * from task where status = ? and pub = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1,status);
			pstm.setInt(2,pub);
			rs = pstm.executeQuery();
			while (rs.next()){
				int tid = rs.getInt("tid");
				String title = rs.getString("title");
				String des = rs.getString("des");
				Date time = rs.getDate("time");
				int reward = rs.getInt("reward");
				Date end = rs.getDate("end");
				tasks.add(new Task(tid,pub,title,des,time,reward,status,end));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}

	public Task queryAllById(int tid) {
		Task task = new Task();
		try {
			conn = DBUtils.getConnection();
			String sql="select * from task where tid = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1,tid);
			rs = pstm.executeQuery();
			while (rs.next()){
				int pub = rs.getInt("pub");
				String title = rs.getString("title");
				String des = rs.getString("des");
				Date time = rs.getDate("time");
				int reward = rs.getInt("reward");
				int status = rs.getInt("status");
				Date end = rs.getDate("end");
				task = new Task(tid,pub,title,des,time,reward,status,end);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task;
	}

	public int count(int pub,int status) {
		int count = 0;
		try {
			conn = DBUtils.getConnection();
			String sql="select count(*) from task where pub = ? and status = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1,pub);
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

	public boolean update(int pub,int tid) throws Exception {
		conn = DBUtils.getConnection();
		String sql="update task set status = 0,pub = ? where tid = ?";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1,pub);
		pstm.setInt(2,tid);
		return pstm.executeUpdate()>0;
	}
}
