package com.xhzm.service;

import java.util.List;

import com.xhzm.entity.User;

public interface UserService {

	public boolean isExitUser(String userName);

	public boolean isExitByNameAndPass(User user);

	public void save(User user);

	public List<User> getUsers();

	public void del(int userId);

	public void update(User user);

	public User getUserById(int userId);
}
