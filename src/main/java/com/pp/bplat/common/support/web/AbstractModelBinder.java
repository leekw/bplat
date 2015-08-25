package com.pp.bplat.common.support.web;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pp.bplat.common.support.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodInvoker;
import com.pp.bplat.common.support.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodResolver;

/**
 * 
 * <pre>
 * com.kt.prm.common.support.web
 * AbstractModelBinder.java
 * 
 * AsynAnnotationHandler modelBinder
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : sslee
 * @Date    : 2012. 3. 23. 오후 3:27:23
 * @Version : 1.0
 */
public abstract class AbstractModelBinder implements ModelBinder {
    
    /**
     * bind 이후 처리 hook method
     * @param methodResolver
     * @param methodInvoker
     * @param handlerMethod
     * @param request
     * @param response
     */
    protected void setAfterBind(ServletHandlerMethodResolver methodResolver,ServletHandlerMethodInvoker methodInvoker,Method handlerMethod,
            HttpServletRequest request,HttpServletResponse response){
        handlerMethod.toString();
    }
    
    @Override
    public Object bind(ServletHandlerMethodResolver methodResolver,ServletHandlerMethodInvoker methodInvoker,Method handlerMethod,
            HttpServletRequest request,HttpServletResponse response) {
        
        Annotation[][] ans = handlerMethod.getParameterAnnotations();
        
        int i = -1;
        Object obj = null;
        for(Annotation[] anArray : ans) {
            i++;
            if(anArray.length == 0 ) continue;
            if(!isSupport(anArray[0])) continue;
            
            obj = bindModel(methodResolver,methodInvoker,anArray[0],handlerMethod.getParameterTypes()[i],request,response);
            setAfterBind(methodResolver, methodInvoker,handlerMethod,request,response);
            
            break;
        }
        
        return obj;
    }

    
    protected abstract Object bindModel(ServletHandlerMethodResolver methodResolver,ServletHandlerMethodInvoker methodInvoker,
            Annotation annotation,Class<?> parameterType,HttpServletRequest request,HttpServletResponse response );
    
    protected abstract boolean isSupport(Annotation annotation);

}
