
package org.ensah.system.service.impl;

import java.util.List;

import org.ensah.system.beans.User;
import org.ensah.system.dao.UserDao;
import org.ensah.system.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void saveUser(User user) {
		
		userDao.saveUser(user);

	}

	public User loginUser(User user) {
		
		return userDao.loginUser(user);
	}

	@Override
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

}
