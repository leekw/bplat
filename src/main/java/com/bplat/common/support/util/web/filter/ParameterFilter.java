package com.bplat.common.support.util.web.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bplat.common.exception.BplatException;
import com.bplat.common.support.constant.BizCode;

/**
 * prm web moduel servletFilter
 * <pre>
 * com.jios.common.support.util.web.filter
 * ParameterFilter.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2012. 5. 30. 오후 2:07:42
 * @Version : 1.0
 */
public class ParameterFilter implements Filter {
	
	private static  Logger logger = LoggerFactory.getLogger(ParameterFilter.class);
    
    @Override
    public void destroy() {}
    

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        this.setRequestParameter((HttpServletRequest)request);
        chain.doFilter((HttpServletRequest)request, response);
    }
    
    private void setRequestParameter(ServletRequest request) throws BplatException {
        
        if(request.getParameter(BizCode.RequestKey.PARAMS.getValue()) != null && !request.getParameter(BizCode.RequestKey.PARAMS.getValue()).isEmpty()) {
            request.setAttribute(BizCode.RequestKey.PARAMS.getValue(), request.getParameter(BizCode.RequestKey.PARAMS.getValue()));
        } else {
            
            String read = null;
            StringBuffer sb = new StringBuffer();
            InputStreamReader isr = null;
            BufferedReader buffer = null;
            try {
                isr = new InputStreamReader(request.getInputStream(), BizCode.RequestKey.ENCODING_TYPE_OF_UTF8.getValue());
                buffer = new BufferedReader(isr);
                while ((read = buffer.readLine()) != null) {
                    sb.append(read);
                }
                request.setAttribute(BizCode.RequestKey.PARAMS.getValue(), sb.toString());
            } catch (IOException e) {
                throw new BplatException(e);
            }finally{
                try {
                    if(isr != null) isr.close();
                    if(buffer != null) buffer.close();
                } catch (IOException e) {
                    logger.debug(e.getMessage());
                }
            }
        }
        
        //request.setAttribute("securityYN", request.getParameter("securityYN") != null ? request.getParameter("securityYN") : Constant.RequestKey.SECURITY_PARAMS_DETAIL);
    }


    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }
   
}
