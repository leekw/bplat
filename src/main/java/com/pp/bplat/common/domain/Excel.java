package com.pp.bplat.common.domain;

import java.util.List;

public class Excel extends Common {
	
    private static final long serialVersionUID = -4921220586400901556L;
    private String fileName;
	private String filePath;
	private List<String> columnIds;
	private int startRow; 

	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public List<String> getColumnIds() {
		return columnIds;
	}
	public void setColumnIds(List<String> columnIds) {
		this.columnIds = columnIds;
	}
	
}
