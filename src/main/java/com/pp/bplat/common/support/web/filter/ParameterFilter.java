package com.pp.bplat.common.support.web.filter;

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

import com.pp.bplat.common.exception.PartnerException;
import com.pp.bplat.common.support.util.Constant;
import com.pp.bplat.common.support.util.Error;

/**
 * prm web moduel servletFilter
 * <pre>
 * com.kt.prm.common.support.web.filter
 * ParameterFilter.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2012. 5. 30. 오후 2:07:42
 * @Version : 1.0
 */
public class ParameterFilter implements Filter {
    
	private static Logger logger = LoggerFactory.getLogger(ParameterFilter.class);
    
    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        this.setRequestParameter((HttpServletRequest)request);
        chain.doFilter((HttpServletRequest)request, response);
    }
    
    private void setRequestParameter(ServletRequest request) throws PartnerException {
        
        if(request.getParameter(Constant.RequestKey.PARAMS.getValue()) != null && !request.getParameter(Constant.RequestKey.PARAMS.getValue()).isEmpty()) {
            request.setAttribute(Constant.RequestKey.PARAMS.getValue(), request.getParameter(Constant.RequestKey.PARAMS.getValue()));
        } else {
            
            String read = null;
            StringBuffer sb = new StringBuffer();
            InputStreamReader isr = null;
            BufferedReader buffer = null;
            try {
                isr = new InputStreamReader(request.getInputStream(), Constant.System.ENCODING_TYPE_OF_UTF8.getValue());
                buffer = new BufferedReader(isr);
                while ((read = buffer.readLine()) != null) {
                    sb.append(read);
                }
                request.setAttribute(Constant.RequestKey.PARAMS.getValue(), sb.toString());
            } catch (IOException e) {
                throw new PartnerException(Error.E0005.getValue());
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
