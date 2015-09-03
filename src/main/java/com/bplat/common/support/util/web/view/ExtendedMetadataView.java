package com.bplat.common.support.util.web.view;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.AbstractView;

import com.bplat.common.support.analyzer.DataAnalyzer;
import com.bplat.common.support.analyzer.factory.DataAnalyzerFactory;
import com.bplat.common.support.constant.BizCode;

public class ExtendedMetadataView extends AbstractView {
	
	@Autowired
	private DataAnalyzerFactory dataAnalyzerFactory;
		
	public ExtendedMetadataView() {
		super();
	}
	
	private String getContentType(String metadataType) {
		String result = null;
		if (BizCode.Data.JSON.isMatch(metadataType)) result = BizCode.RequestKey.CONTENT_TYPE_JSON.getValue(); 
		else if (BizCode.Data.XML.isMatch(metadataType)) result = BizCode.RequestKey.CONTENT_TYPE_XML.getValue();
		else result = BizCode.RequestKey.CONTENT_TYPE_HTML.getValue();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void renderMergedOutputModel( Map<String, Object> model, HttpServletRequest request,HttpServletResponse response ) throws Exception {
		String metadataType = (String) model.get("metadataType");
		DataAnalyzer ananlyzer = dataAnalyzerFactory.getDataAnalyzer(metadataType);
		StringBuffer sb = new StringBuffer();
		OutputStream outputStream = null;
		Writer printWriter = null;
		response.setCharacterEncoding(BizCode.RequestKey.ENCODING_TYPE_OF_UTF8.getValue());
		response.setContentType( getContentType(metadataType) );
		Map<String, Object> data = (Map<String, Object>) model.get("data");
		if(data != null){
			Iterator<Map.Entry<String, Object>> ie = data.entrySet().iterator();
			if (data.size() > 1)
				sb.append("{\"data\":");
			int index = 0;
			boolean isMulti = data.size()>1?true:false;
			int endIdx = data.size();
			while(ie.hasNext()) {
				Map.Entry<String, Object> entry = ie.next();
				String jsonStr = ananlyzer.deserialize(entry.getKey(), entry.getValue());
				
				if(isMulti && index != endIdx) {
					if(index != 0)
						jsonStr = jsonStr.substring(1);
					
					if(index < endIdx-1)
						jsonStr = jsonStr.substring(0,jsonStr.length()-1);
				}
				
				sb.append(jsonStr);
				
				if ( index < (data.size()-1))
					sb.append(",");
				
				index++;
			}
			if (data.size() > 1)
				sb.append("}");
		} else {
			sb.append("{}");
		}
		try {
			outputStream = response.getOutputStream();
	        printWriter = new PrintWriter(new OutputStreamWriter(outputStream, "UTF8"));
	        printWriter.write(sb.toString());
	        printWriter.flush();
		} catch(IOException ex) {
			throw ex;
		} finally {
			if(printWriter != null ){printWriter.close();}
			if(outputStream != null){outputStream.close();}
		}
	}

}
