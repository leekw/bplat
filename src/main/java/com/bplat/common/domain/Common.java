package com.bplat.common.domain;

import java.io.Serializable;

public class Common implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6394699957294472860L;
	private int maxRowSize;
	
	public int getMaxRowSize() {
		return maxRowSize;
	}
	public void setMaxRowSize(int maxRowSize) {
		this.maxRowSize = maxRowSize;
	}
}
