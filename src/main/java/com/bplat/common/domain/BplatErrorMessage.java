package com.bplat.common.domain;

public class BplatErrorMessage {
	
	private String code;
    private String message;
    private String errorTrace;
    
    public BplatErrorMessage(){}
    public BplatErrorMessage(String code,String message) {
        this.code = code;
        this.message = message;
    }
    public BplatErrorMessage(String code,String message,String errorTrace) {
        this.code = code;
        this.message = message;
        this.errorTrace = errorTrace;
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getErrorTrace() {
        return errorTrace;
    }
    public void setErrorTrace(String errorTrace) {
        this.errorTrace = errorTrace;
    }
}
