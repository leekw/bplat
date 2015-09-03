package com.bplat.common.support.util.web;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bplat.common.support.util.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodInvoker;
import com.bplat.common.support.util.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodResolver;

/**
 * AsynAnnotationHandler bind parameter helper
 * <pre>
 * com.jios.common.support.util.web
 * ModelBinder.java
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : sslee
 * @Date    : 2012. 3. 23. 오후 3:28:10
 * @Version : 1.0
 */
public interface ModelBinder {
    
    /**
     * 
     * Description  :annotation 에 묶인 parameter object bind
     * @Method Name : bind
     * @param methodResolver
     * @param methodInvoker
     * @param handlerMethod
     * @param request
     * @param response
     * @return
     */
    Object bind(ServletHandlerMethodResolver methodResolver,ServletHandlerMethodInvoker methodInvoker,
            Method handlerMethod,HttpServletRequest request,HttpServletResponse response);

}
