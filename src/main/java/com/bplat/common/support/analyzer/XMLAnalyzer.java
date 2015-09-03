package com.bplat.common.support.analyzer;

import java.lang.reflect.Field;

import org.springframework.stereotype.Component;

import com.bplat.common.support.analyzer.converter.NullConverter;
import com.thoughtworks.xstream.XStream;

@Component("xmlAnalyzer")
public class XMLAnalyzer implements DataAnalyzer {

	public Object serialize(String data, Class<?> c) {
		XStream xStream = new XStream();
		xStream.autodetectAnnotations(true);
		setAlias(c, xStream);
		xStream.fromXML(data);
		return xStream.fromXML(data);
	}

	public String deserialize(String key, Object obj) {
		XStream xStream = new XStream();
		xStream.registerConverter(new NullConverter(xStream.getMapper()), XStream.PRIORITY_LOW);
		xStream.autodetectAnnotations(true);
		setAlias(obj.getClass(), xStream);
		return xStream.toXML(obj);
	}

	
	private void setAlias(Class<?> clazz, XStream xStreams) {
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			xStreams.alias(field.getName(), field.getClass());
			setAlias(field.getType(), xStreams);
		}
	}

}
