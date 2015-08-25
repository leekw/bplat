package com.pp.bplat.common.support.web;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.ServletWebRequest;

import com.pp.bplat.common.exception.PartnerException;
import com.pp.bplat.common.support.util.Constant;
import com.pp.bplat.common.support.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodInvoker;
import com.pp.bplat.common.support.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodResolver;

/**
 * AsynAnnotationHandler PathVariable modelBinder
 * <pre>
 * com.kt.prm.common.support.web
 * PathVariableModelBinder.java
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : sslee
 * @Date    : 2012. 3. 23. 오후 3:28:29
 * @Version : 1.0
 */
@Component
public class PathVariableModelBinder extends AbstractModelBinder {
    
    @Override
    protected Object bindModel(ServletHandlerMethodResolver methodResolver,ServletHandlerMethodInvoker methodInvoker,
            Annotation annotation,Class<?> parameterType,HttpServletRequest request,HttpServletResponse response) {
        
        ServletWebRequest webRequest = new ServletWebRequest(request, response);
        
        PathVariable an = (PathVariable)annotation;
        Object obj = null;
        
        try {
            obj = methodInvoker.resolvePathVariable(an.value(),java.lang.String.class,webRequest);
            
            if(Constant.RequestKey.META_DATA_TYPE.isMatch(an.value()))
                request.setAttribute(Constant.RequestKey.META_DATA_TYPE.getValue(), (String)obj);
        }
        catch(Exception e) {
            new PartnerException(e);
        }
        
        return obj;
    }

    @Override
    protected boolean isSupport(Annotation annotation) {
        return (annotation instanceof PathVariable);
    }


}
