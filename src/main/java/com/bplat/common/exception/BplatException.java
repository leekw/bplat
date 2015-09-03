package com.bplat.common.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bplat.common.domain.BplatErrorMessage;
import com.bplat.common.support.analyzer.DataAnalyzer;
import com.bplat.common.support.analyzer.factory.DataAnalyzerFactory;
import com.bplat.common.support.constant.ErrorCode;
import com.bplat.common.support.message.BplatMessageSource;

public class BplatException extends RuntimeException implements IBplatException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -961032308022224434L;

	private static  Logger logger = LoggerFactory.getLogger(BplatException.class);
	
	private boolean isWriteLog;
	private String code;
	private String message;
	private Object userObject;
	private DataAnalyzerFactory analyzerFactor;
	
	public BplatException(String code) {
		this(code, (Throwable) null);
	}
	
	public BplatException(Throwable cause) {
		this(BplatMessageSource.getDefaultMessageCode(), cause);
	}
	
	public BplatException(String code, Throwable cause) {
		super(cause);
		this.isWriteLog = false;
		this.setCode(code);
		this.message = BplatMessageSource.getMessage(this.code);
	}

	public BplatException(String code, String message) {
		this.isWriteLog = false;
		this.setCode(code);
		this.message = message != null ? message : BplatMessageSource.getMessage(this.code);
	}

	public BplatException(String code, Object messageParam) {
		this(code, (Object[])messageParam, null);
	}

	public BplatException(String code, Object messageParams, Throwable cause) {
		super(cause);
		this.isWriteLog = false;
		this.setCode(code);

		this.message = BplatMessageSource.getMessage(this.code, messageParams);
	}

	public BplatException(String code, String message, Throwable cause) {
		super(cause);
		this.isWriteLog = false;
		this.code = code != null ? code : BplatMessageSource.getDefaultMessageCode();

		this.message = message != null ? message : BplatMessageSource.getMessage(code);
	}
	
	private void setCode(String code) {
		this.code = code != null ? code : BplatMessageSource.getDefaultMessageCode();
	}

	public String getCode() {
		return this.code;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

	public boolean isWriteLog() {
		return this.isWriteLog;
	}

	public void setWriteLog(boolean isWriteLog) {
		this.isWriteLog = isWriteLog;
	}

	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}
	
	public Object getUserObject() {
		return this.userObject;
	}
 
	@Override
	public void printStackTrace(PrintStream ps) {
		if (getCause() == null) {
			super.printStackTrace(ps);
		} else {
			getCause().printStackTrace(ps);
		}
	}

	@Override
	public void printStackTrace(PrintWriter pw) {
		if (getCause() == null) {
			super.printStackTrace(pw);
		} else {
			getCause().printStackTrace(pw);
		}
	}

    public String getMessageByMetadata(String metadataType) throws Exception {
        String result = null;
        analyzerFactor = new DataAnalyzerFactory();
        try {
        	BplatErrorMessage error = new BplatErrorMessage(this.getCode(),this.getMessage());
    		this.setErrorTrace(error);
        	if (metadataType != null) {
	            DataAnalyzer converter = analyzerFactor.getDataAnalyzer(metadataType);
	            result = converter.deserialize("error", error);
        	} else {
        		StringBuffer sb = new StringBuffer();
        		sb.append("Error Code :").append(error.getCode()).append("\n");
        		sb.append("Error Message :").append(error.getMessage()).append("\n");
        		sb.append("Error Trace :").append(error.getErrorTrace());
        		result = sb.toString();
        	}
        }catch(Exception e) {
            throw new BplatException(ErrorCode.SYSTEM_ERROR.getValue());
        }
        
        return result;
    }
    
    private BplatErrorMessage setErrorTrace(BplatErrorMessage errorMessage) {
        
        Throwable throwable = super.getCause();
        if(throwable != null) {
            
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement element : throwable.getStackTrace()) {
                sb.append(element.toString()).append("\n");
            }
            errorMessage.setErrorTrace(sb.toString());
        }
        
        return errorMessage;
    }
	
}
