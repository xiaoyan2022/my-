package serviceImpl;

import java.util.List;

import daoImpl.BookDaoImpl;
import model.Book;
import service.BookService;

public class BookServiceImpl implements BookService{
	
	@Override
	public List<Book> queryAll(){
		
		return new BookDaoImpl().queryAll();
	}

	@Override
	public boolean add(Book book) {
		
		return new BookDaoImpl().add(book);
	}

	@Override
	public boolean update(Book book) {
		// TODO Auto-generated method stub
		return new BookDaoImpl().update(book);
	}

	@Override
	public boolean del(int id) {
		
		return new BookDaoImpl().del(id);
	}

	@Override
	public Book queryAllById(int id) {
		// TODO Auto-generated method stub
		return new BookDaoImpl().queryById(id);
	}

}
