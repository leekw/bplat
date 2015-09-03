package com.bplat.common.support.analyzer.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bplat.common.support.analyzer.DataAnalyzer;
import com.bplat.common.support.analyzer.JSONAnalyzer;
import com.bplat.common.support.analyzer.XMLAnalyzer;

@Component("dataAnalyzerFactory")
public class DataAnalyzerFactory {
	
	private enum DataType {
		JSON("json"),
		XML("xml");
		private String value;
		private DataType(String value) {
			this.value = value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	@Autowired
	@Qualifier("jsonAnalyzer")
	private DataAnalyzer jsonAnalyzer;
	
	@Autowired
	@Qualifier("xmlAnalyzer")
	private DataAnalyzer xmlAnalyzer;

	public DataAnalyzer getJsonAnalyzer() {
		DataAnalyzer result = null;
		if (jsonAnalyzer != null) {
			result = jsonAnalyzer;
		} else {
			result = new JSONAnalyzer();
		}
		return result;
	}
	
	public void setJsonAnalyzer(DataAnalyzer jsonAnalyzer) {
		this.jsonAnalyzer = jsonAnalyzer;
	}

	public DataAnalyzer getXmlAnalyzer() {
		DataAnalyzer result = null;
		if (xmlAnalyzer != null) {
			result = xmlAnalyzer;
		} else {
			result = new XMLAnalyzer();
		}
		return result;
	}

	public void setXmlAnalyzer(DataAnalyzer xmlAnalyzer) {
		this.xmlAnalyzer = xmlAnalyzer;
	}

	public DataAnalyzer getDataAnalyzer(String type) {
		DataAnalyzer result = null;
		if (DataType.JSON.isMatch(type)) {
			result = this.getJsonAnalyzer();
		} else if (DataType.XML.isMatch(type)) {
			result = this.getXmlAnalyzer();
		} else {
			result = null;
		}
		return result;
	}
}
