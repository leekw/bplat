package com.bplat.common.support.message;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import com.bplat.common.support.constant.ErrorCode;

public class BplatMessageSource {
	private static  Logger logger = LoggerFactory.getLogger(BplatMessageSource.class);
	private static MessageSource messageSource;
	
	private enum Code {
	    DEFAULT_MESSAGE_DETAIL("PRM Application Error!");
        private String value;
        private Code(String value) { this.value = value;}
        private String getValue () { return this.value;}
    }
	
	public void setMessageSource(MessageSource messageSource) {
		BplatMessageSource.messageSource = messageSource;
	}


	public static String getMessage(String code) {
		return getMessage(code, null);
	}
	
	public static String getDefaultMessageCode() {
		return ErrorCode.SYSTEM_ERROR.getValue();
	}

	public static String getDefaultMessageDetail() {
		return Code.DEFAULT_MESSAGE_DETAIL.getValue();
	}

	public static String getMessage(String paramCode, Object messageParams) {
		String message = "";
		String code;
		if (paramCode == null || paramCode.length() == 0){
			code = ErrorCode.SYSTEM_ERROR.getValue();
		}else{
			code = paramCode;
		}
		try {
			message = messageSource.getMessage(code, (Object[])messageParams, Locale.KOREA);
		} catch (NoSuchMessageException nsme) {
			message = Code.DEFAULT_MESSAGE_DETAIL.getValue();
			logger.error(null, nsme);
		} catch (Exception e) {
			message = Code.DEFAULT_MESSAGE_DETAIL.getValue();
			logger.error(null, e);
		}
		return message;
	}
}
