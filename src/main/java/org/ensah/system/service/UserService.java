package org.ensah.system.service;

import java.util.List;

import org.ensah.system.beans.User;

public interface UserService {
	
	public void saveUser(User user);

	public User loginUser(User user);
	
	public User getUser(int userId);
	
	public List<User> getAllUser();

}
