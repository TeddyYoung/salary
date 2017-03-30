package com.fh.common.exception;

public class BizException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	private String msg;
	
	public static final String EXTERNAL = "EXTERNAL";

	public BizException() {
	} // 用来创建无参数对象

	public BizException(String message) { // 用来创建指定参数对象
		super(message); // 调用超类构造器
		this.msg = message;

	}

	public BizException(String code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
