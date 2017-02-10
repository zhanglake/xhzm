package com.xhzm.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xhzm.entity.Customer;
import com.xhzm.entity.User;
import com.xhzm.service.CustomerService;
import com.xhzm.service.UserService;

@Action(value = "loginAction", results = {
		@Result(name = "loginSuccess", location = "/main.jsp"),
		@Result(name = "loginFailer", location = "/loginFailer.jsp") })
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Resource
	private UserService userService;

	@Resource
	private CustomerService customerService;

	private User user;

	private Customer customer;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String login() {
		boolean flag = userService.isExitByNameAndPass(user);
		if (flag) {
			List<Customer> customers = customerService.findAllCustomers();
			ActionContext ct = ActionContext.getContext();
			ct.put("customers", customers);
			return "loginSuccess";
		}
		return "loginFailer";
	}

	public String queryCustomer() {
		List<Customer> customers = customerService.queryCustomers(customer);
		ActionContext ct = ActionContext.getContext();
		ct.put("customers", customers);
		return "loginSuccess";
	}
}
