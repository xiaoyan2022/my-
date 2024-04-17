package dao;

import java.util.List;

import model.Cart;

public interface CartDao {
	
	public List<Cart> queryAll();
	
	public List<Cart> queryByUid(int uid);
	
	public int getNumById(int id);
	
	public boolean add(Cart cart);
	
	public boolean del(int id);
	
	public boolean update(boolean add,int id);
	
	public int total(int uid);
	
}
