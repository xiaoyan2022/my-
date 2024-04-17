package serviceImpl;

import java.util.List;

import daoImpl.CartDaoImpl;
import model.Cart;
import service.CartService;

public class CartServiceImpl implements CartService{

	@Override
	public List<Cart> queryAll() {
		
		return new CartDaoImpl().queryAll();
	}

	@Override
	public List<Cart> queryByUid(int uid) {
		
		return new CartDaoImpl().queryByUid(uid);
	}

	@Override
	public boolean add(Cart cart) {
		
	return new CartDaoImpl().add(cart);
	}

	@Override
	public boolean update(boolean add, int id) {
		
	return new CartDaoImpl().update(add, id);
	}
}
