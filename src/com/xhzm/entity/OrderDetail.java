package com.xhzm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

	@Id
	@Column(name = "order_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderLapmId;

	@Column(name = "lamp")
	private String lamp;

	@Column(name = "number")
	private int number;

	@Column(name = "price")
	private double price;

	@Column(name = "description")
	private String description;

	@Column(name = "order_id")
	private int orderId;

	public String getLamp() {
		return lamp;
	}

	public void setLamp(String lamp) {
		this.lamp = lamp;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderLapmId() {
		return orderLapmId;
	}

	public void setOrderLapmId(int orderLapmId) {
		this.orderLapmId = orderLapmId;
	}
}
