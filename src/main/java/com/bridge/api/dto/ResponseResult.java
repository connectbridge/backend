package com.bridge.api.dto;

import java.sql.Date;
import java.sql.Time;

import io.swagger.annotations.ApiModelProperty;

public class ResponseResult {
	@ApiModelProperty(value="status")
	private int status = 200;

	@ApiModelProperty(value="message")
	private String message;

	@ApiModelProperty(value="성공여부")
	private boolean check = true;

	@ApiModelProperty(value="date")
	private Date date = new Date(System.currentTimeMillis());

	@ApiModelProperty(value="time")
	private Time time = new Time(System.currentTimeMillis());

	@ApiModelProperty(value="result")
	private Object result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ResponseResult [status=" + status + ", message=" + message + ", check=" + check + ", result=" + result
				+ "]";
	}
}
