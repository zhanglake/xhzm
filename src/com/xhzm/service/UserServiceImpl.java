package com.xhzm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xhzm.dao.UserDao;
import com.xhzm.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public void del(int userId) {
		userDao.delUser(userId);
	}

	@Override
	public User getUserById(int userId) {
		return userDao.getUserByUserId(userId);
	}

	@Override
	public List<User> getUsers() {
		List<User> users = userDao.selectUser();
		return users;
	}

	@Override
	public boolean isExitByNameAndPass(User user) {
		return userDao.isExitByNameAndPass(user);
	}

	@Override
	public boolean isExitUser(String userName) {
		return userDao.isExitByName(userName);
	}

	@Override
	public void save(User user) {
		userDao.addUser(user);
	}

	@Override
	public void update(User user) {
		userDao.updateUser(user);
	}

}
