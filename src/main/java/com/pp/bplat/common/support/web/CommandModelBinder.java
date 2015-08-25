package com.pp.bplat.common.support.web;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pp.bplat.common.annotation.Command;
import com.pp.bplat.common.exception.PartnerException;
import com.pp.bplat.common.support.analyzer.DataAnalyzer;
import com.pp.bplat.common.support.analyzer.DataAnalyzerFactory;
import com.pp.bplat.common.support.util.Constant;
import com.pp.bplat.common.support.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodInvoker;
import com.pp.bplat.common.support.web.PartnerAnnotationMethodHandlerAdaptor.ServletHandlerMethodResolver;

/**
 * 
 * <pre>
 * com.kt.prm.common.support.web
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
        
        String parserType = Constant.RequestKey.CONTENT_TYPE_XML.isMatch(request.getContentType()) 
                ? Constant.Data.XML.getValue() : Constant.Data.JSON.getValue() ;
        
        DataAnalyzer anaylzer = analyzerFactor.getDataAnalyzer(parserType);
        
        Command an = (Command)annotation;
        String key = an.key();
        boolean isRequired = an.required();
        String dataString = (String)request.getAttribute(key);
        dataString = this.afterProcessStringData(an,dataString);
        
        Object result = null;
        if(!isRequired  && (dataString == null || Constant.System.EMPTY_STRING.isMatch(dataString)) ) {
            try {
                result = parameterType.newInstance();
            } catch (InstantiationException e) {
                new PartnerException(Code.DISMATCHED.getValue() + parameterType);
            } catch (IllegalAccessException e) {
                new PartnerException(Code.DISMATCHED.getValue() + parameterType);
            }
        }
        
        result = anaylzer.parse(dataString, an.listClass().equals(Object.class) ? parameterType : an.listClass());
        return result;
    }
    
    private String afterProcessStringData(Command an,String paramData) {
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
        return (annotation instanceof Command);
    }

}
