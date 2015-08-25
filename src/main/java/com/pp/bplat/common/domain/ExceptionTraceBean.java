package com.pp.bplat.common.domain;

import com.pp.bplat.common.support.util.Constant;

/**
 * ExceptionTrace db domain
 * @author sslee
 *
 */
public class ExceptionTraceBean {
	
	private long traceId;
	private String keyType;
	private long traceKeyId;
	private long eventUnitId;
    private long springJobInstanceId;
	private long springJobExecutionId;
	private String springJobName;
	private String trace;
	private String settlementYm;
	
    public ExceptionTraceBean(String settlementYm,String keyType,long traceKeyId,long eventUnitId,Exception e) {
		
	    this.settlementYm = settlementYm;
		this.keyType = keyType;
		this.traceKeyId = traceKeyId;
		this.eventUnitId = eventUnitId;
		
		StackTraceElement[] els = e.getStackTrace();
		
		if(els != null) {
			StringBuilder sb = new StringBuilder();
			
			for(StackTraceElement el : els) {
				sb.append(el.toString()).append(Constant.System.RETURN_KEY.getValue());
			}
			
			this.trace = sb.toString();
		}
	}
	
	public ExceptionTraceBean(String settlementYm,String keyType,long traceKeyId,long eventUnitId,String userTrace,Exception e) {
		
	    this.settlementYm = settlementYm;
		this.keyType = keyType;
		this.traceKeyId = traceKeyId;
		this.eventUnitId = eventUnitId;
		
		if(userTrace != null) this.trace = userTrace;
		
		StackTraceElement[] els = e.getStackTrace();
		if(els != null) {
			
			StringBuilder sb = new StringBuilder();
			if(this.trace != null) sb.append(this.trace).append(Constant.System.RETURN_KEY.getValue());
			for(StackTraceElement el : els) {
				sb.append(el.toString()).append(Constant.System.RETURN_KEY.getValue());
			}
			
			this.trace = sb.toString();
		}
		
	}
	
	public ExceptionTraceBean(String settlementYm,String keyType,long traceKeyId,long eventUnitId,String userTrace,Exception e,long springJobInstanceId,long springJobExecutionId,String springJobName) 
	{
	    this.settlementYm = settlementYm;
		this.keyType = keyType;
		this.traceKeyId = traceKeyId;
		this.eventUnitId = eventUnitId;
		this.springJobInstanceId = springJobInstanceId;
		this.springJobExecutionId = springJobExecutionId;
		this.springJobName = springJobName;
		
		if(userTrace != null) this.trace = userTrace;
		
		StackTraceElement[] els = e.getStackTrace();
		if(els != null) {
			
			StringBuilder sb = new StringBuilder();
			if(this.trace != null) sb.append(this.trace).append(Constant.System.RETURN_KEY.getValue());
			for(StackTraceElement el : els) {
				sb.append(el.toString()).append(Constant.System.RETURN_KEY.getValue());
			}
			
			this.trace = sb.toString();
		}
		
	}
	
	public long getTraceId() {
		return traceId;
	}
	public void setTraceId(long traceId) {
		this.traceId = traceId;
	}
	public String getKeyType() {
		return keyType;
	}
	public void setKeyType(String keyType) {
		this.keyType = keyType;
	}
	public long getTraceKeyId() {
		return traceKeyId;
	}
	public void setTraceKeyId(long traceKeyId) {
		this.traceKeyId = traceKeyId;
	}
	public long getSpringJobInstanceId() {
		return springJobInstanceId;
	}
	public void setSpringJobInstanceId(long springJobInstanceId) {
		this.springJobInstanceId = springJobInstanceId;
	}
	public long getSpringJobExecutionId() {
		return springJobExecutionId;
	}
	public void setSpringJobExecutionId(long springJobExecutionId) {
		this.springJobExecutionId = springJobExecutionId;
	}
	public String getSpringJobName() {
        return springJobName;
    }

    public void setSpringJobName(String springJobName) {
        this.springJobName = springJobName;
    }
    public String getSettlementYm() {
        return settlementYm;
    }
    public void setSettlementYm(String settlementYm) {
        this.settlementYm = settlementYm;
    }
    public String getTrace() {
		return trace;
	}
	public void setTrace(String trace) {
		this.trace = trace;
	}
	public long getEventUnitId() {
        return eventUnitId;
    }
    public void setEventUnitId(long eventUnitId) {
        this.eventUnitId = eventUnitId;
    }

}
