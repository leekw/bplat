package com.bplat.common.support.util.web;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.bplat.common.annotation.SessionCommand;
import com.bplat.common.support.util.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodInvoker;
import com.bplat.common.support.util.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodResolver;


/**
 * <pre>
 * com.jios.common.support.util.web
 * SessionModelBinder.java
 * 
 * session modelBinder
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : sslee
 * @Date    : 2012. 3. 23. 오후 3:29:24
 * @Version : 1.0
 */
@Component
public class SessionModelBinder extends AbstractModelBinder {

    @Override
    protected Object bindModel(ServletHandlerMethodResolver methodResolver,ServletHandlerMethodInvoker methodInvoker, Annotation annotation,
            Class<?> parameterType, HttpServletRequest request, HttpServletResponse response) {
        
        SessionCommand an = (SessionCommand)annotation;
        return request.getSession(an.isNewIfAbsent());
        
    }

    @Override
    protected boolean isSupport(Annotation annotation) {
        return (annotation instanceof SessionCommand);
    }

}
