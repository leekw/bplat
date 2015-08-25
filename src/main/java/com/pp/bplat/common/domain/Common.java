package com.pp.bplat.common.domain;

import java.io.Serializable;
import java.util.Date;

import com.pp.bplat.common.support.util.DateUtil;

/**
 * 
 * 공통 도메인 객체
 * <pre>
 * com.kt.prm.common.domain
 * Common.java
 * </pre>
 *
 * @Author <a href="mailto:ags0688@gmail.com">이경욱</a>
 * @Version : 1.0
 * @see com.kt.prm.common.domainCommon
 * @see TODO
 * @since 1.0
 * @history <li>2013. 8. 30., <a href="mailto:ags0688@gmail.com">이경욱</a>, 최초 작성</li>
 */
public class Common implements Serializable {
	
	private int maxRowSize;
	private String key;
	private String status;
	private Date firstCreateDate;
	private String firstCreateTransactionId;
	private Date lastChangeDate;
	private String lastChangeTranscationId;
	private String firstCreateProgramId;
	private String lastChangeProgramId;
	private boolean refreshCache;
	private String viewId;
	
	private enum DefaultValue {
		DEFALUT_USER("SYSTEM"),
		DEFAULT_DAO("DEFAULT_DAO");
		private String value;
		private DefaultValue(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1595136620855559148L;
	
	public String getViewId() {
		return viewId;
	}

	public void setViewId(String viewId) {
		this.viewId = viewId;
	}

	public boolean isRefreshCache() {
		return refreshCache;
	}

	public void setRefreshCache(boolean refreshCache) {
		this.refreshCache = refreshCache;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMaxRowSize() {
		return maxRowSize;
	}

	public void setMaxRowSize(int maxRowSize) {
		this.maxRowSize = maxRowSize;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Date getFirstCreateDate() {
	    return DateUtil.getNow();
	}

	public void setFirstCreateDate(Date firstCreateDate) {
		this.firstCreateDate = firstCreateDate;
	}

	public String getFirstCreateTransactionId() {
	    
	    String result = null;
        if(this.firstCreateTransactionId == null)
            result = DefaultValue.DEFALUT_USER.getValue();
        else
            result = this.firstCreateTransactionId;
        
        return result;
	}

	public void setFirstCreateTransactionId(String firstCreateTransactionId) {
		this.firstCreateTransactionId = firstCreateTransactionId;
	}

	public Date getLastChangeDate() {
	    return lastChangeDate == null ? DateUtil.getNow() : lastChangeDate;
	}

	public void setLastChangeDate(Date lastChangeDate) {
		this.lastChangeDate = lastChangeDate;
	}

	public String getLastChangeTranscationId() {
	    String result = null;
	    if(this.lastChangeTranscationId == null)
	        result = "SYSTEM";
	    else
	        result = this.lastChangeTranscationId;
	    
	    return result;
	    
	}

	public void setLastChangeTranscationId(String lastChangeTranscationId) {
		this.lastChangeTranscationId = lastChangeTranscationId;
	}

	public String getFirstCreateProgramId() {
	    
	    String result = null;
        if(this.firstCreateProgramId == null)
            result = "SYSTEM";
        else
            result = this.firstCreateProgramId;
        
        return result;
        
	}

	public void setFirstCreateProgramId(String firstCreateProgramId) {
		this.firstCreateProgramId = firstCreateProgramId;
	}

	public String getLastChangeProgramId() {
		
	    String result = null;
        if(this.lastChangeProgramId == null)
            result = "SYSTEM";
        else
            result = this.lastChangeProgramId;
        
        return result;
	    
	}

	public void setLastChangeProgramId(String lastChangeProgramId) {
		this.lastChangeProgramId = lastChangeProgramId;
	}
	
}
