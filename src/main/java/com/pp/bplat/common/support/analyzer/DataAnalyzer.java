package com.pp.bplat.common.support.analyzer;

/**
 * 
 * <pre>
 * com.kt.prm.core.support.analyzer
 * DataAnalyzer.java
 * 전송되는 데이터를 분석하기 위한 인터페이스
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : ags0688
 * @Date    : 2012. 3. 27. 오후 1:32:44
 * @Version : 1.0
 */
public interface DataAnalyzer {
	
	/**
	 * 
	 * Description  : 문자열의 데이터를 주어진 Class  Type 으로 변한되어 리턴한다.
	 * @Method Name : parse
	 * @param data Xml 또는 Json 문자열
	 * @param c Class Type
	 * @return Class Type 의 Bean
	 */
	public Object parse(String data, Class<?> c);
	
	/**
	 * 
	 * Description  : 입력된 객체를 Xml Or Json 문자열로 생성한다.
	 * @Method Name : generate
	 * @param obj 입력받은 객체
	 * @return Xml 또는 Json 문자열
	 */
	public String generate(String key, Object obj);

}
