package com.bplat.common.support.analyzer;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Component;

import com.bplat.common.domain.Common;

@Component("jsonAnalyzer")
public class JSONAnalyzer implements DataAnalyzer {
    
	private enum Code {
        PREFIX("{"),SUFFIX("}"),DAE("["),JUNG("{");
        private String value;
        private Code(String value) { this.value = value;}
        private String getValue () { return this.value;}
    }
    
	
	public Object serialize(String data, Class<?> c) {
		Object result = null;
		Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
		setClassMap(c, classMap);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setRootClass(c);
		jsonConfig.setClassMap(classMap);
		if (data.startsWith(Code.DAE.getValue())) {
			result = JSONArray.toCollection(JSONArray.fromObject(data), jsonConfig);
		} else if (data.startsWith(Code.JUNG.getValue())) {
			result = JSONObject.toBean(JSONObject.fromObject(data), jsonConfig);
		} else {
			result = null;
		}
		return result;
	}

	public String deserialize(String key, Object obj) {
		String result = null;
		StringBuffer sb = new StringBuffer();
		if (obj instanceof List || obj instanceof Collection) {
			result = sb.append(Code.PREFIX.getValue()).append("\""+key+"\":")
					 .append(JSONArray.fromObject(obj).toString())
					 .append(Code.SUFFIX.getValue()).toString();
		} else if (obj instanceof Common || obj instanceof Map) {
			result = sb.append(Code.PREFIX.getValue()).append("\""+key+"\":")
					 .append(JSONObject.fromObject(obj).toString())
					 .append(Code.SUFFIX.getValue()).toString();
		} else if (obj instanceof Object) {
			result = sb.append(Code.PREFIX.getValue()).append("\""+key+"\":")
					 .append(JSONObject.fromObject(obj).toString())
					 .append(Code.SUFFIX.getValue()).toString();
		} else {
			result = sb.append(Code.PREFIX.getValue())
					 .append(Code.SUFFIX.getValue()).toString();
		}
		return result;
	}

	private void setClassMap(Class<?> clazz, Map<String, Class<?>> classMap) {
		List<Field> fields = new ArrayList<Field>();
		Field[] ownFields = clazz.getDeclaredFields();
		Field[] superFields = clazz.getSuperclass().getDeclaredFields();
		Collections.addAll(fields, ownFields);
		if (superFields != null) {
			Collections.addAll(fields, superFields);
		}
		for (Field field : fields) {
			if (List.class.isAssignableFrom(field.getType())) {
				Type type = field.getGenericType();
				if (type instanceof ParameterizedType) {
					ParameterizedType ptype = (ParameterizedType) type;
					ptype.getRawType();
					Class<?> c = (Class<?>) ptype.getActualTypeArguments()[0];
					classMap.put(field.getName(), c);
					setClassMap(c, classMap);
				}
			}
		}
	}
}