package com.bike.admin.enums;

public enum AdminUserStatusEnum {

	NORMAL(0),
	FORBIDDEN(1),
	DELETED(-100);
	
	private int code;
	
	private AdminUserStatusEnum(int code){
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
