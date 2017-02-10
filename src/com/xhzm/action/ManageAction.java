package com.xhzm.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.json.annotations.JSON;

import com.xhzm.entity.Customer;
import com.xhzm.entity.Order;
import com.xhzm.entity.OrderDetail;
import com.xhzm.service.CustomerService;
import com.xhzm.service.OrderService;

@Action(value = "manage")
public class ManageAction {
	private static final long serialVersionUID = 1L;

	@Resource
	private CustomerService customerService;
	@Resource
	private OrderService orderService;

	private int customerId;
	private int orderId;
	private String customerName;
	private String deliveryDate;
	private String orderDescription;
	private List<String> lamp;
//	private List<String> price;
	private List<String> number;
	private List<String> description;
	private String[] price;

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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public List<String> getLamp() {
		return lamp;
	}

	public void setLamp(List<String> lamp) {
		this.lamp = lamp;
	}

//	public List<String> getPrice() {
//		return price;
//	}
//
//	public void setPrice(List<String> price) {
//		this.price = price;
//	}

	public List<String> getNumber() {
		return number;
	}

	public String[] getPrice() {
		return price;
	}

	public void setPrice(String[] price) {
		this.price = price;
	}

	public void setNumber(List<String> number) {
		this.number = number;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	/**
	 * 查询所有的客户
	 */
	public void findAllCustomers() {
		List<Customer> customerList = customerService.findAllCustomers();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		try {
			JSONArray jsonArray = JSONArray.fromObject(customerList);
			response.getWriter().print(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据指定客户的所有订单
	 */
	public void showOrderByCustomer() {
		List<Order> o = orderService.findAllOrderByCustomerId(customerId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		try {
			JSONArray jsonArray = JSONArray.fromObject(o);
			response.getWriter().print(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据订单查找订单详情
	 */
	public void showOrderDetailBuOrderId() {
		System.out.println(orderId);
		List<OrderDetail> od = orderService.findOrderDetails(orderId);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/plain;charset=UTF-8");
		try {
			JSONArray jsonArray = JSONArray.fromObject(od);
			response.getWriter().print(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 先添加总订单
	 */
	public void addOrder() {
		System.out.println(customerId);
		System.out.println(orderDescription);
		System.out.println(price);
//		int totalPrice = 0;
//		for (String p : price) {
//			totalPrice += Integer.parseInt(p);
//		}
//		System.out.println(totalPrice);
//		orderService.saveOrder(totalPrice, customerId, orderDescription);
	}
	
	/**
	 * 添加订单详情
	 */
	public void addOrderDetail() {
//		int newOrderId = orderService.getNewOrderId();
		
//		orderService.saveOrderDetail(lamp, price, number, description, newOrderId);
	}

}
