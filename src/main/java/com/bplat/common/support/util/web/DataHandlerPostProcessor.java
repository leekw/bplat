package com.bplat.common.support.util.web;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.bplat.common.annotation.MetadataResponse;
import com.bplat.common.support.constant.BizCode;

/**
 * Handler에서 return를 사용자 data Object로 return시 
 * <pre>
 * com.jios.common.support.util.web
 * DataHandlerPostProcessor.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2014. 1. 16. 오후 1:33:26
 * @Version : 1.0
 */
@Component("dataHandlerPostProcessor")
public class DataHandlerPostProcessor implements HandlerPostProcessor {

	@Override
	public boolean isSupply(Object returnValue, Method handlerMethod,Object handler,ModelAndView modelAndViewParam) {
		return (returnValue != null && !(returnValue instanceof ModelAndView));
	}

	@Override
	public ModelAndView process(Object returnValue, Method handlerMethod,Object handler,ModelAndView modelAndViewParam) {
		
		ModelAndView modelAndView = modelAndViewParam == null ? new ModelAndView() : modelAndViewParam;
		MetadataResponse ann = AnnotationUtils.findAnnotation(handlerMethod, MetadataResponse.class);
		if(ann != null)
		{
			String key = ann.key() == null ? "bean" : ann.key();
			Map<String,Object> userDataMap = new HashMap<String,Object>();
			userDataMap.put(key, returnValue);
			
			modelAndView.addObject(BizCode.RequestKey.PARAM_KEY.getValue(),userDataMap);
		}
		else
		{
			Map<String,Object> userDataMap = new HashMap<String,Object>();
			userDataMap.put(returnValue.getClass().getSimpleName(), returnValue);
			
			modelAndView.addObject(BizCode.RequestKey.PARAM_KEY.getValue(),userDataMap);
		}
		
		return modelAndView;
	}

}
