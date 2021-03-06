package com.bplat.common.support.util.web;

import java.lang.reflect.Method;

import org.springframework.web.servlet.ModelAndView;

/**
 * AsynAnnotationHandlerAdaptor 처리후 servletDispatcher에게 ModelAndView </br> 
 * 값을 setting 하여 전송해준다 
 * <pre>
 * com.jios.common.support.util.web
 * HandlerPostProcessor.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2014. 1. 16. 오전 10:36:12
 * @Version : 1.0
 */
public interface HandlerPostProcessor {
	
	/**
	 * 
	 * @param returnValue Handler의 return value
	 * @param handlerMethod handler의 method
	 * @param handler handler object
	 * @param modelAndView modelAndView or null
	 * @return
	 */
	boolean isSupply(Object returnValue,Method handlerMethod,Object handler,ModelAndView modelAndView);
	
	/**
	 * 
	 * @param returnValue Handler의 return value
	 * @param handlerMethod handler의 method
	 * @param handler handler Object
	 * @param modelAndView modelAndView or null
	 * @return
	 */
	ModelAndView process(Object returnValue,Method handlerMethod,Object handler,ModelAndView modelAndView);

}
