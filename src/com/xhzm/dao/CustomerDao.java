package com.xhzm.dao;

import java.util.List;

import com.xhzm.dto.CustomerCreateRequestDto;
import com.xhzm.entity.Customer;

public interface CustomerDao {
	
	public List<Customer> findAll();

	public List<Customer> queryCustomer(Customer customer);
	
	public void saveCustomer(CustomerCreateRequestDto dto);
}
