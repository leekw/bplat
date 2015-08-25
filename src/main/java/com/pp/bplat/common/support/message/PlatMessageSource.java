package com.pp.bplat.common.support.message;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import com.pp.bplat.common.support.util.Error;

public class PlatMessageSource {
	
	private static Logger logger = LoggerFactory.getLogger(PlatMessageSource.class);

	private static MessageSource messageSource;
	
	private enum Code {
	    DEFAULT_MESSAGE_DETAIL("PRM Application Error!");
        private String value;
        private Code(String value) { this.value = value;}
        private String getValue () { return this.value;}
    }
	
	public void setMessageSource(MessageSource messageSource) {
		PlatMessageSource.messageSource = messageSource;
	}


	public static String getMessage(String code) {
		return getMessage(code, null);
	}
	
	public static String getDefaultMessageCode() {
		return Error.E0000.getValue();
	}

	public static String getDefaultMessageDetail() {
		return Code.DEFAULT_MESSAGE_DETAIL.getValue();
	}

	public static String getMessage(String paramCode, Object messageParams) {
		String message = "";
		String code;
		if (paramCode == null || paramCode.length() == 0){
			code = Error.E0000.getValue();
		}else{
			code = paramCode;
		}
		try {
			message = messageSource.getMessage(code, (Object[])messageParams, Locale.KOREA);
		} catch (NoSuchMessageException nsme) {
			message = Code.DEFAULT_MESSAGE_DETAIL.getValue();
			logger.info("", nsme);
		} catch (Exception e) {
			message = Code.DEFAULT_MESSAGE_DETAIL.getValue();
			logger.info("", e);
		}
		return message;
	}

}
