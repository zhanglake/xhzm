package com.xhzm.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.xhzm.dto.OrderCreateRequestDto;
import com.xhzm.dto.OrderDetailDto;
import com.xhzm.dto.ResponseResult;
import com.xhzm.entity.Order;
import com.xhzm.entity.OrderDetail;
import com.xhzm.service.OrderService;

@Action(value = "orderAction", results = { @Result(name = "loginSuccess", location = "/loginSuss.jsp") })
public class OrderAction {
	private static final long serialVersionUID = 1L;

	@Resource
	private OrderService orderService;

	private String orderReq;
	public String getOrderReq() { return orderReq; }
	public void setOrderReq(String orderReq) { this.orderReq = orderReq; }

	// 新增订单和订单详情
	public void createOrderAndOrderDetail() throws IOException {
		OrderCreateRequestDto orderDto = this.builldOrderRequestFromJson(orderReq);
		
		Integer customerId = orderDto.getCustomerId();
		String deliveryDate = orderDto.getDeliveryDate();
		if (null == deliveryDate) {
			deliveryDate = "";
		}
		List<OrderDetailDto> orderDetailDtos = orderDto.getOrderDetail();
		
		Double totalPrice = 0d;
		for (OrderDetailDto dto : orderDetailDtos) {
			totalPrice += (double) dto.getLampPrice() * (double) dto.getLampNumber();
		}
		orderService.saveOrder(totalPrice, customerId, deliveryDate, "");
		Integer orderId = orderService.getNewOrderId();
		
		orderService.createOrderDetails(orderDetailDtos, orderId);
		
		ResponseResult result = new ResponseResult(200, "success");
		JSONObject jsonObj = JSONObject.fromObject(result);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonObj);
	}
	
	private OrderCreateRequestDto builldOrderRequestFromJson (String jsonString) {
		OrderCreateRequestDto orderCreateRequestDto = new OrderCreateRequestDto();
		
		// 解析json字符串
		JSONObject jsonObject = JSONObject.fromObject(orderReq);
		Integer customerId = jsonObject.getInt("customerId");
		String deliveryDate = jsonObject.getString("deliveryDate");
		
		JSONArray orderDetailListArray = JSONArray.fromObject(jsonObject.get("orderDetail")); 
		
		List<OrderDetailDto> orderDetailDtos = new ArrayList<OrderDetailDto>();
		for (int i = 0;i < orderDetailListArray.size(); i ++) {
			OrderDetailDto dto = new OrderDetailDto();
			JSONObject orderDetailObj = orderDetailListArray.getJSONObject(i);
			String lampName = orderDetailObj.getString("lampName");
			Double lampPrice = orderDetailObj.getDouble("lampPrice");
			Integer lampNumber = orderDetailObj.getInt("lampNumber");
			String lampDesc = orderDetailObj.getString("lampDesc");
			dto.setLampName(lampName);
			dto.setLampPrice(lampPrice);
			dto.setLampNumber(lampNumber);
			dto.setLampDesc(lampDesc);
			orderDetailDtos.add(dto);
		}
		orderCreateRequestDto.setCustomerId(customerId);
		orderCreateRequestDto.setDeliveryDate(deliveryDate);
		orderCreateRequestDto.setOrderDetail(orderDetailDtos);
		
		return orderCreateRequestDto;
	}

}
