package com.pp.bplat.common.support.analyzer;

import com.pp.bplat.common.support.util.Constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * 
 * <pre>
 * com.kt.prm.core.support.analyzer
 * DataAnalyzerFactory.java
 * 전송되는 데이터를 분석하기 위해 DataAnalyzer 를 얻기 위한 Factory Class
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : ags0688
 * @Date    : 2012. 3. 27. 오후 1:36:40
 * @Version : 1.0
 */
@Component("dataAnalyzerFactory")
public class DataAnalyzerFactory {
	
	@Autowired @Qualifier("jsonAnalyzer") private DataAnalyzer jsonAnalyzer;
	
	@Autowired @Qualifier("xmlAnalyzer")  private DataAnalyzer xmlAnalyzer;
	
	/**
	 * 
	 * Description  : JSON Analyzer 를 리턴한다.
	 * @Method Name : getJsonAnalyzer
	 * @return JSONAnalyzer
	 */
	public DataAnalyzer getJsonAnalyzer() {
		DataAnalyzer result = null;
		if (jsonAnalyzer != null) {
			result = jsonAnalyzer;
		} else {
			result = new JSONAnalyzer();
		}
		return result;
	}
	
	/**
	 * 
	 * Description  : JSONAnalyzer setter Method
	 * @Method Name : setJsonAnalyzer
	 * @param jsonAnalyzer
	 */
	public void setJsonAnalyzer(DataAnalyzer jsonAnalyzer) {
		this.jsonAnalyzer = jsonAnalyzer;
	}
	
	/**
	 * 
	 * Description  : XML Analyzer 를 리턴한다.
	 * @Method Name : getXmlAnalyzer
	 * @return XMLAnalyzer
	 */
	public DataAnalyzer getXmlAnalyzer() {
		DataAnalyzer result = null;
		if (xmlAnalyzer != null) {
			result = xmlAnalyzer;
		} else {
			result = new XMLAnalyzer();
		}
		return result;
	}
	
	/**
	 * 
	 * Description  : XMLAnalyzer setter Method
	 * @Method Name : setXmlAnalyzer
	 * @param xmlAnalyzer
	 */
	public void setXmlAnalyzer(DataAnalyzer xmlAnalyzer) {
		this.xmlAnalyzer = xmlAnalyzer;
	}
	
	/**
	 * 
	 * Description  : Type 에 의해 DataAnalyzer 를 리턴한다.
	 * @Method Name : getDataAnalyzer
	 * @param type JSON Or XML
	 * @return DataAnalyzer
	 */
	public DataAnalyzer getDataAnalyzer(String type) {
		DataAnalyzer result = null;
		if (Constant.Data.JSON.isMatch(type)) {
			result = this.getJsonAnalyzer();
		} else if (Constant.Data.XML.isMatch(type)) {
			result = this.getXmlAnalyzer();
		} else {
			result = null;
		}
		return result;
	}
}
