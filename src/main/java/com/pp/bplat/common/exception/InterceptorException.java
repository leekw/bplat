package com.pp.bplat.common.exception;

public class InterceptorException extends PartnerException {

    private static final long serialVersionUID = -1302293895818379401L;

    public InterceptorException(String code) {
		super(code);
	}
    
    public InterceptorException(String code, Object message) {
    	super(code, message);
    }
	
}
