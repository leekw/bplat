package com.bplat.common.support.constant;

public enum ErrorCode {
	SYSTEM_ERROR("ERROR.0000");
	private String value;
	private ErrorCode(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public boolean isMatch(String compare) {
		return value.equals(compare);
	}
}
