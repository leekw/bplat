package com.bplat.common.support.util.web;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bplat.common.annotation.MetadataRequest;
import com.bplat.common.exception.BplatException;
import com.bplat.common.support.analyzer.DataAnalyzer;
import com.bplat.common.support.analyzer.factory.DataAnalyzerFactory;
import com.bplat.common.support.constant.BizCode;
import com.bplat.common.support.util.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodInvoker;
import com.bplat.common.support.util.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodResolver;

/**
 * 
 * <pre>
 * com.jios.common.support.util.web
 * CommandModelBinder.java
 * 
 * Command model Binder
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : sslee
 * @Date    : 2012. 3. 23. 오후 3:27:46
 * @Version : 1.0
 */
@Component
public class CommandModelBinder extends AbstractModelBinder {

    @Autowired
    private DataAnalyzerFactory analyzerFactor;
    
    private enum Code {
        DISMATCHED("dismatched class type is ");
        private String value;
        private Code(String value) { this.value = value;}
        private String getValue () { return this.value;}
    }

    @Override
    protected Object bindModel(ServletHandlerMethodResolver methodResolver,ServletHandlerMethodInvoker methodInvoker, Annotation annotation,
            Class<?> parameterType, HttpServletRequest request,HttpServletResponse response) {
        
        String parserType = BizCode.RequestKey.CONTENT_TYPE_XML.isMatch(request.getContentType()) 
                ? BizCode.Data.XML.getValue() : BizCode.Data.JSON.getValue() ;
        
        DataAnalyzer anaylzer = analyzerFactor.getDataAnalyzer(parserType);
        
        MetadataRequest an = (MetadataRequest)annotation;
        String key = an.key() == null ? "params" : an.key();
        boolean isRequired = an.required();
        String dataString = (String)request.getAttribute(key);
        dataString = this.afterProcessStringData(an,dataString);
        
        Object result = null;
        if(!isRequired  && (dataString == null || BizCode.System.EMPTY_STRING.isMatch(dataString)) ) {
            try {
                result = parameterType.newInstance();
            } catch (InstantiationException e) {
                new BplatException(Code.DISMATCHED.getValue() + parameterType);
            } catch (IllegalAccessException e) {
                new BplatException(Code.DISMATCHED.getValue() + parameterType);
            }
        }
        
        result = anaylzer.serialize(dataString, an.listClass().equals(Object.class) ? parameterType : an.listClass());
        return result;
    }
    
    private String afterProcessStringData(MetadataRequest an,String paramData) {
        String data = paramData;
        boolean isValidateChar = data.startsWith("{");
        if(!an.listClass().equals(Object.class) && isValidateChar) {
            int idx = data.indexOf(": {");
            if(idx != -1) {
                data = data.substring(idx+1);
                data = "["+data.substring(0, data.length()-1)+"]";
            } else {
                data = "["+data+"]";
            }
        }
        
        return data;
    }

    @Override
    protected boolean isSupport(Annotation annotation) {
        return (annotation instanceof MetadataRequest);
    }

}
