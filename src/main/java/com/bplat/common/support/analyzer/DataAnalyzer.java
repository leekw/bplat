package com.bplat.common.support.analyzer;

public interface DataAnalyzer {
	
	public Object serialize(String data, Class<?> c);
	
	public String deserialize(String key, Object obj);

}
