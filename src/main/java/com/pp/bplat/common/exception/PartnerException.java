package com.pp.bplat.common.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pp.bplat.common.domain.PrmError;
import com.pp.bplat.common.support.analyzer.DataAnalyzer;
import com.pp.bplat.common.support.analyzer.DataAnalyzerFactory;
import com.pp.bplat.common.support.message.PlatMessageSource;
import com.pp.bplat.common.support.util.Error;

/**
 * PRM exception Implement class
 * <pre>
 * com.kt.prm.common.exception
 * PartnerException.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2012. 11. 7. 오후 2:54:27
 * @Version : 1.0
 */
public class PartnerException extends RuntimeException implements IPartnerException {

    private static final long serialVersionUID = 696744142250084047L;
	private boolean isWriteLog;
	private String code;
	private String message;
	private Object userObject;
	private DataAnalyzerFactory analyzerFactor;
	
	private static Log logger = LogFactory.getLog(PartnerException.class);
	
	public PartnerException(String code) {
		this(code, (Throwable) null);
	}
	
	public PartnerException(Throwable cause) {
		this(PlatMessageSource.getDefaultMessageCode(), cause);
	}
	
	public PartnerException(String code, Throwable cause) {
		super(cause);
		this.isWriteLog = false;
		this.setCode(code);
		this.message = PlatMessageSource.getMessage(this.code);
	}

	public PartnerException(String code, String message) {
		this.isWriteLog = false;
		this.setCode(code);
		this.message = message != null ? message : PlatMessageSource.getMessage(this.code);
	}

	public PartnerException(String code, Object messageParam) {
		this(code, (Object[])messageParam, null);
	}

	public PartnerException(String code, Object messageParams, Throwable cause) {
		super(cause);
		this.isWriteLog = false;
		this.setCode(code);

		this.message = PlatMessageSource.getMessage(this.code, messageParams);
	}

	public PartnerException(String code, String message, Throwable cause) {
		super(cause);
		this.isWriteLog = false;
		this.code = code != null ? code : PlatMessageSource.getDefaultMessageCode();

		this.message = message != null ? message : PlatMessageSource.getMessage(code);
	}
	
	private void setCode(String code) {
		this.code = code != null ? code : PlatMessageSource.getDefaultMessageCode();
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

    @Override
    public String getMessageByMetadata(String metadataType) throws Exception {
        
        String result = null;
        analyzerFactor = new DataAnalyzerFactory();
        try {
        	PrmError error = new PrmError(this.getCode(),this.getMessage());
    		this.setPrmErrorTrace(error);
        	if (metadataType != null) {
	            DataAnalyzer converter = analyzerFactor.getDataAnalyzer(metadataType);
	            result = converter.generate(Code.ERROR.getValue(), error);
        	} else {
        		StringBuffer sb = new StringBuffer();
        		sb.append("Error Code :").append(error.getCode()).append("\n");
        		sb.append("Error Message :").append(error.getMessage()).append("\n");
        		sb.append("Error Trace :").append(error.getErrorTrace());
        		result = sb.toString();
        	}
        }catch(Exception e) {
        	logger.debug(e.getStackTrace());
            throw new PartnerException(Error.E0001.getValue());
        }
        
        return result;
    }
    
    private PrmError setPrmErrorTrace(PrmError prmError) {
        
        Throwable throwable = super.getCause();
        if(throwable != null) {
            
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement element : throwable.getStackTrace()) {
                sb.append(element.toString()).append("\n");
            }
            prmError.setErrorTrace(sb.toString());
        }
        
        return prmError;
    }
    
    private enum Code {
        ERROR("error");
        private String value;
        private Code(String value) { this.value = value;}
        private String getValue () { return this.value;}
    }
}
