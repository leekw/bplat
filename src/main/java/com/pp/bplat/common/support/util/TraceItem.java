package com.pp.bplat.common.support.util;

import com.pp.bplat.common.domain.ExceptionTraceBean;

/**
 * Exception traceItem
 * @author sslee
 *
 */
public interface TraceItem {
	
	long getTraceKeyId();
	String getTraceKeyType();
	void setExceptionTraceBean(ExceptionTraceBean exceptionTraceBean);
	ExceptionTraceBean getExceptionTraceBean();
}
