package com.xhzm.dto;

import java.util.List;

public class OrderCreateRequestDto {
	
	private int customerId;
	private String deliveryDate;
	private List<OrderDetailDto> orderDetail;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<OrderDetailDto> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetailDto> orderDetail) {
		this.orderDetail = orderDetail;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
