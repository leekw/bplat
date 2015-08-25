package com.pp.bplat.common.support.analyzer.converter;

import java.lang.reflect.Field;

import com.pp.bplat.common.exception.PartnerException;
import com.pp.bplat.common.support.util.Error;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

/**
 * 
 * <pre>
 * com.kt.prm.core.support.analyzer.converter
 * NullConverter.java
 * XML 로 변한 할 때 Object 의 값이 Null 인 값도 XML이 생성되도록 하는 변한 하는 Convert Class
 * </pre>
 *
 * @Company : With the People Co., LTD 
 * @Author  : ags0688
 * @Date    : 2012. 3. 27. 오후 2:59:42
 * @Version : 1.0
 */
public class NullConverter implements Converter {

	private Mapper mapper;

	public NullConverter(Mapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public boolean canConvert(Class type) {
		return false;
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer,	MarshallingContext context) {
		Field[] fieldSet = source.getClass().getDeclaredFields();
		for (Field field : fieldSet) {
			Object member;
			if (!mapper.shouldSerializeMember(source.getClass(),
					field.getName())) {
				continue;
			}
			field.setAccessible(true);
			try {
				member = field.get(source);
				String name = mapper.serializedMember(field.getDeclaringClass(), field.getName());

				if (member == null) {
					writer.startNode(name);
					writer.endNode();
				} else {
					ExtendedHierarchicalStreamWriterHelper.startNode(writer, name, member.getClass());
					context.convertAnother(member);
					writer.endNode();
				}
			} catch (IllegalArgumentException e) {
				throw new PartnerException(Error.E0000.getValue());
			} catch (IllegalAccessException e) {
				throw new PartnerException(Error.E0000.getValue());
			}
		}
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		return null;
	}

}
