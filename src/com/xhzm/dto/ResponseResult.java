package com.xhzm.dto;

public class ResponseResult {
	private Integer code;
	private String status;
	private Object data;
	private String description;

	public ResponseResult() {
		super();
	}

	public ResponseResult(Integer code, String status, Object data) {
		super();
		this.code = code;
		this.status = status;
		this.data = data;
	}

	public ResponseResult(Integer code, String status) {
		super();
		this.code = code;
		this.status = status;
	}

	public ResponseResult(Integer code, String status, Object data,
			String description) {
		super();
		this.code = code;
		this.status = status;
		this.data = data;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
