package com.xhzm.action;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xhzm.dto.CustomerCreateRequestDto;
import com.xhzm.dto.ResponseResult;
import com.xhzm.entity.Order;
import com.xhzm.entity.OrderDetail;
import com.xhzm.service.CustomerService;
import com.xhzm.service.OrderService;

@Action(value = "customerAction", results = {
		@Result(name = "showOrder", location = "/showOrder.jsp"),
		@Result(name = "showDetails", location = "/showOrderDetails.jsp"),
		@Result(name = "loginSuccess", location = "/loginSuss.jsp") })
public class CustomerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Resource
	private OrderService orderService;

	@Resource
	private CustomerService customerService;

	private CustomerCreateRequestDto customerDto;

	private int customerId;

	private int orderId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public CustomerCreateRequestDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerCreateRequestDto customerDto) {
		this.customerDto = customerDto;
	}

	public String showOrder() {
		List<Order> orders = orderService.findAllOrderByCustomerId(customerId);
		ActionContext ct = ActionContext.getContext();
		ct.put("orders", orders);
		return "showOrder";
	}

	public String showOrderDetails() {
		List<OrderDetail> orderDetails = orderService.findOrderDetails(orderId);
		ActionContext ct = ActionContext.getContext();
		ct.put("orderLamps", orderDetails);
		return "showDetails";
	}

	public void addCustomer() throws IOException {
		customerService.saveCustomer(customerDto);
		
		ResponseResult result = new ResponseResult(200, SUCCESS);
		JSONObject jsonObj = JSONObject.fromObject(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonObj);
	}
}
