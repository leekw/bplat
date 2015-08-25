package com.pp.bplat.common.support.configure;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.pp.bplat.common.exception.PartnerException;
import com.pp.bplat.common.support.util.Error;

public class ExposablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    
    private enum Code {
        RUN_LEVEL_BY_DEV("dev"),RUN_LEVEL_BY_QA("qa"),RUN_LEVEL_BY_STAGING("staging"),RUN_LEVEL_BY_LIVE("live"),LOCALHOST("localhost"),
        SERVER_QA("server.qa"),SERVER_STAGING("server.staging"),SERVER_LIVE("server.live"),PROPERTIES(".properties");
        private String value;
        private Code(String value) { this.value = value;}
        private String getValue () { return this.value;}
    }
	
	private String moduleName;
	private String prefix;
	private String currentIp;

	
	@Value("#{systemProperties['RUN.LEVEL']}") String systemOptionLevel;
	@Value("#{systemEnvironment['RUN.LEVEL']}") String jvmOtionLevel;
	
	
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	private void setCurrentIp() {
		try {
			currentIp = java.net.InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
		    currentIp = Code.LOCALHOST.getValue();
		}
	}
		
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
		File[] files = null;	
		setCurrentIp();
		StringBuffer sb = new StringBuffer();
		if (moduleName != null && !moduleName.equals("")) {
			sb.append(moduleName).append(File.separator);
		}
		if (prefix != null && !prefix.equals("")) {
			sb.append(prefix).append(File.separator);
		}
		sb.append(getLevel(props));
		String path = sb.toString();
		URL dirURL = getClass().getClassLoader().getResource(path);
		if (dirURL == null || !dirURL.getProtocol().equals("file")) {
			throw new PartnerException(Error.E0000.getValue(), "Unkwon File Path By Properties!");
		}
		try {
			files = new File(dirURL.toURI()).listFiles();
			addProperties(path, files, props);
		} catch (URISyntaxException e) {
			throw new PartnerException(e);
		}
		super.processProperties(beanFactoryToProcess, props);
	}
	
	private void addProperties(String path, File[] files, Properties props) {
		for (File file : files) {
			if (file.isDirectory()) {
				if (currentIp.endsWith(file.getName())) {
					addProperties(path + File.separator + file.getName(), file.listFiles(), props);
				}
			} else if (file.isFile() && file.getName().endsWith(Code.PROPERTIES.getValue())) {
				addProperties(path, file.getName(), props);
			}			
		}
	}
	
	private void addProperties(String path, String name, Properties props) {
		InputStream is = null;
		
		try {
			is = getClass().getClassLoader().getResourceAsStream(path + File.separator + name);
			props.load(is);
		}
		catch (IOException e) {throw new PartnerException(e);} 
		finally {
			if (is != null) {
				try {is.close();} catch (IOException e) {throw new PartnerException(e);}
			}
		}
		
	}
	
	private boolean isEquals(String servers) {
		boolean result = false;
		
		if (servers != null) {
			String[] hosts = servers.split(",");
			for (String host : hosts) {
				if (host.equals(currentIp)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	private String getLevelBySearchIp(Properties props) {
		String result = null;
		if (isEquals(props.getProperty(Code.SERVER_QA.getValue()))) {
			result = Code.RUN_LEVEL_BY_QA.getValue();
		} else if (isEquals(props.getProperty(Code.SERVER_STAGING.getValue()))) {
			result = Code.RUN_LEVEL_BY_STAGING.getValue();
		} else if (isEquals(props.getProperty(Code.SERVER_LIVE.getValue()))) {
			result = Code.RUN_LEVEL_BY_LIVE.getValue();
		} else {
			result = Code.RUN_LEVEL_BY_DEV.getValue();
		}
		return result;
	}
	
	private boolean isValid(String level) {
		boolean result = false;
		if (level == null) result = true;
		if (Code.RUN_LEVEL_BY_DEV.getValue().equals(level) 
				|| Code.RUN_LEVEL_BY_QA.getValue().equals(level)
				|| Code.RUN_LEVEL_BY_STAGING.getValue().equals(level)
				|| Code.RUN_LEVEL_BY_LIVE.getValue().equals(level)) {
			result = true;
		}
		return result;
	}
	
	private String getLevel(Properties props) {
		String level = null;	
		level = systemOptionLevel != null ? systemOptionLevel : jvmOtionLevel != null ? jvmOtionLevel : null;
		if (!isValid(level)) {
			throw new PartnerException(Error.E0000.getValue(), "Invalid Run Level!");
		}
		return  level != null ? level : getLevelBySearchIp(props);
	}
	
}
