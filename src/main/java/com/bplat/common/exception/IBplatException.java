package com.bplat.common.exception;


public interface IBplatException {
	
	public String getCode();

	public String getMessage();

	public boolean isWriteLog();

	public void setWriteLog(boolean isWriteLog);

	public void setUserObject(Object userObject);

	public Object getUserObject();

	public String getMessageByMetadata(String metadataType) throws Exception;
}
