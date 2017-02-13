package com.xhzm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xhzm.dao.OrderDao;
import com.xhzm.dto.OrderDetailDto;
import com.xhzm.entity.Order;
import com.xhzm.entity.OrderDetail;

@Service
public class OrderServiceImpl implements OrderService {

	@Resource
	private OrderDao orderDao;

	@Override
	public List<Order> findAllOrderByCustomerId(int id) {
		return orderDao.findAllOrderByCustomerId(id);
	}

	@Override
	public List<OrderDetail> findOrderDetails(int id) {
		return orderDao.findOrderDetails(id);
	}

	@Override
	public void saveOrder(Double totalPrice, int orderCustomerId,
			String deliveryDate, String orderDescription) {
		System.out.println(totalPrice + "," + orderCustomerId + "," + deliveryDate + "," + orderDescription);
		orderDao.saveOrder(totalPrice, orderCustomerId, deliveryDate,
				orderDescription);
	}

	@Override
	public int getNewOrderId() {
		return orderDao.getNewOrderId();
	}

	@Override
	public void saveOrderDetail(List<String> lamp, List<String> price,
			List<String> number, List<String> description, int orderId) {
		orderDao.saveOrderDetail(lamp, price, number, description, orderId);
	}

	@Override
	public void createOrderDetails(List<OrderDetailDto> orderDetailDtos, int orderId) {
		orderDao.createOrderDetails(orderDetailDtos, orderId);
	}
}
