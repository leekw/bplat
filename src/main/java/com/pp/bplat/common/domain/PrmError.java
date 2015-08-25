package com.pp.bplat.common.domain;

/**
 * Error 
 * <pre>
 * com.kt.prm.common.domain
 * Error.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2012. 11. 7. 오후 3:39:25
 * @Version : 1.0
 */
public class PrmError {
    
    private String code;
    private String message;
    private String errorTrace;
    
    public PrmError(){}
    public PrmError(String code,String message) {
        this.code = code;
        this.message = message;
    }
    public PrmError(String code,String message,String errorTrace) {
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
