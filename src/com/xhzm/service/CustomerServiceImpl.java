package com.xhzm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xhzm.dao.CustomerDao;
import com.xhzm.dto.CustomerCreateRequestDto;
import com.xhzm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerDao customerDao;

	@Override
	public List<Customer> findAllCustomers() {
		return customerDao.findAll();
	}

	@Override
	public List<Customer> queryCustomers(Customer customer) {
		return customerDao.queryCustomer(customer);
	}
	
	public void saveCustomer(CustomerCreateRequestDto dto){
		customerDao.saveCustomer(dto);
	}

}
