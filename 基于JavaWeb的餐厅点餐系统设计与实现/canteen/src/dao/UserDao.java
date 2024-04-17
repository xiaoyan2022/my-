package dao;

import java.util.List;

import model.User;

public interface UserDao {
	
	public List<User> queryAll();
	
	public User queryByName(String name);
	
	public boolean login(User user);
	
	public boolean register(User user);
	
	public boolean update(User user);
	
	public boolean password(User user);
	
}
