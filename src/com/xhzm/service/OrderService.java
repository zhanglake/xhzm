package com.xhzm.service;

import java.util.List;

import com.xhzm.entity.Order;
import com.xhzm.entity.OrderDetail;

public interface OrderService {

	public List<Order> findAllOrderByCustomerId(int id);

	public List<OrderDetail> findOrderDetails(int id);

	public void saveOrder(int totalPrice, int orderCustomerId,
			String deliveryDate, String orderDescription);

	public int getNewOrderId();

	public void saveOrderDetail(List<String> lamp, List<String> price,
			List<String> number, List<String> description, int orderId);
}
