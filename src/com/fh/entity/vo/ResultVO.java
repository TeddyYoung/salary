package com.fh.entity.vo;

public class ResultVO {
	private int success;
	
	private int fail;
	
	private String failMes;

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

	public int getFail() {
		return fail;
	}

	public void setFail(int fail) {
		this.fail = fail;
	}

	public String getFailMes() {
		return failMes;
	}

	public void setFailMes(String failMes) {
		this.failMes = failMes;
	}
}
