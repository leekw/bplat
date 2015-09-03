package com.bplat.common.support.analyzer.converter;


import java.lang.reflect.Field;

import com.bplat.common.exception.BplatException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.ExtendedHierarchicalStreamWriterHelper;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

public class NullConverter implements Converter {

	private Mapper mapper;

	public NullConverter(Mapper mapper) {
		this.mapper = mapper;
	}

	public boolean canConvert(Class type) {
		return false;
	}

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
				throw new BplatException("");
			} catch (IllegalAccessException e) {
				throw new BplatException("");
			}
		}
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		return null;
	}

}
