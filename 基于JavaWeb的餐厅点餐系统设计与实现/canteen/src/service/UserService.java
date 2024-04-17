package service;

import java.util.List;

import model.User;

public interface UserService {
	
	public List<User> queryAll();
	
	public User queryByName(String name);
	
	public boolean login(User user);
	
	public boolean register(User user);
	
}
