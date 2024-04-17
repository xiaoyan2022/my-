package service;

import java.util.List;

import model.Book;

public interface BookService {
	
	public List<Book> queryAll();
	
	public Book queryAllById(int id);
	
	public boolean add(Book book);
	
	public boolean update(Book book);
	
	public boolean del(int id);
}
