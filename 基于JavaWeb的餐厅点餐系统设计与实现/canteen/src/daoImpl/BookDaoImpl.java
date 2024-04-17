package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import model.Book;
import util.DBUtils;

public class BookDaoImpl implements BookDao{

	private Connection conn;
	private PreparedStatement pstm;
	private Statement stm;
	private ResultSet rs;
	
	@Override
	public List<Book> queryAll(){
		List<Book> books = new ArrayList<>();
		try {
			conn=DBUtils.getConnection();
			stm = conn.createStatement();
			String sql="select * from book";
			rs=stm.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				String imgUrl = rs.getString("imgUrl");
				String publish = rs.getString("publish");
				float price = rs.getFloat("price");
				books.add(new Book(id, name, author, imgUrl, publish, price));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public boolean add(Book book) {
			try {
				conn = DBUtils.getConnection();
				String sql="insert into book(name,author,imgUrl,publish,price)values(?,?,?,?,?)";
				pstm=conn.prepareStatement(sql);
				pstm.setString(1,book.getName());
				pstm.setString(2,book.getAuthor());
				pstm.setString(3,book.getImgUrl());
				pstm.setString(4,book.getPublish());
				pstm.setFloat(5, book.getPrice());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		try {
			return pstm.executeUpdate()>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Book book) {
		try {
			conn = DBUtils.getConnection();
			String sql="update book set name=?,author=?,publish=?,price=? where id = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,book.getName());
			pstm.setString(2,book.getAuthor());
			pstm.setString(3,book.getPublish());
			pstm.setFloat(4, book.getPrice());
			pstm.setInt(5, book.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	try {
		return pstm.executeUpdate()>0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public boolean del(int id) {
		try {
			conn = DBUtils.getConnection();
			String sql="delete from book where id = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1,id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	try {
		return pstm.executeUpdate()>0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public Book queryById(int id) {
		Book book = new Book();
		try {
			conn=DBUtils.getConnection();
			String sql="select * from book where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			while(rs.next()) {
				int id2 = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				String imgUrl = rs.getString("imgUrl");
				String publish = rs.getString("publish");
				float price = rs.getFloat("price");
				book = new Book(id2, name, author, imgUrl, publish, price);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
}
