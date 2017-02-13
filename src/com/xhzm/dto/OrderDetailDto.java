package com.xhzm.dto;

public class OrderDetailDto {
	
	private String lampName;
	private Double lampPrice;
	private Integer lampNumber;
	private String lampDesc;
	
	public String getLampName() {
		return lampName;
	}
	public void setLampName(String lampName) {
		this.lampName = lampName;
	}
	public Double getLampPrice() {
		return lampPrice;
	}
	public void setLampPrice(Double lampPrice) {
		this.lampPrice = lampPrice;
	}
	public Integer getLampNumber() {
		return lampNumber;
	}
	public void setLampNumber(Integer lampNumber) {
		this.lampNumber = lampNumber;
	}
	public String getLampDesc() {
		return lampDesc;
	}
	public void setLampDesc(String lampDesc) {
		this.lampDesc = lampDesc;
	}
	
}
