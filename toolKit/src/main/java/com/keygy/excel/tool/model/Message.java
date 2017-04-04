package com.keygy.excel.tool.model;

public class Message {
	private String code;
	private String msg;
	public Message(String code,String msg) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
