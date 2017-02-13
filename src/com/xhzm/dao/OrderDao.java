package com.xhzm.dao;

import java.util.List;

import com.xhzm.dto.OrderDetailDto;
import com.xhzm.entity.Order;
import com.xhzm.entity.OrderDetail;

public interface OrderDao {

	public List<Order> findAllOrderByCustomerId(int id);

	public List<OrderDetail> findOrderDetails(int orderId);

	public void saveOrder(Double totalPrice, int orderCustomerId,
			String deliveryDate, String orderDescription);

	public int getNewOrderId();

	public void saveOrderDetail(List<String> lamp, List<String> price,
			List<String> number, List<String> description, int orderId);
	
	public void createOrderDetails(List<OrderDetailDto> orderDetailDtos, int orderId);
}
