package com.pp.bplat.common.support.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pp.bplat.common.exception.PartnerException;
import com.pp.bplat.common.support.security.StringEncrypter;
import com.pp.bplat.common.support.util.Constant;
import com.pp.bplat.common.support.util.Error;

/**
 * 
 * <pre>
 * com.kt.prm.common.support.web
 * RequestParamInitInteterceptor.java
 * 
 * request post data를 request attribute에 setting 해주는 handlerInterceptor
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : sslee
 * @Date    : 2012. 3. 23. 오후 3:28:39
 * @Version : 1.0
 */
public class RequestParamInitInteterceptor extends HandlerInterceptorAdapter {
    
    @Autowired
    private StringEncrypter encrypter;
    
    private enum Code {
        ERROR_MESSAGE("No InputStream specified");
        private String value;
        private Code(String value) { this.value = value;}
        private String getValue () { return this.value;}
    }
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) {
        
        this.setRequestParameter(request);
        return true;
    }
    
    private void setRequestParameter(HttpServletRequest request) {
        String read = null;
        StringBuffer sb = null;
        InputStreamReader isr = null;
        BufferedReader buffer = null;
        
        try {

            sb = new StringBuffer();
            isr = new InputStreamReader(request.getInputStream(), Constant.System.ENCODING_TYPE_OF_UTF8.getValue());
            buffer = new BufferedReader(isr);
            
            while ((read = buffer.readLine()) != null) {
                sb.append(read);
            }
            
            String isCurityYn = request.getParameter(Constant.RequestKey.SERCURITY_KEY.getValue()) != null 
            		? Constant.RequestKey.BOOLEAN_Y_STRING.getValue() : Constant.RequestKey.BOOLEAN_N_STRING.getValue();
            request.setAttribute(Constant.RequestKey.SERCURITY_KEY.getValue(), isCurityYn);
            request.setAttribute(Constant.RequestKey.PARAM_KEY.getValue(), Constant.RequestKey.BOOLEAN_Y_STRING.isMatch(isCurityYn) ? this.getEncryptString(sb.toString()) : sb.toString());
            
            Assert.notNull(isr, Code.ERROR_MESSAGE.getValue());
            Assert.notNull(buffer, Code.ERROR_MESSAGE.getValue());
            
        } catch (IOException e) {
            throw new PartnerException(Error.E0005.getValue());
        }finally{
            try {
                if(isr != null) isr.close();
                if(buffer != null) buffer.close();
            } catch (IOException e) {
                throw new PartnerException(e);
            }
        }
    }
    
    private String getEncryptString(String dataString) {
        String result = null;
        if(dataString == null || Constant.System.EMPTY_STRING.isMatch(dataString))
        	result = dataString;
        else {
            try {
            	result = encrypter.decrypt(dataString);
            } catch (Exception e) {
                throw new PartnerException(e);
            }
        }
        return result;
    }

}
