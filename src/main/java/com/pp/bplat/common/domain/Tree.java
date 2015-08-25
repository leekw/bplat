package com.pp.bplat.common.domain;

import java.util.List;

public class Tree extends Common {
	
    private static final long serialVersionUID = 4444781583409559473L;
    private int treeLevel;
	private String hasChild;
	private String treePath;
	private String checkDisableYn;
	private int isLeaf;
	private String  isCheck;
	private List<String> factorValueArr;
	private List<String> factorDescArr;
	
	public String getIsCheck() {
		return isCheck;
	}
	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}
	
	public String getTreePath() {
		return treePath;
	}
	public void setTreePath(String treePath) {
		this.treePath = treePath;
	}
	public int getTreeLevel() {
		return treeLevel;
	}
	public void setTreeLevel(int treeLevel) {
		this.treeLevel = treeLevel;
	}
	public String getHasChild() {
		return hasChild;
	}
	public void setHasChild(String hasChild) {
		this.hasChild = hasChild;
	}
	public String getCheckDisableYn() {
		return checkDisableYn;
	}
	public void setCheckDisableYn(String checkDisableYn) {
		this.checkDisableYn = checkDisableYn;
	}
	public int getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(int isLeaf) {
		this.isLeaf = isLeaf;
	}
	
	public List<String> getFactorValueArr() {
		return factorValueArr;
	}
	public void setFactorValueArr(List<String> factorValueArr) {
		this.factorValueArr = factorValueArr;
	}
	public List<String> getFactorDescArr() {
		return factorDescArr;
	}
	public void setFactorDescArr(List<String> factorDescArr) {
		this.factorDescArr = factorDescArr;
	}
	
}
