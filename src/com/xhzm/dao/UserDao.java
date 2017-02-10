package com.xhzm.dao;

import java.util.List;

import com.xhzm.entity.User;

public interface UserDao {
	public void addUser(User user);

	public void delUser(int userId);

	public void updateUser(User user);

	public List<User> selectUser();

	public User getUserByUserId(int userId);

	public boolean isExitByName(String userName);

	public boolean isExitByNameAndPass(User user);
}
