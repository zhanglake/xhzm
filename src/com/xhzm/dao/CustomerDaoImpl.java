package com.xhzm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xhzm.dto.CustomerCreateRequestDto;
import com.xhzm.entity.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends BaseDao implements CustomerDao {

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = new ArrayList<Customer>();
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		Query query = session.createQuery("from Customer");
		List list = query.list();
		for (Object o : list) {
			Customer c = (Customer) o;
			customers.add(c);
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customers;
	}

	@Override
	public List<Customer> queryCustomer(Customer customer) {
		List<Customer> customers = new ArrayList<Customer>();
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		String hql = "from Customer as c where";
		if (!customer.getName().isEmpty()) {
			hql += " c.name like '%" + customer.getName() + "%' and";
		}
		if (!customer.getAddress().isEmpty()) {
			hql += " c.address like '%" + customer.getAddress() + "%' and";
		} else {
		}
		if (!customer.getPhone().isEmpty()) {
			hql += " c.phone like '%" + customer.getPhone() + "%' and";
		}
		if (!customer.getTelephone().isEmpty()) {
			hql += " c.telephone like '%" + customer.getTelephone() + "%' and";
		}
		hql += " 1=1";
		Query query = session.createQuery(hql);
		List list = query.list();
		for (Object o : list) {
			Customer c = (Customer) o;
			customers.add(c);
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customers;
	}
	
	public void saveCustomer(CustomerCreateRequestDto dto){
		String address = dto.getAddress();
		String name = dto.getName();
		String phone = dto.getPhone();
		String tel = dto.getTelephone();
		
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		
		String sql = "insert into customer (address, name, phone, telephone) values (?,?,?,?)";
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, address);
		query.setParameter(1, name);
		query.setParameter(2, phone);
		query.setParameter(3, tel);
		query.executeUpdate();

		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
