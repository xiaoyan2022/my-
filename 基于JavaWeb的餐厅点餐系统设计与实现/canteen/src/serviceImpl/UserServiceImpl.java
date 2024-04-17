package serviceImpl;

import java.util.List;

import daoImpl.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public List<User> queryAll() {
		
		return new UserDaoImpl().queryAll();
	}

	@Override
	public User queryByName(String name) {
		
		return new UserDaoImpl().queryByName(name);
	}

	@Override
	public boolean login(User user) {
		
		return new UserDaoImpl().login(user);
	}

	@Override
	public boolean register(User user) {
		
		return new UserDaoImpl().register(user);
	}

}
