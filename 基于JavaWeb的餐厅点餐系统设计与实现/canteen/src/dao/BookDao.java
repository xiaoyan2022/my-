package dao;

import java.util.List;

import model.Book;

public interface BookDao {
	
	public List<Book> queryAll();
	
	public Book queryById(int id);
	
	public boolean add(Book book);
	
	public boolean update(Book book);
	
	public boolean del(int id);

	

}
