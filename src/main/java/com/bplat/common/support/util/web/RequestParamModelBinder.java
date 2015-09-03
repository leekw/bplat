package com.bplat.common.support.util.web;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestParam;

import com.bplat.common.support.util.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodInvoker;
import com.bplat.common.support.util.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodResolver;

/**
 * 
 * <pre>
 * com.jios.common.support.util.web
 * RequestParamModelBinder.java
 * 
 * AsynAnnotation RequestParam ModelBinder
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : sslee
 * @Date    : 2012. 3. 23. 오후 3:28:49
 * @Version : 1.0
 */
@Component
public class RequestParamModelBinder extends AbstractModelBinder {

    @Override
    protected Object bindModel(ServletHandlerMethodResolver methodResolver,ServletHandlerMethodInvoker methodInvoker, Annotation annotation,
            Class<?> parameterType, HttpServletRequest request,HttpServletResponse response) {
        
        RequestParam an = (RequestParam)annotation;
        String key = an.value();
        Assert.notNull(key, "must be RequestParam annotation value property");
        
        return (request.getAttribute(key) != null ? (String)request.getAttribute(key) : request.getParameter(key) ); 
        
    }

    @Override
    protected boolean isSupport(Annotation annotation) {
        return (annotation instanceof RequestParam);
    }

}
