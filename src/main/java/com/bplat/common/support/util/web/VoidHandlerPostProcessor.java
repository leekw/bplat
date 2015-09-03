package com.bplat.common.support.util.web;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

/**
 * handler void method 시 처리 
 * <pre>
 * com.jios.common.support.util.web
 * VoidHandlerPostProcessor.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2014. 1. 16. 오후 1:51:37
 * @Version : 1.0
 */
@Component("voidHandlerPostProcessor")
public class VoidHandlerPostProcessor implements HandlerPostProcessor {
	
	@Autowired @Qualifier("modelAndViewHandlerPostProcessor")
	private HandlerPostProcessor modelAndViewHandlerPostProcessor;

	@Override
	public boolean isSupply(Object returnValue, Method handlerMethod,Object handler,ModelAndView modelAndViewParam) {
		return (returnValue == null);
	}

	@Override
	public ModelAndView process(Object returnValue, Method handlerMethod,Object handler,ModelAndView modelAndViewParam) {
		
		if(modelAndViewParam != null) return modelAndViewHandlerPostProcessor.process(modelAndViewParam, handlerMethod, handler, modelAndViewParam);
		else return new ModelAndView();
	}

}
