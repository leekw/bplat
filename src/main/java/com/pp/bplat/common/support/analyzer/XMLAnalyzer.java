package com.pp.bplat.common.support.analyzer;

import java.lang.reflect.Field;

import org.springframework.stereotype.Component;

import com.pp.bplat.common.support.analyzer.converter.NullConverter;
import com.thoughtworks.xstream.XStream;

@Component("xmlAnalyzer")
/**
 * 
 * <pre>
 * com.kt.prm.core.support.analyzer
 * XMLAnalyzer.java
 * XML 문자열을 분석하는 클래스
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : ags0688
 * @Date    : 2012. 3. 27. 오후 2:50:20
 * @Version : 1.0
 */
public class XMLAnalyzer implements DataAnalyzer {

	@Override
	public Object parse(String data, Class<?> c) {
		XStream xStream = new XStream();
		xStream.autodetectAnnotations(true);
		setAlias(c, xStream);
		xStream.fromXML(data);
		return xStream.fromXML(data);
	}

	@Override
	public String generate(String key, Object obj) {
		XStream xStream = new XStream();
		xStream.registerConverter(new NullConverter(xStream.getMapper()), XStream.PRIORITY_LOW);
		xStream.autodetectAnnotations(true);
		setAlias(obj.getClass(), xStream);
		return xStream.toXML(obj);
	}
	
	/**
	 * 
	 * Description  : Xml 변환시 Class Type의 Alias 를 지정한다.
	 * @Method Name : setAlias
	 * @param clazz
	 * @param xStreams
	 */
	private void setAlias(Class<?> clazz, XStream xStreams) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			xStreams.alias(field.getName(), field.getClass());
			setAlias(field.getType(), xStreams);
		}
	}

}
