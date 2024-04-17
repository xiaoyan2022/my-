package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Blog;
import model.User;
import util.DBUtils;

public class BlogDao {
    
	private Connection conn;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;
	
	public List<Blog> queryAllByCondition(String title,String type) throws Exception {
		List<Blog> blogs = new ArrayList<>();
		conn=DBUtils.getConnection();
		String sql="select *,u.nickname name from blog b,user u where b.uid = u.id and title like ? and type like ?";
		pstm = conn.prepareStatement(sql);
		pstm.setString(1,"%"+title+"%");
		pstm.setString(2,"%"+type+"%");
		rs=pstm.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			int uid = rs.getInt("uid");
			String title1=rs.getString("title");
			String content1=rs.getString("content");
			String type1=rs.getString("type");
			Date create_time = rs.getDate("create_time");
			Date update_time = rs.getDate("update_time");
			String name = rs.getString("name");
			blogs.add(new Blog(id, uid, title1, content1, type1, create_time, update_time,name));
		}
		return blogs;
	}
	
	public List<Blog> queryAll() throws Exception {
		List<Blog> blogs = new ArrayList<>();
		conn=DBUtils.getConnection();
		String sql="select *,u.nickname name from blog b,user u where b.uid = u.id";
		pstm = conn.prepareStatement(sql);
		rs=pstm.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			int uid = rs.getInt("uid");
			String title1=rs.getString("title");
			String content1=rs.getString("content");
			String type1=rs.getString("type");
			Date create_time = rs.getDate("create_time");
			Date update_time = rs.getDate("update_time");
			String name = rs.getString("name");
			blogs.add(new Blog(id, uid, title1, content1, type1, create_time, update_time,name));
		}
		return blogs;
	}
	
	public Blog getById(int id) throws Exception {
		Blog blog = new Blog();
		conn=DBUtils.getConnection();
		String sql="select * from blog where id =?";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rs=pstm.executeQuery();
		while(rs.next()) {
			int id1 = rs.getInt("id");
			String title1=rs.getString("title");
			String content1=rs.getString("content");
			String type1=rs.getString("type");
			Date update_time = rs.getDate("update_time");
			blog = new Blog(id1, title1, content1, type1, update_time);
		}
		return blog;
	}
	
	public List<Blog> queryAllByAuthor(int uid) throws Exception {
		List<Blog> blogs = new ArrayList<>();
		conn=DBUtils.getConnection();
		String sql="select *,u.nickname name from blog b,user u where b.uid = u.id and uid = ?";
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, uid);
		rs=pstm.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			int uid1 = rs.getInt("uid");
			String title1=rs.getString("title");
			String content1=rs.getString("content");
			String type1=rs.getString("type");
			Date create_time = rs.getDate("create_time");
			Date update_time = rs.getDate("update_time");
			String name = rs.getString("name");
			blogs.add(new Blog(id, uid1, title1, content1, type1, create_time, update_time,name));
		}
		return blogs;
	}
	
	public boolean addBlog(Blog blog) throws Exception {
		conn = DBUtils.getConnection();
		String sql="insert into blog(uid,title,content,type,create_time,update_time)values(?,?,?,?,?,?)";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1,blog.getUid());
		pstm.setString(2,blog.getTitle());
		pstm.setString(3,blog.getContent());
		pstm.setString(4,blog.getType());
		pstm.setDate(5,new java.sql.Date(blog.getCreate_time().getTime()));
		pstm.setDate(6,new java.sql.Date(blog.getUpdate_time().getTime()));
		return pstm.executeUpdate()>0;
	}
	
	public boolean updateBlog(Blog blog) throws Exception {
		conn = DBUtils.getConnection();
		String sql="update blog set title = ?,content = ?,type = ?,update_time = ? where id =?";
		pstm=conn.prepareStatement(sql);
		pstm.setString(1,blog.getTitle());
		pstm.setString(2,blog.getContent());
		pstm.setString(3,blog.getType());
		pstm.setDate(4,new java.sql.Date(blog.getUpdate_time().getTime()));
		pstm.setInt(5,blog.getUid());
		return pstm.executeUpdate()>0;
	}
	
	public boolean deleteById(int id) throws Exception {
		conn = DBUtils.getConnection();
		String sql="delete from blog where id = ?";
		pstm=conn.prepareStatement(sql);
		pstm.setInt(1,id);
		return pstm.executeUpdate()>0;
	}
}
