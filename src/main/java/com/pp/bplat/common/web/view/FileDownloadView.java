package com.pp.bplat.common.web.view;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.pp.bplat.common.exception.PartnerException;
import com.pp.bplat.common.support.util.Constant;

public class FileDownloadView extends AbstractView {
	
	public enum PrivateConstant {
		data("data")
		, downloadFile("downloadFile")
		, metadataType("metadataType")
		, isDelete("isDelete")
		, Content_Disposition("Content-Disposition")
		, Content_Transfer_Encoding("Content-Transfer-Encoding")
		, binary("binary")
		
		;
		private String value;
		private PrivateConstant(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
		public boolean isMatch(String compare) {
			return value.equals(compare);
		}
	}
	
	public FileDownloadView() {
		super();
	}
	
	private String getContentType(String metadataType) {
		String result = null;
		if (Constant.Data.FILE.isMatch(metadataType)) result = Constant.RequestKey.CONTENT_TYPE_FILE.getValue();
		return result;
	}
	
	@SuppressWarnings("unchecked")	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, Object> data = (Map<String, Object>) model.get(PrivateConstant.data.getValue());
		OutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		File file =(File) data.get(PrivateConstant.downloadFile.getValue());
				
		response.setCharacterEncoding(Constant.System.ENCODING_TYPE_OF_UTF8.getValue());		
		response.setContentType(getContentType((String) data.get(PrivateConstant.metadataType.getValue())));
		response.setContentLength((int) file.length());
		response.setHeader(PrivateConstant.Content_Disposition.getValue(), "attachment;filename="+URLEncoder.encode(file.getName(), Constant.System.ENCODING_TYPE_OF_UTF8.getValue()).replace("+","%20"));
		response.setHeader(PrivateConstant.Content_Transfer_Encoding.getValue(),PrivateConstant.binary.getValue());
		
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			FileCopyUtils.copy(bis, out);
			out.flush();			
		} catch (Exception e) {
			throw new PartnerException("E0001");
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				if (out != null) {
					out.close();
				}
				if(data.get(PrivateConstant.isDelete.getValue()) != null && Constant.Common.Y.isMatch((String)data.get(PrivateConstant.isDelete.getValue()))) {
					file.delete();
				}
			} catch (IOException ex) {
				throw new PartnerException("E0001");
			}
		}
	}
}
