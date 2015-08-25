package com.pp.bplat.common.exception;

/**
 * PRM exception interface
 * <pre>
 * com.kt.prm.common.exception
 * IPartnerException.java
 * </pre>
 *
 * @Company : KT 
 * @Author  : sslee
 * @Date    : 2012. 11. 7. 오후 2:53:55
 * @Version : 1.0
 */
public interface IPartnerException {
	String getCode();
	String getMessage();
    boolean isWriteLog();
    void setWriteLog(boolean isWriteLog);
    void setUserObject(Object userObject);
    Object getUserObject();
    String getMessageByMetadata(String metadataType) throws Exception;
}
