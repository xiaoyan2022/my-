package service;

import java.util.List;

import model.Cart;

public interface CartService {
	
	public List<Cart> queryAll();
	
	public List<Cart> queryByUid(int uid);
	
	public boolean add(Cart cart);
	
	public boolean update(boolean add,int id);
	
}
