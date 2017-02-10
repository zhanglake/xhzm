package com.xhzm.service;

import java.util.List;

import com.xhzm.dto.CustomerCreateRequestDto;
import com.xhzm.entity.Customer;

public interface CustomerService {

	public List<Customer> findAllCustomers();

	public List<Customer> queryCustomers(Customer customer);
	
	public void saveCustomer(CustomerCreateRequestDto dto);
}
