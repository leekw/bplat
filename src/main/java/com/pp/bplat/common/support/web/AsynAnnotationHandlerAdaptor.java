package com.pp.bplat.common.support.web;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.ModelAndView;

import com.pp.bplat.common.exception.PartnerException;
import com.pp.bplat.common.support.security.StringEncrypter;
import com.pp.bplat.common.support.util.Constant;

/**
 * 
 * <pre>
 * com.kt.prm.common.support.web
 * AsynAnnotationHandlerAdaptor.java
 * 
 *  Lion project Asynch 방식의 request 전용 handlerAdapor 
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : sslee
 * @Date    : 2012. 3. 23. 오후 3:27:36
 * @Version : 1.0
 */
public class AsynAnnotationHandlerAdaptor extends PartnerAnnotationMethodHandlerAdaptor {
    
	private static Logger logger = LoggerFactory.getLogger(AsynAnnotationHandlerAdaptor.class);
    
    private enum Code {
        METADATAVIEW("metadataView"),METADATATYPE("metadataType");
        private String value;
        private Code(String value) { this.value = value;}
        private String getValue () { return this.value;}
    }
    
    @Autowired
    private List<ModelBinder> modelBinderList;
    
    @Autowired @Qualifier("stringEncrypter") 
    private StringEncrypter stringEncrypter;
    
    private boolean isSupport(Method handlerMethod,Object handler,HttpServletRequest request) {
        
        int idx = request.getRequestURI().lastIndexOf('.');
        String extract = request.getRequestURI().substring(idx+1);
        
        boolean isSupport = (super.supports(handler) && 
                (Constant.RequestKey.CONTENT_TYPE_JSON.isMatch(request.getContentType()) || 
                        Constant.RequestKey.CONTENT_TYPE_XML.isMatch(request.getContentType()) ) );
        
        return (isSupport || (Constant.Data.JSON.isMatch(extract) || Constant.Data.XML.isMatch(extract))  );
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public ModelAndView handle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
        
        this.decryptParam(request);
        //S:find method
        ServletHandlerMethodResolver methodResolver = super.getMethodResolver(handler);
        Method handlerMethod = methodResolver.resolveHandlerMethod(request);
        //E:find method
        
        //methodResolver.
        ModelAndView modelAndView = null;
        if(!this.isSupport(handlerMethod,handler,request)) 
        {
            modelAndView = super.handle(request, response, handler);
        } 
        else 
        {
          //S:bind method Parameters
            List valueList = new ArrayList();
            ServletHandlerMethodInvoker methodInvoker = super.getServlethandlerMethodInvoker(methodResolver);
            
            for(ModelBinder modelBinder : modelBinderList) {
                Object obj = modelBinder.bind(methodResolver, methodInvoker, handlerMethod, request, response);
                if(obj != null)
                    valueList.add(obj);
            }
            //E:bind method Parameters
            
            //S:HttpServletRequest,response bind
            Class[] clazzs = handlerMethod.getParameterTypes();
            for(Class cl : clazzs) {
                if( cl.equals(HttpServletRequest.class))
                    valueList.add(request);
                if( cl.equals(HttpServletResponse.class))
                    valueList.add(response);
                if( cl.equals(ModelAndView.class))
                    valueList.add(new ModelAndView());
            }
            //E:HttpServletRequest,response bind
            
            modelAndView = (ModelAndView)ReflectionUtils.invokeJdbcMethod(handlerMethod, handler, valueList.toArray());
            
            String metaData = (String)request.getAttribute(Constant.RequestKey.META_DATA_TYPE.getValue());
            if(metaData != null && (Constant.Data.JSON.isMatch(metaData) || Constant.Data.XML.isMatch(metaData)) ) {
                modelAndView.setViewName(Code.METADATAVIEW.getValue());
                modelAndView.addObject(Code.METADATATYPE.getValue(), metaData);
            }
        }
        
        return modelAndView;
    }
    
    private void decryptParam(HttpServletRequest request) {
        
        if(request.getContentType() != null && Constant.System.CONTENT_TYPE_TEXT_PLAIN.isMatch(request.getContentType().toLowerCase())) {
            
            String paramValue = (String)request.getAttribute(Constant.RequestKey.PARAMS.getValue());
            try {
                request.setAttribute(Constant.RequestKey.PARAMS.getValue(), stringEncrypter.decrypt(paramValue));
            } catch (Exception e) {
                throw new PartnerException(e);
            }
        }
    }

}
