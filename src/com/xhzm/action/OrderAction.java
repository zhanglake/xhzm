package com.xhzm.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.xhzm.entity.Order;
import com.xhzm.entity.OrderDetail;
import com.xhzm.service.OrderService;

@Action(value = "orderAction", results = { @Result(name = "loginSuccess", location = "/loginSuss.jsp") })
public class OrderAction {
	private static final long serialVersionUID = 1L;

	@Resource
	private OrderService orderService;

	private List<String> lamp;
	private List<String> price;
	private List<String> number;
	private List<String> description;
	private int orderCustomerId;
	private String orderDescription;
	private String deliveryDate;

	public void addOrder() {
		int totalPrice = 0;
		for (String p : price) {
			totalPrice += Integer.parseInt(p);
		}
		orderService.saveOrder(totalPrice, orderCustomerId, deliveryDate,
				orderDescription);

		int orderId = orderService.getNewOrderId();

		orderService.saveOrderDetail(lamp, price, number, description, orderId);
	}

	public List<String> getLamp() {
		return lamp;
	}

	public void setLamp(List<String> lamp) {
		this.lamp = lamp;
	}

	public List<String> getPrice() {
		return price;
	}

	public void setPrice(List<String> price) {
		this.price = price;
	}

	public List<String> getNumber() {
		return number;
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

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public int getOrderCustomerId() {
		return orderCustomerId;
	}

	public void setOrderCustomerId(int orderCustomerId) {
		this.orderCustomerId = orderCustomerId;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}
