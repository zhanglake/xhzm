package com.xhzm.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.xhzm.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public void addUser(User user) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		session.save(user);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public void delUser(int userId) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		User u = new User(userId);
		session.delete(u);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@Override
	public User getUserByUserId(int userId) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		// load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException
		// get 如果查不到记录，返回的是一个null
		User user = (User) session.load(User.class, userId);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public boolean isExitByName(String userName) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		List user = (List) session.createQuery(
				"From User u where u.userName=:userName").setString("userName",
				userName).list();
		if (user.size() > 0) {
			try {
				tc.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
			return true;
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean isExitByNameAndPass(User user) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		List users = (List) session
				.createQuery(
						"From User u where u.userName=:userName and u.passWord=:passWord")
				.setString("userName", user.getUserName()).setString(
						"passWord", user.getPassWord()).list();

		if (users.size() > 0) {
			try {
				tc.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
			return true;
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<User> selectUser() {
		List<User> users = new ArrayList<User>();
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		List list = session.createQuery("From User").list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			User u = (User) iterator.next();
			users.add(u);
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	@Override
	public void updateUser(User user) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		session.update(user);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
